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
public class VerticalAxis extends AbstractAxis {

    private static final Color AXIS_COLOR = new Color(190, 190, 190);

    private int axisX;
    private int axisY;

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public VerticalAxis(MappingToGUI trans) {
        axisX = trans.mapX(0);
        axisY = trans.mapY(0);

        minX = trans.getBox().getMinX();
        maxX = trans.getBox().getMaxX();
        minY = trans.getBox().getMinY();
        maxY = trans.getBox().getMaxY();
    }

    public void draw(Graphics g) {
        g.setColor(AXIS_COLOR);
        g.drawLine(axisX, minY, axisX, maxY + minY);
    }
}

