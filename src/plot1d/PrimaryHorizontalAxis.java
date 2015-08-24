/*
    PrimaryHorizontalAxis.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;


/**
 * This represents a primary horizontal axis drawn on PlotPanel
 */
public class PrimaryHorizontalAxis extends HorizontalAxis {

    private static final Color AXIS_COLOR = new Color(170, 170, 170);

    public PrimaryHorizontalAxis(double y, MappingToGUI trans) {
        super(y, trans);
    }

    @Override
    protected Color getColor() {
        return AXIS_COLOR;
    }
}

