//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 400;   

    private final int TOPX = 200, TOPY = 360;
    private final int BOTTOMX = 200, BOTTOMY = 380;
    private final int theta = 15;

    private int current; //current order

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public TreePanel (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    public void drawFractal (int order, int x1, int y1, int x2, int y2, Graphics page)
    {
        int deltaX, deltaY, x3, y3, x4, y4;

        if (order == 1){
            return;
        }
        else
        {
            page.drawLine (x1, y1, x2, y2);
            x3 = x2 + (int) Math.sin(Math.toRadians(theta*order));
            y3 = y2 + (int) Math.cos(Math.toRadians(theta*order));
            x4 = x2 + (int) Math.sin(Math.toRadians(theta*order));
            y4 = y2 + (int) Math.cos(Math.toRadians(theta*order));
            drawFractal(order-1, x2, y2, x3, y3, page);
            drawFractal(order-1, x2, y2, x4, y4, page);
        }
    }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);

        page.setColor (Color.green);

        drawFractal (current, BOTTOMX, BOTTOMY, TOPX, TOPY, page);        
    }

    //-----------------------------------------------------------------
    //  Sets the fractal order to the value specified.
    //-----------------------------------------------------------------
    public void setOrder (int order)
    {
        current = order;
    }

    //-----------------------------------------------------------------
    //  Returns the current order.
    //-----------------------------------------------------------------
    public int getOrder ()
    {
        return current;
    }
}
