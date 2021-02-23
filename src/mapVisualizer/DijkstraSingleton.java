package mapVisualizer;

import main.Dijkstra;
import main.Node;

import java.awt.*;
import java.util.List;

public class DijkstraSingleton {

    private Dijkstra dijkstra = new Dijkstra(this);
    private GraphicsPanel pathGraphicPanel = new GraphicsPanel(this);
    private DrawFrame df;

    public DijkstraSingleton(DrawFrame drawFrame) {
        this.df = drawFrame;
    }

    public List<Node> getProcessedNodes(){
        return dijkstra.getProcessedNodes();
    }

    public void findPath(String from, String to) throws InterruptedException {
        this.dijkstra.findWayBetween(from, to);
    }

    public void updatePaths(){
        this.df.getContentPane().validate();
        this.df.getContentPane().repaint();
    }

}
