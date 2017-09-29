package ro.chop;

import java.awt.*;
import java.net.URL;
import javax.swing.*;


/**
 * 

 *
 */
@SuppressWarnings("serial")
public class Chop__Sommet extends JLabel
{

    public Chop__Sommet(String l, int xx, int yy)
    {
        imageURL = getClass().getResource("/images/sarysommet.png");
        ic = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imageURL));
        anc_val = 0;
        marque = false;
        label = l;
        x = xx;
        y = yy;
        setIcon(ic);
        setBounds(xx, yy, ic.getIconWidth(), ic.getIconHeight());
    }

    public Chop__Sommet(Chop__Sommet copiena)
    {
        imageURL = getClass().getResource("/images/sarysommet.png");
        ic = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imageURL));
        anc_val = 0;
        marque = false;
        label = copiena.getLabelS();
        x = copiena.getLocationX();
        y = copiena.getLocationY();
        anc_val = copiena.getAncVal();
        setIcon(ic);
        setBounds(x, y, ic.getIconWidth(), ic.getIconHeight());
    }

    public void setNbFils(int xxx)
    {
        NbFils = xxx;
    }

    public int getNbFils()
    {
        return NbFils;
    }

    public boolean isMarque()
    {
        return marque;
    }

    public void setMarque(boolean marq)
    {
        marque = marq;
    }

    public int getValeur()
    {
        return valeur;
    }

    public void setValeur(int vr)
    {
        valeur = vr;
    }

    public int getAncVal()
    {
        return anc_val;
    }

    public void setAncVal(int v)
    {
        anc_val = v;
    }

    public static void setNbSommet(int ns)
    {
        NombreSommet = ns;
    }

    public static int getNbSommet()
    {
        return NombreSommet;
    }

    public void setLocationX(int s)
    {
        x = s;
    }

    public void setLocationY(int s)
    {
        y = s;
    }

    public int getLocationX()
    {
        return x;
    }

    public int getLocationY()
    {
        return y;
    }

    public String getLabelS()
    {
        return label;
    }

    public void setLabelS(String s)
    {
        label = s;
    }

    public boolean EspaceReserve(int xm, int ym)
    {
        return xm <= x + ic.getIconWidth() && xm >= x && ym <= y + ic.getIconHeight() && ym >= y;
    }

    public void paint(Graphics g)
    {
        g.drawImage(getToolkit().getImage(imageURL), 0, 0, null);
        g.setFont(new Font("Arial", 1, 15));
        if(isMarque())
            g.setColor(Color.red);
        else
            g.setColor(Color.white);
        if(label.length() == 1)
            g.drawString(label, 10, 20);
        else
        if(label.length() == 2)
            g.drawString(label, 6, 20);
        else
            g.drawString(label, 0, 20);
    }

    private URL imageURL;
    Icon ic;
    private String label;
    private int valeur;
    private int anc_val;
    private int x;
    private int y;
    private int NbFils;
    private boolean marque;
    private static int NombreSommet;
    public static final int INFINI = 50000;
}