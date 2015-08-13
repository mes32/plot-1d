/*
 *  PlotGUI.java
 *
 *  This class is part of the package plot1d
 *
 */

package plot1d;

import java.io.*;
import javax.swing.*;

/**
 * This is the main plot-1d GUI in which the results of plotting will be displayed
 */
public class PlotGUI {

    private PlotFrame frame;

    public PlotGUI(InputObject input) {
        frame = new PlotFrame(input.getFileName());

        JLabel label = new JLabel("Dummy Label text");
        frame.add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
