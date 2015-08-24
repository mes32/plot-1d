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

    private static final Color LABEL_COLOR = new Color(0, 0, 0);
    private static final Font LABEL_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 12);

    private int axisX;
    private String label;

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public VerticalAxis(double x, MappingToGUI trans) {
        axisX = trans.mapX(x);
        label = String.valueOf(x);

        minX = trans.getBox().getMinX();
        maxX = trans.getBox().getMaxX();
        minY = trans.getBox().getMinY();
        maxY = trans.getBox().getMaxY();
    }

    abstract Color getColor();

    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawLine(axisX, minY, axisX, maxY + minY);

        g.setColor(LABEL_COLOR);
        g.setFont(LABEL_FONT);
        FontMetrics metric = g.getFontMetrics(LABEL_FONT);
        int width = metric.stringWidth(label);
        int height = metric.getAscent();
        int x = axisX - (width / 2);
        int y = maxY + (height / 2) + 25;
        g.drawString(label, x, y);
    }
}

