/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stormr;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.aetrion.flickr.Flickr;
import com.aetrion.flickr.FlickrException;
import com.aetrion.flickr.REST;
import com.aetrion.flickr.RequestContext;
import com.aetrion.flickr.auth.Auth;
import com.aetrion.flickr.auth.Permission;
import com.aetrion.flickr.people.PeopleInterface;
import com.aetrion.flickr.photos.PhotosInterface;
import com.aetrion.flickr.photos.Size;
import com.aetrion.flickr.photosets.Photoset;
import com.aetrion.flickr.photosets.PhotosetsInterface;
import com.aetrion.flickr.util.AuthStore;
import com.aetrion.flickr.util.FileAuthStore;
import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * A simple program to backup all of a users private and public photos in a photoset aware manner.  If photos 
 * are classified in multiple photosets, they will be copied.  Its a sample, its not perfect :-)
 *
 * This sample also uses the AuthStore interface, so users will only be asked to authorize on the first run.
 *
 * @author Matthew MacKenzie
 * @version $Id: Backup.java,v 1.5 2008/07/05 22:19:48 x-mago Exp $
 */
public class Backup
{

    public static Backup instance;
    
    String username;
    private String nsid = null;
    private Flickr flickr = null;
    private AuthStore authStore = null;

    PhotosetsInterface setInterface;
    PhotosInterface photoInterface;
    SetChooser setChooser;

    public Backup( String apiKey, String nsid, String sharedSecret, File authsDir )
            throws IOException, ParserConfigurationException
    {
        this.flickr = new Flickr( apiKey, sharedSecret, new REST() );
        this.nsid = nsid;

        if ( authsDir != null )
            this.authStore = new FileAuthStore( authsDir );
    }
    
    public void stormrSet(String id)
    {
        new MovieBuilder( id, username );
    }
    
    /**
     * Not thread safe enough!
     * @param username
     */
    public void addSetsFor( final String username )
    {
        this.username = username;
        new Thread()
        {

            @Override
            public void run()
            {
        try
        {
            setInterface = flickr.getPhotosetsInterface();
            photoInterface = flickr.getPhotosInterface();

            PeopleInterface peopleFinder = flickr.getPeopleInterface();

            Iterator sets;
            try
            {
                sets = setInterface.getList( peopleFinder.findByUsername( username ).getId() ).getPhotosets().iterator();
            }
            catch (FlickrException e)
            {
                e.printStackTrace();
                Desktop.getDesktop().browse( new URI( "http://www.flickr.com/search/people/?q="+URLEncoder.encode( username) ) );
                JOptionPane.showMessageDialog( setChooser, "Can't find user "+username );
                return;
            }
            //Iterator sets = pi.getList(nsid).getPhotosets().iterator();

            while ( sets.hasNext() )
            {
                Photoset set = ( Photoset ) sets.next();
                setChooser.addSet( set.getId(), photoInterface.getImage( set.getPrimaryPhoto(), Size.SQUARE ), set.getTitle(), set.getDescription() );
                System.out.println( "a set called " + set.getTitle() );
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        
            }
        }.start();
        
    }

    void showSetURL( String id )
    {
        try
        {
            Photoset set = Backup.instance.setInterface.getInfo( id );
            StormrUtils.showBrowser( set.getUrl() );
        }
        catch ( Exception ex )
        {
            Logger.getLogger( Backup.class.getName() ).log( Level.SEVERE, null, ex );
        }
    }

    private void authorize() throws IOException, SAXException, FlickrException
    {
        String frob = this.flickr.getAuthInterface().getFrob();

        URL authUrl = this.flickr.getAuthInterface().buildAuthenticationUrl( Permission.READ, frob );
        //System.out.println("Please visit: " + authUrl.toExternalForm() + " then, hit enter.");
        try
        {
            Desktop.getDesktop().browse( authUrl.toURI() );
        }
        catch ( URISyntaxException ex )
        {
            ex.printStackTrace();
        }

        System.in.read();

        Auth token = this.flickr.getAuthInterface().getToken( frob );
        RequestContext.getRequestContext().setAuth( token );
        authStore.store( token );
        System.out.println( "Thanks.  You probably will not have to do this every time.  Now starting backup." );
    }

    
    public void doBackup( File directory ) throws Exception
    {   
        
        SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
                setChooser = new SetChooser();
            }
        });
   
//        RequestContext rc = RequestContext.getRequestContext();
//        if ( authStore != null )
//        {
//            Auth auth = authStore.retrieve( this.nsid );
//            if ( auth == null )
//                authorize();
//            else
//                rc.setAuth( auth );
//        }


        
//        pi.getList( nsid )
        
    /*
    
    PhotosInterface photoInt = flickr.getPhotosInterface();
    Map allPhotos = new HashMap();
    
    Iterator sets = pi.getList(this.nsid).getPhotosets().iterator();
    
    while (sets.hasNext()) {
    Photoset set = (Photoset)sets.next();
    PhotoList photos = pi.getPhotos(set.getId(), 500, 1);
    allPhotos.put(set.getTitle(), photos);
    }
    
    int notInSetPage = 1;
    Collection notInASet = new ArrayList();
    while (true) {
    Collection nis = photoInt.getNotInSet(50, notInSetPage);
    notInASet.addAll(nis);
    if (nis.size() < 50) break;
    notInSetPage++;
    }
    allPhotos.put("NotInASet", notInASet);
    
    
    
    Iterator allIter = allPhotos.keySet().iterator();
    
    while (allIter.hasNext()) {
    String setTitle = (String) allIter.next();
    String setDirectoryName = makeSafeFilename(setTitle);
    
    Collection currentSet = (Collection) allPhotos.get(setTitle);
    Iterator setIterator = currentSet.iterator();
    File setDirectory = new File(directory, setDirectoryName);
    setDirectory.mkdir();
    while (setIterator.hasNext()) {
    
    Photo p = (Photo) setIterator.next();
    String url = p.getLargeUrl();
    URL u = new URL(url);
    String filename = u.getFile();
    filename = filename.substring(filename.lastIndexOf("/") + 1 , filename.length());				
    System.out.println("Now writing " + filename + " to " + setDirectory.getCanonicalPath());
    BufferedInputStream inStream = new BufferedInputStream(photoInt.getImageAsStream(p, Size.LARGE));
    File newFile = new File(setDirectory, filename);
    
    FileOutputStream fos = new FileOutputStream(newFile);
    
    int read;
    
    while ((read = inStream.read()) != -1) {
    fos.write(read);
    }
    fos.flush();
    fos.close();
    inStream.close();
    }
    }
     */

    }

    private String makeSafeFilename( String input )
    {
        byte[] fname = input.getBytes();
        byte[] bad = new byte[]
        {
            '\\', '/'
        };
        byte replace = '_';
        for ( int i = 0; i < fname.length; i++ )
        {
            for ( int j = 0; j < bad.length; j++ )
            {
                if ( fname[i] == bad[j] )
                    fname[i] = replace;
            }
        }
        return new String( fname );
    }

    public static void main( String[] args ) throws Exception
    {
//		if (args.length < 4) {
//			System.out.println("Usage: java " + Backup.class.getName() + " api_key nsid shared_secret output_dir");
//			System.exit(1);
//		}
        instance = new Backup( "[get your own credentials from flickr]", "[you lazy cretin]", " ;) ",
                                new File( System.getProperty( "user.home" ) + File.separatorChar + ".flickrAuth" ) );

        UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        
        File out = new File( "blah" );
        out.mkdirs();
        instance.doBackup( out );
    }
}
