package mapVisualizer;

import business.CityMapWithCoords;
import main.Node;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathGraphicPanel extends JPanel {

    List<Node> nodes; //nodes processed by dijkstra algo
    Map<String, double[]> map = new CityMapWithCoords().getMap();
    private final DijkstraSingleton updater;

    public PathGraphicPanel(DijkstraSingleton dijkstraSingleton) {
        this.updater = dijkstraSingleton;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
