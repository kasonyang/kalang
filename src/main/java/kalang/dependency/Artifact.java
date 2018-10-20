package kalang.dependency;

public class Artifact {

    private String group;

    private String name;

    private String version;

    public Artifact(String group, String name, String version) {
        this.group = group;
        this.name = name;
        this.version = version;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s",group,name,version);
    }
}
