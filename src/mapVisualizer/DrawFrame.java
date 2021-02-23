package mapVisualizer;

import javax.swing.*;

public class DrawFrame extends JFrame {

    GraphicsPanel graphicsPanel;
    public DijkstraSingleton dijkstraSingleton = new DijkstraSingleton(this);

    DrawFrame(){
        super("Lines");
        this.graphicsPanel = new GraphicsPanel(this.dijkstraSingleton);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.add(graphicsPanel);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args){

        DrawFrame df = new DrawFrame();
        try{
            df.dijkstraSingleton.findPath("Mannheim", "Köln");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
