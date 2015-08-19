/*
    PlotPoint.java

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
public class PlotPoint {

    private static final Color POINT_COLOR = Color.blue;

    private Point location;

    public PlotPoint(DataPoint input, BoxTransform trans) {
        location = trans.mapPoint(input);
    }

    public void draw(Graphics g) {
        g.setColor(POINT_COLOR);
        g.drawRect((int)location.getX()-1, (int)location.getY()-1, 3, 3);
    }
}

