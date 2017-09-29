package ro.chop;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;


/**
 * 

 *
 */
public class Main__CheminOptimal
{

    public Main__CheminOptimal()
    {
        JFrame frame = new Chop__Fenetre();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if(frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
        if(frameSize.width > screenSize.width)
            frameSize.width = screenSize.width;
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    public static void main(String args[])
    {
        /** Templates ***********************************************************/
        /*	try
         * {
         * for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() )
         * {
         * if ( "Nimbus".equals(info.getName()) )
         * {
         * javax.swing.UIManager.setLookAndFeel(info.getClassName());
         * break;
         * }
         * }
         * }
         * catch ( ClassNotFoundException ex )
         * {
         * java.util.logging.Logger.getLogger(Main__CheminOptimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         * }
         * catch ( InstantiationException ex )
         * {
         * java.util.logging.Logger.getLogger(Main__CheminOptimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         * }
         * catch ( IllegalAccessException ex )
         * {
         * java.util.logging.Logger.getLogger(Main__CheminOptimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         * }
         * catch ( javax.swing.UnsupportedLookAndFeelException ex )
         * {
         * java.util.logging.Logger.getLogger(Main__CheminOptimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         * }*/
		/***********************************************************************/
	 try {
            
             //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
             UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
             //UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
             //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        new Main__CheminOptimal();
    }
}
