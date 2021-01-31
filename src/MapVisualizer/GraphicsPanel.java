package MapVisualizer;

import business.CityMapWithCoords;
import main.ClusterCreator;
import main.Connection;
import main.Node;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphicsPanel extends JPanel {

    Map<String, double[]> map = new HashMap<>();
    List<Node> cluster = new ClusterCreator().getCluster();

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.map = new CityMapWithCoords().getMap();
        //this.setBackground();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        double[] coords = new double[2];

        for(Node node : cluster){
            for(Connection connection : node.getConnections()){
                //set coords from originNode
                coords = map.get(node.getName());
                x1 = (int) coords[0];
                y1 = (int) coords[1];

                //set coords from originNode
                coords = map.get(connection.getGoToNode().getName());
                x2 = (int) coords[0];
                y2 = (int) coords[1];
                g2d.drawLine(x1, y1, x2, y2);
            }
        }

        g2d.drawLine(x1, y1, x2, y2);

    }
}
