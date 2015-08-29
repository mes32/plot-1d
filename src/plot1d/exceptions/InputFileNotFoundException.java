/*
    InputFileNotFoundException.java
  
    This class is part of the program plot-1d
  
 */

package plot1d.exceptions;

import java.io.*;


/**
 * This exception is thrown when the provided input filename is not found. This file should contain 
 * 1-dimensional data for plotting.
 */
public class InputFileNotFoundException extends FileNotFoundException {
    public InputFileNotFoundException() {
        super();
    }

    public InputFileNotFoundException(String s) {
        super(s);
    }
}
