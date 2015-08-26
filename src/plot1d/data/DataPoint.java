/*
    DataPoint.java - plot-1d

    This class is part of the package plot1d

 */

package plot1d.data;

import java.io.*;
import java.awt.*;

import plot1d.MappingToGUI;


/**
 * This represents a 2-dimensional point. A single sample from a 1-dimensional dataset. See 
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

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
        return new RegionExtent(minX, minY, maxX, maxY);
    }

    public void draw(Graphics g, plot1d.MappingToGUI trans) {

        int x = trans.mapX(this.x);
        int y = trans.mapY(this.y);

        g.setColor(POINT_COLOR);
        g.drawOval(x - HALF_POINT_RADIUS, y - HALF_POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }
}
