package coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {

    private Component parent;
    private JLabel positionText;
    private static final int JPG_WIDTH = 752;
    private static final int JPG_HEIGTH = 891;
    private Normalizer normalizer;

    ClickListener(Component parent, JLabel positionText, Singleton singleton){
        this.parent = parent;
        this.positionText = positionText;
        this.normalizer = new Normalizer(20,20,JPG_WIDTH,JPG_HEIGTH);
        singleton.setNormalizer(normalizer);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     *
     * returns mouse position relative to parent component
     */
    @Override
    public void mousePressed(MouseEvent e) {
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        double parentX = parent.getLocationOnScreen().getX();
        double parentY = parent.getLocationOnScreen().getY();
        double x_coord = mouseX - parentX;
        double y_coord = mouseY - parentY;
        normalizer.normalize(x_coord, y_coord);
        positionText.setText("" + normalizer.getX_coord() + ", " + normalizer.getY_coord());
        //System.out.println("Position: " + (mouseX - parentX) + ", " + (mouseY - parentY));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
