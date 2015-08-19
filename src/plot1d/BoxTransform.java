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

    private Point min;
    private Point max;

    public BoxTransform(Dimension panelSize, Extent pointsExtent) {
        int width = (int)panelSize.getWidth();
        int height = (int)panelSize.getHeight();

        int xMargin = 20;
        int yMargin = 20;

        min = new Point(xMargin, yMargin);
        max = new Point(width - 2*xMargin, height - 2*yMargin);
    }

    public Point getMin() {
        return min;
    }

    public Point getMax() {
        return max;
    }

    public int getX(int x) {
        return 0;
    }

    public int getX(double x) {
        return 0;
    }

    public int getY(int y) {
        return 0;
    }

    public int getY(double y) {
        return 0;
    }
}

