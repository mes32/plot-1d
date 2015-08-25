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
    private RegionExtent dataExtent;
    private RegionExtent plotExtent;

    public MappingToGUI(BorderBox box, RegionExtent dataExtent) {
        this.box = box;
        this.dataExtent = dataExtent;
        this.plotExtent = new RegionExtent(dataExtent, DATA_PADDING);
    }

    public BorderBox getBox() {
        return box;
    }

    public int mapX(double x) {
        double temp = (x - plotExtent.getMinX()) / plotExtent.getRangeX();
        temp = temp * (double)box.getWidth() + (double)box.getMinX();
        return (int)temp;
    }

    public int mapX(int x) {
        return mapX((double)x);
    }

    public int mapY(double y) {
        double temp = (y - plotExtent.getMinY()) / plotExtent.getRangeY();
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

