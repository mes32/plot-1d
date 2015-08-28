/*
    InputObject.java

    This class is part of the program plot-1d

 */

package plot1d.data;

import java.io.*;

import plot1d.data.*;


/**
 * This class parses the input arguments and packages them into an object for use by the other 
 * classes. 
 */
public class InputObject {

    private File file;
    private String fileName;
    private DataSet dataSet;

    public InputObject(String[] args) {
        if (args.length == 0) {
            // *** Should throw an exception instead of crash
            System.err.println("Missing input file");
            System.exit(1);
        }

        String path = args[0];
        file = new File(path);

        dataSet = new DataSet(file);
    }

    /**
     * Returns a nicely formatted string of the filename given in this input command.
     */
    public String getFileName() {
        return file.getName() + " (" + file.getParentFile().getPath() + ")";
    }

    /**
     * Returns an array of data points provided in this input command.
     */
    public DataPoint[] getPoints() {
        return dataSet.getPoints();
    }
}
