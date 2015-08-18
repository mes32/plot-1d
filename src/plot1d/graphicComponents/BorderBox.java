/*
    BorderBox.java

    This class is part of the package plot1d

 */

package plot1d.graphicComponents;

import java.io.*;
import javax.swing.*;
import java.awt.*;


/**
 * This is an extension of JPanel for use by PlotGUI
 */
public class BorderBox {

    public BorderBox() {
        //System.out.println("BorderBox() constructor");
    }

    /*@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.red);
        g.drawLine(0, 0, 200, 200);
    }*/

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.drawLine(0, 0, 100, 100);
    }
}

