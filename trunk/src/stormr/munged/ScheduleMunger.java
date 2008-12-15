/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munged;

import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;
import stormr.munger.Munger;

/**
 *
 * @author twak
 */
public class ScheduleMunger extends Munger
{
    @Override
    public List<Node> output()
    {
        List<Activity> activities = (List<Activity>)Munger.workpad.get( "schedule" );
        Collections.sort( activities );
        return processListOTemplates( activities );
    }
}
