package stormr.munged;

import java.util.List;
import javax.vecmath.Matrix4d;
import stormr.munger.Mungable;
import stormr.munger.Munger;

/**
 *
 * @author twak
 */
public class Prop 
{
    @Mungable
    public String templateName;
    @Mungable (fields="m00,m01,m02,m03,m10,m11,m12,m13,m20,m21,m22,m23,m30,m31,m32,m33,")
    public Matrix4d location = new Matrix4d();
    @Mungable
    public double scale = 1.0;
    
    
    public Prop(String templateName, Matrix4d location)
    {
        this.templateName = templateName;
        this.location = location;
    }
    
    public void setScale(Double scale)
    {
        this.scale = scale;
    }
    
    public int getIndex()
    {
        // assumes nothing else in front of us in the props list
        return ((List<Prop>)Munger.workpad.get( "props" )).indexOf( this );
    }
}
