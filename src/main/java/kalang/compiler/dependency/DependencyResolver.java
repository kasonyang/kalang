package kalang.compiler.dependency;

import org.apache.ivy.Ivy;
import org.apache.ivy.core.cache.ArtifactOrigin;
import org.apache.ivy.core.event.EventManager;
import org.apache.ivy.core.event.download.StartArtifactDownloadEvent;
import org.apache.ivy.core.module.descriptor.DefaultModuleDescriptor;
import org.apache.ivy.core.module.id.ModuleRevisionId;
import org.apache.ivy.core.report.ArtifactDownloadReport;
import org.apache.ivy.core.report.ResolveReport;
import org.apache.ivy.core.resolve.IvyNode;
import org.apache.ivy.core.resolve.ResolveOptions;
import org.apache.ivy.core.settings.IvySettings;
import org.apache.ivy.plugins.resolver.AbstractResolver;
import org.apache.ivy.plugins.resolver.IBiblioResolver;
import org.apache.ivy.util.Message;
import org.apache.ivy.util.url.URLHandlerRegistry;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class DependencyResolver {

    private final List<String> repositories;

    public DependencyResolver() {
        this.repositories = Collections.EMPTY_LIST;
    }

    public DependencyResolver(Set<String> repositories){
        this.repositories = new LinkedList<>(repositories);
    }

    /**
     * Resolve dependencies
     * @param artifacts
     * @return the result of resolution
     * @throws ResolveException if failed to resolve
     */
    public ResolveResult resolve(Artifact[] artifacts){
        try {
            return doResolve(artifacts);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private ResolveResult doResolve(Artifact[] artifacts) throws IOException, ParseException {
        Message.setDefaultLogger(new NoMessageLogger());
        URLHandlerRegistry.setDefault(new ExtendURLHandler());
        IvySettings settings = new IvySettings();
        if (!this.repositories.isEmpty()) {
            int repoSize = repositories.size();
            for(int i=0;i<repoSize;i++) {
                IBiblioResolver dr = new IBiblioResolver();
                dr.setName("user-repo" + (i+1));
                dr.setM2compatible(true);
                dr.setRoot(repositories.get(i));
                settings.addResolver(dr);
            }
        }
        settings.loadDefault();
        if (!this.repositories.isEmpty()) {
            settings.setDefaultResolver("user-repo1");
        }
        EventManager eventManager = new EventManager();
        eventManager.addIvyListener(event -> {
            if (event instanceof StartArtifactDownloadEvent) {
                ArtifactOrigin origin = ((StartArtifactDownloadEvent) event).getOrigin();
                System.out.println("Downloading:" +origin.getLocation());
            }
        });
        Collection<org.apache.ivy.plugins.resolver.DependencyResolver> resolvers = settings.getResolvers();
        for(org.apache.ivy.plugins.resolver.DependencyResolver r:resolvers) {
            if (r instanceof AbstractResolver) {
                ((AbstractResolver) r).setEventManager(eventManager);
            }
        }
        Ivy ivy = Ivy.newInstance(settings);
        ResolveOptions ops = new ResolveOptions();
        //confs: [default, master, compile, provided, runtime, test, system, sources, javadoc, optional]
        ops.setConfs(new String[]{"default"});
        //ops.setArtifactFilter(FilterHelper.getArtifactTypeFilter("jar"));
        ModuleRevisionId[] mrids = new ModuleRevisionId[artifacts.length];
        Map<ModuleRevisionId,Artifact> revisionId2Artifact = new HashMap<>();
        for(int i=0;i<artifacts.length;i++){
            Artifact art = artifacts[i];
            mrids[i] = ModuleRevisionId.newInstance(art.getGroup(),art.getName(),art.getVersion());
            revisionId2Artifact.put(mrids[i],art);
        };
        DefaultModuleDescriptor moduleDescriptor = DefaultModuleDescriptor.newCallerInstance(mrids, true, false);
        ResolveReport res = ivy.resolve(moduleDescriptor, ops);
        ResolveResult result = new ResolveResult();
        ArtifactDownloadReport[] reports = res.getAllArtifactsReports();
        for(ArtifactDownloadReport r:reports) {
            result.addLocalFile(r.getLocalFile());
        }
        IvyNode[] uds = res.getUnresolvedDependencies();
        if (uds!=null && uds.length>0) {
            throw new ResolveException("failed to resolve artifact:" + uds[0].getId().toString());
        }
        return result;
    }

}
