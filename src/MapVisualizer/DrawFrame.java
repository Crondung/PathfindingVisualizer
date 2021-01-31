package MapVisualizer;

import business.CityMapWithCoords;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class DrawFrame extends JFrame {

    GraphicsPanel graphicsPanel = new GraphicsPanel();

    DrawFrame(){
        super("Lines");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.add(graphicsPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args){
        new DrawFrame();
    }
}
