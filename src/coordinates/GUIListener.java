package coordinates;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUIListener implements WindowListener {

    private Singleton singleton;

    public GUIListener(Singleton singleton) {
        this.singleton = singleton;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        singleton.printCoords();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
