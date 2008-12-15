/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munged;

import javax.vecmath.Matrix4d;
import stormr.munger.Mungable;

/**
 *
 * @author twak
 */
public class Mark {
    @Mungable (fields="m00,m01,m02,m03,m10,m11,m12,m13,m20,m21,m22,m23,m30,m31,m32,m33,")
    public Matrix4d location = new Matrix4d();
    
    @Mungable
    public String name;
    
    public Mark (Matrix4d position)
    {
        this.location = position;
        this.name = "mark "+position.hashCode(); //eep
    }
}
