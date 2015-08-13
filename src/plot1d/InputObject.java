/**
 *  InputObject.java - plot-1d
 *
 *  This class parses the input arguments and packages them into an object for use by the other 
 *  classes. 
 *
 */

package plot1d;

import java.io.*;

public class InputObject {

    private File file;
    private String fileName;

    public InputObject(String[] args) {
        if (args.length == 0) {
            // *** Should be an exception eventually
            System.err.println("Missing input file");
            System.exit(1);
        }

        String path = args[0];
        file = new File(path);
    }

    public String getFileName() {
        return file.getName() + " (" + file.getParentFile().getPath() + ")";
    }
}
