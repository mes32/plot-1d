/*
    BorderBox.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;


/**
 * This is an extension of JPanel for use by PlotGUI
 */
public class BorderBoxTemp {

    private static final Color BORDER_COLOR = Color.black;

    private Point min;
    private Point max;

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public BorderBoxTemp(Point min, Point max) {
        this.min = min;
        this.max = max;

        minX = (int)min.getX();
        minY = (int)min.getY();
        maxX = (int)max.getX();
        maxY = (int)max.getY();
    }

    public void draw(Graphics g) {
        g.setColor(BORDER_COLOR);
        g.drawRect(minX, minY, maxX, maxY);
    }
}

