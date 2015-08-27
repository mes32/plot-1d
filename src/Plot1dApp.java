/*
    Plot1dApp.java - plot-1d

    This is the main application class for the plot-1d project. 

 */

import java.io.*;

import plot1d.*;
import plot1d.data.*;

public class Plot1dApp {
    public static void main(String[] args) {
        InputObject input = new InputObject(args);
        PlotGUI gui = new PlotGUI(input);
    }
}
