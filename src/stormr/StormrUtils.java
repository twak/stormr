/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author twak
 */
class StormrUtils 
{
    static void setupFrame( JFrame aThis )
    {
            aThis.setVisible( true );
            aThis.setIconImage( getImage("/resources/rr.png") );
    }
    
    public static BufferedImage getImage(String tag)
    {
        try
        {
            return ImageIO.read( Backup.instance.getClass().getResourceAsStream( tag ) );
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
        return null;
    }

    public static void showBrowser( String url )
    {
        try
            {
                Desktop.getDesktop().browse( new URI( url ) );
            }
            catch ( Exception ex )
            {
                Logger.getLogger( MovieBuilder.class.getName() ).log( Level.SEVERE, null, ex );
            }
            return;
    }
    
        // Copies src file to dst file.
    // If the dst file does not exist, it is created
    public static void copy(InputStream in, File dst)
    {
        try
        {
        OutputStream out = new FileOutputStream(dst);
    
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    public static void getImageFromUrl( String location, File dest )
    {
        try
        {
            for ( int i = 1; i < 31; i++ )
            {
                URL url = new URL( location );
                InputStream in = url.openStream();
                
                OutputStream out = new BufferedOutputStream( new FileOutputStream( dest ) );
                for ( int b; ( b = in.read() ) != -1;)
                {
                    out.write( b );
                }
                out.close();
                in.close();
            }

        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }


}
