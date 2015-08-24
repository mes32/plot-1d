/*
    PrimaryVerticalAxis.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;


/**
 * This represents a primary vertical axis drawn on PlotPanel
 */
public class PrimaryVerticalAxis extends VerticalAxis {

    private static final Color AXIS_COLOR = new Color(170, 170, 170);

    public PrimaryVerticalAxis(double y, MappingToGUI trans) {
        super(y, trans);
    }

    @Override
    protected Color getColor() {
        return AXIS_COLOR;
    }
}

