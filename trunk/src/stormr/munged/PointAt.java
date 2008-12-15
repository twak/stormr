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
public class PointAt extends Activity implements HasReference
{
    @Mungable
    public String hand = "LEFT";
    
    public String reference = "../../../set/scenery/Prop[3]";
    @Mungable
    public String _class = "Prop";
    
    public PointAt(double startTime, int propIndex)
    {
        super (startTime);
        duration = 0.2 + Math.random() * 0.5; // default (for now...)
        setReference( propIndex );
    }
    
    public PointAt(double startTime)
    {
        super (startTime);
        duration = 0.2 + Math.random() * 0.5; // default (for now...)
        reference = null;
    }
    
    public void setReference (int index)    
    {
        reference =  "../../../set/scenery/Prop"+ (index == 0 ? "" : ("["+(index+1)+"]"));
    }

    public String getReference()
    {
        return reference;
    }
    
}
