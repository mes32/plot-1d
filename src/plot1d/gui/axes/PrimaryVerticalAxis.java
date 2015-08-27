/*
    PrimaryVerticalAxis.java

    This class is part of the package plot1d

 */

package plot1d.gui.axes;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;
import plot1d.gui.*;


/**
 * This represents a primary vertical axis drawn on PlotPanel
 */
public class PrimaryVerticalAxis extends VerticalAxis {

    private static final Color AXIS_COLOR = new Color(100, 100, 100);

    public PrimaryVerticalAxis(double y, MappingToGUI trans) {
        super(y, trans);
    }

    @Override
    protected Color getColor() {
        return AXIS_COLOR;
    }
}

