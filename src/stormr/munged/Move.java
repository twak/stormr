/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munged;

import java.util.List;
import stormr.munger.Mungable;
import stormr.munger.Munger;

/**
 *
 * @author twak
 */
public class Move extends Activity
{
    @Mungable
    public String markReference = "../../../marks/mark[X]";
    
    @Mungable
    public String gait = "Walk02";
    
    @Mungable
    public boolean isPlace = false;
    
    @Mungable
    public double speed = 0.21, stride = 1.0, gateBlend = 0.0;
    
    public Move ( Mark mark, double startTime )
    {
        super (startTime);
        setMarkReference( ((List<Mark>)Munger.workpad.get("marks")).indexOf( mark ) );
    }
    
    public void setMarkReference(int index)
    {
        // 1-based array
        markReference = "../../../marks/mark" + (index == 0 ? "" : "["+(index+1)+"]");
    }
    
}
