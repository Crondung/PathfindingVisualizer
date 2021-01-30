package coordinates;

import main.TableParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class ChangeCityAction implements ActionListener {
    private List<String> cities;
    JLabel cityText;
    Iterator<String> cityIterator;
    Singleton singleton;

    ChangeCityAction(JLabel cityText, Singleton singleton){
        this.singleton = singleton;
        this.cityText = cityText;
        this.cities = new TableParser().getCities();
        this.cityIterator = cities.iterator();
        this.cityText.setText(cityIterator.next());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(cityIterator.hasNext()){
            cityText.setText(cityIterator.next());
        }
        singleton.updateCoordinates();
    }
}
