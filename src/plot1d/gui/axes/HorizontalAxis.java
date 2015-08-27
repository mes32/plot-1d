/*
    HorizontalAxis.java

    This class is part of the package plot1d

 */

package plot1d.gui.axes;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;
import plot1d.gui.*;


/**
 * This represents a horizontal axis drawn on PlotPanel
 */
abstract class HorizontalAxis extends AbstractAxis {

    private static final Color LABEL_COLOR = new Color(0, 0, 0);
    private static final Font LABEL_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 12);

    private int axisY;
    private String label;

    private int left;
    private int right;

    public HorizontalAxis(double y, MappingToGUI trans) {
        axisY = trans.mapY(y);
        label = String.valueOf(y);

        left = trans.getBox().getLeft();
        right = trans.getBox().getRight();
    }


    abstract Color getColor();

    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawLine(left, axisY, right, axisY);

        g.setColor(LABEL_COLOR);
        g.setFont(LABEL_FONT);
        FontMetrics metric = g.getFontMetrics(LABEL_FONT);
        int width = metric.stringWidth(label);
        int height = metric.getAscent();
        int x = left - 8 - width;
        int y = axisY + (height / 2) - 1;
        g.drawString(label, x, y);
    }
}

