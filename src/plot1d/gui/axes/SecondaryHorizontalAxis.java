/*
    SecondaryHorizontalAxis.java

    This class is part of the program plot-1d

 */

package plot1d.gui.axes;

import java.awt.*;

import plot1d.gui.*;


/**
 * This represents a secondary horizontal axis drawn on PlotPanel
 */
public class SecondaryHorizontalAxis extends HorizontalAxis {

    private static final Color AXIS_COLOR = new Color(240, 240, 240);
    private static final int PRIORITY = 2;

    public SecondaryHorizontalAxis(double y, MappingToGUI trans) {
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

