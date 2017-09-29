package ro.chop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 * 

 *
 */
@SuppressWarnings("serial")
public class Chop__Fenetre extends JFrame
    implements Runnable
{

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Chop__Fenetre()
    {
        //menu
        jPopupMenu1 = new JPopupMenu();
        //contenu du menu
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jMenuItem4 = new JMenuItem();
        jMenuItem5 = new JMenuItem();
        jMenuItem6 = new JMenuItem();
//*****************************************************************************************
        jTabbedPane1 = new JTabbedPane();
        //menubar et conntenu
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        jMenuItem8 = new JMenuItem();
        jMenuItem9 = new JMenuItem();
        //jMenu3 = new JMenu();
        jMenuItem7 = new JMenuItem();
        jMenuItem10 = new JMenuItem();
        jMenuItem11 = new JMenuItem();
//******************************************************************************************
        //imgURL = getClass().getResource("/images/fond.png");
        imgURL = getClass().getResource("/images/fond.png");
        imgURL2 = getClass().getResource("/images/read-success.png");
    //panel de dessin
        jPanel1 = new Chop__PanelDeDessin(Toolkit.getDefaultToolkit().getImage(imgURL));
//******************************************************************************************
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jTabbedPane2 = new JTabbedPane();
        jPanel3 = new JPanel();
        modelTable = new DefaultTableModel();
        jTable1 = new JTable(modelTable);
        jMenuItem12 = new JMenuItem();
        jMenuItem13 = new JMenuItem();
        jMenuItem14 = new JMenuItem();
        jMenuItem15 = new JMenuItem();
        jMenuItem16 = new JMenuItem();
        jButton1 = new JButton();
        jMenuItem17 = new JMenuItem();
        jSeparator1 = new JSeparator();
        jPanel4 = new JPanel();
        jLabel2 = new JLabel();
        jComboBox1 = new JComboBox();
        mlist = new DefaultListModel();
        jList1 = new JList(mlist);
        jScrollPane1 = new JScrollPane();
        imgFermer = getClass().getResource("/images/idio.png");
        fer = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imgFermer));
        fermer = new Chop__IconClosable(fer);
        jLabel3 = new JLabel();
        goi = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imgURL2));
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
	private void jbInit()
        throws Exception
    {
        getContentPane().setLayout(null);
        setSize(new Dimension(993, 711));
        setTitle("Mini-projet R.O: GB, SR : Demoucron");
        setJMenuBar(jMenuBar1);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/images/go.png")).getImage());
        getContentPane().setBackground(Color.white);
        jList1.addListSelectionListener(new ListSelectionListener() {

            @SuppressWarnings("rawtypes")
            @Override
			public void valueChanged(ListSelectionEvent e)
            {
                if(((JList)e.getSource()).getSelectedIndex() != -1)
                {
                    int d = ((JList)e.getSource()).getSelectedIndex();
                    DefaultListModel lm = (DefaultListModel)((JList)e.getSource()).getModel();
                    System.out.println((new StringBuilder()).append("selected:").append(d).toString());
                    System.out.println((new StringBuilder()).append("Object:").append(lm.getElementAt(d)).toString());
                    String so = lm.getElementAt(d).toString();
                    som = so.split("->");
                    for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
                        ce[i].setMin(false);

                    start();
                    stop();
                }
            }
            @SuppressWarnings("unused")
			final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jPopupMenu1.setLabel("jPopupMenu1");
        jMenuItem1.setText("Nouveau chemin \351l\351mentaire...");
        jMenuItem1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                jMenuItem1_actionPerformed(e);
            }

            @SuppressWarnings("unused")
			final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem1.setMnemonic('c');
        jMenuItem1.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e)
            {
                menuNouveauChemin_mouseMoved(e);
            }
            @SuppressWarnings("unused")
			final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e)
            {
                menuNouveauChemin_mouseExited(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem2.setText("Relier en tant qu'origine");
        jMenuItem2.setMnemonic('o');
        jMenuItem2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                menuRelierOrigine_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e)
            {
                menuRelierOrigine_mouseExited(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem2.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e)
            {
                menuRelierOrigine_mouseMoved(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem3.setText("Relier en tant qu'extr\351mit\351");
        jMenuItem3.setMnemonic('e');
        jMenuItem3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menuRelierExtremite_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem3.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e)
            {
                menuRelierExtremite_mouseMoved(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e)
            {
                menuRelierExtremite_mouseExited(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem4.setText("Modifier le nom");
        jMenuItem4.setMnemonic('M');
        jMenuItem4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                jMenuItem4_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem4.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e)
            {
                menuModifier_mouseMoved(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem4.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e)
            {
                menuModifier_mouseExited(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem5.setText("Effacer");
        jMenuItem5.setMnemonic('f');
        jMenuItem5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menuEffacer_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem5.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e)
            {
                menuEffacer_mouseMoved(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem5.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e)
            {
                menuEffacer_mouseExited(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem6.setText("Nouveau sommet...");
        jMenuItem6.setMnemonic('s');
        jMenuItem6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                jMenuItem6_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem6.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent e)
            {
                jMenuItem6_focusGained(e);
            }

            public void focusLost(FocusEvent e)
            {
                jMenuItem6_focusLost(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem6.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e)
            {
                jMenuItem6_mouseMoved(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem6.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e)
            {
                jMenuItem6_mouseExited(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jTabbedPane1.setBounds(new Rectangle(30, 10, 925, 625));
        jMenu1.setText("");
        jMenu2.setText("");
        jMenuItem8.setText("");
        jMenuItem8.setMnemonic(112);
        jMenuItem8.setAccelerator(KeyStroke.getKeyStroke(112, 2));
        jMenuItem8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                aboutBoxmenu_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem9.setText("Quitter");
        jMenuItem9.setAccelerator(KeyStroke.getKeyStroke(81, 2));
        jMenuItem9.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menuQuitter_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            
            {
                this$0 = Chop__Fenetre.this;
            }
        }
              
); 
       
        jMenuItem11.setText("Algorithme de D\351moucron");
        jMenuItem11.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menunewDemoucron_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jPanel1.setLayout(null);
        jPanel1.setBackground(Color.gray);
        jPanel1.setBounds(new Rectangle(0, 0, 925, 335));
        jPanel1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e)
            {
                jPanel1_mouseClicked(e);
            }

            public void mousePressed(MouseEvent e)
            {
                jPanel1_mousePressed(e);
            }

            public void mouseReleased(MouseEvent e)
            {
                jPanel1_mouseReleased(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jPanel1.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e)
            {
                jPanel1_mouseMoved(e);
            }

            public void mouseDragged(MouseEvent e)
            {
                jPanel1_mouseDragged(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jPanel2.setLayout(null);
        jPanel2.setBackground(Color.white);
        
        jPopupMenu1.add(jMenuItem6);
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.addSeparator();
        jPopupMenu1.add(jMenuItem2);
        jPopupMenu1.add(jMenuItem3);
        jPopupMenu1.addSeparator();
        jPopupMenu1.add(jMenuItem4);
        jPopupMenu1.add(jMenuItem5);
        jPopupMenu1.addSeparator();
        jPopupMenu1.add(jMenuItem12);
        jPopupMenu1.add(jMenuItem13);
        //jMenu3.add(jMenuItem7);
        //jMenu3.add(jMenuItem10);
        //jMenu3.add(jMenuItem11);
        //jMenu3.add(jMenuItem17);
        //jMenu1.add(jMenu3);
        jMenu1.add(jMenuItem14);
        jMenu1.add(jMenuItem15);
        jMenu1.addSeparator();
        jMenu1.add(jMenuItem16);
        jMenu1.add(jMenuItem9);
        jMenuBar1.add(jMenu1);
        jMenu2.add(jMenuItem8);
        jMenuBar1.add(jMenu2);
        getContentPane().add(jLabel3, null);
        jLabel1.setForeground(Color.green);
        getContentPane().add(jLabel1, null);
        getContentPane().add(jTabbedPane1, null);
        JScrollPane jp = new JScrollPane(jTable1);
        jp.setBounds(10, 10, 315, 130);
        jPanel4.add(jComboBox1, null);
        jPanel4.add(jLabel2, null);
        jPanel4.add(jButton1, null);
        jPanel3.add(jPanel4, null);
        jPanel3.add(jSeparator1, null);
        jPanel3.add(jp, null);
        jScrollPane1.getViewport().add(jList1, null);
        jPanel2.add(jScrollPane1, null);
        jPanel2.add(jPanel1, null);
        jTabbedPane2.addTab("DONNEES", jPanel3);
        jPanel2.add(jTabbedPane2, null);
        jTabbedPane1.addTab("GRAPHE", jPanel2);
        getContentPane().add(jTabbedPane1, null);
        s = new Chop__Sommet[200];
        ce = new Chop__CheminElementaire[200];
        NumCe = 0;
        NumObj = 0;
        deplace = false;
        DoRelier = false;
        RelieOrg = true;
        dialogy = new Chop__NouveauChemin();
        //jLabel1.setText((new StringBuilder()).append("X : 0, Y : 0   |    Nombre de sommets : ").append(NumObj).append("   |    Nombre d'arcs : ").append(NumCe).toString());
        //jLabel1.setBounds(new Rectangle(20, 635, 520, 20));
        jTabbedPane2.setBounds(new Rectangle(5, 350, 650, 240));
        jPanel3.setLayout(null);
        jTable1.setBounds(new Rectangle(20, 10, 315, 130));
        jTable1.setEnabled(false);
        modelTable.addColumn("Num\351ro");
        modelTable.addColumn("Origine");
        modelTable.addColumn("Extr\351mit\351");
        modelTable.addColumn("Distance");
        jMenuItem12.setText("Modifier la longueur de cet arc");
        jMenuItem12.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menuModifLgr_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem12.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e)
            {
                menuModifLgr_mouseMoved(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem12.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e)
            {
                menuModifLgr_mouseExited(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;            
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem13.setText("Supprimer cet arc");
        jMenuItem13.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menuSupprArc_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;            
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem13.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e)
            {
                menuSupprArc_mouseMoved(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem13.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e)
            {
                menuSupprArc_mouseExited(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem14.setText("Ouvrir...");
        jMenuItem14.setMnemonic('O');
        jMenuItem14.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        jMenuItem14.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menuOpenGraph_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem15.setText("Enregistrer...");
        jMenuItem15.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        jMenuItem15.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menuSaveGraph_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem16.setText("Exporter en tant qu'image JPEG...");
        jMenuItem16.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menuExporter_actionPerformed(e);
            }
            @SuppressWarnings("unused")
            final Chop__Fenetre this$0; 
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        
        jButton1.setBackground(Color.gray);
        jButton1.setText("Executer");
        jButton1.setForeground(Color.white);
        jButton1.setEnabled(false);
        jButton1.setIcon(goi);
        jButton1.setBounds(new Rectangle(25, 75, 120, 50));
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                traiterGraph_actionPerformed(e);
            }
            @SuppressWarnings("unused")
			final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jMenuItem17.setText("Algorithme de Rakobe");
        jMenuItem17.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                menunewRakobe_actionPerformed(e);
            }
            @SuppressWarnings("unused")
			final Chop__Fenetre this$0;
            {
                this$0 = Chop__Fenetre.this;
            }
        }
);
        jSeparator1.setBounds(new Rectangle(355, 10, 0, 130));
        jPanel4.setBounds(new Rectangle(395, 40, 170, 130));
        jPanel4.setLayout(null);
        jPanel4.setBorder(BorderFactory.createBevelBorder(1));
        jLabel2.setText("Algorithme de");
        jLabel2.setBounds(new Rectangle(10, 5, 155, 25));
        jComboBox1.setBounds(new Rectangle(25, 40, 120, 20));
        jp.setBounds(new Rectangle(10, 10, 315, 185));
        jLabel3.setText("<HTML><BODY>Demoucrom!</BODY></HTML>");
        jLabel3.setBounds(new Rectangle(520, 635, 450, 20));
        jLabel3.setFont(new Font("Times New Roman", 1, 16));
        jLabel3.setForeground(new Color(255, 255, 255));
        jScrollPane1.setBounds(new Rectangle(665, 370, 260, 220));
        jList1.setBorder(BorderFactory.createTitledBorder("R\351sultat(s)"));
        jList1.setBackground(Color.white);
        jComboBox1.addItem("DEMOUCRON");
    }

    public void run()
    {
        for(int h = 0; h < som.length - 1; h++)
        {
            try
            {
                Thread.sleep(500L);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            chercheArc(som[h], som[h + 1]).setMin(true);
            jPanel1.repaint();
        }

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

    private void jPanel1_mouseClicked(MouseEvent e)
    {
        boolean trouve = false;
        boolean trouvearc = false;
        for(int i = 0; !trouve && i < Chop__Sommet.getNbSommet();)
            if(s[i].EspaceReserve(e.getX(), e.getY()))
            {
                trouve = true;
                SelectedSommet = i;
            } else
            {
                i++;
            }

        if(!trouve && DoRelier)
        {
            jPanel1.remove(ce[NumCe - 1]);
            NumCe--;
            Chop__CheminElementaire.setNombreArc(NumCe);
            isGraphSet();
            jPanel1.repaint();
        }
        if(trouve)
        {
            if(!DoRelier)
            {
                posX = e.getX();
                posY = e.getY();
                jPopupMenu1.show(jPanel1, posX, posY);
                jMenuItem1.setEnabled(false);
                jMenuItem6.setEnabled(false);
                jMenuItem12.setEnabled(false);
                jMenuItem13.setEnabled(false);
                jMenuItem2.setEnabled(true);
                jMenuItem3.setEnabled(true);
                jMenuItem4.setEnabled(true);
                jMenuItem5.setEnabled(true);
            }
        } else
        {
            for(int i = 0; !trouvearc && i < NumCe;)
                if(e.getX() > ce[i].getPosX() - 10 && e.getX() < ce[i].getPosX() + 10 && e.getY() > ce[i].getPosY() - 10 && e.getY() < ce[i].getPosY() + 10)
                {
                    trouvearc = true;
                    SelectedArc = i;
                } else
                {
                    i++;
                }

            if(!DoRelier)
                if(!trouvearc)
                {
                    posX = e.getX();
                    posY = e.getY();
                    jPopupMenu1.show(jPanel1, posX, posY);
                    jMenuItem1.setEnabled(true);
                    jMenuItem6.setEnabled(true);
                    jMenuItem12.setEnabled(false);
                    jMenuItem13.setEnabled(false);
                    jMenuItem2.setEnabled(false);
                    jMenuItem3.setEnabled(false);
                    jMenuItem4.setEnabled(false);
                    jMenuItem5.setEnabled(false);
                } else
                {
                    posX = e.getX();
                    posY = e.getY();
                    jPopupMenu1.show(jPanel1, posX, posY);
                    jMenuItem1.setEnabled(false);
                    jMenuItem6.setEnabled(false);
                    jMenuItem12.setEnabled(true);
                    jMenuItem13.setEnabled(true);
                    jMenuItem2.setEnabled(false);
                    jMenuItem3.setEnabled(false);
                    jMenuItem4.setEnabled(false);
                    jMenuItem5.setEnabled(false);
                }
        }
        if(trouve && DoRelier)
            if(ce[NumCe - 1].getOrg() == s[SelectedSommet] || ce[NumCe - 1].getExt() == s[SelectedSommet])
            {
                JOptionPane.showMessageDialog(jPanel1, "Vous ne pouvez pas cr\351er un arc sur un m\352me sommet.", "Erreur", 0);
                jPanel1.remove(ce[NumCe - 1]);
                NumCe--;
                Chop__CheminElementaire.setNombreArc(NumCe);
                isGraphSet();
                jPanel1.repaint();
            } else
            if(CheminExiste())
            {
                JOptionPane.showMessageDialog(jPanel1, "Cet arc existe d\351j\340.", "Erreur", 0);
                jPanel1.remove(ce[NumCe - 1]);
                NumCe--;
                Chop__CheminElementaire.setNombreArc(NumCe);
                isGraphSet();
                jPanel1.repaint();
            } else
            {
                if(RelieOrg)
                    ce[NumCe - 1].setExt(s[SelectedSommet]);
                else
                    ce[NumCe - 1].setOrg(s[SelectedSommet]);
                String dis = "";
                for(boolean erreur = true; erreur;)
                {
                    erreur = false;
                    dis = JOptionPane.showInputDialog(jPanel1, "Longueur de l'arc : ", "Distance", 1);
                    if(dis.isEmpty())
                        JOptionPane.showMessageDialog(jPanel1, "Vous n'avez rien entr\351.", "Erreur", 0);
                    else
                    if(dis.compareTo("0") == 0)
                    {
                        erreur = true;
                        JOptionPane.showMessageDialog(jPanel1, "Entrez un nombre entier de valeur non nul.", "Erreur", 0);
                    } else
                    {
                        int k = 0;
                        do
                        {
                            if(k >= dis.length())
                                break;
                            if(dis.charAt(k) < '0' || dis.charAt(k) > '9')
                            {
                                erreur = true;
                                JOptionPane.showMessageDialog(jPanel1, "Entrez un nombre entier valide.", "Erreur", 0);
                                break;
                            }
                            k++;
                        } while(true);
                        if(!erreur)
                        {
                            int ld = Integer.parseInt(dis);
                            ce[NumCe - 1].setLongueur(ld);
                        } else
                        {
                            ce[NumCe - 1].setLongueur(0);
                        }
                    }
                }

                jPanel1.repaint();
            }
        DoRelier = false;
        afficheArc();
    }

    public void isGraphSet()
    {
        if(Chop__CheminElementaire.getNombreArc() == 0)
            jButton1.setEnabled(false);
        else
            jButton1.setEnabled(true);
    }

    private boolean CheminExiste()
    {
        for(int k = 0; k < NumCe; k++)
        {
            if(ce[k].getOrg() == ce[NumCe - 1].getOrg() && ce[k].getExt() == s[SelectedSommet])
                return true;
            if(ce[k].getExt() == ce[NumCe - 1].getExt() && ce[k].getOrg() == s[SelectedSommet])
                return true;
        }

        return false;
    }

    private void jPanel1_mouseMoved(MouseEvent e)
    {
        jLabel1.setText((new StringBuilder()).append("X : ").append(e.getX()).append(", Y : ").append(e.getY()).append("   |    Nombre de sommets : ").append(NumObj).append("   |    Nombre d'arcs : ").append(NumCe).toString());
        if(dialogy.getVocliky())
        {
            CreerNouveauChemin();
            jPanel1.repaint();
            afficheArc();
            dialogy.setVocliky(false);
        }
        if(DoRelier)
        {
            if(RelieOrg)
            {
                ce[NumCe - 1].setex(e.getX() - 15);
                ce[NumCe - 1].setey(e.getY() - 15);
            } else
            {
                ce[NumCe - 1].setox(e.getX() - 15);
                ce[NumCe - 1].setoy(e.getY() - 15);
            }
            jPanel1.repaint();
        }
    }

    private void jMenuItem1_actionPerformed(ActionEvent e)
    {
        dialogy.setVocliky(false);
        dialogy.setCopie(s);
        dialogy.setVisible(true);
        e.getID();
    }

    private void jPanel1_mouseDragged(MouseEvent e)
    {
        jLabel1.setText((new StringBuilder()).append("X : ").append(e.getX()).append(", Y : ").append(e.getY()).append("   |    Nombre de sommets : ").append(NumObj).append("   |    Nombre d'arcs : ").append(NumCe).toString());
        for(int i = 0; i < Chop__Sommet.getNbSommet() && !deplace;)
            if(s[i].EspaceReserve(e.getX(), e.getY()))
            {
                deplace = true;
                SelectedSommet = i;
            } else
            {
                i++;
            }

        if(deplace && e.getX() < jPanel1.getWidth() && e.getX() > 0 && e.getY() > 0 && e.getY() < jPanel1.getHeight())
        {
            s[SelectedSommet].setLocationX(e.getX() - 15);
            s[SelectedSommet].setLocationY(e.getY() - 15);
            s[SelectedSommet].setBounds(e.getX() - 15, e.getY() - 15, 30, 30);
        }
        jPanel1.repaint();
    }

    private void jPanel1_mousePressed(MouseEvent e)
    {
        deplace = false;
        e.getX();
    }

    private void CreerNouveauChemin()
    {
        s[NumObj] = new Chop__Sommet(dialogy.getLib_o(), posX - 15, posY);
        jPanel1.add(s[NumObj]);
        NumObj++;
        Chop__Sommet.setNbSommet(NumObj);
        s[NumObj] = new Chop__Sommet(dialogy.getLib_e(), posX + 15, posY);
        jPanel1.add(s[NumObj]);
        ce[NumCe] = new Chop__CheminElementaire(s[NumObj - 1], s[NumObj], dialogy.getLgr());
        jPanel1.add(ce[NumCe]);
        NumCe++;
        Chop__CheminElementaire.setNombreArc(NumCe);
        isGraphSet();
        NumObj++;
        Chop__Sommet.setNbSommet(NumObj);
        jPanel1.repaint();
    }

    private void jPanel1_mouseReleased(MouseEvent e)
    {
        e.getX();
    }

    private void jMenuItem6_actionPerformed(ActionEvent e)
    {
        boolean nahita = false;
        String newlabel = "";
        e.getID();
        do
        {
            if(!newlabel.isEmpty() && !nahita)
                break;
            nahita = false;
            newlabel = JOptionPane.showInputDialog(jPanel1, "Nom du sommet : ", "Ajouter un sommet", 3);
            for(int v = 0; v < Chop__Sommet.getNbSommet() && !nahita; v++)
                if(s[v].getLabelS().compareTo(newlabel) == 0)
                    nahita = true;

            if(nahita)
                JOptionPane.showMessageDialog(jPanel1, "Ce sommet existe d\351j\340. Entrez un autre nom.", "Erreur", 0);
            if(newlabel.isEmpty())
                JOptionPane.showMessageDialog(jPanel1, "Entrez un nom valide.", "Erreur", 0);
        } while(true);
        if(!newlabel.isEmpty() && !nahita)
        {
            s[NumObj] = new Chop__Sommet(newlabel, posX, posY);
            jPanel1.add(s[NumObj]);
            NumObj++;
            Chop__Sommet.setNbSommet(NumObj);
            jPanel1.repaint();
        }
        afficheArc();
        jPanel1.repaint();
    }

    private void jMenuItem6_focusGained(FocusEvent e)
    {
        e.getID();
        String str = "Cr\351er \340 cet endroit un nouveau sommet avec son libell\351.";
        jLabel1.setText(str);
    }

    private void jMenuItem6_focusLost(FocusEvent e)
    {
        e.getID();
        jLabel1.setText("");
    }

    private void jMenuItem6_mouseMoved(MouseEvent e)
    {
        e.getX();
        String str = "Cr\351er \340 cet endroit un nouveau sommet avec son libell\351.";
        jLabel1.setText(str);
    }

    private void jMenuItem6_mouseExited(MouseEvent e)
    {
        e.getX();
        jLabel1.setText("");
    }

    private void jMenuItem4_actionPerformed(ActionEvent e)
    {
        boolean nahita = false;
        String newlabel = "";
        e.getID();
        do
        {
            if(!newlabel.isEmpty() && !nahita)
                break;
            nahita = false;
            newlabel = JOptionPane.showInputDialog(jPanel1, "Nouveau nom du sommet : ", "Modifier un sommet", 3);
            for(int v = 0; v < Chop__Sommet.getNbSommet() && !nahita; v++)
            {
                System.out.println((new StringBuilder()).append("newlabel : ").append(newlabel).append("  label").append(v).append(":").append(s[v].getLabelS()).toString());
                if(s[v].getLabelS().compareTo(newlabel) == 0 && v != SelectedSommet)
                    nahita = true;
            }

            if(nahita)
                JOptionPane.showMessageDialog(jPanel1, "Ce sommet existe d\351j\340. Entrez un autre nom.", "Erreur", 0);
            if(newlabel.isEmpty())
                JOptionPane.showMessageDialog(jPanel1, "Entrez un nom valide.", "Erreur", 0);
        } while(true);
        if(!newlabel.isEmpty() && !nahita)
            s[SelectedSommet].setLabelS(newlabel);
        afficheArc();
        jPanel1.repaint();
    }

    private void menuModifier_mouseMoved(MouseEvent e)
    {
        e.getX();
        String str = "Modifier le nom de ce sommet.\nEntrez la valeur du nouveau nom.";
        jLabel1.setText(str);
    }

    private void menuModifier_mouseExited(MouseEvent e)
    {
        e.getX();
        jLabel1.setText("");
    }

    public int findFirstArc(Chop__Sommet p)
    {
        int k = 0;
        int res = -1;
        for(boolean found = false; k < NumCe && !found;)
            if(ce[k].getOrg() == p || ce[k].getExt() == p)
            {
                res = k;
                found = true;
            } else
            {
                k++;
            }

        return res;
    }

    private void menuEffacer_actionPerformed(ActionEvent e)
    {
        e.getID();
        int conf = JOptionPane.showConfirmDialog(jPanel1, "Voulez -vous vraiment effacer ce sommet?", "Confimez!", 0, 2);
        if(conf == 0)
        {
            for(; findFirstArc(s[SelectedSommet]) != -1; supprimeArc(findFirstArc(s[SelectedSommet])));
            remplaceSommet(SelectedSommet, NumObj - 1);
            for(int k = 0; k < NumCe; k++)
            {
                if(ce[k].getOrg() == s[NumObj - 1])
                    ce[k].setOrg(s[SelectedSommet]);
                if(ce[k].getExt() == s[NumObj - 1])
                    ce[k].setExt(s[SelectedSommet]);
            }

            jPanel1.remove(s[NumObj - 1]);
            NumObj--;
            Chop__Sommet.setNbSommet(NumObj);
            afficheArc();
            jPanel1.repaint();
        }
    }

    private void remplaceSommet(int i1, int i2)
    {
        s[i1].setLabelS(s[i2].getLabelS());
        s[i1].setLocationX(s[i2].getLocationX());
        s[i1].setLocationY(s[i2].getLocationY());
        s[i1].setBounds(s[i2].getLocationX(), s[i2].getLocationY(), 30, 30);
    }

    private void menuEffacer_mouseMoved(MouseEvent e)
    {
        e.getX();
        String str = "Effacer ce sommet.\nAttention, si vous effacez ce sommet, les arcs seront aussi supprim\351s.";
        jLabel1.setText(str);
    }

    private void menuEffacer_mouseExited(MouseEvent e)
    {
        e.getX();
        jLabel1.setText("");
    }

    private void menuRelierOrigine_actionPerformed(ActionEvent e)
    {
        e.getID();
        ce[NumCe] = new Chop__CheminElementaire(s[SelectedSommet], posX, posY);
        jPanel1.add(ce[NumCe]);
        NumCe++;
        Chop__CheminElementaire.setNombreArc(NumCe);
        isGraphSet();
        DoRelier = true;
        RelieOrg = true;
    }

    private void menuRelierOrigine_mouseExited(MouseEvent e)
    {
        e.getX();
        jLabel1.setText("");
    }

    private void menuRelierOrigine_mouseMoved(MouseEvent e)
    {
        e.getX();
        String str = "D\351finir un nouvel arc \340 partir de ce sommet. Cliquez sur un autre sommet pour valider";
        jLabel1.setText(str);
    }

    private void menuNouveauChemin_mouseMoved(MouseEvent e)
    {
        e.getX();
        String str = "Cr\351er un nouvel arc avec son origine, son extr\351mit\351 et sa distance.";
        jLabel1.setText(str);
    }

    private void menuNouveauChemin_mouseExited(MouseEvent e)
    {
        e.getX();
        jLabel1.setText("");
    }

    private void menuRelierExtremite_actionPerformed(ActionEvent e)
    {
        e.getID();
        ce[NumCe] = new Chop__CheminElementaire(posX, posY, s[SelectedSommet]);
        jPanel1.add(ce[NumCe]);
        NumCe++;
        Chop__CheminElementaire.setNombreArc(NumCe);
        isGraphSet();
        DoRelier = true;
        RelieOrg = false;
    }

    private void menuRelierExtremite_mouseMoved(MouseEvent e)
    {
        e.getX();
        String str = "D\351finir un nouvel arc dont ce sommet est l'extr\351mit\351. Cliquez sur un autre sommet pour valider";
        jLabel1.setText(str);
    }

    private void menuRelierExtremite_mouseExited(MouseEvent e)
    {
        e.getX();
        jLabel1.setText("");
    }

    private void menuModifLgr_actionPerformed(ActionEvent e)
    {
        e.getID();
        boolean averina = true;
        String newlabel = "";
        do
        {
            if(!averina)
                break;
            newlabel = JOptionPane.showInputDialog(jPanel1, "Nouvelle valeur : ", "Modifier la longueur", 3);
            if(entierValide(newlabel))
            {
                averina = false;
                int nl = Integer.parseInt(newlabel);
                ce[SelectedArc].setLongueur(nl);
                jPanel1.repaint();
                afficheArc();
            }
        } while(true);
    }

    private void menuModifLgr_mouseMoved(MouseEvent e)
    {
        e.getX();
        String str = "Modifier la distance entre ces deux sommets. ";
        jLabel1.setText(str);
    }

    private void menuModifLgr_mouseExited(MouseEvent e)
    {
        e.getX();
        jLabel1.setText("");
    }

    private boolean entierValide(String str)
    {
        boolean diso = false;
        if(str.isEmpty())
        {
            diso = true;
            JOptionPane.showMessageDialog(jPanel1, "Entrez un nombre entier valide.", "Erreur", 0);
            return !diso;
        }
        int k = 0;
        do
        {
            if(k >= str.length())
                break;
            if(str.charAt(k) < '0' || str.charAt(k) > '9')
            {
                diso = true;
                JOptionPane.showMessageDialog(jPanel1, "Entrez un nombre entier valide.", "Erreur", 0);
                break;
            }
            k++;
        } while(true);
        return !diso;
    }

    private void menuSupprArc_actionPerformed(ActionEvent e)
    {
        e.getID();
        int conf = JOptionPane.showConfirmDialog(jPanel1, "Voulez -vous vraiment effacer cet arc?", "Confimez!", 0, 2);
        if(conf == 0)
        {
            supprimeArc(SelectedArc);
            afficheArc();
        }
    }

    private void menuSupprArc_mouseMoved(MouseEvent e)
    {
        e.getX();
        String str = "Supprimer le chemin \351lementaire entre ces deux sommets. ";
        jLabel1.setText(str);
    }

    private void menuSupprArc_mouseExited(MouseEvent e)
    {
        e.getX();
        jLabel1.setText("");
    }

    private void supprimeArc(int s)
    {
        ce[s].setOrg(ce[NumCe - 1].getOrg());
        ce[s].setExt(ce[NumCe - 1].getExt());
        ce[s].setLongueur(ce[NumCe - 1].getLongueur());
        jPanel1.remove(ce[NumCe - 1]);
        jPanel1.repaint();
        NumCe--;
        Chop__CheminElementaire.setNombreArc(NumCe);
        isGraphSet();
    }

    private void afficheArc()
    {
        for(int h = modelTable.getRowCount() - 1; h >= 0; h--)
            modelTable.removeRow(h);

        for(int h = 0; h < NumCe; h++)
            modelTable.addRow(new Object[] {
                Integer.valueOf(h + 1), ce[h].getOrg().getLabelS(), ce[h].getExt().getLabelS(), Integer.valueOf(ce[h].getLongueur())
            });

    }

    private void aboutBoxmenu_actionPerformed(ActionEvent e)
    {
        e.getID();
        JOptionPane.showMessageDialog(null, 
        		"<HTML><BODY>Mini-projet R.O : Chemins Optimaux<BR><BR>SR<BR>GB</BODY></HTML>", 
        		"Chemin Optimal", JOptionPane.INFORMATION_MESSAGE);
    }

    private void menuSaveGraph_actionPerformed(ActionEvent e)
    {
        e.getID();
        FileDialog d1 = new FileDialog(this, "Sauvegarder un graphe", 1);
        FilenameFilter filter = new FilenameFilter() {

            public boolean accept(File dir, String name)
            {
                return name.endsWith(".kobe");
            }

            @SuppressWarnings("unused")
			final Chop__Fenetre this$0;

            
            {
                this$0 = Chop__Fenetre.this;
                ////super();
            }
        }
;
        d1.setFilenameFilter(filter);
        d1.setLocation(300, 200);
        d1.setDirectory("/home/kobe/");
        d1.setVisible(true);
        File fic;
        if(!d1.getFile().matches(".*kobe"))
            fic = new File((new StringBuilder()).append(d1.getDirectory()).append(d1.getFile()).append(".kobe").toString());
        else
            fic = new File((new StringBuilder()).append(d1.getDirectory()).append(d1.getFile()).toString());
        try
        {
            if(fic.createNewFile())
            {
                FileOutputStream fp = new FileOutputStream(fic);
                byte b1[] = {
                    83, 111, 109, 109, 101, 116, 58, 10
                };
                fp.write(b1);
                for(int f = 0; f < NumObj; f++)
                    appendlignesommet(s[f], fp);

                byte b0[] = {
                    65, 114, 99, 58, 10
                };
                fp.write(b0);
                for(int f = 0; f < NumCe; f++)
                    appendlignearc(ce[f], fp);

                byte b2[] = {
                    70, 105, 110, 46, 10, 10
                };
                byte b3[] = {
                    45, 45, 45, 45, 45, 45, 45, 45, 45
                };
                fp.write(b2);
                fp.write(b3);
                fp.close();
                setTitle((new StringBuilder()).append("TP RO \"").append(fic.getAbsolutePath()).append("\" enregistr\351]").toString());
                jLabel1.setText((new StringBuilder()).append("\"").append(fic.getAbsolutePath()).append("\" enregistr\351").toString());
            } else
            if(fic.exists())
            {
                int conf = JOptionPane.showConfirmDialog(jPanel1, "Ce fichier existe. Voulez -vous le remplacer?", "Confimez!", 0, 2);
                if(conf == 0)
                {
                    fic.delete();
                    fic.createNewFile();
                    FileOutputStream fp = new FileOutputStream(fic);
                    byte b1[] = {
                        83, 111, 109, 109, 101, 116, 58, 10
                    };
                    fp.write(b1);
                    for(int f = 0; f < NumObj; f++)
                        appendlignesommet(s[f], fp);

                    byte b0[] = {
                        65, 114, 99, 58, 10
                    };
                    byte b2[] = {
                        70, 105, 110, 46, 10, 10
                    };
                    byte b3[] = {
                        45, 45, 45, 45, 45, 45, 45, 45, 45
                    };
                    fp.write(b0);
                    for(int f = 0; f < NumCe; f++)
                        appendlignearc(ce[f], fp);

                    fp.write(b2);
                    fp.write(b3);
                    setTitle((new StringBuilder()).append("Projet R.O[\"").append(fic.getAbsolutePath()).append("\" enregistr\351]").toString());
                    jLabel1.setText((new StringBuilder()).append("\"").append(fic.getAbsolutePath()).append("\" enregistr\351").toString());
                    fp.close();
                }
            }
        }
        catch(IOException r)
        {
            r.printStackTrace();
        }
    }

    private void appendlignearc(Chop__CheminElementaire c, FileOutputStream d)
    {
        String s = (new StringBuilder()).append(c.getOrg().getLabelS()).append("\t").append(c.getExt().getLabelS()).append("\t").append(c.getLongueur()).append("\n").toString();
        for(int g = 0; g < s.length(); g++)
            try
            {
                d.write(s.charAt(g));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

    }

    private void appendlignesommet(Chop__Sommet c, FileOutputStream d)
    {
        String s = (new StringBuilder()).append(c.getLabelS()).append("\t").append(c.getLocationX()).append("\t").append(c.getLocationY()).append("\n").toString();
        for(int g = 0; g < s.length(); g++)
            try
            {
                d.write(s.charAt(g));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

    }

    private String lireligne(FileInputStream d)
    {
        String s = "";
        char c = '\0';
        try
        {
            do
            {
                if(c == '\n')
                    break;
                c = (char)d.read();
                if(c != '\n')
                    s = (new StringBuilder()).append(s).append(c).toString();
            } while(true);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return s;
    }

    private void creersommet(String nom, String kx, String ky)
    {
        s[NumObj] = new Chop__Sommet(nom, Integer.parseInt(kx), Integer.parseInt(ky));
        jPanel1.add(s[NumObj]);
        NumObj++;
        Chop__Sommet.setNbSommet(NumObj);
    }

    private void creerarc(String or, String ex, String di)
    {
        ce[NumCe] = new Chop__CheminElementaire(Integer.parseInt(di));
        int r = chercheSommet(or);
        if(r != -1)
        {
            ce[NumCe].setOrg(s[r]);
        } else
        {
            creersommet(or, "25", "150");
            ce[NumCe].setOrg(s[NumObj - 1]);
        }
        r = chercheSommet(ex);
        if(r != -1)
        {
            ce[NumCe].setExt(s[r]);
        } else
        {
            creersommet(ex, "25", "150");
            ce[NumCe].setExt(s[NumObj - 1]);
        }
        jPanel1.add(ce[NumCe]);
        NumCe++;
        Chop__CheminElementaire.setNombreArc(NumCe);
        isGraphSet();
    }

    private int chercheSommet(String l)
    {
        for(int k = 0; k < Chop__Sommet.getNbSommet(); k++)
            if(s[k].getLabelS().compareTo(l) == 0)
                return k;

        return -1;
    }

    private void menuOpenGraph_actionPerformed(ActionEvent e)
    {
        e.getID();
        FileDialog d1 = new FileDialog(this, "Ouvrir un graphe", 0);
        d1.setLocation(300, 200);
        d1.setDirectory("/home/kobe/");
        FilenameFilter filter = new FilenameFilter() {

            public boolean accept(File dir, String name)
            {
                return name.endsWith(".kobe");
            }

            @SuppressWarnings("unused")
			final Chop__Fenetre this$0;

            
            {
                this$0 = Chop__Fenetre.this;
                ////super();
            }
        }
;
        d1.setFilenameFilter(filter);
        d1.setVisible(true);
        if(!d1.getFile().matches(".*kobe"))
        {
            JOptionPane.showMessageDialog(jPanel1, "Ce fichier n'est pas un graphe.", "Erreur", 0);
        } else
        {
            File fic = new File((new StringBuilder()).append(d1.getDirectory()).append(d1.getFile()).toString());
            System.out.println(fic.getName());
            try
            {
                FileInputStream fn = new FileInputStream(fic);
                jPanel1.removeAll();
                jPanel1.repaint();
                NumObj = 0;
                Chop__Sommet.setNbSommet(NumObj);
                NumCe = 0;
                Chop__CheminElementaire.setNombreArc(NumCe);
                isGraphSet();
                String str = lireligne(fn);
                for(str = lireligne(fn); str.compareTo("Arc:") != 0; str = lireligne(fn))
                {
                    String temp[] = str.split("\\t", 3);
                    creersommet(temp[0], temp[1], temp[2]);
                }

                for(str = lireligne(fn); str.compareTo("Fin.") != 0; str = lireligne(fn))
                {
                    String temp[] = str.split("\\t", 3);
                    creerarc(temp[0], temp[1], temp[2]);
                }

                setTitle((new StringBuilder()).append("TP RO ").append(d1.getDirectory()).append(d1.getFile()).append("]").toString());
                jPanel1.repaint();
                for(int index = jTabbedPane2.getTabCount(); index > 1; index--)
                    jTabbedPane2.remove(index - 1);

                afficheArc();
            }
            catch(FileNotFoundException f)
            {
                f.printStackTrace();
            }
        }
    }

    private void menuQuitter_actionPerformed(ActionEvent e)
    {
    	int confi_quit = JOptionPane.showConfirmDialog(null, "�tes-vous s�r de fermer cette application?", "Mini-projet R.O : Chemin Optimal", JOptionPane.YES_NO_OPTION);
        if(confi_quit == JOptionPane.YES_OPTION)
        {
        	e.getID();
            System.exit(0);
        }
    }

    private void traiterGraph_actionPerformed(ActionEvent e)
    {
        e.getID();
        mlist.removeAllElements();
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            ce[i].setMin(false);

        for(int i = 0; i < Chop__Sommet.getNbSommet(); i++)
            s[i].setMarque(false);

        jPanel1.repaint();
        
        if(jComboBox1.getSelectedIndex() == 0)
        {
            findEtRemplaceDebutEtFin();
            Chop__PanelDemoucron pdem = new Chop__PanelDemoucron(ce, s, jPanel1, mlist, jList1);
            jTabbedPane2.addTab((new StringBuilder()).append("Demoucron").append(jTabbedPane2.getTabCount()).toString(), fermer, pdem);
            jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount() - 1);
        }
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

    private void findEtRemplaceDebutEtFin()
    {
        boolean stop = false;
        int i = 0;
        int indice = 0;
        boolean nahita;
        int j;
        int NbArc;
        for(NbArc = Chop__CheminElementaire.getNombreArc(); i < NbArc && !stop;)
        {
            nahita = false;
            for(j = 0; j < NbArc && !nahita; j++)
                if(ce[i].getOrg().getLabelS().compareTo(ce[j].getExt().getLabelS()) == 0)
                    nahita = true;

            if(nahita)
            {
                i++;
            } else
            {
                indice = i;
                stop = true;
            }
        }

        System.out.println((new StringBuilder()).append("Debut:").append(ce[indice].getOrg().getLabelS()).append(",indice:").append(indice).toString());
        int indiceremplace = chercheSommet(ce[indice].getOrg().getLabelS());
        Chop__Sommet temp = s[0];
        s[0] = s[indiceremplace];
        for(int p = 0; p < Chop__CheminElementaire.getNombreArc(); p++)
        {
            if(ce[p].getOrg() == s[indiceremplace])
                ce[p].setOrg(s[0]);
            if(ce[p].getExt() == s[indiceremplace])
                ce[p].setExt(s[0]);
        }

        s[indiceremplace] = temp;
        for(int p = 0; p < Chop__CheminElementaire.getNombreArc(); p++)
        {
            if(ce[p].getOrg() == temp)
                ce[p].setOrg(s[indiceremplace]);
            if(ce[p].getExt() == temp)
                ce[p].setExt(s[indiceremplace]);
        }

        stop = false;
        nahita = false;
        i = 0;
        j = 0;
        indice = 0;
        while(i < NbArc && !stop) 
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
                stop = true;
            }
        }
        System.out.println((new StringBuilder()).append("Fin:").append(ce[indice].getExt().getLabelS()).append(",indice:").append(indice).toString());
        indiceremplace = chercheSommet(ce[indice].getExt().getLabelS());
        temp = s[Chop__Sommet.getNbSommet() - 1];
        s[Chop__Sommet.getNbSommet() - 1] = s[indiceremplace];
        for(int p = 0; p < Chop__CheminElementaire.getNombreArc(); p++)
        {
            if(ce[p].getOrg() == s[indiceremplace])
                ce[p].setOrg(s[Chop__Sommet.getNbSommet() - 1]);
            if(ce[p].getExt() == s[indiceremplace])
                ce[p].setExt(s[Chop__Sommet.getNbSommet() - 1]);
        }

        s[indiceremplace] = temp;
        for(int p = 0; p < Chop__CheminElementaire.getNombreArc(); p++)
        {
            if(ce[p].getOrg() == temp)
                ce[p].setOrg(s[indiceremplace]);
            if(ce[p].getExt() == temp)
                ce[p].setExt(s[indiceremplace]);
        }

    }

    private void menunewDemoucron_actionPerformed(ActionEvent e)
    {
        e.getID();
        mlist.removeAllElements();
        jPanel1.removeAll();
        jPanel1.repaint();
        NumObj = 0;
        Chop__Sommet.setNbSommet(NumObj);
        NumCe = 0;
        Chop__CheminElementaire.setNombreArc(NumCe);
        isGraphSet();
        jComboBox1.setSelectedIndex(2);
        afficheArc();
        for(int i = jTabbedPane2.getTabCount() - 1; i > 0; i--)
            jTabbedPane2.remove(i);

    }

    private void menunewRakobe_actionPerformed(ActionEvent e)
    {
        e.getID();
        mlist.removeAllElements();
        jPanel1.removeAll();
        jPanel1.repaint();
        NumObj = 0;
        Chop__Sommet.setNbSommet(NumObj);
        NumCe = 0;
        Chop__CheminElementaire.setNombreArc(NumCe);
        isGraphSet();
        jComboBox1.setSelectedIndex(3);
        afficheArc();
        for(int i = jTabbedPane2.getTabCount() - 1; i > 0; i--)
            jTabbedPane2.remove(i);

    }

    private void menuExporter_actionPerformed(ActionEvent e)
    {
        e.getID();
        FileDialog d1 = new FileDialog(this, "Exporter un graphe en JPEG", 1);
        FilenameFilter filter = new FilenameFilter() {

            public boolean accept(File dir, String name)
            {
                return name.endsWith(".jpg");
            }

            @SuppressWarnings("unused")
			final Chop__Fenetre this$0;

            
            {
                this$0 = Chop__Fenetre.this;
                ////super();
            }
        }
;
        d1.setFilenameFilter(filter);
        d1.setLocation(300, 200);
        d1.setDirectory("/home/kobe/");
        d1.setVisible(true);
        File fic;
        if(!d1.getFile().matches(".*jpg"))
            fic = new File((new StringBuilder()).append(d1.getDirectory()).append(d1.getFile()).append(".jpg").toString());
        else
            fic = new File((new StringBuilder()).append(d1.getDirectory()).append(d1.getFile()).toString());
        try
        {
            captureComponentToJpeg(jPanel1, fic);
        }
        catch(IOException f)
        {
            f.printStackTrace();
        }
    }

    public void captureComponentToJpeg(Component c, File destFile)
        throws IOException
    {
        BufferedImage image = new BufferedImage(c.getWidth(), c.getHeight(), 1);
        c.paint(image.createGraphics());
        ImageIO.write(image, "JPEG", destFile);
    }

    private Chop__CheminElementaire chercheArc(String o, String e)
    {
        for(int i = 0; i < Chop__CheminElementaire.getNombreArc(); i++)
            if(ce[i].getOrg().getLabelS().compareTo(o) == 0 && ce[i].getExt().getLabelS().compareTo(e) == 0)
                return ce[i];

        return null;
    }

    private JPopupMenu jPopupMenu1;
    private JMenuItem jMenuItem1;
    private Chop__Sommet s[];
    private Chop__CheminElementaire ce[];
    private int NumObj;
    private int NumCe;
    private boolean deplace;
    private boolean DoRelier;
    private boolean RelieOrg;
    private Chop__NouveauChemin dialogy;
    private int posX;
    private int posY;
    private int SelectedSommet;
    private int SelectedArc;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;
    private JTabbedPane jTabbedPane1;
    private JMenuBar jMenuBar1;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuItem jMenuItem8;
    private JMenuItem jMenuItem9;
    //private JMenu jMenu3;
    private JMenuItem jMenuItem7;
    private JMenuItem jMenuItem10;
    private JMenuItem jMenuItem11;
    private URL imgURL;
    private URL imgURL2;
    private Chop__PanelDeDessin jPanel1;
    private JPanel jPanel2;
    private JLabel jLabel1;
    private JTabbedPane jTabbedPane2;
    private JPanel jPanel3;
    DefaultTableModel modelTable;
    private JTable jTable1;
    private JMenuItem jMenuItem12;
    private JMenuItem jMenuItem13;
    private JMenuItem jMenuItem14;
    private JMenuItem jMenuItem15;
    private JMenuItem jMenuItem16;
    private JButton jButton1;
    private JMenuItem jMenuItem17;
    private JSeparator jSeparator1;
    private JPanel jPanel4;
    private JLabel jLabel2;
    @SuppressWarnings("rawtypes")
	private JComboBox jComboBox1;
    @SuppressWarnings("rawtypes")
	private DefaultListModel mlist;
    @SuppressWarnings("rawtypes")
	private JList jList1;
    private JScrollPane jScrollPane1;
    private URL imgFermer;
    Icon fer;
    Chop__IconClosable fermer;
    private JLabel jLabel3;
    private Thread runeo;
    String som[];
    Icon goi;
}