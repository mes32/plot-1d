/*
    AbstractAxis.java

    This class is part of the package plot1d

 */

package plot1d;

import java.awt.*;
import java.util.*;

import plot1d.*;


/**
 * This abstract class represents a horizontal/vertical axis drawn on PlotPanel
 */
abstract class AbstractAxis {

    public static AbstractAxis[] factory(MappingToGUI trans) {

        RegionExtent extent = trans.getDataExtent();
        RegionExtent plotExtent = trans.getPlotExtent();

        double intervalX = getInterval(extent.getRangeX());
        double intervalY = getInterval(extent.getRangeY());

        java.util.List<AbstractAxis> outList = new ArrayList<AbstractAxis>();

        if (extent.containsX(0.0)) {
            PrimaryVerticalAxis primaryVerticalAxis = new PrimaryVerticalAxis(0.0, trans);
            outList.add(primaryVerticalAxis);

            for (int i=1; i*intervalX <= plotExtent.getMaxX(); i++) {
                outList.add(new SecondaryVerticalAxis(i*intervalX, trans));
            }
            for (int i=-1; i*intervalX >= plotExtent.getMinX(); i--) {
                outList.add(new SecondaryVerticalAxis(i*intervalX, trans));
            }
        } else {
            for (int i=0; i*intervalX <= plotExtent.getMaxX(); i++) {
                if (i*intervalX >= plotExtent.getMinX()) {
                    outList.add(new SecondaryVerticalAxis(i*intervalX, trans));
                }
            }
        }

        if (extent.containsY(0.0)) {
            PrimaryHorizontalAxis primaryHorizontalAxis = new PrimaryHorizontalAxis(0.0, trans);
            outList.add(primaryHorizontalAxis);

            for (int i=1; i*intervalY <= plotExtent.getMaxY(); i++) {
                outList.add(new SecondaryHorizontalAxis(i*intervalY, trans));
            }
            for (int i=-1; i*intervalY >= plotExtent.getMinY(); i--) {
                outList.add(new SecondaryHorizontalAxis(i*intervalY, trans));
            }
        } else {
            for (int i=0; i*intervalY <= plotExtent.getMaxY(); i++) {
                if (i*intervalY >= plotExtent.getMinY()) {
                    outList.add(new SecondaryHorizontalAxis(i*intervalY, trans));
                }
            }
        }

        return outList.toArray(new AbstractAxis[outList.size()]);
    }

    private static double getInterval(double range) {
        double roughInterval = range / 4.0;
        double ex = Math.ceil(Math.log10(roughInterval)) - 1.0;
        double scaleFactor = Math.pow(10, ex);
        double regularInterval = roughInterval / scaleFactor;

        if (regularInterval > 1.0 && regularInterval < 2.0) {
            regularInterval = 1.0;
        } else if (regularInterval > 2.0 && regularInterval < 2.5) {
            regularInterval = 2.0;
        } else if (regularInterval > 2.5 && regularInterval < 5.0) {
            regularInterval = 2.5;
        } else if (regularInterval > 5.0 && regularInterval < 10.0) {
            regularInterval = 5.0;
        }

        return regularInterval * scaleFactor;
    }

    abstract void draw(Graphics g);
}

