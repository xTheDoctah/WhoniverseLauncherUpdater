package eu.xthedoctah.updater.dto;

import eu.xthedoctah.updater.utils.ToString;

public class LauncherReqDTO extends ToString {
    private String launcherID;

    public LauncherReqDTO(String id) {
        launcherID = id;
    }
}
