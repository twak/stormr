/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.meeper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import stormr.munger.Munger;

/**
 * create a movie.mscope file with each audio sample in it, and the correct audio. Tis
 * extracts the artic sequences
 * @author twak
 */
public class ArticsExtractor {
    public ArticsExtractor()
    {
                try
        {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = db.parse( "movie.mscope" );
            parse( document );
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
                
                for (Sync s : syncs)
                {
                    System.out.println("s = new Sync (\""+s.fileName+"\");");
                    for (String t: s.artics)
                        System.out.println("s.artics.add(\""+t+"\");");
                    System.out.println("map.put(s.filename, s);");
                }
    }
    
    List<Sync> syncs = new ArrayList();
    Sync current;
    
    public class Sync
    {
        String fileName;
        List<String> artics = new ArrayList();
    }
    
    public void parse(Node n)
    {
        NodeList nl = n.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++)
        {
            Node node = nl.item( i );
            if (node.getNodeName().compareTo( "audioResource") == 0)
            {
                current = new Sync();
                current.fileName = node.getTextContent();
                syncs.add(current);
            }
            else if (node.getNodeName().compareTo( "artic") == 0)
            {
                current.artics.add (node.getTextContent());
            }
            else
                parse(node);
        }
    }
    
    public static void main (String[] args)
    {
        new ArticsExtractor();
    }
}
