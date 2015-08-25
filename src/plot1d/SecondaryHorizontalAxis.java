/*
    SecondaryHorizontalAxis.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;


/**
 * This represents a secondary horizontal axis drawn on PlotPanel
 */
public class SecondaryHorizontalAxis extends HorizontalAxis {

    private static final Color AXIS_COLOR = new Color(240, 240, 240);

    public SecondaryHorizontalAxis(double y, MappingToGUI trans) {
        super(y, trans);
    }

    @Override
    protected Color getColor() {
        return AXIS_COLOR;
    }
}

