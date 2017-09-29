package ro.chop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * 
 
 *
 */
public class Chop__NouveauChemin extends JDialog
{

    public void setfocustext()
    {
        jTextField1.setFocusable(true);
    }

    public boolean getVocliky()
    {
        return vocliky;
    }

    public void setVocliky(boolean b)
    {
        vocliky = b;
    }

    public void setLgr(int s)
    {
        lgr = s;
    }

    public int getLgr()
    {
        return lgr;
    }

    public String getLib_o()
    {
        return lib_o;
    }

    public String getLib_e()
    {
        return lib_e;
    }

    public void setCopie(Chop__Sommet s[])
    {
        CopieSommet = s;
    }

    public Chop__NouveauChemin()
    {
        this(null, "", false);
    }

    public Chop__NouveauChemin(Frame parent, String title, boolean modal)
    {
        super(parent, title, true);
        jLabel1     = new JLabel();
        jLabel2     = new JLabel();
        jLabel3     = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel4     = new JLabel();
        jButton1    = new JButton();
        jButton2    = new JButton();
        jTextField1 = new JTextField();
        jTextField3 = new JTextField();
        jTextField2 = new JTextField();
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception
    {
        setLocation(300, 200);
        setSize(new Dimension(221, 217));
        getContentPane().setLayout(null);
        setTitle("Nouveau chemin \351l\351mentaire");
        addWindowListener(new WindowAdapter() 
        {
	        public void windowActivated(WindowEvent e)
	        {
	        	this_windowActivated(e);
	        }
	
	        @SuppressWarnings("unused")
			final Chop__NouveauChemin this$0;
	        {
	        	this$0 = Chop__NouveauChemin.this;
	        }
        }
        			    );
        setResizable(false);
        jLabel1.setText("Origine : ");
        jLabel1.setBounds(new Rectangle(15, 50, 55, 15));
        jLabel2.setText("Extremit\351 : ");
        jLabel2.setBounds(new Rectangle(15, 85, 70, 15));
        jLabel3.setText("Longueur : ");
        jLabel3.setBounds(new Rectangle(15, 120, 70, 15));
        jSeparator1.setBounds(new Rectangle(0, 35, 220, 2));
        jSeparator1.setForeground(Color.white);
        jLabel4.setText("Entrez les propri\351t\351s du chemin : ");
        jLabel4.setBounds(new Rectangle(5, 5, 210, 25));
        jButton1.setText("OK");
        jButton1.setBounds(new Rectangle(15, 150, 70, 30));
        jButton1.setEnabled(false);
        jButton1.addMouseMotionListener(new MouseMotionAdapter() 
        {
            public void mouseMoved(MouseEvent e)
            {
                jButton1_mouseMoved(e);
            }
            @SuppressWarnings("unused")
			final Chop__NouveauChemin this$0;
            {
                this$0 = Chop__NouveauChemin.this;
            }
        }
        								);
        jButton1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                jButton1_actionPerformed(e);
            }
            @SuppressWarnings("unused")
			final Chop__NouveauChemin this$0;
            
            {
                this$0 = Chop__NouveauChemin.this;
            }
        }
        						 );
        
        jButton2.setText("Annuler");
        jButton2.setBounds(new Rectangle(110, 150, 80, 30));
        jButton2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                jButton2_actionPerformed(e);
            }
            @SuppressWarnings("unused")
			final Chop__NouveauChemin this$0;
            
            {
                this$0 = Chop__NouveauChemin.this;
            }
        }
        							);
        
        jTextField1.setBounds(new Rectangle(95, 45, 95, 25));
        jTextField1.addKeyListener(new KeyAdapter() 
        {
            public void keyReleased(KeyEvent e)
            {
                jTextField1_keyReleased(e);
            }
            @SuppressWarnings("unused")
			final Chop__NouveauChemin this$0;
            {
                this$0 = Chop__NouveauChemin.this;
            }
        }
        						  );
        
        jTextField3.setBounds(new Rectangle(95, 115, 95, 25));
        jTextField3.addKeyListener(new KeyAdapter() 
        {
            public void keyReleased(KeyEvent e)
            {
                jTextField3_keyReleased(e);
            }
            @SuppressWarnings("unused")
			final Chop__NouveauChemin this$0;            
            {
                this$0 = Chop__NouveauChemin.this;
            }
        }
        						  );
        
        jTextField2.setBounds(new Rectangle(95, 80, 95, 25));
        jTextField2.addKeyListener(new KeyAdapter() 
        {
            public void keyReleased(KeyEvent e)
            {
                jTextField2_keyReleased(e);
            }
            @SuppressWarnings("unused")
			final Chop__NouveauChemin this$0;
            {
                this$0 = Chop__NouveauChemin.this;
            }
        }
        						 );
        
        getContentPane().add(jTextField2, null);
        getContentPane().add(jTextField3, null);
        getContentPane().add(jTextField1, null);
        getContentPane().add(jButton2, null);
        getContentPane().add(jButton1, null);
        getContentPane().add(jLabel4, null);
        getContentPane().add(jSeparator1, null);
        getContentPane().add(jLabel3, null);
        getContentPane().add(jLabel2, null);
        getContentPane().add(jLabel1, null);
        CopieSommet = new Chop__Sommet[200];
    }

    private void jTextField1_keyReleased(KeyEvent e)
    {
        e.getID();
        if(EntreeValide())
            jButton1.setEnabled(true);
        else
            jButton1.setEnabled(false);
    }

    private boolean EntreeValide()
    {
        if(!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty())
        {
            for(int h = 0; h < Chop__Sommet.getNbSommet(); h++)
                if(CopieSommet[h].getLabelS().compareTo(jTextField2.getText()) == 0 || CopieSommet[h].getLabelS().compareTo(jTextField1.getText()) == 0)
                    return false;

            if(jTextField1.getText().compareTo(jTextField2.getText()) == 0)
                return false;
            return FloatyValide(jTextField3.getText());
        } 
        else
        {
            return false;
        }
    }

    private boolean FloatyValide(String str)
    {
        if(str.charAt(0) == '.')
            return false;
        if(str.compareTo("0") == 0)
            return false;
        for(int y = 0; y < str.length(); y++)
            if(str.charAt(y) != '0' && str.charAt(y) != '1' && str.charAt(y) != '2' && str.charAt(y) != '3' && str.charAt(y) != '4' && str.charAt(y) != '5' && str.charAt(y) != '6' && str.charAt(y) != '7' && str.charAt(y) != '8' && str.charAt(y) != '9' && str.charAt(y) != '0' && str.charAt(y) != '.')
                return false;

        return true;
    }

    private void jTextField2_keyReleased(KeyEvent e)
    {
        e.getID();
        if(EntreeValide())
            jButton1.setEnabled(true);
        else
            jButton1.setEnabled(false);
    }

    private void jTextField3_keyReleased(KeyEvent e)
    {
        e.getID();
        if(EntreeValide())
            jButton1.setEnabled(true);
        else
            jButton1.setEnabled(false);
    }

    private void jButton1_mouseMoved(MouseEvent e)
    {
        e.getID();
        if(EntreeValide())
            jButton1.setEnabled(true);
        else
            jButton1.setEnabled(false);
    }

    private void jButton2_actionPerformed(ActionEvent e)
    {
        e.getID();
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        setVisible(false);
    }

    private void jButton1_actionPerformed(ActionEvent e)
    {
        e.getID();
        lib_o = jTextField1.getText();
        lib_e = jTextField2.getText();
        lgr = Integer.parseInt(jTextField3.getText());
        vocliky = true;
        setVisible(false);
    }

    private void this_windowActivated(WindowEvent e)
    {
        e.getID();
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField1.setText("");
    }

    private static final long serialVersionUID = 1L;
    private JLabel 		 jLabel1;
    private JLabel 		 jLabel2;
    private JLabel 		 jLabel3;
    private JSeparator 	 jSeparator1;
    private JLabel 	 	 jLabel4;
    private JButton 	 jButton1;
    private JButton 	 jButton2;
    private JTextField 	 jTextField1;
    private JTextField 	 jTextField3;
    private JTextField 	 jTextField2;
    private Chop__Sommet CopieSommet[];
    private String 		 lib_o;
    private String 		 lib_e;
    private int 		 lgr;
    private boolean 	 vocliky;
}