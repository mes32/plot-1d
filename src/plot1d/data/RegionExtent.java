/*
    RegionExtent.java

    This class is part of the program plot-1d

 */

package plot1d.data;

import java.io.*;
import javax.swing.*;
import java.awt.*;


/**
 * This represents a rectangular region that encompasses the extent of a set of data points.
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

    /**
     * Alternate constructor that expands an input region by a percentage in each direction.
     */
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

    /**
     * Returns the minimum x-axis value found in the set of input points
     */
    public double getMinX() {
        return minX;
    }

    /**
     * Returns the minimum y-axis value found in the set of input points
     */
    public double getMinY() {
        return minY;
    }

    /**
     * Returns the maximum x-axis value found in the set of input points
     */
    public double getMaxX() {
        return maxX;
    }

    /**
     * Returns the maximum y-axis value found in the set of input points
     */
    public double getMaxY() {
        return maxY;
    }

    /**
     * Returns the range of x-axis values found in the set of input points
     */
    public double getRangeX() {
        return maxX - minX;
    }

    /**
     * Returns the range of y-axis values found in the set of input points
     */
    public double getRangeY() {
        return maxY - minY;
    }

    /**
     * Returns true if a given value falls within the x-axis values of this rectangular region
     */
    public boolean containsX(double x) {
        if (x > maxX || x < minX) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns true if a given value falls within the y-axis values of this rectangular region
     */
    public boolean containsY(double y) {
        if (y > maxY || y < minY) {
            return false;
        } else {
            return true;
        }
    }

}
