/*
    RegionExtent.java - plot-1d

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
public class RegionExtent {

    private double minX;
    private double minY;
    private double maxX;
    private double maxY;

    public RegionExtent(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public RegionExtent(RegionExtent input, double expansionFactor) {
        double inputRangeX = input.getRangeX();
        double inputRangeY = input.getRangeY();

        double xPadding = expansionFactor * inputRangeX;
        double yPadding = expansionFactor * inputRangeY;

        this.minX = input.getMinX() - xPadding;
        this.maxX = input.getMaxX() + xPadding;
        this.minY = input.getMinY() - yPadding;
        this.maxY = input.getMaxY() + yPadding;
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

    public boolean containsX(double x) {
        if (x > maxX || x < minX) {
            return false;
        } else {
            return true;
        }
    }

    public boolean containsY(double y) {
        if (y > maxY || y < minY) {
            return false;
        } else {
            return true;
        }
    }

}
