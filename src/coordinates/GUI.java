package coordinates;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{


    GUI(){
        super("Coordinate Finder");
        Singleton singleton = new Singleton();
        this.addWindowListener(new GUIListener(singleton));
        setLayout(new BorderLayout());
        ControlPanel control = new ControlPanel(singleton);
        JPanel karte = new DeutschlandKarte(control.getCoordinatePanel(), singleton);
        add(karte, BorderLayout.CENTER);

        add(control, BorderLayout.LINE_START);

        pack();
        setSize(new Dimension(1000,1000));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        new GUI();
    }

}
