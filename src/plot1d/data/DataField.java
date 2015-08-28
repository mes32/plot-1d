/*
    DataField.java

    This class is part of the program plot-1d

 */

package plot1d.data;

import java.io.*;


/**
 * This represents one field/variable in a dataset to plot. There could several variables per 
 * dataset. See DataSet.java. This variable is primarily a list points to plot. See DataPoint.java.
 */
public class DataField {

    private String name;
    private DataPoint[] points;

    DataField(DataPoint[] points) {
        this.name = null;
        this.points = points;
    }

    /**
     * Returns the data points associated with this field/variable
     */
    public DataPoint[] getPoints() {
        return points;
    }

    /**
     * Returns the number of data points associated with this field/variable
     */
    public int getPointsLength() {
        return points.length;
    }
}
