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
        // *** Calculate borders and offsets
        // *** This should include creating mapping = new boxTransform(getWidth(), getHeight);
        //     int xTrans = mapping.getX(xOld);
        //     int yTrans = mapping.getY(yOld);
        //     int xMin = mapping.getMinX();
        //     int xMax = mapping.getMaxX();

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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAll(g);
        repaint();
    }

    private void drawBorderBox(Graphics g) {
        Dimension panelSize = getSize();
        int width = (int)panelSize.getWidth();
        int marginWidth = width/20;
        int height = (int)panelSize.getHeight();
        int marginHeight = height/20;

        BorderBox box = new BorderBox(marginWidth, marginHeight, width - 2*marginWidth, height - 2*marginHeight);
        box.draw(g);
    }
}

