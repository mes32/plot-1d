/*
    MappingToGUI.java

    This class is part of the program plot-1d

 */

package plot1d.gui;

import javax.swing.*;
import java.awt.*;

import plot1d.data.*;


/**
 * This represents the transform that allows mapping locations in data-space into locations in 
 * GUI-space. In data-space locations are represented as coordinate pairs of type 'double'. The 
 * range of allowed values is arbitrary in data-space. GUI-space on the other hand plots the data 
 * points at pixel locations that must be coordinate pairs of type 'int' and are scaled to fit
 * within the size of GUI.
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

    /**
     * Returns the box that encloses the plotted points in GUI-space
     */
    public BorderBox getBox() {
        return box;
    }

    /**
     * Maps a 'double' type x-axis value from data-space to GUI-space, a pixel location
     */
    public int mapX(double x) {
        double temp = (x - plotExtent.getMinX()) / plotExtent.getRangeX();
        temp = temp * (double)box.getWidth() + (double)box.getLeft();
        return (int)temp;
    }

    /**
     * Maps an 'int' type x-axis value from data-space to GUI-space, a pixel location
     */
    public int mapX(int x) {
        return mapX((double)x);
    }

    /**
     * Maps a 'double' type y-axis value from data-space to GUI-space, a pixel location
     */
    public int mapY(double y) {
        double temp = (y - plotExtent.getMinY()) / plotExtent.getRangeY();
        temp = temp * (double)box.getHeight();
        temp = (double)box.getBottom() - temp;
        return (int)temp;
    }

    /**
     * Maps an 'int' type x-axis value from data-space to GUI-space, a pixel location
     */
    public int mapY(int y) {
        return mapY((double)y);
    }

    /**
     * Returns the rectangular region that encloses all datapoints. This region has no additional 
     * padding. The related getPlotExtent() function returns this region with some padding for 
     * display.
     */
    public RegionExtent getDataExtent() {
        return dataExtent;
    }

    /**
     * Returns the rectangular region that encloses the plotted region. This region has some 
     * additional padding. The related getDataExtent() function returns the region that tightly 
     * encloses the data without padding.
     */
    public RegionExtent getPlotExtent() {
        return plotExtent;
    }
}

