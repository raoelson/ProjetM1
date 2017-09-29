package ro.chop;

import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.net.URL;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;


/**
 * 
 
 *
 */
@SuppressWarnings("serial")
public class Chop__PanelDemoucron extends JPanel
{
    class MyRenderer extends DefaultTableCellRenderer
    {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if(row == 0 && column == 0)
                cell.setBackground(Color.BLACK);
            else
            if(row == 0)
            {
                cell.setBackground(Color.BLUE);
                cell.setForeground(Color.white);
            } else
            if(column == 0)
            {
                cell.setBackground(Color.BLUE);
                cell.setForeground(Color.white);
            } else
            if(value != null)
            {
                if(!value.toString().equals("0"))
                {
                    cell.setBackground(Color.LIGHT_GRAY);
                    cell.setForeground(Color.red);
                } else
                {
                    cell.setBackground(Color.white);
                    cell.setForeground(Color.BLACK);
                }
            } else
            {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            if(isSelected)
                cell.setBackground(Color.yellow);
            return cell;
        }

        final Chop__PanelDemoucron this$0;

        MyRenderer()
        {
            this$0 = Chop__PanelDemoucron.this;
            //super();
        }
    }


    public Chop__PanelDemoucron()
    {
        jButton1 = new JButton();
        tableDemoucron = new DefaultTableModel();
        ce = new Chop__CheminElementaire[200];
        s = new Chop__Sommet[200];
        jButton2 = new JButton();
        prec = new JButton();
        suiv = new JButton();
        info = new JLabel();
        position = 0;
        mit = true;
        down = getClass().getResource("/images/down.png");
        icdown = new ImageIcon(Toolkit.getDefaultToolkit().getImage(down));
        up = getClass().getResource("/images/up.png");
        icup = new ImageIcon(Toolkit.getDefaultToolkit().getImage(up));
        baky = getClass().getResource("/images/previous.png");
        icback = new ImageIcon(Toolkit.getDefaultToolkit().getImage(baky));
        nexta = getClass().getResource("/images/next.png");
        icnext = new ImageIcon(Toolkit.getDefaultToolkit().getImage(nexta));
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("rawtypes")
	public Chop__PanelDemoucron(Chop__CheminElementaire p0[], Chop__Sommet p1[], Chop__PanelDeDessin p2, DefaultListModel p3, JList j)
    {
        jButton1 = new JButton();
        tableDemoucron = new DefaultTableModel();
        ce = new Chop__CheminElementaire[200];
        s = new Chop__Sommet[200];
        jButton2 = new JButton();
        prec = new JButton();
        suiv = new JButton();
        info = new JLabel();
        position = 0;
        mit = true;
        down = getClass().getResource("/images/down.png");
        icdown = new ImageIcon(Toolkit.getDefaultToolkit().getImage(down));
        up = getClass().getResource("/images/up.png");
        icup = new ImageIcon(Toolkit.getDefaultToolkit().getImage(up));
        baky = getClass().getResource("/images/previous.png");
        icback = new ImageIcon(Toolkit.getDefaultToolkit().getImage(baky));
        nexta = getClass().getResource("/images/next.png");
        icnext = new ImageIcon(Toolkit.getDefaultToolkit().getImage(nexta));
        ce = p0;
        s = p1;
        dessin = p2;
        mlist = p3;
        jl = j;
        tableDemoucron.setRowCount(Chop__Sommet.getNbSommet() + 1);
        tableDemoucron.setColumnCount(Chop__Sommet.getNbSommet() + 1);
        jTable1 = new JTable(tableDemoucron);
        jTable1.setTableHeader(null);
        jTable1.setEnabled(true);
        jTable1.setCellSelectionEnabled(true);
      //  jTable1.setDefaultRenderer(java/lang/Object , new MyRenderer();
        jScrollPane1 = new JScrollPane();
        mat = new int[Chop__Sommet.getNbSommet() - 1][Chop__Sommet.getNbSommet()][Chop__Sommet.getNbSommet()];
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
        setLayout(null);
        setSize(new Dimension(642, 367));
        prec.setText("Pr\351c\351dent");
        prec.setBounds(new Rectangle(30, 150, 150, 50));
        prec.setEnabled(false);
        prec.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                switcheo("prec");
            }
            @SuppressWarnings("unused")
			final Chop__PanelDemoucron this$0;
            {
                this$0 = Chop__PanelDemoucron.this;
            }
        }
);
        prec.setIcon(icback);
        suiv.setText("Suivant");
        suiv.setBounds(new Rectangle(300, 150, 150, 50));
        suiv.setEnabled(false);
        suiv.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                switcheo("suiv");
            }
            @SuppressWarnings("unused")
			final Chop__PanelDemoucron this$0;
            {
                this$0 = Chop__PanelDemoucron.this;
            }
        }
);
        suiv.setIcon(icnext);
        jButton1.setBackground(Color.gray);
        jButton1.setText("Minimal");
        jButton1.setForeground(Color.white);
        info.setText("k = 1");
        info.setBounds(new Rectangle(220, 155, 60, 40));
        jButton1.setBounds(new Rectangle(505, 10, 125, 55));
        jButton1.setIcon(icup);
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                mit = true;
                mlist.removeAllElements();
                exec_actionPerformed(e);
            }
            @SuppressWarnings("unused")
			final Chop__PanelDemoucron this$0;
            {
                this$0 = Chop__PanelDemoucron.this;
            }
        }
);
        jButton2.setBackground(Color.gray);
        jButton2.setText("Maximal");
        jButton2.setForeground(Color.white);
        jButton2.setBounds(new Rectangle(505, 85, 125, 55));
        jButton2.addActionListener(new ActionListener() {

            @SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e)
            {
                mit = false;
                mlist.removeAllElements();
                Chop__PanelKobe pr1 = new Chop__PanelKobe(ce, dessin, mlist);
                String f = findDebut();
                pr1.setDebut(f);
                f = findFin();
                pr1.setFin(f);
                pr1.testCircuit();
                if(pr1.isCircuit())
                {
                    JOptionPane jop = new JOptionPane();
                    JOptionPane _tmp = jop;
                    JOptionPane.showMessageDialog(null, "Ce graphe contient un circuit et ne peut pas \352tre maximis\351.", "Exception", 0);
                } else
                {
                    System.out.println("Maximisation!");
                    f = findDebut();
                    pr1.setDebut(f);
                    f = findFin();
                    pr1.setFin(f);
                    pr1.maximiserAlgoHafa();
                    maximiser_actionPerformed(e);
                }
            }
            @SuppressWarnings("unused")
			final Chop__PanelDemoucron this$0;
            {
                this$0 = Chop__PanelDemoucron.this;
            }
        }
);
        jButton2.setIcon(icdown);
        jScrollPane1.setBounds(new Rectangle(1, 1, 475, 150));
        jScrollPane1.getViewport().add(jTable1, null);
        jTable1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e)
            {
                System.out.println((new StringBuilder()).append("Debut : ").append(tableDemoucron.getValueAt(jTable1.getSelectedRow(), 0).toString()).toString());
                System.out.println((new StringBuilder()).append("Fin : ").append(tableDemoucron.getValueAt(0, jTable1.getSelectedColumn()).toString()).toString());
                if(!tableDemoucron.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString().equals(""))
                {
                    Chop__PanelKobe pr1 = new Chop__PanelKobe(ce, dessin, mlist);
                    String f = tableDemoucron.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    pr1.setDebut(f);
                    f = findFin();
                    String f1 = tableDemoucron.getValueAt(0, jTable1.getSelectedColumn()).toString();
                    pr1.setFin(f);
                    pr1.setDemou(f1, true);
                    if(mit)
                    {
                        pr1.minimiserAlgoDemoucron();
                        jl.setSelectedIndex(0);
                    } else
                    {
                        pr1.maximiserAlgoDemoucron();
                        jl.setSelectedIndex(0);
                    }
                }
            }

            @SuppressWarnings("unused")
			final Chop__PanelDemoucron this$0;
            {
                this$0 = Chop__PanelDemoucron.this;
            }
        }
);
        add(jScrollPane1, null);
        add(jButton2, null);
        add(jButton1, null);
        add(prec, null);
        add(suiv, null);
        add(info, null);
    }

    private void calculMatrice(int numSommet, boolean min)
    {
        int taloha = numSommet - 1;
        for(int m = 0; m < Chop__Sommet.getNbSommet(); m++)
        {
            for(int n = 0; n < Chop__Sommet.getNbSommet(); n++)
                mat[numSommet][m][n] = mat[taloha][m][n];

        }

        taloha = numSommet;
        for(int i = 0; i < Chop__Sommet.getNbSommet(); i++)
        {
            if((mat[taloha][i][numSommet] == 50000 || !min) && (mat[taloha][i][numSommet] == -50000 || min))
                continue;
            for(int j = 0; j < Chop__Sommet.getNbSommet(); j++)
            {
                if((mat[taloha][numSommet][j] == 50000 || !min) && (mat[taloha][numSommet][j] == -50000 || min))
                    continue;
                int val = mat[taloha][i][numSommet] + mat[taloha][numSommet][j];
                if(min && val < mat[taloha][i][j])
                    mat[numSommet][i][j] = val;
                if(!min && val > mat[taloha][i][j])
                    mat[numSommet][i][j] = val;
            }

        }

    }

    private void printMat(int k)
    {
        for(int i = 0; i < tableDemoucron.getRowCount(); i++)
        {
            for(int j = 0; j < tableDemoucron.getColumnCount(); j++)
                tableDemoucron.setValueAt(null, i, j);

        }

        for(int i = 1; i < Chop__Sommet.getNbSommet() + 1; i++)
            tableDemoucron.setValueAt(s[i - 1].getLabelS(), 0, i);

        for(int i = 1; i < Chop__Sommet.getNbSommet() + 1; i++)
        {
            tableDemoucron.setValueAt(s[i - 1].getLabelS(), i, 0);
            for(int j = 1; j < Chop__Sommet.getNbSommet() + 1; j++)
                if(mat[k][i - 1][j - 1] != 50000 && mat[k][i - 1][j - 1] != -50000 && i - 1 != j - 1)
                    tableDemoucron.setValueAt(Integer.valueOf(mat[k][i - 1][j - 1]), i, j);

        }

    }

    private void init(boolean min)
    {
        for(int i = 0; i < Chop__Sommet.getNbSommet(); i++)
        {
            for(int j = 0; j < Chop__Sommet.getNbSommet(); j++)
            {
                if(isArc(s[i].getLabelS(), s[j].getLabelS()))
                {
                    mat[0][i][j] = chercheArc(s[i].getLabelS(), s[j].getLabelS()).getLongueur();
                    continue;
                }
                if(min)
                    mat[0][i][j] = 50000;
                else
                    mat[0][i][j] = -50000;
            }

        }

    }

    private Chop__CheminElementaire chercheArc(String o, String e)
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            if(ce[i].getOrg().getLabelS().compareTo(o) == 0 && ce[i].getExt().getLabelS().compareTo(e) == 0)
                return ce[i];

        return null;
    }

    boolean isArc(String or, String ex)
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            if(ce[i].getOrg().getLabelS().equals(or) && ce[i].getExt().getLabelS().equals(ex))
                return true;

        return false;
    }

    private void exec_actionPerformed(ActionEvent e)
    {
        e.getID();
        init(true);
        printMat(0);
        for(int i = 1; i < Chop__Sommet.getNbSommet() - 1; i++)
            calculMatrice(i, true);

        tableDemoucron.setValueAt("", 0, 0);
        suiv.setEnabled(true);
        prec.setEnabled(false);
        position = 0;
        info.setText("k = 1");
    }

    private void switcheo(String p)
    {
        if(p.equals("suiv") && position < Chop__Sommet.getNbSommet() - 2)
        {
            position++;
            prec.setEnabled(true);
            printMat(position);
            if(position == Chop__Sommet.getNbSommet() - 2)
                suiv.setEnabled(false);
        }
        if(p.equals("prec") && position > 0)
        {
            position--;
            suiv.setEnabled(true);
            printMat(position);
            if(position == 0)
                prec.setEnabled(false);
        }
        info.setText((new StringBuilder()).append("k = ").append(position + 1).toString());
    }

    private void maximiser_actionPerformed(ActionEvent e)
    {
        e.getID();
        init(false);
        printMat(0);
        for(int i = 1; i < Chop__Sommet.getNbSommet() - 1; i++)
            calculMatrice(i, false);

        tableDemoucron.setValueAt("", 0, 0);
        suiv.setEnabled(true);
        prec.setEnabled(false);
        position = 0;
        info.setText("k = 1");
    }

    private String findFin()
    {
        boolean stop = false;
        boolean nahita = false;
        int i = 0;
        int j = 0;
        int indice = 0;
        for(int NbArc = Chop__CheminElementaire.getNombreArc(); i < NbArc && !stop;)
        {
            nahita = false;
            for(j = 0; j < NbArc && !nahita; j++)
                if(ce[i].getExt().getLabelS().compareTo(ce[j].getOrg().getLabelS()) == 0)
                    nahita = true;

            if(nahita)
            {
                i++;
            } else
            {
                indice = i;
                return ce[indice].getExt().getLabelS();
            }
        }

        return "NONE";
    }

    private String findDebut()
    {
        boolean stop = false;
        int i = 0;
        int indice = 0;
        for(int NbArc = Chop__CheminElementaire.getNombreArc(); i < NbArc && !stop;)
        {
            boolean nahita = false;
            for(int j = 0; j < NbArc && !nahita; j++)
                if(ce[i].getOrg().getLabelS().compareTo(ce[j].getExt().getLabelS()) == 0)
                    nahita = true;

            if(nahita)
            {
                i++;
            } else
            {
                indice = i;
                return ce[indice].getOrg().getLabelS();
            }
        }

        return "NONE";
    }

    private JButton 				jButton1;
    private int 					mat[][][];
    private DefaultTableModel 		tableDemoucron;
    private Chop__PanelDeDessin 	dessin;
    private Chop__CheminElementaire	ce[];
    private Chop__Sommet s[];
    private JButton 				jButton2;
    private JScrollPane 			jScrollPane1;
    private JTable 					jTable1;
    @SuppressWarnings("rawtypes")
	private DefaultListModel 		mlist;
    private JButton 				prec;
    private JButton 				suiv;
    private JLabel 					info;
    private int 					position;
    private boolean 				mit;
    @SuppressWarnings("rawtypes")
	private JList 					jl;
    private URL 					down;
    Icon 							icdown;
    private URL 					up;
    Icon 							icup;
    private URL 					baky;
    Icon 							icback;
    private URL 					nexta;
    Icon 							icnext;
}