/*
    Plot1dApp.java - plot-1d

    This is the main application class for the plot-1d project. 

 */

import java.io.*;

import plot1d.*;

public class Plot1dApp {
    public static void main(String[] args) {
        InputObject input = new InputObject(args);
        PlotGUI gui = new PlotGUI(input);
    }
}
