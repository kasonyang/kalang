package kalang.compiler.compile;

import kalang.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author KasonYang
 */
public class CompilePhaseManager {

    private List<CompilePhase> compilePhaseList = new LinkedList<>();

    public CompilePhaseManager() {
        //add a start phase
        registerPhase("", u -> {});
    }

    public CompilePhase getStartPhase() {
        return compilePhaseList.get(0);
    }

    public CompilePhase getLastPhase() {
        if (compilePhaseList.isEmpty()) {
            throw new IllegalStateException("none compile phase found");
        }
        return compilePhaseList.get(compilePhaseList.size() - 1);
    }

    public CompilePhase getPhase(String id) {
        CompilePhase phase = getPhaseByIdIfExists(id);
        if (phase == null) {
            throw new IllegalArgumentException("phase does exists:" + id);
        }
        return phase;
    }

    public CompilePhase registerPhase(String id, PhaseProcessor processor) {
        return registerPhase(compilePhaseList.size(), id, processor);
    }

    public CompilePhase registerPhaseAfter(String newId, PhaseProcessor processor, String existPhaseId) {
        int existIdx = getPhaseIndex(getPhase(existPhaseId));
        return registerPhase(existIdx + 1, newId, processor);
    }

    public CompilePhase registerPhaseBefore(String newId, PhaseProcessor processor, String existPhaseId) {
        int existIdx = getPhaseIndex(getPhase(existPhaseId));
        return registerPhase(existIdx, newId, processor);
    }


    private CompilePhase registerPhase(int index, String id, PhaseProcessor processor) {
        if (getPhaseByIdIfExists(id) != null) {
            throw new IllegalArgumentException("phase exits already:" + id);
        }
        CompilePhase phase = new CompilePhase() {
            @Override
            public String getId() {
                return id;
            }

            @Override
            public boolean isBefore(CompilePhase other) {
                return getPhaseIndex(this) < getPhaseIndex(other);
            }

            @Override
            public CompilePhase nextPhase() {
                int nextIdx = getPhaseIndex(this) + 1;
                return nextIdx >= compilePhaseList.size() ? null : compilePhaseList.get(nextIdx);
            }

            @Override
            public boolean isLastPhase() {
                return getPhaseIndex(this) == compilePhaseList.size() - 1;
            }

            @Override
            public void process(CompilationUnit compilationUnit) {
                processor.process(compilationUnit);
            }

            @Override
            public String toString() {
                return getId();
            }
        };
        compilePhaseList.add(index, phase);
        return phase;
    }

    private int getPhaseIndex(CompilePhase phase) {
        int idx = compilePhaseList.indexOf(phase);
        if (idx < 0) {
            throw new IllegalArgumentException("phase does not exits:" + phase.getId());
        }
        return idx;
    }

    @Nullable
    private CompilePhase getPhaseByIdIfExists(String id) {
        for (CompilePhase p : compilePhaseList) {
            if (Objects.equals(p.getId(), id)) {
                return p;
            }
        }
        return null;
    }


}
