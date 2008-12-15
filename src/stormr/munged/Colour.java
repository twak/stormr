package stormr.munged;

import java.awt.Color;


/**
 * Interface between a double-formatted colour and java.awt.color
 * @author twak
 */
public class Colour
{

    Color col;

    public Colour( Color col )
    {
        super();
        this.col = col;
    }

    public float getRed()
    {
        return col.getRed() / 255.0F;
    }

    public float getGreen()
    {
        return col.getGreen() / 255.0F;
    }

    public float getBlue()
    {
        return col.getBlue() / 255.0F;
    }

    public float getAlpha()
    {
        return 1.0F;
    }
}
