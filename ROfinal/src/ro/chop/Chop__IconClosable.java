package ro.chop;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;


/**
 * 

 *
 */
public class Chop__IconClosable
    implements Icon
{

    public Chop__IconClosable(Icon icon)
    {
        mTabbedPane = null;
        mPosition = null;
        imgFermer = getClass().getResource("/images/idio.png");
        fer = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imgFermer));
        imgFermer2 = getClass().getResource("/images/idioover.png");
        fer2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imgFermer2));
        mIcon = icon;
    }

    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        if(null == mTabbedPane)
        {
            mTabbedPane = (JTabbedPane)c;
            mTabbedPane.addMouseListener(new MouseAdapter() 
            {
                public void mouseReleased(MouseEvent e)
                {
                    if(!e.isConsumed() && mPosition.contains(e.getX(), e.getY()))
                    {
                        int index = mTabbedPane.getSelectedIndex();
                        mTabbedPane.remove(index);
                        e.consume();
                    }
                }

                @SuppressWarnings("unused")
				final Chop__IconClosable this$0;
                {
                	this$0 = Chop__IconClosable.this;
                }
            }
            							);
            mTabbedPane.addMouseMotionListener(new MouseMotionAdapter() 
            {
                public void mouseMoved(MouseEvent e)
                {
                    if(!e.isConsumed() && mPosition.contains(e.getX(), e.getY()))
                        mIcon = fer2;
                    else
                        mIcon = fer;
                    e.consume();
                }

                @SuppressWarnings("unused")
				final Chop__IconClosable this$0;            
	            {
	                this$0 = Chop__IconClosable.this;
	            }
            }
            								  );
        }
        mPosition = new Rectangle(x, y, getIconWidth(), getIconHeight());
        mIcon.paintIcon(c, g, x, y);
    }

    public int getIconWidth()
    {
        return mIcon.getIconWidth();
    }

    public int getIconHeight()
    {
        return mIcon.getIconHeight();
    }

    private Icon 				mIcon;
    private JTabbedPane 		mTabbedPane;
    private transient Rectangle mPosition;
    private URL 				imgFermer;
    Icon 						fer;
    private URL 				imgFermer2;
    Icon 						fer2;
}