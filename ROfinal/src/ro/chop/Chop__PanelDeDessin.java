package ro.chop;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * 

 *
 */
public class Chop__PanelDeDessin extends JPanel
{
    public Chop__PanelDeDessin(String img)
    {
        this((new ImageIcon(img)).getImage());
    }

    public Chop__PanelDeDessin(Image img)
    {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, null);
    }

    private static final long serialVersionUID = 1L;
    private Image img;
}