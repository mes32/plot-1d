/*
    VerticalAxis.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;


/**
 * This represents a vertical axis drawn on PlotPanel
 */
abstract class VerticalAxis extends AbstractAxis {

    private int axisX;

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public VerticalAxis(double x, MappingToGUI trans) {
        axisX = trans.mapX(x);

        minX = trans.getBox().getMinX();
        maxX = trans.getBox().getMaxX();
        minY = trans.getBox().getMinY();
        maxY = trans.getBox().getMaxY();
    }

    abstract Color getColor();

    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawLine(axisX, minY, axisX, maxY + minY);
    }
}

