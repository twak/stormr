/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munged;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import stormr.munger.Munger;

/**
 *
 * @author twak
 */
public class ArticMunger extends Munger
{

    @Override
    public List<Node> output()
    {
        try
        {
            // return the list of nodes from the most recent say
            return createFor( Munger.docBuilder.newDocument(), ( ( Say ) Munger.workpad.get("object") ).artics );
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
        return null;
    }

    
    
    public static List<Node> createFor (Document doc, List<String> artics)
    {
        List<Node> out = new ArrayList();
        
        for ( String f : artics )
        {
            Element tic = doc.createElement( "artic" );
            tic.setTextContent( f );
            out.add( tic );
        }
        
        return out;
    }
    
}
