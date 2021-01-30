package coordinates;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Singleton {
    private Normalizer normalizer;
    private List<double[]> coordinates = new LinkedList<>();

    public void setNormalizer(Normalizer normalizer) {
        this.normalizer = normalizer;
    }

    public Normalizer getNormalizer() {
        return normalizer;
    }

    public void updateCoordinates(){
        double[] coords = {normalizer.getX_coord(), normalizer.getY_coord()};
        coordinates.add(coords);
    }

    public List<double[]> getCoordinates() {
        return coordinates;
    }

    public void printCoords(){
        for(double[] coords : coordinates){
            System.out.println("" + coords[0] + ", " + coords[1]);
        }
    }
}
