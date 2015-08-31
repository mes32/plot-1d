/*
    DataSet.java
  
    This class is part of the program plot-1d
  
 */

package plot1d.data;

import java.io.*;
import java.util.*;

import plot1d.exceptions.*;


/**
 * This represents a dataset to plot. It has one or more fields/variables. See DataField.java.
 */
public class DataSet {

    private DataField[] fields;

    public DataSet(File file) throws InputFileNotFoundException, InvalidInputFileException {

        // *** For now assume file contains a single set of space delimited points (i.e. one field) and no header row
        List<DataPoint> pointList = new ArrayList<DataPoint>();

        FileInputStream inputStream = null;
        BufferedReader br = null;
        try {
            if (file.isDirectory()) {
                throw new InvalidInputFileException("Input file cannot be a directory. " + file);
            }

            // Open input file
            inputStream = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(inputStream));

            // Read file
            String line;
            while ((line = br.readLine()) != null)   {

                String[] tokens = line.split(" ");
                if (tokens.length != 0 && tokens.length != 2) {
                    throw new InvalidInputFileException("Invalid input file. " + file);
                }
                if (tokens.length == 0) {
                    continue;
                }

                // Parse tokens for numeric information (ignore any commas)
                double x = Double.parseDouble(tokens[0].trim().replaceAll(",", ""));
                double y = Double.parseDouble(tokens[1].trim().replaceAll(",", ""));
                pointList.add(new DataPoint(x, y));
            }

            // Close file
            br.close();
        } catch (FileNotFoundException e) {
            throw new InputFileNotFoundException("Input file not found. " + file);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            try {
                br.close();
            } catch (Exception e) {} 
        }

        DataPoint[] points = pointList.toArray(new DataPoint[pointList.size()]);

        fields = new DataField[1];
        fields[0] = new DataField(points);
    }

    /**
     * Returns the data points associated with this dataset
     */
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
}
