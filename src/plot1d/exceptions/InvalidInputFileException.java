/*
    InvalidInputFileException.java
  
    This class is part of the program plot-1d
  
 */

package plot1d.exceptions;


/**
 * This exception is thrown when the provided input file does not contain usable data. This file 
 * should contain 1-dimensional data for plotting.
 */
public class InvalidInputFileException extends RuntimeException {
    public InvalidInputFileException() {
        super();
    }

    public InvalidInputFileException(String s) {
        super(s);
    }
}
