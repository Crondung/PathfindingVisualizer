package coordinates;

import java.awt.*;
import java.text.DecimalFormat;

/*
    used to normalize given Point into x and y coordinates
    relative to the points environment
    for a cartesian System with adjustable max x/y size
*/
public class Normalizer {

    //TODO Verhältnis von environment zu axis sollte beibehalten werden

    private int x_axis_max;
    private int y_axis_max;
    private int pointEnvironmentMaxX;
    private int pointEnvironmentMaxY;

    private double x_coord;
    private double y_coord;

    Normalizer(int x_axis_max, int y_axis_max, int pointEnvironmentMaxX, int pointEnvironmentMaxY){
        this.x_axis_max=x_axis_max;
        this.y_axis_max=y_axis_max;
        this.pointEnvironmentMaxX = pointEnvironmentMaxX;
        this.pointEnvironmentMaxY = pointEnvironmentMaxY;
    }

    public void normalize(double pointX, double pointY){
        this.x_coord = pointX/pointEnvironmentMaxX * x_axis_max;
        this.y_coord = pointY/pointEnvironmentMaxY * y_axis_max;
    }

    /*
    return coord rounded to 1 decimal place
    rounding always gives just 1 decimal??
     */
    public double getX_coord() {
        return Math.round(x_coord);
    }

    public double getY_coord() {
        return Math.round(y_coord);
    }
}
