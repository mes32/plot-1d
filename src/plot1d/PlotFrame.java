/*
 *  PlotFrame.java
 *
 *  This class is part of the package plot1d
 *
 */

package plot1d;

import java.io.*;
import javax.swing.JFrame;
import java.awt.*;


/**
 * This is an extension of JFrame for use by PlotGUI
 */
public class PlotFrame extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    public PlotFrame() {
        setTitle("Dummy Frame Title");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

