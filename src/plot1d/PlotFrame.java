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

    public PlotFrame(String plottedFileName) {
        setTitle(plottedFileName + "  -  plot-1d");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

