/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munged;

import java.util.List;
import org.w3c.dom.Node;
import stormr.munger.Munger;

/**
 *
 * @author twak
 */
public class MarkMunger extends Munger {
    @Override
    public List<Node> output()
    {
        return processListOTemplates( ( List<Mark> ) Munger.workpad.get( "marks" ) );
    }
}
