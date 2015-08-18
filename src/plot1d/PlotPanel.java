/*
    PlotPanel.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.graphicComponents.*;


/**
 * This is an extension of JPanel for use by PlotGUI
 */
public class PlotPanel extends JPanel {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public PlotPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setSize(new Dimension(WIDTH, HEIGHT));
        //setMinimumSize(new Dimension(WIDTH, HEIGHT));
        //setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(Color.white);
    }

    private void drawAll(Graphics g) {
        // Calculate borders and offsets

        //drawAxesTertiary();
        //drawAxesSecondary();
        //drawAxesPrimary();
        //drawAxesIncrements();
        drawBorderBox(g);
        //drawXLab();
        //drawYLab();
        //drawTitle();
        //drawPoints(input.getPoints());
        //drawKey();

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAll(g);
    }

    private void drawBorderBox(Graphics g) {
        BorderBox box = new BorderBox();
        box.draw(g);
    }
}

