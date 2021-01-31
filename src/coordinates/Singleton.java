package coordinates;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    public void writeCoordsToCSV() throws FileNotFoundException {
        String filename = "res/test.csv";
        PrintWriter writer = new PrintWriter(new File(filename));
        for(double[] coord : coordinates){
            writer.write("" + coord[0] + ", " + coord[1] + "\n");
        }
        writer.close();
    }

    public void printCoords(){
        for(double[] coords : coordinates){
            System.out.println("" + coords[0] + ", " + coords[1]);
        }
    }
}
