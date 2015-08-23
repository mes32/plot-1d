/*
    AbstractAxis.java

    This class is part of the package plot1d

 */

package plot1d;

import java.io.*;
import javax.swing.*;
import java.awt.*;

import plot1d.*;


/**
 * This abstract class represents a horizontal/vertical axis drawn on PlotPanel
 */
abstract class AbstractAxis {

    public static AbstractAxis[] factory(PointsExtent extent, MappingToGUI trans) {

        HorizontalAxis primaryHorizontalAxis = new PrimaryHorizontalAxis(0.0, trans);
        VerticalAxis primaryVerticalAxis = new VerticalAxis(0.0, trans);

        AbstractAxis[] out = new AbstractAxis[2];
        out[0] = primaryHorizontalAxis;
        out[1] = primaryVerticalAxis;

        return out;
    } 

    abstract void draw(Graphics g);
}

