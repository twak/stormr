/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munger;

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author twak
 */
public class MungeUtils 
{
    
    public static Munger findChildren( String name )
    {
        try
        {
            Class c = Class.forName( name );
            Munger child = ( Munger ) c.newInstance();
            return child;
        }
        catch ( InstantiationException ex )
        {
            Logger.getLogger( MungeUtils.class.getName() ).log( Level.SEVERE, null, ex );
        }
        catch ( IllegalAccessException ex )
        {
            Logger.getLogger( MungeUtils.class.getName() ).log( Level.SEVERE, null, ex );
        }
        catch ( ClassNotFoundException ex )
        {
            Logger.getLogger( MungeUtils.class.getName() ).log( Level.SEVERE, null, ex );
        }
        return null;
    }
    
    public static void toFile(Munger root, File file )
    {
        try
        {
            XMLSerializer serializer = new XMLSerializer();
            FileWriter fw = new FileWriter( file );
            serializer.setOutputCharStream( fw );
            serializer.serialize( root.output().get( 0 ) );
            fw.close();
        }
        catch ( Exception x )
        {
            x.printStackTrace();
        }
    }
    
    public void findMunger (String name)
    {
        
    }
}
