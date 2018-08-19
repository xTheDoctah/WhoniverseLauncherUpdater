package eu.xthedoctah.updater.model;

import eu.xthedoctah.updater.utils.ToString;

public class Version extends ToString {
    private static Version instance;
    private String updaterVersion = "1.0";
    private String launcherVersion = "1.0";
    private String Token = "sadad";

    public static Version getInstance() {
        if (instance == null)
            instance = new Version();
        return instance;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getUpdaterVersion() {
        return updaterVersion;
    }

    public void setUpdaterVersion(String updaterVersion) {
        this.updaterVersion = updaterVersion;
    }

    public String getLauncherVersion() {
        return launcherVersion;
    }

    public void setLauncherVersion(String launcherVersion) {
        this.launcherVersion = launcherVersion;
    }


}
