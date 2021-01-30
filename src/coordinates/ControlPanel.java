package coordinates;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ControlPanel extends JPanel {
    private JLabel coordinatePanel;

    ControlPanel(Singleton singleton){

        JLabel currentCity = new JLabel("", SwingConstants.CENTER); //display cities here, change when button clicked

        coordinatePanel = new JLabel("Koordinaten: ", SwingConstants.CENTER);

        JButton nextCity = new JButton("Next");
        nextCity.addActionListener(new ChangeCityAction(currentCity, singleton));

        currentCity.setBorder(BorderFactory.createLineBorder(Color.black));
        coordinatePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        nextCity.setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new GridLayout(3,1));
        add(currentCity);
        add(coordinatePanel);
        add(nextCity);
    }


    public JLabel getCoordinatePanel(){
        return coordinatePanel;
    }
}
