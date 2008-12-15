/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author twak
 */
public class Image 
{
    public class Note
    {
        Rectangle location;
        String text, author;
        public Note (Rectangle location, String text, String author)
        {
            this.location = location;
            this.text = text;
            this.author = author;
        }
        
        public Point getCentre()
        {
            return new Point((int)location.getCenterX(), (int)location.getCenterY());
        }
    }
    
    public String file;
    public List<Note> notes = new ArrayList();
    public BufferedImage image;
    public String title, description;
    public Color average = Color.black;
    public boolean isPortrait = false;
    
    
    public Image (BufferedImage image, String title, String description)
    {
        this.image = image;
        this.title = title;
        this.description = description;
         
        int r,g,b; r=g=b= 0;
        Random randy = new Random();
        int samples = 5;
        for (int i = 0; i < samples; i++)
        {
            int
                    x =  (int)(randy.nextDouble() * image.getWidth()), 
                    y =(int)(randy.nextDouble() *image.getHeight()) ;
            Color c = new Color( image.getRGB(x,y ) );
            
            r+= c.getRed();
            g+= c.getGreen();
            b+= c.getBlue();
        }
        
        average = new Color (r/samples, g/samples, b/samples);
    }
    
    public void addNote (Rectangle rectangle, String text, String author)
    {
        notes.add(new Note(rectangle, text, author));
        
        System.out.println(rectangle +"--"+text);
    }
    
    /**
     * Add margins to this photo (& move notes accordingly)
     */
    public void processToRatio( int x, int y, Color background)
    {   
        isPortrait = image.getWidth() < image.getHeight();
        if (!isPortrait) // flip image...
        {
            BufferedImage flip = new BufferedImage (image.getHeight(), image.getWidth(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = (Graphics2D)flip.getGraphics();
            AffineTransform at = new AffineTransform();
            at.setToIdentity();
            at.rotate( Math.PI /2 );
            at.translate(0,-image.getHeight());
            g2.setTransform( at );
            g2.drawImage( image, 0,0,null );
            image = flip;
            
            // adjusting notes for flip isn't need caus it happens in world space
            
        }
     
        
        
        // image now portrait - add padding to keep ratio
        
        double r = image.getWidth() / (double)image.getHeight();
        
        double tr = x/(double)y;
        int tx = (int)(tr * image.getHeight()), ty = image.getHeight(); // target x,y dimensions
        
        int ofx = tx, ofy = ty ;
        
        if (r > tr)
        {
            //image is too fat, pad top and bottom
            ofy = tx * image.getHeight() / image.getWidth();
        }
        else if (r < tr)
        {
            ofx = ty * image.getWidth() / image.getHeight();
        }
        BufferedImage newImage = new BufferedImage (tx, ty, BufferedImage.TYPE_INT_RGB);
        Graphics g = newImage.getGraphics();
        g.setColor( background );
        g.fillRect( 0,0, tx, ty);
        g.drawImage( image, (tx-ofx)/2, (ty-ofy)/2, ofx, ofy, null );
        image = newImage;
        
        // squish
        for (Note n : notes)
        {
            Rectangle old = n.location;
            
            
            double ratio = Math.min( ofx / (double)tx, ofy / (double)ty );
            
            if ( isPortrait )
                n.location.setLocation(
                        ( int ) ( old.x * ratio ) + ( tx - ofx ) / 2,
                        ( int ) ( old.y * ratio ) + ( ty - ofy ) / 2 );
            else // image is sidewayss
                n.location.setLocation(
                        ( int ) ( old.x * ratio ) + ( ty - ofy ) / 2,
                        ( int ) ( old.y * ratio ) + ( tx - ofx ) / 2 );
                
            
            n.location.setSize( old.width * ofx / tx, old.height * ofy / ty );
        }
    }
}
