/*
 *  DataField.java - plot-1d
 *
 *  This class is part of the package plot1d
 *
 */

package plot1d;

import java.io.*;


/**
 * This represents one field/variable in a dataset to plot using plot-1d. See DataSet.java.
 */
public class DataField {

    private String name;
    private DataPoint[] points;

    DataField(DataPoint[] points) {
        this.name = null;
        this.points = points;
    }
}
