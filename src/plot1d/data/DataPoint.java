/*
    DataPoint.java

    This class is part of the program plot-1d

 */

package plot1d.data;

import java.awt.*;

import plot1d.gui.*;


/**
 * This represents a 2-dimensional point. A single sample from a 1-dimensional dataset. A dataset
 * may have many fields/variables each with a collection of such points. See DataSet.java and 
 * DataField.java.
 */
public class DataPoint {

    private static final int POINT_RADIUS = 6;
    private static final int HALF_POINT_RADIUS = POINT_RADIUS / 2;
    private static final Color POINT_COLOR = new Color (0, 127, 255);

    private double x;
    private double y;

    public DataPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-axis location of this point
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-axis location of this point
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the 2-d region that encloses all data points in an array. This is essentially a 
     * rectangle represented by a RegionExtent object.
     */
    public static RegionExtent getExtent(DataPoint[] points) {
        if (points.length == 0) {
            return new RegionExtent(0, 0, 0, 0);
        }

        double minX = points[0].getX();
        double maxX = minX;
        double minY = points[0].getY();
        double maxY = minY;

        for (int i=1; i < points.length; i++) {
            double x = points[i].getX();
            double y = points[i].getY();

            if (x < minX) {
                minX = x;
            } else if (x > maxX) {
                maxX = x;
            }

            if (y < minY) {
                minY = y;
            } else if (y > maxY) {
                maxY = y;
            }
        }

        // Return region extent representing the maximum and minimum values encountered
        return new RegionExtent(minX, minY, maxX, maxY);
    }

    /**
     * Draws this data point on GUI. First maps the location of this point in data-space to a 
     * location in GUI-space (i.e. relative to the frame window, scaled to the size of the frame 
     * window, and rasterized byrounded to the nearest integer).
     */
    public void draw(Graphics g, MappingToGUI trans) {
        int x = trans.mapX(this.x);
        int y = trans.mapY(this.y);
        g.setColor(POINT_COLOR);
        g.drawOval(x - HALF_POINT_RADIUS, y - HALF_POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }
}
