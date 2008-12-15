/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author twak
 */
public class DocMunger extends Munger
{
    Document document;
    Map<Node, Munger> joinPoints = new HashMap();
        
   public DocMunger()
   {
       
   }
        
   /**
    * Bootstap method
    * @param filename
    */
    public DocMunger(final String filename)
    {
    }
    
    private void buildTree()
    {
        try
        {
            System.out.println("parsing "+(String)Munger.workpad.get( "file"));
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = db.parse( getClass().getResourceAsStream( "/resources/"+Munger.workpad.get( "file") ) );
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }
    
    private void findChildren(Node n)
    {
        NodeList nl = n.getChildNodes();
        String prefix = "_munge";
        for (int i = 0; i < nl.getLength(); i++)
        {
            Node node = nl.item( i );
            String name = node.getNodeName();
            
            Map<String, String> attribs = new HashMap();
            NamedNodeMap nnm = node.getAttributes();
            if (nnm != null)
            for (int j = 0; j < nnm.getLength(); j++)
            {
                Node attrib = nnm.item( j );
                attribs.put( attrib.getNodeName(), attrib.getNodeValue());
            }
            
            if (name.startsWith( prefix ))
            {
                String value;
                if (  (value = attribs.get( "attrib" )) != null)
                { // perform a replacement on the given attribute
                System.err.println(Munger.workpad.get( "file") + ":" + value +":"+Munger.workpad.get( value ));
                    node.getParentNode().replaceChild( 
                            document.createTextNode( Munger.workpad.get( value ).toString() ), 
                            node);
                }
                else if (( value = attribs.get("tag")) != null )
                { // straight replacement using values from workpad
                    Element rep = document.createElement( value );
                    for (String key : attribs.keySet())
                    {
                        if ( key.compareTo( "tag" ) != 0 )
                            rep.setAttribute( key, Munger.workpad.get( attribs.get(key) ).toString() );
                    }
                    
                    node.getParentNode().replaceChild( 
                            rep, 
                            node);
                }
                else
                {
                    joinPoints.put( node, MungeUtils.findChildren( attribs.get( "class" ) ) );
                }
            }
            else
                findChildren(node);
        }
    }
    
    @Override
    public List<Node> output()
    {
        buildTree();
        findChildren( document );
        
        for (Node key : joinPoints.keySet())
        {
            List<Node> toAdd = joinPoints.get( key ).output();
            for ( Node ger : toAdd )
            {
                ger = document.adoptNode( ger );
                key.getParentNode().insertBefore( ger, key );
            }
            
            key.getParentNode().removeChild( key );
        }
        
        return new ArrayList<Node>() { { add( document.getFirstChild() ) ;} };
    }
}
