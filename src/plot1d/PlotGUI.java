/*
    PlotGUI.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;

/**
 * This is the main plot-1d GUI in which the results of plotting will be displayed
 */
public class PlotGUI {

    private PlotFrame frame;
    private PlotPanel panel;

    public PlotGUI(InputObject input) {
        frame = new PlotFrame(input.getFileName());

        panel = new PlotPanel();
        frame.add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

        // Calculate borders and offsets

        //panel.drawAxesTertiary();
        //panel.drawAxesSecondary();
        //panel.drawAxesPrimary();
        //panel.drawAxesIncrements();
        //panel.drawBorderBox();
        //panel.drawXLab();
        //panel.drawYLab();
        //panel.drawTitle();
        //panel.drawPoints(input.getPoints());
        //panel.drawKey();
    }
}
