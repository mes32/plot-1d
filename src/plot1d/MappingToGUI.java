/*
    MappingToGUI.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;



/**
 * This represents the transform between data coordinate space and PlotPanel's GUI coordinate space
 */
public class MappingToGUI {

    private static final double DATA_PADDING = 0.05;

    private BorderBox box;
    private RegionExtent regionExtent;

    private double dataMinX;
    private double dataMaxX;
    private double dataMinY;
    private double dataMaxY;
    private double dataWidth;
    private double dataHeight;

    public MappingToGUI(BorderBox box, RegionExtent regionExtent) {

        this.box = box;
        this.regionExtent = regionExtent;

        double inputRangeX = regionExtent.getRangeX();
        double inputRangeY = regionExtent.getRangeY();

        double xPad = DATA_PADDING * inputRangeX;
        double yPad = DATA_PADDING * inputRangeY;

        dataMinX = regionExtent.getMinX() - xPad;
        dataMaxX = regionExtent.getMaxX() + xPad;
        dataMinY = regionExtent.getMinY() - yPad;
        dataMaxY = regionExtent.getMaxY() + yPad;

        dataWidth = dataMaxX - dataMinX;
        dataHeight = dataMaxY - dataMinY;
    }

    public BorderBox getBox() {
        return box;
    }

    public int mapX(double x) {
        double temp = (x - dataMinX) / dataWidth;
        temp = temp * (double)box.getWidth() + (double)box.getMinX();
        return (int)temp;
    }

    public int mapX(int x) {
        return mapX((double)x);
    }

    public int mapY(double y) {
        double temp = (y - dataMinY) / dataHeight;
        temp = temp * (double)box.getHeight() + (double)box.getMinY();
        temp = 10.0 + (double)box.getHeight() - 0.90*temp;

        // *** This is only approximately correct

        return (int)temp;
    }

    public int mapY(int y) {
        return mapY((double)y);
    }

    public Point mapPoint(DataPoint point) {
        return new Point(mapX(point.getX()), mapY(point.getY()));
    } 
}

