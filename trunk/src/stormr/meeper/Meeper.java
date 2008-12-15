/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.meeper;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Makes a meeping sound
 * @author twak
 */
public class Meeper 
{
    double duration;
            
    static List<String> 
            meeps = new ArrayList(), 
            waits = new ArrayList();
    
    {
        for (int i = 1; i < 16; i++) //gah - how to get list of resources from jar?
            meeps.add( "/resources/meep"+i+".wav");
        
        for (int i = 1; i < 3; i++)
            waits.add( "/resources/wait"+i+".wav");
    }
    
            
            
    public double getDuration()
    {
        return duration;
    }
    
    Node lipSync = null;
    List<String> files= new ArrayList();
    
    public Meeper(File destination, String text)
    {
        String[] words = text.split( " " );
        
        List<AudioInputStream> toConcat = new ArrayList();
        
        // same text = same meeps...
        Random randy = new Random(text.hashCode());
        
        try
        {
            
        int meepCount = 0;
        
        String meep = "";
                
        for (String s : words)
        {
//             add some meeps
            boolean pause = s.contains( ".:;!" );
            
            meepCount++;
            if ( meepCount == 2 || pause )
            {
                String newMeep;
                
                // don't do same meep twice in a row
                do
                {
                    newMeep = meeps.get( randy.nextInt(
                                  meeps.size() ) );
                }
                while ( meep.compareTo( newMeep ) == 0 );
                        
                meep = newMeep;
                
                toConcat.add( 
                        AudioSystem.getAudioInputStream( getClass().getResourceAsStream( meep ) ) );
                
                files.add(meep); // store for artic generation
                meepCount = 0;
            }
            
            // pause for breath
            if (pause)
                toConcat.add(
                        AudioSystem.getAudioInputStream( getClass().getResourceAsStream( 
                        waits.get(randy.nextInt( 
                        waits.size() ) ) ) ) );
        }
        
            if (toConcat.size() == 0)
                toConcat.add(  AudioSystem.getAudioInputStream( 
                        getClass().getResourceAsStream( 
                        meeps.get( 
                        randy.nextInt( 
                        meeps.size() ) ) ) ) );
            
         AudioFormat format = toConcat.get( 0 ).getFormat();
         double bytesSec = format.getSampleRate() * format.getSampleSizeInBits() / 8;
        
         SequenceAudioInputStream sais = new SequenceAudioInputStream( toConcat.get( 0 ).getFormat(), toConcat );

         AudioSystem.write(
                    sais,
                    AudioFileFormat.Type.WAVE, destination );
         
         duration = sais.bytesSent / bytesSec;
         
         sais.close();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
    
    public List<String> getArtics ()
    {
        return ArticBuilder.createFor( files );   
    }
    
    public class WavFiler implements FilenameFilter
    {
        public boolean accept( File dir, String name )
        {
            return name.endsWith( ".wav");
        }   
    }
    
    public static void main (String[] args)
    {
        new Meeper (new File ("audio.wav"), "morning aThe sound of the morning alarm rang out, four loud hard clear gong-clangs, and all over the great starship Valhalla the men of the Crew rolled out of their bunks to begin another day. The great ship had travelled silently through the endless night of space while they slept, bringing them closer and closer to the mother world, Earth. The Valhalla was on the return leg of a journey to Alpha Centauri."+
"But one man aboard the starship had not waited for the morning alarm. For Alan Donnell the day had begun several hours before. Restless, unable to sleep, he had quietly slipped from his cabin in the fore section, where the unmarried Crewmen lived, and had headed forward to the main viewscreen, in order to stare at the green planet growing steadily larger just ahead."+
"He stood with his arms folded, a tall red-headed figure, long-legged, a little on the thin side. Today was his seventeenth birthday."+
"Alan adjusted the fine controls on the viewscreen and[12] brought Earth into sharper focus. He tried to pick out the continents on the planet below, struggling to remember his old history lessons. Tutor Henrich would not be proud of him, he thought."+
"That's South America down there, he decided, after rejecting the notion that it might be Africa. They had pretty much the same shape, and it was so hard to remember what Earth's continents looked like when there were so many other worlds. But that's South America. And so that's North America just above it. The place where I was born."+
"Then the 0800 alarm went off, the four commanding gongs that Alan always heard as It's! Time! Wake! Up! The starship began to stir into life. As Alan drew out his Tally and prepared to click off the start of a new day, he felt a strong hand firmly grasp his shoulder.);"
);
    }
}
