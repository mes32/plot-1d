/*
    SecondaryVerticalAxis.java

    This class is part of the program plot-1d

 */

package plot1d.gui.axes;

import java.awt.*;

import plot1d.gui.*;


/**
 * This represents a secondary vertical axis drawn on PlotPanel
 */
public class SecondaryVerticalAxis extends VerticalAxis {

    private static final Color AXIS_COLOR = new Color(240, 240, 240);
    private static final int PRIORITY = 2;

    public SecondaryVerticalAxis(double y, MappingToGUI trans) {
        super(y, trans);
    }

    @Override
    protected Color getColor() {
        return AXIS_COLOR;
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }
}

