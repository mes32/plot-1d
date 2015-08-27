/*
    PrimaryHorizontalAxis.java

    This class is part of the package plot1d

 */

package plot1d.gui.axes;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;
import plot1d.gui.*;


/**
 * This represents a primary horizontal axis drawn on PlotPanel
 */
public class PrimaryHorizontalAxis extends HorizontalAxis {

    private static final Color AXIS_COLOR = new Color(100, 100, 100);

    public PrimaryHorizontalAxis(double y, MappingToGUI trans) {
        super(y, trans);
    }

    @Override
    protected Color getColor() {
        return AXIS_COLOR;
    }
}

