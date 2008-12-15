/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munged;

import stormr.munger.Mungable;

/**
 *
 * @author twak
 */
public class Activity implements Comparable<Activity>
{
    @Mungable 
    public double startTime, duration;
    
    public Activity (double startTime)
    {
        this.startTime = startTime;
    }

    public int compareTo( Activity o )
    {
        if (o.startTime > startTime)
            return -1;
        if (o.startTime < startTime)
            return 1;
        return 0;
    }
}
