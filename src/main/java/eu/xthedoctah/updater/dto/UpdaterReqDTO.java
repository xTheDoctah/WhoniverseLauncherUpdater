package eu.xthedoctah.updater.dto;

import eu.xthedoctah.updater.utils.ToString;

public class UpdaterReqDTO extends ToString {
    private String updaterID;

    public UpdaterReqDTO(String id) {
        updaterID = id;
    }
}
