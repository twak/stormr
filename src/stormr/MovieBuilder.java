/*
 * MovieBuilder.java
 *
 * Created on December 13, 2008, 12:35 PM
 */

package stormr;

import com.aetrion.flickr.photos.Note;
import com.aetrion.flickr.photos.Photo;
import com.aetrion.flickr.photos.PhotoList;
import com.aetrion.flickr.photos.Size;
import com.aetrion.flickr.photosets.Photoset;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.vecmath.Matrix4d;
import javax.vecmath.Point2d;
import javax.vecmath.Vector3d;
import stormr.meeper.Meeper;
import stormr.munged.Activity;
import stormr.munged.Colour;
import stormr.munged.Credits;
import stormr.munged.Cut;
import stormr.munged.Frame;
import stormr.munged.LookAt;
import stormr.munged.LookAtCamera;
import stormr.munged.Mark;
import stormr.munged.Move;
import stormr.munged.PointAt;
import stormr.munged.Prop;
import stormr.munged.Say;
import stormr.munged.StandUp;
import stormr.munged.Wall;
import stormr.munger.DocMunger;
import stormr.munger.MungeUtils;
import stormr.munger.Munger;

/**
 *
 * @author  tom
 */
public class MovieBuilder extends javax.swing.JFrame {
    
    Random randy = new Random();
    List<Image> images;
    String id, setDescription = "";
    String setTitle = "untitled presentation";
    String legals = "";
    String userName;
    
    File movieHome;
    
    boolean cancelled = false;
    
    // time between cuttingroom time ref and on set
    double timeOffset = 6;
    
    /** Creates new form MovieBuilder */
    public MovieBuilder( String id , String userName) {
        this.id = id;
        this.userName = userName;
        initComponents();
        setSize( 800,300 );
        setResizable( false );
        setTitle("Stormr is communicating with the internets");
        StormrUtils.setupFrame( this );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        
        File root = new File (System.getProperty( "user.home" ), "Moviestorm/");
        if (!root.exists())
        {
            StormrUtils.showBrowser( "http://moviestorm.co.uk" );
            setVisible( false );
            JOptionPane.showMessageDialog( this, 
                    "It doesn't look like you've got moviestorm installed :(\nhttp://moviestorm.co.uk");
            return;
        }
        
        movieHome = root;
        int i = 0;
        while (movieHome.exists())
        {
            movieHome = new File (root, "Movies/Stormr "+(++i)+"/");
        }
        movieHome.mkdirs();
        
        StormrUtils.copy( 
                getClass().getResourceAsStream( "/resources/movie.summary"), 
                new File (movieHome, "movie.summary") );
        
        new Thread()
        {
            @Override
            public void run()
            {
                stormrSet( MovieBuilder.this.id );
            }
        }.start();
        
        if (cancelled)
            return;
    }
    
    /**
     * 
     * @param id set to storm
     */
    public void stormrSet( String id )
    {
        images = new ArrayList();
        File imgDir = new File (movieHome, "Images");
        imgDir.mkdirs();
        
        int count = 0;
        
        try
        {
            if (cancelled)
            return;
            
            Photoset set = Backup.instance.setInterface.getInfo( id );
            
            String userImage = set.getOwner().getBuddyIconUrl();
            StormrUtils.getImageFromUrl(  userImage, new File (imgDir, "user.jpg") );
            
            setDescription = set.getDescription() == null ? setDescription : set.getDescription() ;
            setTitle = set.getTitle() == null ? setTitle : set.getTitle() ;
            int pageSize = 10; // I wonder what this does..?
            for (int p = 0; p < (set.getPhotoCount()/pageSize)+1; p++)
            {
                PhotoList photoList = Backup.instance.setInterface.getPhotos( id, pageSize, p+1  );
                Iterator it = photoList.iterator();
                
                while (it.hasNext())
                {
                    
                    Photo photo = (Photo) it.next();
                    photo = Backup.instance.photoInterface.getPhoto( photo.getId() ); // the photolist doesn't return all info!
                    
                    imager1.setMessage( "downloading " + photo.getTitle() );
                    
                    Image image = new Image(Backup.instance.photoInterface.getImage( photo, Size.MEDIUM ),
                            photo.getTitle(), photo.getDescription());
                    
                    for (Object o : photo.getNotes())
                    {
                        Note n = (Note)o;
                        image.addNote( n.getBounds(), n.getText(), photo.getOwner().getUsername() );
                    }
                    
                    image.file = image.hashCode()+".jpg";
                    
                    // orient the image
                    image.processToRatio( 1000, 1618, image.average.darker().darker() );
                    
                    
                    File imageFile = new File (imgDir, image.file );
                    if (imageFile.exists())
                        imageFile.delete();
                    ImageIO.write( image.image, "jpg", imageFile );
                    
                    images.add(image);
                    
                    imager1.setImages( images );
                    
                    legals += photo.getTitle()+ " by " + photo.getOwner().getUsername() +
                            " (" +photo.getLicense() +")\n";
                    
                    count++;
                }
            }
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
//            JOptionPane.showMessageDialog( setChooser, "Couldn't get any more photos :(" );
        }
        
        imager1.setMessage( "creating movie..." );
        
        createMovie(images);
    }
        
    List<Activity> credits;
    private void createMovie( List <Image> images)
    {
        Munger.workpad.clear();
        List<Prop> props = new ArrayList();
        Munger.workpad.put( "props", props );
        List<Mark> marks = new ArrayList();
        Munger.workpad.put( "marks", marks );
        List<Activity> schedule = new ArrayList();
        Munger.workpad.put( "schedule", schedule );
        List<Wall> walls = new ArrayList();
        Munger.workpad.put( "walls", walls );
        credits = new ArrayList();
        Munger.workpad.put( "credits", credits);
        List<Activity> cuts = new ArrayList();
        Munger.workpad.put( "cuts", cuts);
        
        Color wallCol = images.get( images.size() -1 ).average.darker().darker();
        
        Munger.workpad.put( "ceiling_red", wallCol.getRed()/255f);
        Munger.workpad.put( "ceiling_green", wallCol.getGreen()/255f);
        Munger.workpad.put( "ceiling_blue", wallCol.getBlue()/255f);
        Munger.workpad.put( "ceiling_alpha", wallCol.getAlpha()/255f);
        
        // values in the script editor
        Munger.workpad.put( "title", setTitle);
        Munger.workpad.put( "blurb", legals);
        Munger.workpad.put( "tagline", setDescription);
        
        // frame of reference for each image
        Matrix4d loc = new Matrix4d(); loc.setIdentity();
        loc.setTranslation( new Vector3d( 20, 0, 0 ) );
        
        // distance between frames
        Matrix4d translate = new Matrix4d();
        translate.setIdentity();
        translate.setTranslation( new Vector3d(-3, 0, 0 ) );
        
        double time = 0;
        
        // start location
        Matrix4d startMat = new Matrix4d();
        startMat.setIdentity();

        Matrix4d startOffset = new Matrix4d();
        startOffset.setIdentity();
        startOffset.setTranslation( new Vector3d( 19, 0.7, 0 ) );

        startMat.mul( startOffset );
        
        Mark startMark = new Mark( startMat );
        marks.add( startMark ); // add mark before adding new Move!
        Move startMove = new Move( startMark, 0 );
        startMove.isPlace = true;
        schedule.add( startMove );
        // time we edit to
        timeOffset = 6;
        time = 7;
        
        schedule.add(  new LookAtCamera( time- 0.5 ));
        // welcome minions!
        time += addSay( setTitle + " " + setDescription , time );
        
        schedule.add( new StandUp( time ) );
        
        time += 3.54;
        
        int i = 0;
        for ( Image image : images )
        {
            if (cancelled)
            return;
            
            loc.mul( translate );

            Matrix4d frameOffset = new Matrix4d();
            frameOffset.setIdentity();
            frameOffset.setTranslation( new Vector3d( 0, 0.1, 1.3 ) );
            
            Matrix4d frameMat = new Matrix4d();
            frameMat.setIdentity();
            
            // centre frame at origin
            Matrix4d toOrigin = new Matrix4d();
            toOrigin.setIdentity();
            toOrigin.setTranslation( new Vector3d( 0, 0, -0.28 ) );

            Matrix4d rot = new Matrix4d();
            rot.setIdentity();

            if ( !image.isPortrait )
                rot.rotY( Math.PI / 2. );

            Matrix4d scale = new Matrix4d();
            scale.setIdentity();
            scale.setScale( 3 );

            frameMat.mul( frameOffset );
            frameMat.mul( loc );
            frameMat.mul( scale );
            frameMat.mul( rot );
            frameMat.mul( toOrigin  );
                        
            Frame frame = new Frame( "Dressing/Decor/Furnishings/Pictures/Wall_Picture_02", frameMat  );
            frame.frameImage = "Images/"+image.file;
            frame.setColor( image.average );
            frame.scale = 3;
            
            Wall wall = new Wall ( 
                    // first & last wall sections have double the length
                    new Point2d (loc.m03 + (i==0 ? 6 : 1.5), loc.m13) ,
                    new Point2d (loc.m03 - (i==images.size() -1  ? 3 : 1.5), loc.m13)
                    );
            
            walls.add( wall );
            wall.setHeight( 3 );
            wall.color = new Colour ( wallCol );
            
            props.add( frame );
            
            {
                Matrix4d markMat = new Matrix4d();
                markMat.setIdentity();

                Matrix4d markOffset = new Matrix4d();
                markOffset.setIdentity();
                markOffset.setTranslation( new Vector3d( 1, 0.95, 0 ) );

                Matrix4d markRot = new Matrix4d();
                markRot.setIdentity();
                markRot.rotZ( Math.PI / 4. );

                markMat.mul( loc );
                markMat.mul( markOffset );
                markMat.mul( markRot );

                rot.mul( markOffset );

                Mark mark = new Mark( markMat );
                marks.add( mark ); // add mark before new Move!

                Move move = new Move( mark, time );
                
                
                move.isPlace = false;//i == 0;

                double sayTime = addSay(
                        image.title == null ? "An untitled masterpiece" : image.title,
                        time + 2 )+2;

                // stop eyballing the camera!
                if (randy.nextDouble() < 0.5)
                    schedule.add(new LookAt( time - 0.2 ));
                
                // longer to say title or move to point? quicker to move to first mark!
                time+= Math.max( sayTime, i == 0 ? 1.6 :  3.5 );
                schedule.add( move );
                if ( randy.nextDouble() > 0.5 )
                {
                    LookAt look = new LookAt( time - Math.random() * 0.5 - 1, frame.getIndex() );
                    schedule.add( look );
                    // stop looking!
                    look = new LookAt( time - 0.25 );
                    schedule.add( look );
                    schedule.add(  new LookAtCamera( look.startTime + 0.5 ));
                }
                else
                {
                    schedule.add(  new LookAtCamera( time ));
                }
            }
            
            
            
            Matrix4d kMat = new Matrix4d();
            kMat.setIdentity();
            Matrix4d kOff = new Matrix4d();
            kOff.setIdentity();
            Vector3d frameDir = new Vector3d( -1f, 4f, 1.3f );
            kOff.setTranslation( frameDir );
            Matrix4d kRot = new Matrix4d();
            kRot.setIdentity();
            kRot.rotZ( Math.PI * 1.1 );
//            frameDir.negate();
            frameDir.normalize();
            kMat.mul( loc );
            kMat.mul( kOff );
            kMat.mul( kRot );
            KeyFrame keyFrame = new KeyFrame( time + 0.3, kMat, frameDir );
            schedule.add( keyFrame );
            
            imager1.setMessage( "adding description " + image.description );

            if (image.description != null)
            {
                time += addSay( image.description, time);
                time += 0.5;    
            }
            else
                time += 1; // time to appreciate the masterpiece
            
            
            for (Image.Note n : image.notes)
            {
                imager1.setMessage( "adding note " + n.text );
                
                Point p = n.getCentre();
                Matrix4d imageLoc = new Matrix4d(); imageLoc.setIdentity();
                
                Matrix4d offset = new Matrix4d(); offset.setIdentity();
                if (image.isPortrait)
                    offset.setTranslation( new Vector3d (-p.x /450. +.4, 0, -p.y/ 450. +2.1f) );
                else
                    offset.setTranslation( new Vector3d (-p.x /450. +.6, 0, -p.y/ 450. +1.80f) );
                        
                
                Matrix4d s2 = new Matrix4d(); s2.setIdentity();
                s2.setScale( 0.1 );
                
                imageLoc.mul( loc );
                imageLoc.mul( offset );
                imageLoc.mul( s2 );
                
                
                Prop cube = new Prop( "Primitives/Prim_Cube_01", imageLoc  );
                props.add( cube );
                
                PointAt point = new PointAt( time - 0.2, cube.getIndex() );
                schedule.add( point );
                
                double noteTalkTime = addSay (n.text, n.text, time);
                
                if (noteTalkTime > 1 && randy.nextDouble() < 0.5)
                {
                    LookAt look = new LookAt( time, cube.getIndex() );
                    schedule.add( look );
                    // stop looking!
                    schedule.add( new LookAtCamera( time + Math.min (1, Math.random() * noteTalkTime ) ) );
                }
                
                time += 0.5 + noteTalkTime; // short delay before moving on
            }
            
            // second keyframe to keep camera still ;)
            keyFrame = new KeyFrame( time + 0.3, kMat, frameDir );
            schedule.add( keyFrame );
            
            // stop pointing!
            PointAt point = new PointAt( time );
            schedule.add( point );
            
            
            i++;
        }
        
        credits.add( new Credits( time - timeOffset, 2, userName+", Stormr & Moviestorm" ));
        
        // final shot - closeup on last image
        time += 2;
        Matrix4d kMat = new Matrix4d();
        kMat.setIdentity();
        Matrix4d kOff = new Matrix4d();
        kOff.setIdentity();
        Vector3d frameDir = new Vector3d( 0f, 2f, 1.3f );
        kOff.setTranslation( frameDir );
        Matrix4d kRot = new Matrix4d();
        kRot.setIdentity();
        kRot.rotZ( Math.PI );
//            frameDir.negate();
        frameDir.normalize();
        kMat.mul( loc );
        kMat.mul( kOff );
        kMat.mul( kRot );
        KeyFrame keyFrame = new KeyFrame( time, kMat, frameDir );
        schedule.add( keyFrame );
        
        // delta between cutting room and 
        cuts.add( new Cut( 0, time - timeOffset, timeOffset));
        
        
        if(cancelled) // final check before writing
            return;
        
        Munger.workpad.put( "file", "root" );
        Munger dm = new DocMunger();
        MungeUtils.toFile( dm, new File (movieHome, "movie.mscope") );
//        File dest = new File (movieHome, "movie.mscope");
//        File src = new File ("movie.mscope");
//        dest.delete();
//        boolean result = src.renameTo( dest );
        
        imager1.setMessage( "done! - start moviestorm and load movie \"" + movieHome.getName()+"\"" );
        
        cancelButton.setText( "OK" );
        imager1.stop();
    }
    
    private double addSay (String text, double time)
    {
        return addSay( text, text, time );
    }
    
    private double addSay (String text, String subtitle, double time)
    {
        if (text == null || text.length() == 0)
            return 0;
        
        File dialogueDir = new File (movieHome, "Dialogue");
        dialogueDir.mkdirs();
        
        String descriptionFile = "dialogue_" + randy.nextInt() + ".wav";
        Meeper meeper = new Meeper( new File( dialogueDir, descriptionFile ), text );
        Say say = new Say( text, time, meeper.getDuration(), meeper.getArtics() );
        say.audioResource = descriptionFile;
        ((List<Activity>)Munger.workpad.get("schedule")).add( say );
        
        credits.add( new Credits( time-timeOffset, meeper.getDuration(), subtitle ) );
        
        return meeper.getDuration();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imager1 = new stormr.Imager();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout imager1Layout = new javax.swing.GroupLayout(imager1);
        imager1.setLayout(imager1Layout);
        imager1Layout.setHorizontalGroup(
            imager1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        imager1Layout.setVerticalGroup(
            imager1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        cancelButton.setText("cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
            .addComponent(imager1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(imager1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    cancelled = true;
    setVisible( false ); // also called on "OK"
}//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private stormr.Imager imager1;
    // End of variables declaration//GEN-END:variables

}
