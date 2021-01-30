package coordinates;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DeutschlandKarte extends JPanel {

    private JLabel coordinates;
    private BufferedImage karte;

    DeutschlandKarte(JLabel coordinates, Singleton singleton){
        this.coordinates = coordinates;
        try {
            karte = ImageIO.read(new File("res/karte.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        addMouseListener(new ClickListener(this, coordinates, singleton));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(karte, 0, 0, this);
    }
}
