/*
 *  DataSet.java - plot-1d
 *
 *  This class is part of the package plot1d
 *
 */

package plot1d.data;

import java.io.*;
import java.util.*;


/**
 * This represents a dataset to plot using plot-1d
 */
public class DataSet {

    private DataField[] fields;

    public DataSet(File file) {

        // *** For now assume file contains a single set of space delimited points (i.e. one field) and no header row
        List<DataPoint> pointList = new ArrayList<DataPoint>();

        FileInputStream inputStream = null;
        BufferedReader br = null;
        try {
            // Open input file
            inputStream = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(inputStream));

            // Read file
            String line;
            while ((line = br.readLine()) != null)   {

                String[] tokens = line.split(" ");
                if (tokens.length != 0 && tokens.length != 2) {
                    // *** Should throw an exception instead of crash
                    System.err.println("In DataSet.java - Invalid line found in input file");
                    System.exit(1);
                }
                if (tokens.length == 0) {
                    continue;
                }

                double x = Double.parseDouble(tokens[0].trim());
                double y = Double.parseDouble(tokens[1].trim());
                pointList.add(new DataPoint(x, y));
            }

            // Close file
            br.close();
        } catch (FileNotFoundException e) {
            // *** Should throw an exception instead of crash
            System.err.println("In DataSet.java - FileNotFoundException");
            System.exit(1);
        } catch (IOException e) {
            // *** Should throw an exception instead of crash
            System.err.println("In DataSet.java - IOException");
            System.exit(1);
        } finally {
            try {
                br.close();
            } catch (IOException e) {} 
        }

        DataPoint[] points = pointList.toArray(new DataPoint[pointList.size()]);

        fields = new DataField[1];
        fields[0] = new DataField(points);
    }

    public DataPoint[] getPoints() {

        int totalLength = 0;
        for (DataField field : fields) {
            totalLength += field.getPointsLength();
        }

        DataPoint[] points = new DataPoint[totalLength];
        int index = 0;
        for (DataField field : fields) {
            DataPoint[] tempArray = field.getPoints();
            for (int j=0; j < tempArray.length; j++) {
                points[index] = tempArray[j];
                index++;
            }
        }

        return points;
    }

    /*public void addFile(File file) {

    }*/

    /*public void plot() {

    }*/
}
