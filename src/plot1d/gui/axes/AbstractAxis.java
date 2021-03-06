/*
    AbstractAxis.java

    This class is part of the program plot-1d

 */

package plot1d.gui.axes;

import java.awt.*;
import java.util.*;

import plot1d.data.*;
import plot1d.gui.*;


/**
 * This abstract class represents a horizontal/vertical axis drawn on PlotPanel
 */
abstract public class AbstractAxis implements Comparable<AbstractAxis> {

    /**
     * Returns a sorted array of axes based on the dimensions of the data and the plot
     */
    public static AbstractAxis[] factory(MappingToGUI trans) {

        RegionExtent dataExtent = trans.getDataExtent();
        RegionExtent plotExtent = trans.getPlotExtent();

        double intervalX = getInterval(dataExtent.getRangeX());
        double intervalY = getInterval(dataExtent.getRangeY());

        java.util.List<AbstractAxis> outList = new ArrayList<AbstractAxis>();

        if (dataExtent.containsX(0.0)) {
            // Add the primary x-axis axis (x=0) if it is within the range of the data points
            // The add secondary x-axes on intervals above and below the primary

            PrimaryVerticalAxis primaryVerticalAxis = new PrimaryVerticalAxis(0.0, trans);
            outList.add(primaryVerticalAxis);

            for (int i=1; i*intervalX <= plotExtent.getMaxX(); i++) {
                outList.add(new SecondaryVerticalAxis(i*intervalX, trans));
            }
            for (int i=-1; i*intervalX >= plotExtent.getMinX(); i--) {
                outList.add(new SecondaryVerticalAxis(i*intervalX, trans));
            }
        } else if (0.0 < dataExtent.getMinX()) {
            // From below data extent start at x=0 and move up adding needed secondary axis

            for (int i=0; i*intervalX <= plotExtent.getMaxX(); i++) {
                if (i*intervalX >= plotExtent.getMinX()) {
                    outList.add(new SecondaryVerticalAxis(i*intervalX, trans));
                }
            }
        } else {
            // From above data extent start at x=0 and move down adding needed secondary axis

            for (int i=0; i*intervalX >= plotExtent.getMinX(); i--) {
                if (i*intervalX <= plotExtent.getMaxX()) {
                    outList.add(new SecondaryVerticalAxis(i*intervalX, trans));
                }
            }
        }

        if (dataExtent.containsY(0.0)) {
            // Add the primary y-axis axis (y=0) if it is within the range of the data points
            // The add secondary y-axes on intervals above and below the primary

            PrimaryHorizontalAxis primaryHorizontalAxis = new PrimaryHorizontalAxis(0.0, trans);
            outList.add(primaryHorizontalAxis);

            for (int i=1; i*intervalY <= plotExtent.getMaxY(); i++) {
                outList.add(new SecondaryHorizontalAxis(i*intervalY, trans));
            }
            for (int i=-1; i*intervalY >= plotExtent.getMinY(); i--) {
                outList.add(new SecondaryHorizontalAxis(i*intervalY, trans));
            }
        } else if (0.0 < dataExtent.getMinY()) {
            // From below data extent start at y=0 and move up adding needed secondary axis

            for (int i=0; i*intervalY <= plotExtent.getMaxY(); i++) {
                if (i*intervalY >= plotExtent.getMinY()) {
                    outList.add(new SecondaryHorizontalAxis(i*intervalY, trans));
                }
            }
        } else {
            // From above data extent start at y=0 and move down adding needed secondary axis

            for (int i=0; i*intervalY >= plotExtent.getMinY(); i--) {
                if (i*intervalY <= plotExtent.getMaxY()) {
                    outList.add(new SecondaryVerticalAxis(i*intervalY, trans));
                }
            }
        }

        AbstractAxis[] outArray = outList.toArray(new AbstractAxis[outList.size()]);
        Arrays.sort(outArray);
        return outArray;
    }

    /**
     * Finds a nicely rounded interval between secondary axes based on range of data. Starts from an 
     * interval low enough that there are at least five secondary axes. Then rounds the interval 
     * down until its leading digits are one of the following: 1, 2, 2.5, 5.
     */
    private static double getInterval(double range) {

        // Find a roughly correct interval. Then scale this value with division to ensure it is 
        // between 1 and 10.
        double roughInterval = range / 4.0;
        double ex = Math.ceil(Math.log10(roughInterval)) - 1.0;
        double scaleFactor = Math.pow(10, ex);
        double regularInterval = roughInterval / scaleFactor;

        // Regularize the scaled value so that it is equal to 1, 2, 2.5, or 5.
        if (regularInterval > 1.0 && regularInterval < 2.0) {
            regularInterval = 1.0;
        } else if (regularInterval > 2.0 && regularInterval < 2.5) {
            regularInterval = 2.0;
        } else if (regularInterval > 2.5 && regularInterval < 5.0) {
            regularInterval = 2.5;
        } else if (regularInterval > 5.0 && regularInterval < 10.0) {
            regularInterval = 5.0;
        }

        // Undo the scalling division on the now regularalized interval and return
        return regularInterval * scaleFactor;
    }

    /**
     * Draws this axis on the PlotPanel
     */
    abstract public void draw(Graphics g);

    /**
     * Returns the priority of this axis. This value is used for sorting an plot layering purposes.
     */
    abstract public int getPriority();

    /**
     * Compares two axes based on priority. Axes have priority as follows (primary=1, secondary=2, 
     * etc). This comparison sorts the lower priory numbers later so that they are painted on top of
     * the other axes.
     */
    public int compareTo(AbstractAxis other) {
        Integer x = new Integer(this.getPriority());
        Integer y = new Integer(other.getPriority());
        return y.compareTo(x);
    }
}

