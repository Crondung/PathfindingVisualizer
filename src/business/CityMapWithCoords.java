package business;

import main.TableParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CityMapWithCoords {
    List<String> cities = new TableParser().getCities();
    List<double[]> coordinates = new LinkedList<>();
    Map<String, double[]> map = new HashMap<>();

    public CityMapWithCoords(){
        readCoordinates();
        generateMap();
    }

    public Map<String, double[]> getMap() {
        return map;
    }

    private void generateMap() {
        Iterator<String> citiesIterator = cities.iterator();
        Iterator<double[]> coordsIterator = coordinates.iterator();
        while (citiesIterator.hasNext() && coordsIterator.hasNext()){
            map.put(citiesIterator.next(), coordsIterator.next());
        }
    }

    private void readCoordinates() {
        try (BufferedReader br = new BufferedReader(new FileReader("res/test.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                double[] coords = new double[2];
                String[] values = line.split(",");
                coords[0] = Double.parseDouble(values[0]);
                coords[1] = Double.parseDouble(values[1]);
                coordinates.add(coords);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
