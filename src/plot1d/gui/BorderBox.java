/*
    BorderBox.java

    This class is part of the program plot-1d

 */

package plot1d.gui;

import java.awt.*;


/**
 * This represents a rectangular region with a border inside the main GUI panel. This rectangular 
 * box encloses the plotted data points and the plot axes. Additional annotation of the plot (title,
 * axes labels, unit labels, etc) occupy other areas of the GUI panel surrounding this box.
 */
public class BorderBox {

    private static final Color BORDER_COLOR = Color.black;
    private static final int MARGIN_TOP = 10;
    private static final int MARGIN_BOTTOM = 80;
    private static final int MARGIN_LEFT = 80;
    private static final int MARGIN_RIGHT = 10;

    private int x;
    private int y;

    private int height;
    private int width;

    public BorderBox(Dimension panelSize) {
        int panelWidth = (int)panelSize.getWidth();
        int panelHeight = (int)panelSize.getHeight();

        width = panelWidth - MARGIN_RIGHT - MARGIN_LEFT;
        height = panelHeight - MARGIN_TOP - MARGIN_BOTTOM;

        x = MARGIN_LEFT;
        y = MARGIN_TOP;
    }

    /**
     * Returns the width in pixels of the rectanglar region enclosed by this border box
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height in pixels of the rectanglar region enclosed by this border box
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the top-most position of this rectanglar region. This position is in pixels relative 
     * to the enclosing frame.
     */
    public int getTop() {
        return y;
    }

    /**
     * Returns the bottom-most position of this rectanglar region. This position is in pixels 
     * relative to the enclosing frame.
     */
    public int getBottom() {
        return y + height;
    }

    /**
     * Returns the left-most position of this rectanglar region. This position is in pixels relative
     * to the enclosing frame.
     */
    public int getLeft() {
        return x;
    }

    /**
     * Returns the right-most position of this rectanglar region. This position is in pixels 
     * relative to the enclosing frame.
     */
    public int getRight() {
        return x + width;
    }

    /**
     * Draws this box with a border onto the GUI
     */
    public void draw(Graphics g) {
        g.setColor(BORDER_COLOR);
        g.drawRect(x, y, width, height);
    }
}

