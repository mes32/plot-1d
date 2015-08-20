/*
    PrimaryAxes.java

    This class is part of the package plot1d

 */

package plot1d.graphicElements;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;


/**
 * This is an extension of JPanel for use by PlotGUI
 */
public class PrimaryAxes {

    private static final Color AXES_COLOR = new Color(190, 190, 190);

    private int axisX;
    private int axisY;

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public PrimaryAxes(BoxTransform trans) {
        axisX = trans.mapX(0);
        axisY = trans.mapY(0);

        minX = trans.getGuiMinX();
        maxX = trans.getGuiMaxX();
        minY = trans.getGuiMinY();
        maxY = trans.getGuiMaxY();

        if (axisX < minX) {
            axisX = minX;
        } else if (axisX > maxX) {
            axisX = maxX;
        }

        if (axisY < minY) {
            axisY = minY;
        } else if (axisY > maxY) {
            axisY = maxY;
        }
    }

    public void draw(Graphics g) {
        g.setColor(AXES_COLOR);
        g.drawLine(axisX, minY, axisX, maxY + minY);
        g.drawLine(minX, axisY, maxX + minX, axisY);
    }
}

