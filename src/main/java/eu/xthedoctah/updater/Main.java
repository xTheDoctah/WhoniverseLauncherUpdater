package eu.xthedoctah.updater;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0)
            JOptionPane.showMessageDialog(null, "Errore: Mancano gli argomenti!","Errore",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        if(System.console() == null)
            JOptionPane.showMessageDialog(null,"Errore: L'updater deve essere avviato da console!","Errore",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
    }
}
