package eu.xthedoctah.updater.model;

public class Response {
    private static Response instance;
    private String version;
    private String url;

    public static Response getInstance() {
        if (instance == null)
            instance = new Response();
        return instance;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
