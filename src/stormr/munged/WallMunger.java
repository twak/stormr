/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munged;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.vecmath.Point3d;
import org.w3c.dom.Node;
import stormr.munger.DocMunger;
import stormr.munger.MungeUtils;
import stormr.munger.Munger;

/**
 *
 * @author twak
 */
public class WallMunger extends Munger
{
    public WallMunger() {}
        
    @Override
    public List<Node> output()
    {
        return processListOTemplates( ( List<Mark> ) Munger.workpad.get( "walls" ) );
//        List<Node> out = new ArrayList();
//        for (Wall wall : (List<Wall>) Munger.workpad.get( "walls") )
//        {
//            Munger.workpad.put( "x1", wall.start.x );
//            Munger.workpad.put( "x2", wall.end.x );
//            Munger.workpad.put( "y1", wall.start.y );
//            Munger.workpad.put( "y2", wall.end.y );
//            Munger.workpad.put( "height", wall.height );
//            
//            Munger.workpad.put( "file", "wall");
//            
//            out.addAll( new DocMunger().output() );
//        }
//        return out;
    }

}
