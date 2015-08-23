/*
    PointsExtent.java - plot-1d

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;


/**
 * This represents a 2-dimensional point. A single sample from a 1-dimensional dataset. See 
 * DataField.java.
 */
public class PointsExtent {

    private double minX;
    private double minY;
    private double maxX;
    private double maxY;

    public PointsExtent(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getRangeX() {
        return maxX - minX;
    }

    public double getRangeY() {
        return maxY - minY;
    }

}
