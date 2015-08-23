/*
    PlotPanel.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;


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

        BorderBox box = new BorderBox(getSize());
        MappingToGUI trans = new MappingToGUI(box, DataPoint.getExtent(points));

        //drawAxesTertiary();
        //drawAxesSecondary();
        drawAxes(g, trans);
        //drawAxesIncrements();
        drawBorderBox(g, box);
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

    private void drawAxes(Graphics g, MappingToGUI trans) {
        HorizontalAxis primaryHorizontalAxis = new HorizontalAxis(trans);
        VerticalAxis primaryVerticalAxis = new VerticalAxis(trans);
        primaryHorizontalAxis.draw(g);
        primaryVerticalAxis.draw(g);
    }

    private void drawBorderBox(Graphics g, BorderBox box) {
        //BorderBox box = new BorderBox(trans.getGuiMin(), trans.getGuiMax());
        box.draw(g);
    }

    private void drawPoints(Graphics g, MappingToGUI trans) {
        for (DataPoint point : points) {
            //PlotPoint plotPoint = new PlotPoint(point, trans);
            point.draw(g, trans);
        }
    }
}

