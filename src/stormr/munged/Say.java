package stormr.munged;

import java.util.List;
import stormr.munger.Mungable;

/**
 *
 * @author twak
 */
public class Say extends Activity
{
    @Mungable
    public String text;
    @Mungable
    public String audioResource;
    
    @Mungable
    List<String> artics;

    public Say( String text, double startTime, double duration, List<String> artics )
    {
        super( startTime );
        this.text = text;
        this.artics = artics;
        this.duration = duration;
    }
}
