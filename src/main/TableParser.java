package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TableParser {
    private static final String FILE_DISTANCE_TABLE = "res/etab.html";
    List <Integer> distances;
    List <String> cities;
    Map<List<String>, Integer> cityToCityDistance;

    public TableParser(){
        this.distances = new LinkedList<>();
        this.cities = new LinkedList<>();
        this.cityToCityDistance = new HashMap<>();
        int zero = 0;
        initListsFromFile();
        mapCitiesDistances();
    }

    public List<String> getCities() {
        return cities;
    }

    public Map<List<String>, Integer> getCityToCityDistance() {
        return cityToCityDistance;
    }

    /**
     * creates map with key: city, other city and value: distance between the 2 cities
     */
    private void mapCitiesDistances(){
        int n = -1;
        ListIterator<Integer> dists = distances.listIterator();
        for (String city : cities){
            for(String otherCity : cities){
                if(dists.hasNext()) n = dists.next();
                cityToCityDistance.put(List.of(city, otherCity), n);
            }
        }
    }


    //TODO funktion teilen in pattern match und adden
    private void extractCityFromString(String s){
        String pattern = ".*?(<b>)(.+)(</b>).*";
        if(s.matches(pattern)){
            cities.add(s.replaceAll(pattern, "$2"));
        }
    }

    private void extractNumberFromString(String s){
        String pattern = "[\\s]*(<td>[^0-9]*)([0-9]+)([^0-9]*</td>)";
        String zeroPattern = "[\\s]*<td bgcolor=\"#F88208\">&nbsp;</td>"; //für Verbindung von Stadt zu sich selbst
        //System.out.println("check for number");
        int r = -1;
        if (s.matches(pattern)) {
            String number = s.replaceAll(pattern, "$2");
            r = Integer.parseInt(number);
        }
        else if(s.matches(zeroPattern)){
            r = 0;
        }

        if(r >= 0) distances.add(r);
    }

    /*
    read File and call parseFunctions
     */
    private void initListsFromFile(){
        try {
            BufferedReader in = new BufferedReader(new FileReader(FILE_DISTANCE_TABLE));
            String line;
            while((line = in.readLine()) != null){
                extractNumberFromString(line);
                extractCityFromString(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
