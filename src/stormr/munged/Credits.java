package stormr.munged;

import java.awt.Color;
import stormr.munger.Mungable;

/**
 *
 * @author twak
 */
public class Credits extends Activity
{
    @Mungable
    public String text, description;
    
    @Mungable
    public double textSize = 40;
    
    @Mungable
    public String transition = "BLEND" ; // or "IMMEDIATE"
    
    @Mungable (methods="getRed,getGreen,getBlue")
    public Color color = Color.white;
    
    public Credits (double startTime, double duration, String text)
    {
        super (startTime);
        this.duration = duration;
        this.text = this.description = text;
    }
}
