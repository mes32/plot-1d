/*
    BoxTransform.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.graphicElements.*;


/**
 * This represents the transform between data coordinate space and PlotPanel's GUI coordinate space
 */
public class BoxTransform {

    private Point guiMin;
    private Point guiMax;
    private int guiWidth;
    private int guiHeight;

    private double dataMinX;
    private double dataMaxX;
    private double dataMinY;
    private double dataMaxY;
    private double dataWidth;
    private double dataHeight;

    public BoxTransform(Dimension panelSize, Extent pointsExtent) {
        int panelWidth = (int)panelSize.getWidth();
        int panelHeight = (int)panelSize.getHeight();

        int marginX = 20;
        int marginY = 20;

        guiMin = new Point(marginX, marginY);
        guiMax = new Point(panelWidth - 2*marginX, panelHeight - 2*marginY);

        guiWidth = panelWidth - 2*marginX;
        guiHeight = panelHeight - 2*marginY;

        double inputRangeX = pointsExtent.getMaxX() - pointsExtent.getMinX();
        double inputRangeY = pointsExtent.getMaxY() - pointsExtent.getMinY();

        dataMinX = pointsExtent.getMinX() - 0.05*inputRangeX;
        dataMaxX = pointsExtent.getMaxX() + 0.05*inputRangeX;
        dataMinY = pointsExtent.getMinY() - 0.05*inputRangeY;
        dataMaxY = pointsExtent.getMaxY() + 0.05*inputRangeY;

        dataWidth = dataMaxX - dataMinX;
        dataHeight = dataMaxY - dataMinY;
    }

    public Point getGuiMin() {
        return guiMin;
    }

    public Point getGuiMax() {
        return guiMax;
    }

    public int mapX(double x) {
        double temp = (x - dataMinX) / dataWidth;
        temp = temp * (double)guiWidth + guiMin.getX();
        return (int)temp;
    }

    public int mapX(int x) {
        return mapX((double)x);
    }

    public int mapY(double y) {
        double temp = (y - dataMinY) / dataHeight;
        temp = temp * (double)guiHeight + guiMin.getY();
        return (int)temp;
    }

    public int mapY(int y) {
        return mapY((double)y);
    }

    public Point mapPoint(DataPoint point) {
        return new Point(mapX(point.getX()), mapY(point.getY()));
    } 
}

