/*
    PlotGUI.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;

import plot1d.data.*;

/**
 * This is the main plot-1d GUI in which the results of plotting will be displayed
 */
public class PlotGUI {

    private PlotFrame frame;
    private PlotPanel panel;

    public PlotGUI(InputObject input) {
        frame = new PlotFrame(input.getFileName());

        panel = new PlotPanel(input.getPoints());
        frame.add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
