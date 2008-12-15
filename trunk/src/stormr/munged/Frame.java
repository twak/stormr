/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stormr.munged;

import java.awt.Color;
import javax.vecmath.Matrix4d;
import stormr.munger.Mungable;

/**
 * A frame with a tinted surround and an image on the interior
 * @author twak
 */
public class Frame extends Prop
{
    @Mungable (methods = "getRed,getGreen,getBlue,getAlpha")
    public Colour color = new Colour (Color.orange  );
    
    @Mungable
    public String frameImage = "";
    
    public Frame( String templateName, Matrix4d location )
    {
        super( templateName, location );
    }

    public void setColor( Color pink )
    {
        this.color = new Colour(pink);
    }
}
