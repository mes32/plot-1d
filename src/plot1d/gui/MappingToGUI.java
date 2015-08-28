/*
    MappingToGUI.java

    This class is part of the package plot1d

 */

package plot1d.gui;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.data.*;


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
        temp = temp * (double)box.getWidth() + (double)box.getLeft();
        return (int)temp;
    }

    public int mapX(int x) {
        return mapX((double)x);
    }

    public int mapY(double y) {
        double temp = (y - plotExtent.getMinY()) / plotExtent.getRangeY();
        temp = temp * (double)box.getHeight();
        temp = (double)box.getBottom() - temp;
        return (int)temp;
    }

    public int mapY(int y) {
        return mapY((double)y);
    }

    public RegionExtent getDataExtent() {
        return dataExtent;
    }

    public RegionExtent getPlotExtent() {
        return plotExtent;
    }
}
