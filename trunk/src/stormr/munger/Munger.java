package stormr.munger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;

/**
 *
 * @author twak
 */
public abstract class Munger extends ArrayList<Munger>
{
    public static Map<String, Object> workpad = new HashMap();
            
    public abstract List<Node> output();
    public static DocumentBuilder docBuilder;
    static
    {
        try
        {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
    
    public void processFields( Object prop ) throws Exception
    {
        for ( Field f : getFields (prop.getClass() ) )
        {
            Mungable m = f.getAnnotation( Mungable.class );
            if ( m == null )
                continue;
            Object tmp = null;
            for ( String method : Arrays.asList( m.methods().split( "," ) ) )
            {
                if ( method.length() > 0 )
                    Munger.workpad.put( f.getName() + "." + method, ( tmp = f.get( prop ) ).getClass().getMethod( method ).invoke( tmp ) );
            }
            for ( String field : Arrays.asList( m.fields().split( "," ) ) )
            {
                if ( field.length() > 0 )
                    Munger.workpad.put( f.getName() + "." + field, ( tmp = f.get( prop ) ).getClass().getField( field ).get( tmp ) );
            }

            System.out.println(f.getDeclaringClass().getSimpleName() +"'"+ f.getName());
            if ( m.methods().length() == 0 && m.fields().length() == 0 )
                Munger.workpad.put( f.getName(), f.get( prop ).toString() );
        }
        
        for ( Method m : getMethods( prop.getClass() ) )
        {
            if (m.getAnnotation( Mungable.class ) != null)
            {
                Munger.workpad.put( m.getName(), m.invoke( prop ) );
            }
        }
    }
    
    private List<Method> getMethods(Class c)
    {
        List<Method> out = new ArrayList<Method>( Arrays.asList( c.getMethods()) );
        if (c.getSuperclass() != Object.class)
            out.addAll( getMethods( c.getSuperclass() ) );
        return out;
    }
    
    private List<Field> getFields(Class c)
    {
        List<Field> out = new ArrayList<Field>( Arrays.asList( c.getFields()) );
        if (c.getSuperclass() != Object.class)
            out.addAll( getFields( c.getSuperclass() ) );
        return out;
    }

    public List<Node> processListOTemplates( List stuff )
    {
        List<Node> out = new ArrayList();
        for ( Object stuf : stuff )
        {
            try
            {
                processFields( stuf );
            }
            catch ( Exception ex )
            {
                ex.printStackTrace();
            }

            Munger.workpad.put( "object", stuf);
            Munger.workpad.put( "file", stuf.getClass().getSimpleName().toLowerCase() );
            out.addAll( new DocMunger().output() );
        }

        return out;
    }
}

