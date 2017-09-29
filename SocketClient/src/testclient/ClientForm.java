/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author DjazzJah
 */
public class ClientForm extends javax.swing.JFrame {

    /**
     * Creates new form ClientForm
     */
    Socket requestSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    static int verf = 0;
    private File file;

    public ClientForm(int verify) {
        file = new File("D:/M1/SocketClient/json/json.txt");
        verf = verify;
        initComponents();
        this.setResizable(false);
        chargementTableau();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableau = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfnom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfadresse = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        tfsolde = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tfid = new javax.swing.JTextField();
        tfmessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setText("Nom : ");

        jLabel2.setText("Adresse : ");

        tfadresse.setColumns(20);
        tfadresse.setRows(5);
        jScrollPane2.setViewportView(tfadresse);

        jLabel3.setText("Solde : ");

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

        tfid.setEditable(false);
        tfid.setEnabled(false);

        tfmessage.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfnom)
                            .addComponent(tfsolde)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfmessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tfmessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfsolde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(551, 468));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableauMouseClicked
        tfid.setText(tableau.getValueAt(tableau.getSelectedRow(), 0).toString());
        tfnom.setText(tableau.getValueAt(tableau.getSelectedRow(), 1).toString());
        tfadresse.setText(tableau.getValueAt(tableau.getSelectedRow(), 2).toString());
        tfsolde.setText(tableau.getValueAt(tableau.getSelectedRow(), 3).toString());

        if (!tfid.getText().isEmpty()) {
            jButton1.setText("Modifier");
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_tableauMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.effacer();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int test = ouverture();
        if (test != 0) {
            try {
                if (!tfid.getText().isEmpty()) {
                    int rep = JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer id =" + tfid.getText() + "? ", "Boite de Confirmation", JOptionPane.YES_NO_OPTION);
                    if (rep == JOptionPane.YES_OPTION) {
                        sendMessage("supp" + tfid.getText().trim());
                        message = (String) in.readObject();
                        if (message.equalsIgnoreCase("Enregistrement supprimé")) {
                            tfmessage.setText(message);
                            chargementTableau();
                        }
                    }
                    this.effacer();
                }
            } catch (Exception e) {
            } finally {
                fermeture();
            }
        } else {
            JOptionPane.showMessageDialog(this, "démarrer votre serveur", "Attention ...", JOptionPane.ERROR_MESSAGE);
            bt_ = "supp";
            data = tfid.getText();
            json();
        }
        fermeture();
    }//GEN-LAST:event_jButton2ActionPerformed
    String data = "";
    String bt_ = "";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int test = ouverture();
        String nom = tfnom.getText().toUpperCase();
        String adresse = tfadresse.getText();
        if (!nom.equalsIgnoreCase("")) {
            String bt = jButton1.getText();
            int solde = Integer.parseInt(tfsolde.getText());
            if (bt.equalsIgnoreCase("Ajouter")) {
                bt_ = "save";
                data = "[";
                data = data + "{\"nom\":\"";
                data = data + nom;
                data = data + "\",\"adresse\":\"";
                data = data + adresse;
                data = data + "\",\"solde\":\"";
                data = data + solde
                        + "\"},";
                if (data.charAt(data.length() - 1) == ',') {
                    data = data.substring(0, data.length() - 1);
                }
                data = data + "]";

            } else {
                bt_ = "edit";
                int id = Integer.parseInt(tfid.getText().trim());
                data = "[";
                data = data + "{\"id\":\"";
                data = data + id;
                data = data + "\",\"nom\":\"";
                data = data + nom;
                data = data + "\",\"adresse\":\"";
                data = data + adresse;
                data = data + "\",\"solde\":\"";
                data = data + solde
                        + "\"},";
                if (data.charAt(data.length() - 1) == ',') {
                    data = data.substring(0, data.length() - 1);
                }
                data = data + "]";
            }
            this.effacer();
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez remplir les champs vides");
        }
        if (test != 0) {
            try {
                if (bt_.equalsIgnoreCase("save")) {
                    sendMessage(bt_ + data);
                    data = "";
                } else {
                    sendMessage(bt_ + data);
                    data = "";
                }
                message = (String) in.readObject();
                tfmessage.setText(message);
            } catch (Exception e) {
                fermeture();
            } finally {
                fermeture();
                chargementTableau();
            }
            fermeture();
        } else {
            json();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ClientForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientForm(verf).setVisible(true);
//                if (verf != 1) {
//                    new login().setVisible(true);
//                } else {
//                    new ClientForm(verf).setVisible(true);
//                }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableau;
    private javax.swing.JTextArea tfadresse;
    private javax.swing.JTextField tfid;
    private javax.swing.JLabel tfmessage;
    private javax.swing.JTextField tfnom;
    private javax.swing.JTextField tfsolde;
    // End of variables declaration//GEN-END:variables

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
            Logger.getLogger(ClientForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int ouverture() {
        int i = 1;
        try {
            ImageIcon im = new ImageIcon("D:\\M1\\SocketClient\\img\\ok.gif");
            this.setIconImage(im.getImage());
            this.setTitle("Connecté");
            requestSocket = new Socket("localhost", 2004);
            System.out.println("Connected to localhost in port 2004");
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ImageIcon im = new ImageIcon("D:\\M1\\SocketClient\\img\\stop.gif");
            this.setIconImage(im.getImage());
            this.setTitle("Déconnecté");
            i = 0;
            Logger.getLogger(ClientForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    DefaultTableModel dt;

    public void chargementTableau() {

        int test = ouverture();
        if (test != 0) {
            if (file.exists()) {
                try {
                    String ligne, data_ = "";
                    BufferedReader read__ = null;
                    read__ = new BufferedReader(new FileReader(file));
                    while ((ligne = read__.readLine()) != null) {
                        data_ += ligne;
                    }
                    String[] split_ = data_.split(";");
                    for (int i = 0; i < split_.length; i++) {
                        if (test != 0) {                            
                            sendMessage("fich" + split_[i]);                                                       
                        }
                    }
                    
                    message = (String) in.readObject();
                    dt = new DefaultTableModel();
                    dt.addColumn("id");
                    dt.addColumn("Nom");
                    dt.addColumn("Adresse");
                    dt.addColumn("Solde");
                    tableau.setModel(dt);
                    dt.setRowCount(0);
                    JSONArray jArray = new JSONArray(message);
                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject json_data = jArray.getJSONObject(i);
                        Object[] affiche = {Integer.toString(json_data.getInt("id")), (json_data.getString("nom")), (json_data.getString("adresse")), Integer.toString(json_data.getInt("solde"))};
                        dt.addRow(affiche);
                    }
                    tableau.setModel(dt);
                    fermeture();
                    fermeture();
                    read__.close();

                } catch (Exception e) {
                    fermeture();
                } finally {
                    fermeture();
                }
                file.delete();
            } else {
                try {
                    sendMessage("SELECT c FROM Client c");
                    message = (String) in.readObject();
                    dt = new DefaultTableModel();
                    dt.addColumn("id");
                    dt.addColumn("Nom");
                    dt.addColumn("Adresse");
                    dt.addColumn("Solde");
                    tableau.setModel(dt);
                    dt.setRowCount(0);
                    JSONArray jArray = new JSONArray(message);
                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject json_data = jArray.getJSONObject(i);
                        Object[] affiche = {Integer.toString(json_data.getInt("id")), (json_data.getString("nom")), (json_data.getString("adresse")), Integer.toString(json_data.getInt("solde"))};
                        dt.addRow(affiche);
                    }
                    tableau.setModel(dt);
                    fermeture();
                } catch (Exception e) {
                } finally {
                    fermeture();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "démarrer votre serveur", "Attention ...", JOptionPane.ERROR_MESSAGE);
        }
        fermeture();
    }

    public void effacer() {
        tfadresse.setText("");
        tfid.setText("");
        tfnom.setText("");
        tfsolde.setText("");
        jButton1.setText("Ajouter");
        jButton2.setEnabled(false);
    }

    public void json() {
        FileWriter fw = null;
        try {
            String content = bt_ + data;

            // if file doesnt exists, then create it
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();
            } else {
                String ligne, data_ = "";
                BufferedReader read = new BufferedReader(new FileReader(file));
                while ((ligne = read.readLine()) != null) {
                    data_ += ligne;
                }
                data_ += ";";
                read.close();
                fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw_ = new BufferedWriter(fw);
                bw_.write(data_);
                bw_.write(content);
                bw_.close();
            }


//            JOptionPane.showMessageDialog(this, "démarrer votre serveur", "Attention ...", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
