package stormr.munged;

import stormr.munger.Mungable;

/**
 *
 * @author twak
 */
public class Cut extends Activity
{
    @Mungable
    public double cutStartTime;
    public Cut (double startTime, double duration, double cutStartTime)
    {
        super (startTime);
        this.duration = duration;
        this.cutStartTime = cutStartTime;
    }
}
