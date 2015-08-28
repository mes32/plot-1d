/*
    Plot1dApp.java - plot-1d

    This is the main application class for the plot-1d project. 

 */

import java.io.*;

import plot1d.*;
import plot1d.data.*;
import plot1d.gui.*;

/**
 * The main application class for plot-1d. Creates input object and launches the GUI.
 */
public class Plot1dApp {
    public static void main(String[] args) {
        InputObject input = new InputObject(args);
        PlotGUI gui = new PlotGUI(input);
    }
}
