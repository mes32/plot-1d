/*
    NoInputFileSpecifiedException.java
  
    This class is part of the program plot-1d
  
 */

package plot1d.exceptions;


/**
 * This exception is thrown when no filename is provided as input. The provided file should contain 
 * 1-dimensional data for plotting.
 */
public class NoInputFileSpecifiedException extends RuntimeException {
    public NoInputFileSpecifiedException() {
        super();
    }

    public NoInputFileSpecifiedException(String s) {
        super(s);
    }
}
