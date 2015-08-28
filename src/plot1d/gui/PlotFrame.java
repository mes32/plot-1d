/*
    PlotFrame.java

    This class is part of the program plot-1d

 */

package plot1d.gui;

import javax.swing.*;
import java.awt.*;


/**
 * This is an extension of JFrame for use by PlotGUI
 */
public class PlotFrame extends JFrame {
    public PlotFrame(String plottedFileName) {
        setTitle(plottedFileName + "  -  plot-1d");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

