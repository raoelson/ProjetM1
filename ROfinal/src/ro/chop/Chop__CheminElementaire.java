package ro.chop;

import java.awt.*;
import javax.swing.Icon;
import javax.swing.JLabel;


/**
 * 
 
 *
 */
@SuppressWarnings("serial")
public class Chop__CheminElementaire extends JLabel
{
    class ic implements Icon
    {
        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            String lava = (new StringBuilder()).append(longueur).append("").toString();
            if(origine != null)
            {
                ox = origine.getLocationX();
                oy = origine.getLocationY();
            } 
            else
            {
                ox = getox();
                oy = getoy();
            }
            if(extremite != null)
            {
                ex = extremite.getLocationX();
                ey = extremite.getLocationY();
            } 
            else
            {
                ex = getex();
                ey = getey();
            }
            int xx = Math.abs(ox - ex) / 2;
            int yy = Math.abs(oy - ey) / 2;
            if(ox > ex)
                xx = ox - xx;
            else
                xx = ox + xx;
            if(oy > ey)
                yy = oy - yy;
            else
                yy = oy + yy;
            g.setFont(new Font("Arial", 1, 14));
            g.setColor(Color.blue);
            g.drawString(lava, xx + 15, yy + 5);
            if(min)
                g.setColor(Color.white);
            else
                g.setColor(Color.black);
            g.drawLine(ox + 15, oy + 15, ex + 15, ey + 15);
            int xp = (3 * ex + ox) / 4 + 15;
            int yp = (3 * ey + oy) / 4 + 15;
            int xp1;
            if(ex > ox)
                xp1 = (int)((double)xp - (double)(15 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            else
                xp1 = (int)((double)xp + (double)(15 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            int yp1;
            if(ey < oy)
                yp1 = (int)((double)yp + (double)(15 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            else
                yp1 = (int)((double)yp - (double)(15 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            int xp2;
            int xp3;
            if(ex > ox)
            {
                xp2 = (int)((double)xp1 - (double)(8 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
                xp3 = (int)((double)xp1 + (double)(8 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            } 
            else
            {
                xp2 = (int)((double)xp1 + (double)(8 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
                xp3 = (int)((double)xp1 - (double)(8 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            }
            
            int yp2;
            int yp3;
            if(ey < oy)
            {
                yp2 = (int)((double)yp1 - (double)(8 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
                yp3 = (int)((double)yp1 + (double)(8 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            } 
            else
            {
                yp2 = (int)((double)yp1 + (double)(8 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
                yp3 = (int)((double)yp1 - (double)(8 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            }
            
            int xp4;
            if(ex > ox)
                xp4 = (int)((double)xp - (double)(10 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            else
                xp4 = (int)((double)xp + (double)(10 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            int yp4;
            if(ey < oy)
                yp4 = (int)((double)yp + (double)(10 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            else
                yp4 = (int)((double)yp - (double)(10 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
            int pox[] = {
                xp, xp2, xp4, xp3, xp
            };
            int poy[] = {
                yp, yp2, yp4, yp3, yp
            };
            g.setColor(Color.red);
            g.fillPolygon(pox, poy, 5);
        }

        public int getIconWidth()
        {
            return ScreenSize.width;
        }

        public int getIconHeight()
        {
            return ScreenSize.height;
        }

        public void redessine()
        {
            repaint();
        }

        final Chop__CheminElementaire this$0;

        public ic()
        {
            this$0 = Chop__CheminElementaire.this;
        }
    }


    public Chop__CheminElementaire(Chop__Sommet o, Chop__Sommet e, int l)
    {
        ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, ScreenSize.width, ScreenSize.height);
        origine = o;
        extremite = e;
        traite = false;
        ox = origine.getLocationX();
        oy = origine.getLocationY();
        ex = extremite.getLocationX();
        ey = extremite.getLocationY();
        longueur = l;
        icon = new ic();
        setIcon(icon);
        icon.redessine();
    }

    public Chop__CheminElementaire()
    {
        ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, ScreenSize.width, ScreenSize.height);
        traite = false;
        icon = new ic();
        setIcon(icon);
        icon.redessine();
    }

    public Chop__CheminElementaire(Chop__Sommet o, int xd, int yd)
    {
        ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, ScreenSize.width, ScreenSize.height);
        origine = o;
        traite = false;
        ex = xd;
        ey = yd;
        icon = new ic();
        setIcon(icon);
        icon.redessine();
    }

    public Chop__CheminElementaire(int xo, int yo, Chop__Sommet e)
    {
        ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, ScreenSize.width, ScreenSize.height);
        extremite = e;
        traite = false;
        ox = xo;
        oy = yo;
        icon = new ic();
        setIcon(icon);
        icon.redessine();
    }

    public Chop__CheminElementaire(int s)
    {
        ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        longueur = s;
        traite = false;
        setBounds(0, 0, ScreenSize.width, ScreenSize.height);
        icon = new ic();
        setIcon(icon);
        icon.redessine();
    }

    public boolean getTraite()
    {
        return traite;
    }

    public boolean getMin()
    {
        return min;
    }

    public void setMin(boolean b)
    {
        min = b;
    }

    public void setTraite(boolean d)
    {
        traite = d;
    }

    public int getPosX()
    {
        ox = origine.getLocationX();
        oy = origine.getLocationY();
        ex = extremite.getLocationX();
        ey = extremite.getLocationY();
        int xp = (3 * ex + ox) / 4 + 15;
        int xarc;
        if(ex > ox)
            xarc = (int)((double)xp - (double)(10 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
        else
            xarc = (int)((double)xp + (double)(10 * Math.abs(ex - ox)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
        return xarc;
    }

    public int getPosY()
    {
        ox = origine.getLocationX();
        oy = origine.getLocationY();
        ex = extremite.getLocationX();
        ey = extremite.getLocationY();
        int yp = (3 * ey + oy) / 4 + 15;
        int yarc;
        if(ey < oy)
            yarc = (int)((double)yp + (double)(10 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
        else
            yarc = (int)((double)yp - (double)(10 * Math.abs(ey - oy)) / Math.sqrt((ex - ox) * (ex - ox) + (ey - oy) * (ey - oy)));
        return yarc;
    }

    public void setex(int a)
    {
        ex = a;
    }

    public void setey(int a)
    {
        ey = a;
    }

    public int getex()
    {
        return ex;
    }

    public int getey()
    {
        return ey;
    }

    public void setox(int a)
    {
        ox = a;
    }

    public void setoy(int a)
    {
        oy = a;
    }

    public int getox()
    {
        return ox;
    }

    public int getoy()
    {
        return oy;
    }

    public static void setNombreArc(int na)
    {
        NombreArc = na;
    }

    public static int getNombreArc()
    {
        return NombreArc;
    }

    public void setLongueur(int l)
    {
        longueur = l;
    }

    public int getLongueur()
    {
        return longueur;
    }

    public Chop__Sommet getOrg()
    {
        return origine;
    }

    public Chop__Sommet getExt()
    {
        return extremite;
    }

    public void setOrg(Chop__Sommet o)
    {
        origine = o;
    }

    public void setExt(Chop__Sommet e)
    {
        extremite = e;
    }

    Dimension 			ScreenSize;
    ic 					icon;
    private Chop__Sommet origine;
    private Chop__Sommet extremite;
    private int 		longueur;
    private static int 	NombreArc;
    private int 		ox;
    private int 		ex;
    private int 		oy;
    private int 		ey;
    private boolean 	traite;
    private boolean 	min;
}