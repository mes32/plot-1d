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
public class BorderBox extends JComponent {

    public BorderBox() {
        System.out.println("BorderBox() constructor");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawLine(10, 10, 20, 20);
    }
}

