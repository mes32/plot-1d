/*
    DataPoint.java - plot-1d

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;


/**
 * This represents a 2-dimensional point. A single sample from a 1-dimensional dataset. See 
 * DataField.java.
 */
public class DataPoint {

    private double x;
    private double y;

    public DataPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
