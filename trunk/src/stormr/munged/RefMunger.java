/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munged;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import stormr.munger.Munger;

/**
 * a node that dissapears if the reference is null
 * @author twak
 */
public class RefMunger extends Munger
{
    @Override public List<Node> output()
    {
        HasReference p = (HasReference)Munger.workpad.get( "object" );
        List<Node> out = new ArrayList();
        if (p.getReference() == null)
            return out;
        
        Document doc = Munger.docBuilder.newDocument();
        
        Element target = doc.createElement( "target" );
        target.setAttribute( "class", "Prop" );
        target.setAttribute( "reference", p.getReference());
        out.add(target);
        
        return out;
    }

}
