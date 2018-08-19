package eu.xthedoctah.updater;

import eu.xthedoctah.updater.dto.LauncherReqDTO;
import eu.xthedoctah.updater.dto.UpdaterReqDTO;
import eu.xthedoctah.updater.model.Url;
import eu.xthedoctah.updater.model.Version;
import eu.xthedoctah.updater.service.RequestService;
import eu.xthedoctah.updater.utils.IO;

import javax.swing.*;

/*
 * check if the updater has some update
 * check if the launcher has some update
 * */
public class Main {
    private static String workingDir = System.getProperty("user.home") + "/.whoniverse";
    private static String uri = "";

    public static void main(String[] args) {
        if (System.console() == null) {
            JOptionPane.showMessageDialog(null, "Errore: L'updater deve essere avviato da console!", "Errore", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        if (args.length == 0) {
            JOptionPane.showMessageDialog(null, "Errore: Mancano gli argomenti!", "Errore", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            Version.getInstance().setToken(args[0]);
        }

        Version local = Version.getInstance();
        Version remote = new RequestService().doRequest(uri, local);
        //TODO: To finish the download of the components.
        if (!remote.getUpdaterVersion().equals(local.getUpdaterVersion())) {
            Url url = (Url) new RequestService().doRequest(uri, new UpdaterReqDTO(remote.getUpdaterVersion()), Url.class);
            IO.createDir(workingDir + "/tmp");
        } else if (!remote.getLauncherVersion().equals(local.getLauncherVersion())) {
            Url url = (Url) new RequestService().doRequest(uri, new LauncherReqDTO(remote.getLauncherVersion()), Url.class);
            IO.createDir(workingDir + "/tmp");
        }

    }
}
