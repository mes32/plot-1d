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

    public PlotPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));


        this.setBackground(Color.white);
    }
}

