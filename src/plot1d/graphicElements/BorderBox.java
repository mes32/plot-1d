/*
    BorderBox.java

    This class is part of the package plot1d

 */

package plot1d.graphicElements;

import java.io.*;
import javax.swing.*;
import java.awt.*;


/**
 * This is an extension of JPanel for use by PlotGUI
 */
public class BorderBox {

    private static final Color BORDER_COLOR = Color.black;

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public BorderBox(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        g.setColor(BORDER_COLOR);
        g.drawRect(x1, y1, x2, y2);
    }
}

