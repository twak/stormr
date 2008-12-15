/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stormr.meeper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author twak
 */
public class ArticBuilder
{

    static Map<String, Sync> map = new HashMap();

    public static class Sync
    {

        String filename;
        List<String> artics = new ArrayList();

        public Sync( String filename )
        {
            this.filename = filename;
        }
    }
    
    static public List<String> createFor (List<String> filenames)
    {
        List<String> out = new ArrayList();
        
        for ( String f : filenames )
        {
            Sync key =  map.get( f.replace( "/resources/", ""));
            if ( key != null )
                for ( String a : key.artics )
                    out.add( a );
        }
        
        return out;
    }

    static
    {
        /**
         * generated using ArticBuilder
         */
        Sync s = new Sync( "meep1.wav" );
        s = new Sync( "meep1.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 b e 30 6d 50 5b 39 c 30 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 c 7 58 56 59 33 33 c 30 " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 7f 7 58 66 59 33 36 c 30 " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 54 7 58 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 54 7 58 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 54 7 58 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 54 7 58 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 b 7 58 5e 49 33 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 54 1e 30 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 54 1e 30 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 54 1e 30 " );
        map.put( s.filename, s );
        s = new Sync( "meep2.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 79 1e 30 6c 5c 33 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 7 13 47 56 49 33 3e 19 30 " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 6f 13 47 75 49 33 34 19 30 " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 54 13 47 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 54 13 47 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 54 13 47 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 54 13 47 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 54 13 47 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 54 13 47 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 54 13 47 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d d 13 47 6f 50 52 39 c 30 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 9 13 47 6a 50 52 3b c 30 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 5 13 47 69 50 52 3a c 30 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 72 7 51 57 49 33 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 72 7 51 57 49 33 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 72 7 51 57 49 33 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 d 1e 30 50 50 52 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 9 1e 30 5c 50 52 " );
        map.put( s.filename, s );
        s = new Sync( "meep3.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 2b 7 51 6c 46 33 2c c 30 67 18 3b " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 2d 7 51 6e 49 33 22 3 30 64 18 3b " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 11 7 51 61 49 33 22 1 47 61 1a 4c " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 19 7 51 63 44 44 21 c 30 62 1a 4c " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 7 7 51 66 44 44 3a c 30 79 1a 4c " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 65 7 51 70 44 44 30 c 30 71 1a 4c " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 54 7 51 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 7c 7 51 64 5c 33 31 c 30 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 0 7 51 5f 5c 33 3f c 30 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6c 3b 4b 4d 32 a 7f b 30 62 49 33 " );
        s.artics.add( "X35 79 6c 1a 4b 4d 32 e9 7f b 30 62 49 33 " );
        map.put( s.filename, s );
        s = new Sync( "meep4.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 76 1e 30 6b 5c 33 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 0 7 55 52 49 33 3a 19 30 " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 6c 7 55 73 49 33 34 19 30 " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 51 7 55 74 49 33 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 51 7 55 74 49 33 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 7f 7 55 7d 49 33 3d 19 30 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 1d 7 55 68 49 33 2d 19 30 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 6 1e 30 5b 5c 33 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 d 7 55 62 49 33 24 19 30 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 54 7 55 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 54 7 55 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 54 7 55 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 54 7 55 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 54 7 55 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 7a 7 55 6c 49 33 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 7a 7 55 6c 49 33 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 9 7 55 6d 49 33 3b 15 58 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 15 7 55 69 50 5b 2b c 30 " );
        s.artics.add( "X35 79 6c 3b 4b 4d 32 a 1f 7 58 56 49 33 21 15 55 " );
        s.artics.add( "X35 79 6c 1a 4b 4d 32 e9 78 1e 30 6d 50 5b " );
        s.artics.add( "X35 79 6c f9 4b 4d 32 c8 54 1e 30 " );
        map.put( s.filename, s );
        s = new Sync( "meep5.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 62 1e 30 64 5c 33 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 1 1e 30 6e 44 44 21 d 30 77 0 4c " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 17 13 47 52 49 33 22 d 30 72 0 4c " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 68 b 30 7a 49 33 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 1f 7 55 53 5c 33 3a c 30 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 62 7 55 64 49 33 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 62 7 55 64 49 33 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 62 7 55 64 49 33 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 54 7 55 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 54 7 55 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 54 7 55 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 54 7 55 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 54 7 55 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 73 7 55 56 50 5b " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 6 7 58 5b 50 56 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 54 7 58 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 54 7 58 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 54 7 58 " );
        s.artics.add( "X35 79 6c 3b 4b 4d 32 a 54 7 58 " );
        s.artics.add( "X35 79 6c 1a 4b 4d 32 e9 54 7 58 " );
        s.artics.add( "X35 79 6c f9 4b 4d 32 c8 54 7 58 " );
        s.artics.add( "X35 79 6c df 4b 4d 32 ae 66 7 58 7b 49 33 " );
        s.artics.add( "X35 79 6c be 4b 4d 32 8d d 7 58 50 49 33 " );
        s.artics.add( "X35 79 6c 9d 4b 4d 33 6c 54 1e 30 " );
        s.artics.add( "X35 79 6d 43 4b 4d 33 32 54 1e 30 " );
        s.artics.add( "X35 79 6d 22 4b 4d 33 11 54 1e 30 " );
        map.put( s.filename, s );
        s = new Sync( "meep6.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 6d b 30 70 49 33 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 2e b 30 6f 49 33 22 1 47 66 14 4c " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 15 13 47 57 49 33 2c d 30 70 0 4c " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 1b 1e 30 52 44 44 39 d 30 75 0 4c " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 76 1e 30 6b 5c 33 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 18 1e 30 6d 44 44 21 d 30 79 0 4c " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 1a 13 47 6d 48 33 2f c 30 71 0 4c " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 3 13 47 6d 48 33 21 c 30 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 71 13 47 64 48 33 25 c 30 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 66 13 47 7c 49 33 37 d 30 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 6a 13 47 7c 49 33 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 6a 13 47 7c 49 33 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 6a 13 47 7c 49 33 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 6a 13 47 7c 49 33 " );
        map.put( s.filename, s );
        s = new Sync( "meep7.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 5 1f 30 57 49 33 38 15 55 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 12 1f 30 54 50 56 2b c 30 " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 1d 7 55 6b 49 33 2c d 30 " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 8 7 55 6a 49 33 3c d 30 77 5 4c " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 1 7 55 68 49 33 21 1c 30 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 13 e 30 56 49 33 15 15 55 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 7 7 55 60 49 33 23 1c 30 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 78 7 55 67 49 33 3c 1c 30 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 65 7 55 78 49 33 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 76 7 55 6d 49 33 34 15 58 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 1 1e 30 5b 50 56 30 15 58 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 72 1e 30 6c 50 56 32 15 58 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 69 1e 30 7d 50 5b " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 69 1e 30 7d 50 5b " );
        map.put( s.filename, s );
        s = new Sync( "meep8.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 2 1e 30 44 5c 33 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 6f b 30 73 49 33 " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 6f b 30 73 49 33 " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 17 b 30 6d 44 44 3b 1c 30 7b 14 4c 38 8 33 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 14 13 47 65 48 33 25 1c 30 7c 0 4c 3c 8 33 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 2 13 47 6f 48 33 3a c 30 7a 5 4c " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 74 13 47 62 48 33 3f c 30 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 69 13 47 70 48 33 36 c 30 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 54 13 47 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 54 13 47 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 54 13 47 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 54 13 47 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 54 13 47 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 54 13 47 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 54 13 47 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 64 13 47 7e 59 33 32 c 30 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 3 e 30 47 49 33 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 3 e 30 47 49 33 " );
        s.artics.add( "X35 79 6c 3b 4b 4d 32 a 1a 7 58 6b 59 33 29 c 30 " );
        s.artics.add( "X35 79 6c 1a 4b 4d 32 e9 71 7 58 67 59 33 25 c 30 " );
        s.artics.add( "X35 79 6c f9 4b 4d 32 c8 67 7 58 70 59 33 30 c 30 " );
        s.artics.add( "X35 79 6c df 4b 4d 32 ae 54 7 58 " );
        s.artics.add( "X35 79 6c be 4b 4d 32 8d 54 7 58 " );
        s.artics.add( "X35 79 6c 9d 4b 4d 33 6c 54 7 58 " );
        s.artics.add( "X35 79 6d 43 4b 4d 33 32 54 7 58 " );
        s.artics.add( "X35 79 6d 22 4b 4d 33 11 54 7 58 " );
        s.artics.add( "X35 79 6d 1 4b 4d 33 f0 54 7 58 " );
        map.put( s.filename, s );
        s = new Sync( "meep9.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 6a b 30 7c 49 33 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 15 b 30 61 48 33 21 1 47 60 15 4c " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 11 13 47 68 48 33 23 c 30 7f 0 4c " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 19 13 47 57 48 33 2d c 30 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 1f 13 47 6a 48 33 2d c 30 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 c 13 47 61 49 33 3a d 30 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 4 13 47 6c 49 33 21 d 30 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 1a 13 47 6b 48 33 29 c 30 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 1c 13 47 6b 49 33 2f d 30 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 7 13 47 6d 49 33 25 d 30 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 6 13 47 61 49 33 23 15 58 72 14 4c " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 18 13 47 53 50 5b 20 c 30 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 1e 7 58 56 44 44 20 c 30 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 d 7 58 65 49 33 27 1 47 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 62 7 58 64 49 33 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 62 7 58 64 49 33 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 62 7 58 64 49 33 " );
        map.put( s.filename, s );
        s = new Sync( "meep10.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 78 b 30 6d 49 33 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 10 1e 30 6e 5c 33 23 1 47 67 14 4c " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 12 1e 30 54 44 44 29 d 30 73 0 4c " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 19 13 47 55 49 33 22 d 30 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 12 1e 30 68 48 33 28 1 47 77 5 4c " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 11 1e 30 57 44 44 25 d 30 62 5 4c " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 11 1e 30 6c 48 33 22 1 47 62 5 4c " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 14 13 47 56 49 33 2c d 30 77 5 4c " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 1 13 47 56 49 33 27 d 30 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 72 13 47 69 49 33 37 d 30 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 8 1e 30 54 44 44 3c d 30 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 60 1e 30 79 44 44 31 d 30 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 6d 1e 30 72 44 44 34 d 30 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 54 1e 30 " );
        map.put( s.filename, s );
        s = new Sync( "meep11.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 a 1e 30 6b 50 56 39 18 30 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 0 1e 30 5c 50 56 3c 18 30 " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 2 7 55 5f 49 33 32 18 30 " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 d 7 55 56 49 33 30 18 30 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 60 7 55 67 49 33 34 18 30 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 1d a 30 5f 50 56 39 c 30 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a a a 30 6d 50 56 38 c 30 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 7 a 30 54 50 56 3c c 30 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 1f 7 55 5a 5d 33 32 c 30 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 8 7 55 52 5d 33 33 c 30 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 76 7 55 6f 5d 33 31 c 30 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 6d 7 55 73 5d 33 34 c 30 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 6e 7 55 73 49 33 35 18 30 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 77 7 55 6f 49 33 36 18 30 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 9 7 55 50 49 33 31 18 30 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 1f 7 55 58 49 33 30 18 30 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 71 1e 30 6d 50 56 32 18 30 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 8 1e 30 50 50 56 30 18 30 " );
        s.artics.add( "X35 79 6c 3b 4b 4d 32 a 1 1e 30 5b 50 56 31 18 30 " );
        s.artics.add( "X35 79 6c 1a 4b 4d 32 e9 8 7 55 5e 49 33 36 18 30 " );
        s.artics.add( "X35 79 6c f9 4b 4d 32 c8 70 7 55 60 49 33 39 15 58 72 1 4c " );
        s.artics.add( "X35 79 6c df 4b 4d 32 ae 13 a 30 6a 50 5b 27 c 30 63 c 29 " );
        s.artics.add( "X35 79 6c be 4b 4d 32 8d 1e 7 58 50 5d 33 3a c 30 " );
        s.artics.add( "X35 79 6c 9d 4b 4d 33 6c 7 7 58 68 5d 33 38 c 30 " );
        s.artics.add( "X35 79 6d 43 4b 4d 33 32 75 7 58 65 5d 33 3f c 30 " );
        s.artics.add( "X35 79 6d 22 4b 4d 33 11 6d 7 58 70 49 33 35 18 30 " );
        s.artics.add( "X35 79 6d 1 4b 4d 33 f0 6e 7 58 70 49 33 " );
        s.artics.add( "X35 79 6d e0 4b 4d 33 d6 6e 7 58 70 49 33 " );
        s.artics.add( "X35 79 6d c6 4b 4d 33 b5 6e 7 58 70 49 33 " );
        map.put( s.filename, s );
        s = new Sync( "meep12.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 7d 1e 30 64 44 44 36 13 30 72 5 4c " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 76 1e 30 66 44 44 3f 1c 30 70 a 4c " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 e 1e 30 62 59 33 24 1 47 72 a 4c " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 16 1e 30 54 50 56 27 1c 30 7b 18 3b " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 d 7 55 65 49 33 3b 1c 30 71 18 3b " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 51 7 55 77 59 33 35 c 30 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 54 7 55 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 54 7 55 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 54 7 55 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 54 7 55 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 54 7 55 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 54 7 55 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 54 7 55 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 54 7 55 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 52 7 55 77 49 33 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 52 7 55 77 49 33 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 7c 7 55 7b 5d 33 3c c 30 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 19 7 55 63 49 33 26 1 47 62 1 4c " );
        s.artics.add( "X35 79 6c 3b 4b 4d 32 a 12 7 55 6e 49 33 21 18 30 61 18 3b " );
        s.artics.add( "X35 79 6c 1a 4b 4d 32 e9 2b 1e 30 6d 50 56 22 18 30 66 18 3b " );
        s.artics.add( "X35 79 6c f9 4b 4d 32 c8 12 1e 30 6a 5d 33 29 1 47 7a c 29 " );
        s.artics.add( "X35 79 6c df 4b 4d 32 ae 15 1e 30 55 44 44 2e 18 30 " );
        s.artics.add( "X35 79 6c be 4b 4d 32 8d 14 a 30 55 49 33 29 1 47 " );
        s.artics.add( "X35 79 6c 9d 4b 4d 33 6c 1d a 30 55 49 33 26 1 47 " );
        s.artics.add( "X35 79 6d 43 4b 4d 33 32 b a 30 55 49 33 30 1 47 " );
        s.artics.add( "X35 79 6d 22 4b 4d 33 11 71 a 30 55 49 33 " );
        s.artics.add( "X35 79 6d 1 4b 4d 33 f0 71 a 30 55 49 33 " );
        s.artics.add( "X35 79 6d e0 4b 4d 33 d6 71 a 30 55 49 33 " );
        s.artics.add( "X35 79 6d c6 4b 4d 33 b5 1f a 30 6d 50 5b 2c c 30 " );
        s.artics.add( "X35 79 6d a5 4b 4d 33 94 54 7 58 " );
        s.artics.add( "X35 79 6d 84 4b 4d 34 7a 54 7 58 " );
        s.artics.add( "X35 79 6a 6a 4b 4d 34 59 54 7 58 " );
        s.artics.add( "X35 79 6a 49 4b 4d 34 38 54 7 58 " );
        s.artics.add( "X35 79 6a 2f 4b 4d 34 1e 54 7 58 " );
        s.artics.add( "X35 79 6a e 4b 4d 34 fd 54 7 58 " );
        s.artics.add( "X35 79 6a ed 4b 4d 34 dc 54 7 58 " );
        s.artics.add( "X35 79 6a d3 4b 4d 34 a2 54 7 58 " );
        map.put( s.filename, s );
        s = new Sync( "meep13.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 4 7 55 59 49 33 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 76 7 55 6b 49 33 " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 51 7 55 74 49 33 " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 54 7 55 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 54 7 55 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 54 7 55 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 79 7 55 78 49 33 39 13 30 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 7 7 55 61 49 33 21 13 30 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 2 1e 30 5c 56 33 33 15 55 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 7d 7 55 78 49 33 3d 13 30 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 66 7 55 7b 49 33 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 71 7 55 54 49 33 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 4 7 55 59 49 33 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 7 1e 30 5a 50 56 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 74 1e 30 69 50 56 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 8 1e 30 5d 50 56 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 3 7 55 46 49 33 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 f 7 55 52 49 33 " );
        s.artics.add( "X35 79 6c 3b 4b 4d 32 a 60 7 55 65 49 33 " );
        s.artics.add( "X35 79 6c 1a 4b 4d 32 e9 54 7 55 " );
        s.artics.add( "X35 79 6c f9 4b 4d 32 c8 7a 7 55 62 49 33 31 18 30 " );
        s.artics.add( "X35 79 6c df 4b 4d 32 ae b 7 55 57 49 33 32 18 30 " );
        s.artics.add( "X35 79 6c be 4b 4d 32 8d 1 7 55 5f 49 33 3c 18 30 " );
        s.artics.add( "X35 79 6c 9d 4b 4d 33 6c 78 1e 30 66 5d 33 3e 15 55 " );
        s.artics.add( "X35 79 6d 43 4b 4d 33 32 2 1e 30 50 50 56 3f 18 30 " );
        s.artics.add( "X35 79 6d 22 4b 4d 33 11 1 7 55 5f 49 33 3c 18 30 " );
        s.artics.add( "X35 79 6d 1 4b 4d 33 f0 b 7 55 57 49 33 32 18 30 " );
        s.artics.add( "X35 79 6d e0 4b 4d 33 d6 7a 7 55 63 49 33 31 18 30 " );
        s.artics.add( "X35 79 6d c6 4b 4d 33 b5 52 7 55 76 49 33 35 18 30 " );
        s.artics.add( "X35 79 6d a5 4b 4d 33 94 9 7 55 57 5d 33 3c c 30 " );
        s.artics.add( "X35 79 6d 84 4b 4d 34 7a 1f 7 55 5e 5d 33 3e c 30 " );
        s.artics.add( "X35 79 6a 6a 4b 4d 34 59 1 a 30 55 50 56 3b c 30 " );
        s.artics.add( "X35 79 6a 49 4b 4d 34 38 7d a 30 61 49 33 " );
        s.artics.add( "X35 79 6a 2f 4b 4d 34 1e 7d a 30 61 49 33 " );
        s.artics.add( "X35 79 6a e 4b 4d 34 fd 7d a 30 61 49 33 " );
        s.artics.add( "X35 79 6a ed 4b 4d 34 dc 7d a 30 61 49 33 " );
        s.artics.add( "X35 79 6a d3 4b 4d 34 a2 7d a 30 61 49 33 " );
        s.artics.add( "X35 79 6a b2 4b 4d 34 81 7d a 30 61 49 33 " );
        s.artics.add( "X35 79 6a 91 4b 4d 35 60 7d a 30 61 49 33 " );
        s.artics.add( "X35 79 6b 77 4b 4d 35 46 7b a 30 6e 49 33 " );
        s.artics.add( "X35 79 6b 56 4b 4d 35 25 2 a 30 47 49 33 " );
        s.artics.add( "X35 79 6b 35 4b 4d 35 4 54 1e 30 " );
        s.artics.add( "X35 79 6b 1b 4b 4d 35 ea 54 1e 30 " );
        map.put( s.filename, s );
        s = new Sync( "meep14.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 0 9 47 68 55 33 20 c 30 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 2 9 47 6d 55 33 20 c 30 " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 a 9 47 60 49 33 26 10 30 " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 7b 9 47 6f 49 33 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 d 9 47 56 49 33 30 10 30 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 1e 9 47 50 49 33 3c 10 30 77 4 35 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 17 1e 30 6c 5e 44 2c 1d 49 7a 9 4c " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 19 f 49 53 49 33 3a 1b 47 74 9 4c " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 17 9 47 6a 58 4a 23 c 30 78 9 4c " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 1a 9 47 62 49 33 21 1d 49 62 9 4c " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d f 9 47 66 55 33 3a c 30 76 4 35 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 68 9 47 7c 49 33 34 10 30 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 6a 9 47 7c 49 33 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 66 9 47 7c 49 33 37 10 30 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 73 9 47 65 55 33 39 c 30 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 9 9 47 6a 55 33 38 c 30 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 1d 9 47 50 55 33 3a c 30 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 e 2 30 65 5e 44 27 c 30 " );
        s.artics.add( "X35 79 6c 3b 4b 4d 32 a 7f 2 30 63 49 33 " );
        s.artics.add( "X35 79 6c 1a 4b 4d 32 e9 7f 2 30 63 49 33 " );
        s.artics.add( "X35 79 6c f9 4b 4d 32 c8 7f 2 30 63 49 33 " );
        s.artics.add( "X35 79 6c df 4b 4d 32 ae 7f 2 30 63 49 33 " );
        map.put( s.filename, s );
        s = new Sync( "meep15.wav" );
        s.artics.add( "X35 79 6e 63 4b 4d 30 52 61 c 30 65 49 33 " );
        s.artics.add( "X35 79 6e 42 4b 4d 30 31 61 c 30 65 49 33 " );
        s.artics.add( "X35 79 6e 21 4b 4d 30 10 72 c 30 63 49 33 39 15 55 " );
        s.artics.add( "X35 79 6e 7 4b 4d 30 f6 15 c 30 55 50 56 2f c 30 " );
        s.artics.add( "X35 79 6e e6 4b 4d 30 d5 0 7 55 6b 49 33 20 1e 30 " );
        s.artics.add( "X35 79 6e c5 4b 4d 30 b4 72 7 55 57 49 33 " );
        s.artics.add( "X35 79 6e ab 4b 4d 30 9a 54 7 55 " );
        s.artics.add( "X35 79 6e 8a 4b 4d 31 79 54 7 55 " );
        s.artics.add( "X35 79 6f 69 4b 4d 31 58 54 7 55 " );
        s.artics.add( "X35 79 6f 4f 4b 4d 31 3e 54 7 55 " );
        s.artics.add( "X35 79 6f 2e 4b 4d 31 1d 54 7 55 " );
        s.artics.add( "X35 79 6f d 4b 4d 31 fc 7f 7 55 79 49 33 31 1e 30 " );
        s.artics.add( "X35 79 6f f3 4b 4d 31 c2 9 7 55 56 49 33 3c 1e 30 " );
        s.artics.add( "X35 79 6f d2 4b 4d 31 a1 5 1e 30 68 50 56 3a 1e 30 " );
        s.artics.add( "X35 79 6f b1 4b 4d 31 80 2 1e 30 50 50 56 3e 1e 30 " );
        s.artics.add( "X35 79 6f 90 4b 4d 32 66 5 7 55 5e 49 33 33 1e 30 " );
        s.artics.add( "X35 79 6c 76 4b 4d 32 45 73 7 55 6a 49 33 36 19 30 " );
        s.artics.add( "X35 79 6c 55 4b 4d 32 24 1c 1e 30 55 50 56 26 19 30 " );
        s.artics.add( "X35 79 6c 3b 4b 4d 32 a e 1e 30 50 5c 33 " );
        s.artics.add( "X35 79 6c 1a 4b 4d 32 e9 7f b 30 63 49 33 " );
        s.artics.add( "X35 79 6c f9 4b 4d 32 c8 7f b 30 63 49 33 " );
        s.artics.add( "X35 79 6c df 4b 4d 32 ae 8 13 47 68 5c 33 39 c 30 " );
        s.artics.add( "X35 79 6c be 4b 4d 32 8d c 13 47 54 5e 44 31 c 30 " );
        s.artics.add( "X35 79 6c 9d 4b 4d 33 6c 7 13 47 5e 5e 44 31 c 30 " );
        s.artics.add( "X35 79 6d 43 4b 4d 33 32 3 13 47 5a 5e 44 36 c 30 " );
        s.artics.add( "X35 79 6d 22 4b 4d 33 11 0 13 47 46 5e 44 36 c 30 " );
        s.artics.add( "X35 79 6d 1 4b 4d 33 f0 6 9 47 5f 44 44 36 c 30 " );
        s.artics.add( "X35 79 6d e0 4b 4d 33 d6 73 9 47 68 44 44 37 c 30 " );
        s.artics.add( "X35 79 6d c6 4b 4d 33 b5 54 9 47 " );
        s.artics.add( "X35 79 6d a5 4b 4d 33 94 54 9 47 " );
        s.artics.add( "X35 79 6d 84 4b 4d 34 7a 54 9 47 " );
        s.artics.add( "X35 79 6a 6a 4b 4d 34 59 54 9 47 " );
        s.artics.add( "X35 79 6a 49 4b 4d 34 38 54 9 47 " );
        s.artics.add( "X35 79 6a 2f 4b 4d 34 1e 54 9 47 " );
        map.put( s.filename, s );


    }
}
