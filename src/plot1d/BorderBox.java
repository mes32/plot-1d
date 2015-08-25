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
public class BorderBox {

    private static final Color BORDER_COLOR = Color.black;
    private static final int MARGIN_TOP = 10;
    private static final int MARGIN_BOTTOM = 80;
    private static final int MARGIN_LEFT = 80;
    private static final int MARGIN_RIGHT = 10;

    private int height;
    private int width;

    private Point min;
    private Point max;

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public BorderBox(Dimension panelSize) {
        int panelWidth = (int)panelSize.getWidth();
        int panelHeight = (int)panelSize.getHeight();

        width = panelWidth - MARGIN_RIGHT - MARGIN_LEFT;
        height = panelHeight - MARGIN_TOP - MARGIN_BOTTOM;

        min = new Point(MARGIN_LEFT, MARGIN_TOP);
        max = new Point(panelWidth - MARGIN_RIGHT - MARGIN_LEFT, panelHeight - MARGIN_TOP - MARGIN_BOTTOM);

        minX = (int)min.getX();
        minY = (int)min.getY();
        maxX = (int)max.getX();
        maxY = (int)max.getY();
    }

    public Point getMin() {
        return min;
    }

    public Point getMax() {
        return max;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(Graphics g) {
        g.setColor(BORDER_COLOR);
        g.drawRect(minX, minY, maxX, maxY);
    }
}

