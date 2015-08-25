/*
    SecondaryVerticalAxis.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;


/**
 * This represents a secondary vertical axis drawn on PlotPanel
 */
public class SecondaryVerticalAxis extends VerticalAxis {

    private static final Color AXIS_COLOR = new Color(240, 240, 240);

    public SecondaryVerticalAxis(double y, MappingToGUI trans) {
        super(y, trans);
    }

    @Override
    protected Color getColor() {
        return AXIS_COLOR;
    }
}

