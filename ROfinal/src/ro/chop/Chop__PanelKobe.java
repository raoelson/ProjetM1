package ro.chop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 * 

 *
 */
@SuppressWarnings("serial")
public class Chop__PanelKobe extends JPanel implements Runnable
{

    public Chop__PanelKobe()
    {
        ce = new Chop__CheminElementaire[200];
        Branche = new Chop__CheminElementaire[2000][200];
        len = new int[2000];
        efanandalo = false;
        traitemin = true;
        leglobal = false;
        down = getClass().getResource("/images/down.png");
        icdown = new ImageIcon(Toolkit.getDefaultToolkit().getImage(down));
        up = getClass().getResource("/images/up.png");
        icup = new ImageIcon(Toolkit.getDefaultToolkit().getImage(up));
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Chop__PanelKobe(boolean b)
    {
        super(b);
        ce = new Chop__CheminElementaire[200];
        Branche = new Chop__CheminElementaire[2000][200];
        len = new int[2000];
        efanandalo = false;
        traitemin = true;
        leglobal = false;
        down = getClass().getResource("/images/down.png");
        icdown = new ImageIcon(Toolkit.getDefaultToolkit().getImage(down));
        up = getClass().getResource("/images/up.png");
        icup = new ImageIcon(Toolkit.getDefaultToolkit().getImage(up));
    }

    public Chop__PanelKobe(LayoutManager layoutManager)
    {
        super(layoutManager);
        ce = new Chop__CheminElementaire[200];
        Branche = new Chop__CheminElementaire[2000][200];
        len = new int[2000];
        efanandalo = false;
        traitemin = true;
        leglobal = false;
        down = getClass().getResource("/images/down.png");
        icdown = new ImageIcon(Toolkit.getDefaultToolkit().getImage(down));
        up = getClass().getResource("/images/up.png");
        icup = new ImageIcon(Toolkit.getDefaultToolkit().getImage(up));
    }

    public Chop__PanelKobe(LayoutManager layoutManager, boolean b)
    {
        super(layoutManager, b);
        ce = new Chop__CheminElementaire[200];
        Branche = new Chop__CheminElementaire[2000][200];
        len = new int[2000];
        efanandalo = false;
        traitemin = true;
        leglobal = false;
        down = getClass().getResource("/images/down.png");
        icdown = new ImageIcon(Toolkit.getDefaultToolkit().getImage(down));
        up = getClass().getResource("/images/up.png");
        icup = new ImageIcon(Toolkit.getDefaultToolkit().getImage(up));
    }

    @SuppressWarnings("rawtypes")
	public Chop__PanelKobe(Chop__CheminElementaire c[], Chop__PanelDeDessin d, DefaultListModel m)
    {
        ce = new Chop__CheminElementaire[200];
        Branche = new Chop__CheminElementaire[2000][200];
        len = new int[2000];
        efanandalo = false;
        traitemin = true;
        leglobal = false;
        down = getClass().getResource("/images/down.png");
        icdown = new ImageIcon(Toolkit.getDefaultToolkit().getImage(down));
        up = getClass().getResource("/images/up.png");
        icup = new ImageIcon(Toolkit.getDefaultToolkit().getImage(up));
        ce = c;
        dessin = d;
        mlist = m;
        demoucron = false;
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            System.out.println((new StringBuilder()).append(i).append(" : ").append(ce[i].getOrg().getLabelS()).append(", ").append(ce[i].getExt().getLabelS()).append(", ").append(ce[i].getLongueur()).toString());

        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void jbInit()
        throws Exception
    {
        setSize(new Dimension(674, 504));
        setLayout(null);
        if(jTree1 == null)
        {
            racine = new DefaultMutableTreeNode("Debut");
            jTree1 = new JTree(racine);
        }
        
        b1 = new JButton("Minimal");
        b1.setBackground(Color.gray);
        b1.setForeground(Color.white);
        b1.setBounds(new Rectangle(520, 20, 125, 55));
        b1.setIcon(icdown);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0)
            {
                System.out.println("Debut minimisation:");
                for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
                    ce[i].setMin(false);

                mlist.removeAllElements();
                traitement();
                dessineBranche(racine0);
                traitemin = true;
                start();
                stop();
            }
            @SuppressWarnings("unused")
			final Chop__PanelKobe this$0;
            {
                this$0 = Chop__PanelKobe.this;
            }
        }
);
        b2 = new JButton("Maximal");
        b2.setBackground(Color.gray);
        b2.setForeground(Color.white);
        b2.setBounds(new Rectangle(520, 135, 125, 55));
        b2.setIcon(icup);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0)
            {
                System.out.println("Debut maximisation:");
                for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
                    ce[i].setMin(false);

                mlist.removeAllElements();
                traitement();
                dessineBranche(racine0);
                traitemin = false;
                start();
                stop();
            }
            @SuppressWarnings("unused")
			final Chop__PanelKobe this$0;
            {
                this$0 = Chop__PanelKobe.this;
            }
        }
);
        jTree1.setBounds(new Rectangle(60, 25, 330, 215));
        jsp = new JScrollPane(jTree1);
        jsp.setBounds(new Rectangle(5, 5, 500, 195));
        add(jsp, null);
        add(b1, null);
        add(b2, null);
    }

    private void dessineBranche(DefaultMutableTreeNode a)
    {
        if(!efanandalo)
            racine.add(a);
        efanandalo = true;
    }

    public void start()
    {
        if(runeo == null)
        {
            runeo = new Thread(this);
            runeo.start();
        } else
        {
            runeo.run();
        }
    }

    public void stop()
    {
        if(runeo != null)
        {
            runeo.interrupt();
            runeo = null;
        }
    }

    public void setDebut(String a)
    {
        Debut = chercheSommet(a);
    }

    public Chop__Sommet getDebut()
    {
        return Debut;
    }

    public Chop__Sommet getFin()
    {
        return Fin;
    }

    public void setFin(String f)
    {
        Fin = chercheSommet(f);
    }

    public Chop__Sommet chercheSommet(String st)
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
        {
            if(ce[i].getOrg().getLabelS().compareTo(st) == 0)
                return ce[i].getOrg();
            if(ce[i].getExt().getLabelS().compareTo(st) == 0)
                return ce[i].getExt();
        }

        return null;
    }

    private int lamdaS(int indi, int limite)
    {
        int sum = 0;
        for(int i = 0; i <= limite; i++)
            sum += Branche[indi][i].getLongueur();

        return sum;
    }

    private Chop__Sommet getFils(String w)
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            if(ce[i].getOrg().getLabelS().compareTo(w) == 0 && !ce[i].getTraite())
                return ce[i].getExt();

        return null;
    }

    private Chop__CheminElementaire getArc(Chop__Sommet wo, Chop__Sommet we)
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            if(ce[i].getOrg() == wo && ce[i].getExt() == we)
                return new Chop__CheminElementaire(wo, we, ce[i].getLongueur());

        return null;
    }

    private void mbolaMisy(Chop__CheminElementaire a[][], Chop__Sommet deb, int ind, int niv, DefaultMutableTreeNode nd)
    {
        int j = niv;
        Chop__Sommet temp = deb;
        DefaultMutableTreeNode nodtmp = nd;
        DefaultMutableTreeNode ndfils = nd;
        do
        {
            if(temp == Fin || temp == null)
                break;
            if(getFils(temp.getLabelS()) != null)
            {
                nodtmp = ndfils;
                a[ind][j] = getArc(temp, getFils(temp.getLabelS()));
                ndfils = new DefaultMutableTreeNode((new StringBuilder()).append(a[ind][j].getExt().getLabelS()).append(" : ").append(lamdaS(ind, j)).toString());
                nodtmp.add(ndfils);
                System.out.print((new StringBuilder()).append(a[ind][j].getOrg().getLabelS()).append("-").toString());
                int z = 0;
                boolean yauncircuit;
                for(yauncircuit = false; z < j && !yauncircuit; z++)
                    if(a[ind][z].getOrg().getLabelS().equals(a[ind][j].getExt().getLabelS()))
                    {
                        System.out.print("!");
                        yauncircuit = true;
                        leglobal = yauncircuit;
                    }

                if(yauncircuit)
                    temp = null;
                else
                if(demoucron && (getFils(temp.getLabelS()).equals(Fin) || getFils(temp.getLabelS()).getLabelS().equals(FinDemoucron)))
                    temp = null;
                else
                    temp = getFils(temp.getLabelS());
                j++;
            }
        } while(true);
        racine1 = nodtmp;
        int somme = 0;
        len[ind] = j;
        for(int d = 0; d < len[ind]; d++)
            somme += a[ind][d].getLongueur();

        System.out.println((new StringBuilder()).append(a[ind][j - 1].getExt().getLabelS()).append(" : ").append(len[ind]).append(" : ").append(somme).toString());
    }

    private int minimum()
    {
        int min = 0;
        int minSom = 0xf4240;
        for(int i = 0; i < NbBranche; i++)
        {
            if(!Branche[i][len[i] - 1].getExt().getLabelS().equals(Fin.getLabelS()))
                continue;
            int somme = 0;
            for(int d = 0; d < len[i]; d++)
                somme += Branche[i][d].getLongueur();

            if(somme < minSom)
            {
                min = i;
                minSom = somme;
            }
        }

        return min;
    }

    private int minimumDemoucron()
    {
        int min = 0;
        int minSom = 0xf4240;
        for(int i = 0; i < NbBranche; i++)
        {
            if(!Branche[i][len[i] - 1].getExt().getLabelS().equals(FinDemoucron))
                continue;
            int somme = 0;
            for(int d = 0; d < len[i]; d++)
                somme += Branche[i][d].getLongueur();

            if(somme < minSom)
            {
                min = i;
                minSom = somme;
            }
        }

        return min;
    }

    @SuppressWarnings("unchecked")
	private void autresMin(int min)
    {
        int somMin = 0;
        int indexList = 0;
        String apiana = "";
        for(int d = 0; d < len[min]; d++)
        {
            somMin += Branche[min][d].getLongueur();
            apiana = (new StringBuilder()).append(apiana).append(Branche[min][d].getOrg().getLabelS()).append("->").toString();
        }

        apiana = (new StringBuilder()).append(apiana).append(Branche[min][len[min] - 1].getExt().getLabelS()).toString();
        mlist.add(indexList++, apiana);
        for(int i = 0; i < NbBranche; i++)
        {
            if(!Branche[i][len[i] - 1].getExt().getLabelS().equals(Fin.getLabelS()) || i == min)
                continue;
            int somme = 0;
            apiana = "";
            for(int d = 0; d < len[i]; d++)
            {
                somme += Branche[i][d].getLongueur();
                apiana = (new StringBuilder()).append(apiana).append(Branche[i][d].getOrg().getLabelS()).append("->").toString();
            }

            apiana = (new StringBuilder()).append(apiana).append(Branche[i][len[i] - 1].getExt().getLabelS()).toString();
            if(somme == somMin)
                mlist.add(indexList++, apiana);
        }

    }

    @SuppressWarnings("unchecked")
	private void autresMinDemoucron(int min)
    {
        int somMin = 0;
        int indexList = 0;
        String apiana = "";
        for(int d = 0; d < len[min]; d++)
        {
            somMin += Branche[min][d].getLongueur();
            apiana = (new StringBuilder()).append(apiana).append(Branche[min][d].getOrg().getLabelS()).append("->").toString();
        }

        apiana = (new StringBuilder()).append(apiana).append(Branche[min][len[min] - 1].getExt().getLabelS()).toString();
        mlist.add(indexList++, apiana);
        for(int i = 0; i < NbBranche; i++)
        {
            if(!Branche[i][len[i] - 1].getExt().getLabelS().equals(FinDemoucron) || i == min)
                continue;
            int somme = 0;
            apiana = "";
            for(int d = 0; d < len[i]; d++)
            {
                somme += Branche[i][d].getLongueur();
                apiana = (new StringBuilder()).append(apiana).append(Branche[i][d].getOrg().getLabelS()).append("->").toString();
            }

            apiana = (new StringBuilder()).append(apiana).append(Branche[i][len[i] - 1].getExt().getLabelS()).toString();
            if(somme == somMin)
                mlist.add(indexList++, apiana);
        }

    }

    @SuppressWarnings("unchecked")
	private void autresMax(int max)
    {
        int somMax = 0;
        int indexList = 0;
        String apiana = "";
        for(int d = 0; d < len[max]; d++)
        {
            somMax += Branche[max][d].getLongueur();
            apiana = (new StringBuilder()).append(apiana).append(Branche[max][d].getOrg().getLabelS()).append("->").toString();
        }

        apiana = (new StringBuilder()).append(apiana).append(Branche[max][len[max] - 1].getExt().getLabelS()).toString();
        mlist.add(indexList++, apiana);
        for(int i = 0; i < NbBranche; i++)
        {
            if(!Branche[i][len[i] - 1].getExt().getLabelS().equals(Fin.getLabelS()) || i == max)
                continue;
            int somme = 0;
            apiana = "";
            for(int d = 0; d < len[i]; d++)
            {
                somme += Branche[i][d].getLongueur();
                apiana = (new StringBuilder()).append(apiana).append(Branche[i][d].getOrg().getLabelS()).append("->").toString();
            }

            apiana = (new StringBuilder()).append(apiana).append(Branche[i][len[i] - 1].getExt().getLabelS()).toString();
            if(somme == somMax)
                mlist.add(indexList++, apiana);
        }

    }

    @SuppressWarnings("unchecked")
	private void autresMaxDemoucron(int max)
    {
        int somMax = 0;
        int indexList = 0;
        String apiana = "";
        for(int d = 0; d < len[max]; d++)
        {
            somMax += Branche[max][d].getLongueur();
            apiana = (new StringBuilder()).append(apiana).append(Branche[max][d].getOrg().getLabelS()).append("->").toString();
        }

        apiana = (new StringBuilder()).append(apiana).append(Branche[max][len[max] - 1].getExt().getLabelS()).toString();
        mlist.add(indexList++, apiana);
        for(int i = 0; i < NbBranche; i++)
        {
            if(!Branche[i][len[i] - 1].getExt().getLabelS().equals(FinDemoucron) || i == max)
                continue;
            int somme = 0;
            apiana = "";
            for(int d = 0; d < len[i]; d++)
            {
                somme += Branche[i][d].getLongueur();
                apiana = (new StringBuilder()).append(apiana).append(Branche[i][d].getOrg().getLabelS()).append("->").toString();
            }

            apiana = (new StringBuilder()).append(apiana).append(Branche[i][len[i] - 1].getExt().getLabelS()).toString();
            if(somme == somMax)
                mlist.add(indexList++, apiana);
        }

    }

    private int maximum()
    {
        int max = 0;
        int maxSom = 0;
        for(int i = 0; i < NbBranche; i++)
        {
            if(!Branche[i][len[i] - 1].getExt().getLabelS().equals(Fin.getLabelS()))
                continue;
            int somme = 0;
            for(int d = 0; d < len[i]; d++)
                somme += Branche[i][d].getLongueur();

            if(somme > maxSom)
            {
                max = i;
                maxSom = somme;
            }
        }

        return max;
    }

    private int maximumDemoucron()
    {
        int max = 0;
        int maxSom = 0;
        for(int i = 0; i < NbBranche; i++)
        {
            if(!Branche[i][len[i] - 1].getExt().getLabelS().equals(FinDemoucron))
                continue;
            int somme = 0;
            for(int d = 0; d < len[i]; d++)
                somme += Branche[i][d].getLongueur();

            if(somme > maxSom)
            {
                max = i;
                maxSom = somme;
            }
        }

        return max;
    }

    public void traitement()
    {
        racine0 = new DefaultMutableTreeNode((new StringBuilder()).append(getDebut().getLabelS()).append(" : ").append(lamdaS(0, -1)).toString());
        mbolaMisy(Branche, getDebut(), 0, 0, racine0);
        niveau = len[0] - 1;
        int indice = 0;
        while(niveau >= 0) 
        {
            chercheArc(Branche[indice][niveau].getOrg().getLabelS(), Branche[indice][niveau].getExt().getLabelS()).setTraite(true);
            if(getFils(Branche[indice][niveau].getOrg().getLabelS()) != null)
            {
                indice++;
                copieRacine(Branche, indice, niveau);
                mbolaMisy(Branche, Branche[indice][niveau].getOrg(), indice, niveau, racine1);
                niveau = len[indice] - 1;
            } else
            {
                racine1 = (DefaultMutableTreeNode)racine1.getParent();
                reUseFils(Branche[indice][niveau].getOrg().getLabelS());
                niveau--;
            }
        }
        NbBranche = indice + 1;
    }

    private void copieRacine(Chop__CheminElementaire a[][], int ind, int niv)
    {
        for(int i = 0; i <= niv; i++)
        {
            a[ind][i] = a[ind - 1][i];
            if(i != niv)
                System.out.print((new StringBuilder()).append(a[ind][i].getOrg().getLabelS()).append("-").toString());
        }

    }

    private void reUseFils(String s)
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            if(ce[i].getOrg().getLabelS().compareTo(s) == 0)
                ce[i].setTraite(false);

    }

    @SuppressWarnings("unused")
	private void affiche(int lgr)
    {
        for(int i = 0; i < lgr; i++)
        {
            for(int j = 0; j < len[i]; j++)
                System.out.println((new StringBuilder()).append("Branche[").append(i).append("][").append(j).append("] = (").append(Branche[i][j].getOrg().getLabelS()).append(",").append(Branche[i][j].getExt().getLabelS()).append(",").append(Branche[i][j].getLongueur()).append(")").toString());

        }

    }

    private Chop__CheminElementaire chercheArc(String o, String e)
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            if(ce[i].getOrg().getLabelS().compareTo(o) == 0 && ce[i].getExt().getLabelS().compareTo(e) == 0)
                return ce[i];

        return null;
    }

    private void minimizedGraph()
    {
        int min = minimum();
        autresMin(min);
        System.out.println((new StringBuilder()).append("Min:").append(min).toString());
        for(int i = 0; i < len[min]; i++)
        {
            try
            {
                Thread.sleep(500L);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            chercheArc(Branche[min][i].getOrg().getLabelS(), Branche[min][i].getExt().getLabelS()).setMin(true);
            dessin.repaint();
        }

        stop();
    }

    private void maximizedGraph()
    {
        int max = maximum();
        autresMax(max);
        System.out.println((new StringBuilder()).append("Max:").append(max).toString());
        for(int i = 0; i < len[max]; i++)
        {
            chercheArc(Branche[max][i].getOrg().getLabelS(), Branche[max][i].getExt().getLabelS()).setMin(true);
            try
            {
                Thread.sleep(500L);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            dessin.repaint();
        }

    }

    public void run()
    {
        if(traitemin)
            minimizedGraph();
        else
            maximizedGraph();
    }

    public void minimiserAlgoHafa()
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            ce[i].setMin(false);

        mlist.removeAllElements();
        traitement();
        int min = minimum();
        autresMin(min);
    }

    public void minimiserAlgoDemoucron()
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            ce[i].setMin(false);

        mlist.removeAllElements();
        traitement();
        int min = minimumDemoucron();
        autresMinDemoucron(min);
    }

    public void maximiserAlgoHafa()
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            ce[i].setMin(false);

        mlist.removeAllElements();
        traitement();
        int max = maximum();
        autresMin(max);
    }

    public void testCircuit()
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            ce[i].setMin(false);

        mlist.removeAllElements();
        traitement();
    }

    public boolean isCircuit()
    {
        return leglobal;
    }

    public void maximiserAlgoDemoucron()
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            ce[i].setMin(false);

        mlist.removeAllElements();
        traitement();
        int max = maximumDemoucron();
        autresMaxDemoucron(max);
    }

    public void setDemou(String f, boolean d)
    {
        demoucron = d;
        FinDemoucron = f;
    }

    private Chop__CheminElementaire ce[];
    private Chop__PanelDeDessin 	dessin;
    private JTree 					jTree1;
    private JButton 				b1;
    private JButton 				b2;
    private JScrollPane 			jsp;
    private Chop__Sommet 			Debut;
    private Chop__Sommet 			Fin;
    private Chop__CheminElementaire Branche[][];
    int len[];
    DefaultMutableTreeNode 			racine;
    DefaultMutableTreeNode 			racine0;
    DefaultMutableTreeNode 			racine1;
    private int 					NbBranche;
    private boolean 				efanandalo;
    private boolean 				traitemin;
    Thread 							runeo;
    private int 					niveau;
    @SuppressWarnings("rawtypes")
	DefaultListModel 				mlist;
    private boolean 				demoucron;
    private String 					FinDemoucron;
    private boolean 				leglobal;
    private URL 					down;
    Icon 							icdown;
    private URL 					up;
    Icon 							icup;
}