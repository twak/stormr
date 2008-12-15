/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr;

import javax.vecmath.Matrix4d;
import javax.vecmath.Vector3d;
import stormr.munged.Activity;
import stormr.munger.Mungable;

/**
 *
 * @author twak
 */
public class KeyFrame extends Activity
{
    @Mungable (fields="m00,m01,m02,m03,m10,m11,m12,m13,m20,m21,m22,m23,m30,m31,m32,m33")
    public Matrix4d location;
    
    @Mungable (fields="x,y,z")
    public Vector3d offset;
    
    @Mungable
    public double 
            pan, 
            tilt, 
            roll, 
            fov = 0.33955655, 
            focalDistance = 3, 
            focalRange = 1024;
    
    @Mungable
    public boolean cutTo = false;
    
    /**
     * Remember kids, co-temporal keyframes makes the whole thing blow up
     */
    public KeyFrame (double startTime, Matrix4d location, Vector3d offset)
    {
        super (startTime);
        this.location = location;
        this.offset = offset;
    }
}
