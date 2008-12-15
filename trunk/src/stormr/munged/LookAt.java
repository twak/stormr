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
public class LookAt extends Activity implements HasReference
{
    public String reference = "../../../set/scenery/Prop[3]";
    
    public LookAt(double startTime, int propIndex)
    {
        super (startTime);
        duration = 0.5 + Math.random() * 0.2; // default (for now...)
        setReference( propIndex );
    }
    
    public LookAt(double startTime)
    {
        super (startTime);
        duration = 0.5 + Math.random() * 0.2; // default (for now...)
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
