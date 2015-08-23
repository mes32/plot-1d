/*
    HorizontalAxis.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;


/**
 * This represents a horizontal axis drawn on PlotPanel
 */
abstract class HorizontalAxis extends AbstractAxis {

    private int axisY;

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public HorizontalAxis(double y, MappingToGUI trans) {
        axisY = trans.mapY(y);

        minX = trans.getBox().getMinX();
        maxX = trans.getBox().getMaxX();
        minY = trans.getBox().getMinY();
        maxY = trans.getBox().getMaxY();
    }


    abstract Color getColor();

    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawLine(minX, axisY, maxX + minX, axisY);
    }
}

