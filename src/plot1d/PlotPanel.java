/*
    PlotPanel.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.graphicElements.*;


/**
 * This is an extension of JPanel for use by PlotGUI
 */
public class PlotPanel extends JPanel {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private DataPoint[] points;

    public PlotPanel(DataPoint[] points) {

        this.points = points;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setSize(new Dimension(WIDTH, HEIGHT));
        //setMinimumSize(new Dimension(WIDTH, HEIGHT));
        //setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(Color.white);
    }

    private void drawAll(Graphics g) {
        BoxTransform trans = new BoxTransform(getSize(), DataPoint.getExtent(points));

        //drawAxesTertiary();
        //drawAxesSecondary();
        //drawAxesPrimary();
        //drawAxesIncrements();
        drawBorderBox(g, trans);
        //drawXLab();
        //drawYLab();
        //drawTitle();
        drawPoints(g, trans);
        //drawKey();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAll(g);
        repaint();
    }

    private void drawBorderBox(Graphics g, BoxTransform trans) {

        BorderBox box = new BorderBox(trans.getGuiMin(), trans.getGuiMax());
        box.draw(g);
    }

    private void drawPoints(Graphics g, BoxTransform trans) {

        for (DataPoint point : points) {
            PlotPoint plotPoint = new PlotPoint(point, trans);
            plotPoint.draw(g);
        }
    }
}

