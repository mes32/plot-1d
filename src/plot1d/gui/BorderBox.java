/*
    BorderBox.java

    This class is part of the package plot1d

 */

package plot1d.gui;

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

    private int x;
    private int y;

    private int height;
    private int width;

    public BorderBox(Dimension panelSize) {
        int panelWidth = (int)panelSize.getWidth();
        int panelHeight = (int)panelSize.getHeight();

        width = panelWidth - MARGIN_RIGHT - MARGIN_LEFT;
        height = panelHeight - MARGIN_TOP - MARGIN_BOTTOM;

        x = MARGIN_LEFT;
        y = MARGIN_TOP;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTop() {
        return y;
    }

    public int getBottom() {
        return y + height;
    }

    public int getLeft() {
        return x;
    }

    public int getRight() {
        return x + width;
    }

    public void draw(Graphics g) {
        g.setColor(BORDER_COLOR);
        g.drawRect(x, y, width, height);
    }
}

