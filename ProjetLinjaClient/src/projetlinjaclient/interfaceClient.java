/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlinjaclient;

import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author DjazzJah
 */
public class interfaceClient extends javax.swing.JFrame {

    /**
     * Creates new form interfaceClient
     */
    File file;
    Socket requestSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;

    public interfaceClient() {
        file = new File("C:\\file.xml");
        initComponents();
        this.chargementTableau();
        this.setResizable(false);
        tfid.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tfnom = new javax.swing.JTextField();
        tfadresse = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfbourse = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfmessage = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tfid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableauMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Adresse:");

        jLabel3.setText("Bourse :");

        jLabel1.setText("Nom :");

        tfmessage.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfnom)
                    .addComponent(tfadresse)
                    .addComponent(tfbourse, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfmessage, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(tfmessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfadresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfbourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Supprimer");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Effacer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tfid.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(581, 443));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int test = ouverture();
        if (test != 0) {
            try {
                if (!tfid.getText().isEmpty()) {
                    int rep = JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer id =" + tfid.getText() + "? ", "Boite de Confirmation", JOptionPane.YES_NO_OPTION);
                    if (rep == JOptionPane.YES_OPTION) {
                        sendMessage("supp" + tfid.getText().trim());
                        message = (String) in.readObject();
                        if (message.equalsIgnoreCase("ok")) {
                            tfmessage.setText("Enregistrement supprimé");                            
                        }
                    }
                    this.effacer();
                }
            } catch (Exception e) {
            } finally {
                fermeture();
                chargementTableau();
            }
        } else {
            JOptionPane.showMessageDialog(this, "démarrer votre serveur");
            createFilexml("supp", tfid.getText(), tfnom.getText(), tfadresse.getText(), tfbourse.getText());
        }
        fermeture();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableauMouseClicked
        // TODO add your handling code here:

        tfid.setText(tableau.getValueAt(tableau.getSelectedRow(), 0).toString());
        tfnom.setText(tableau.getValueAt(tableau.getSelectedRow(), 1).toString());
        tfadresse.setText(tableau.getValueAt(tableau.getSelectedRow(), 2).toString());
        tfbourse.setText(tableau.getValueAt(tableau.getSelectedRow(), 3).toString());
        if (!tfid.getText().isEmpty()) {
            jButton1.setText("Modifier");
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_tableauMouseClicked
    int reponses_dao = 0;
    String bouton_ = "";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: 
        String bt = jButton1.getText();
        if (bt.equalsIgnoreCase("Ajouter")) {
            bouton_ = "save";
        } else {
            bouton_ = "edit";
        }
        int test = ouverture();
        if (test != 0) {
            String nom = tfnom.getText().toUpperCase();
            String adresse = tfadresse.getText();
            if (!nom.equalsIgnoreCase("")) {

                int solde = Integer.parseInt(tfbourse.getText());
                if (bt.equalsIgnoreCase("Ajouter")) {
                    try {
                        reponses = "<root>";
                        reponses = reponses + "\n<etudiant action=\"" + bouton_ + "\" id=\"" + tfid.getText() + "\">";
                        reponses = reponses + "\n<nom>" + nom + "</nom>";
                        reponses = reponses + "\n<adresse>" + adresse + "</adresse>";
                        reponses = reponses + "\n<bourse>" + solde + "</bourse>";
                        reponses = reponses + "\n</etudiant>";
                        reponses = reponses + "\n</root>";
                        sendMessage(bouton_ + reponses);
                        message = (String) in.readObject();                        
                        if (message.equalsIgnoreCase("ok")) {
                            tfmessage.setText("Enregistrement ajouté");                            
                        }
                    } catch (Exception e) {
                        fermeture();
                    } finally {
                        fermeture();
                        chargementTableau();
                    }
                    fermeture();
                } else {
                    try {
                        reponses = "<root>";
                        reponses = reponses + "\n<etudiant action=\"" + bouton_ + "\" id=\"" + tfid.getText() + "\">";
                        reponses = reponses + "\n<nom>" + nom + "</nom>";
                        reponses = reponses + "\n<adresse>" + adresse + "</adresse>";
                        reponses = reponses + "\n<bourse>" + solde + "</bourse>";
                        reponses = reponses + "\n</etudiant>";
                        reponses = reponses + "\n</root>";
                        sendMessage(bouton_ + reponses);
                        message = (String) in.readObject();                        
                        if (message.equalsIgnoreCase("ok")) {
                            tfmessage.setText("Enregistrement modifié");                            
                        }
                    } catch (Exception e) {
                        fermeture();
                    } finally {
                        fermeture();
                        chargementTableau();
                    }
                    fermeture();
                }
                this.effacer();
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez remplir les champs vides");
                fermeture();
            }
                fermeture();
        } else {
            JOptionPane.showMessageDialog(this, "démarrer votre serveur");
            createFilexml(bouton_, tfid.getText(), tfnom.getText(), tfadresse.getText(), tfbourse.getText());
        }
        fermeture();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:        
        tfmessage.setText("");
        this.effacer();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaceClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaceClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaceClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaceClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaceClient().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableau;
    private javax.swing.JTextField tfadresse;
    private javax.swing.JTextField tfbourse;
    private javax.swing.JTextField tfid;
    private javax.swing.JLabel tfmessage;
    private javax.swing.JTextField tfnom;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel dt;
    String reponses;

    public void chargementTableau() {

        int test = ouverture();
        if (test != 0) {
            if (file.exists()) {
                try {
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(file);
                    doc.getDocumentElement().normalize();
                    NodeList nList = doc.getElementsByTagName("etudiant");
                    reponses = "<root>";
                    for (int temp = 0; temp < nList.getLength(); temp++) {

                        Node nNode = nList.item(temp);
                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            reponses = reponses + "\n<etudiant action=\"" + eElement.getAttribute("action") + "\" id=\"" + eElement.getAttribute("id") + "\">";
                            reponses = reponses + "\n<nom>" + eElement.getElementsByTagName("nom").item(0).getTextContent() + "</nom>";
                            reponses = reponses + "\n<adresse>" + eElement.getElementsByTagName("adresse").item(0).getTextContent() + "</adresse>";
                            reponses = reponses + "\n<bourse>" + eElement.getElementsByTagName("bourse").item(0).getTextContent() + "</bourse>";
                            reponses = reponses + "\n</etudiant>";
                        }
                    }
                    reponses = reponses + "\n</root>";
                    sendMessage("fich" + reponses);
                    file.delete();
                    message = (String) in.readObject();
                    System.out.println(message);
                    dt = new DefaultTableModel();
                    dt.addColumn("id");
                    dt.addColumn("Nom");
                    dt.addColumn("Adresse");
                    dt.addColumn("Bourse");
                    tableau.setModel(dt);
                    dt.setRowCount(0);
                    try {
                        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        InputSource is = new InputSource();
                        is.setCharacterStream(new StringReader(message));
                        Document doc_ = db.parse(is);
                        NodeList nodes = doc_.getElementsByTagName("etudiant");
                        for (int i = 0; i < nodes.getLength(); i++) {
                            Node nNode = nodes.item(i);
                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element eElement = (Element) nNode;
                                Object[] affiche = {eElement.getAttribute("id"), eElement.getElementsByTagName("nom").item(0).getTextContent(),
                                    eElement.getElementsByTagName("adresse").item(0).getTextContent(), eElement.getElementsByTagName("bourse").item(0).getTextContent()};
                                dt.addRow(affiche);
                            }
                        }
                    } catch (Exception e) {
                    }
                    tableau.setModel(dt);
                    fermeture();
                } catch (Exception ex) {
                    Logger.getLogger(interfaceClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                fermeture();
            } else {
                try {
                    sendMessage("SELECT c FROM Client c");
                    message = (String) in.readObject();
                    System.out.println(message);
                    dt = new DefaultTableModel();
                    dt.addColumn("id");
                    dt.addColumn("Nom");
                    dt.addColumn("Adresse");
                    dt.addColumn("Bourse");
                    tableau.setModel(dt);
                    dt.setRowCount(0);
                    try {
                        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        InputSource is = new InputSource();
                        is.setCharacterStream(new StringReader(message));
                        Document doc = db.parse(is);
                        NodeList nodes = doc.getElementsByTagName("etudiant");
                        for (int i = 0; i < nodes.getLength(); i++) {
                            Node nNode = nodes.item(i);
                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element eElement = (Element) nNode;
                                Object[] affiche = {eElement.getAttribute("id"), eElement.getElementsByTagName("nom").item(0).getTextContent(),
                                    eElement.getElementsByTagName("adresse").item(0).getTextContent(), eElement.getElementsByTagName("bourse").item(0).getTextContent()};
                                dt.addRow(affiche);
                            }
                        }
                    } catch (Exception e) {
                    }
                    tableau.setModel(dt);
                    fermeture();
                } catch (Exception e) {
                } finally {
                    fermeture();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "démarrer votre serveur");
        }
        fermeture();
    }

    void sendMessage(String msg) {
        try {
            out.writeObject(msg);
            out.flush();
            System.out.println("client>" + msg);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void fermeture() {
        try {
            in.close();
            out.close();
            requestSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(interfaceClient.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int ouverture() {
        int i = 1;
        try {
            ImageIcon im = new ImageIcon("D:\\M1\\ProjetLinjaClient\\img\\ball.vert.gif");
            this.setIconImage(im.getImage());
            this.setTitle("Connecté");
            requestSocket = new Socket("localhost", 2004);
            System.out.println("Connected to localhost in port 2004");
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(interfaceClient.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ImageIcon im = new ImageIcon("D:\\M1\\ProjetLinjaClient\\img\\ball.gray.gif");
            this.setIconImage(im.getImage());
            this.setTitle("Déconnecté");
            i = 0;
            Logger.getLogger(interfaceClient.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public void effacer() {
        tfadresse.setText("");
        tfid.setText("0");
        tfnom.setText("");
        tfbourse.setText("");
        jButton1.setText("Ajouter");
        jButton2.setEnabled(false);
    }

    public void createFilexml(String action, String id, String nom, String adresse, String bourse) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);

            Element staff = doc.createElement("etudiant");
            rootElement.appendChild(staff);
            Attr attr = doc.createAttribute("action");
            attr.setValue(action);
            staff.setAttributeNode(attr);
            attr = doc.createAttribute("id");
            attr.setValue(id);
            staff.setAttributeNode(attr);
            Element firstname = doc.createElement("nom");
            firstname.appendChild(doc.createTextNode(nom));
            staff.appendChild(firstname);

            Element lastname = doc.createElement("adresse");
            lastname.appendChild(doc.createTextNode(adresse));
            staff.appendChild(lastname);

            Element nickname = doc.createElement("bourse");
            nickname.appendChild(doc.createTextNode(bourse));
            staff.appendChild(nickname);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\file.xml"));

            // Output to console for testing             
            transformer.transform(source, result);

            System.out.println("File saved!");
        } catch (Exception e) {
        }
    }
}