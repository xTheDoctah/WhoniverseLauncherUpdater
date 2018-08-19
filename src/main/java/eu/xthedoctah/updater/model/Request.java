package eu.xthedoctah.updater.model;

public class Request {
    private static Request instance;
    private String token;
    private String host;

    public static Request getInstance() {
        if (instance == null)
            instance = new Request();
        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
