/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

/**
 *
 * @author tom
 */
public class ListDownLayout implements LayoutManager
{

    public void addLayoutComponent( String name, Component comp )
    {
    }

    public void removeLayoutComponent( Component comp )
    {
    }

    public Dimension preferredLayoutSize( Container parent )
    {
        int height = 0;
        for (Component c : parent.getComponents())
            height += c.getPreferredSize().getHeight();
        return new Dimension ( 100, height );
    }

    public Dimension minimumLayoutSize( Container parent )
    {
        int height = 0;
        for (Component c : parent.getComponents())
            height += c.getPreferredSize().getHeight();
        return new Dimension ( Integer.MAX_VALUE, height );
    }

    public void layoutContainer( Container parent )
    {
              synchronized (parent.getTreeLock()) {
        int height = 0;
        for (Component c : parent.getComponents())
        {
            Dimension prefSize = c.getPreferredSize();
            c.setSize( parent.getWidth(), prefSize.height );
            c.setLocation( 0, height);
            height += prefSize.getHeight();
        }
              }
    }

}
