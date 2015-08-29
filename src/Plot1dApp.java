/*
    Plot1dApp.java

    This class is part of the program plot-1d

 */

import java.io.*;

import plot1d.*;
import plot1d.data.*;
import plot1d.gui.*;
import plot1d.exceptions.*;

/**
 * The main application class for plot-1d. Creates input object and launches the GUI.
 */
public class Plot1dApp {
    public static void main(String[] args) {
        try {
            InputObject input = new InputObject(args);
            PlotGUI gui = new PlotGUI(input);
        } catch (NoInputFileSpecifiedException e) {
            printUsage();
            System.exit(1);
        } catch (InputFileNotFoundException e) {
            printErrorMessage(e);
            System.exit(1);
        } catch (InvalidInputFileException e) {
            printErrorMessage(e);
            System.exit(1);
        }
    }

    /**
     * Prints the usage for this application to stderr
     */
    private static void printUsage() {
        System.err.println();
        System.err.println("Usage: plot-1d.sh <input.1d>");
    }

    /**
     * Prints an error message to stderr based on an Exception
     */
    private static void printErrorMessage(Exception e) {
        System.err.println();
        System.err.println("Error in plot-1d. " + e.getMessage());
    }
}
