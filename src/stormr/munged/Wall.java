package stormr.munged;

import java.awt.Color;
import javax.vecmath.Point2d;
import stormr.munged.Colour;
import stormr.munger.Mungable;

/**
 *
 * @author twak
 */
public class Wall
{
    @Mungable (fields = "x,y")
    public Point2d start, end;
    @Mungable
    public double height = 3.;
    @Mungable (methods = "getRed,getGreen,getBlue,getAlpha")
    public Colour color = new Colour (Color.orange );
    
    public Wall( Point2d start, Point2d end )
    {
        this.start = start;
        this.end = end;
    }

    public void setHeight( double height )
    {
        this.height = height;
    }
}
