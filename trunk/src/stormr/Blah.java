/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stormr;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.vecmath.Matrix4d;
import javax.vecmath.Point2d;
import javax.vecmath.Vector3d;
import stormr.munged.Frame;
import stormr.munged.Prop;
import stormr.munged.Wall;
import stormr.munger.DocMunger;
import stormr.munger.MungeUtils;
import stormr.munger.Munger;

/**
 *
 * @author tom
 */
public class Blah
{
    
//            <template name="Dressing/Decor/Furnishings/Pictures/Wall_Picture_01/Wall Picture 12_Tint"/>

    public static void main( String[] args )
    {
        List<Wall> walls = new ArrayList();
        Munger.workpad.put( "walls", walls );
        Random randy = new Random();
        
        for (int i = 0; i < 10; i++)
        walls.add( new Wall( 
                new Point2d ( randy.nextDouble() * 50 -25, randy.nextDouble() * 50-25 ),
                new Point2d ( randy.nextDouble() * 50 -25, randy.nextDouble() * 50-25 )));
        
        List<Prop> props = new ArrayList();
        Munger.workpad.put( "props", props );
        
        
        for (int i = 0; i< 10; i++)
        {
            Matrix4d mat = new Matrix4d();
            mat.setIdentity();
            mat.setTranslation( new Vector3d( randy.nextDouble() * 50 - 25, randy.nextDouble() * 50 - 25, 0 ) );
//            mat.rotZ( randy.nextDouble() * Math.PI * 2 );
            props.add( new Prop ("Dressing/Decor/Furnishings/Pictures/Wall_Picture_01/Wall Picture 12_Tint", mat) );
        }
        
        Matrix4d mat = new Matrix4d();
        mat.setIdentity();
        Frame frame = new Frame ("Dressing/Decor/Furnishings/Pictures/Wall_Picture_02", mat);
        frame.frameImage = "Images/me.jpg";
        frame.setColor (Color.pink);
        props.add(frame);

        Munger.workpad.put( "file", "movie.mscope" );
        
        Munger dm = new DocMunger();
        MungeUtils.toFile( dm, new File ("output.txt" ) );
    }
}
