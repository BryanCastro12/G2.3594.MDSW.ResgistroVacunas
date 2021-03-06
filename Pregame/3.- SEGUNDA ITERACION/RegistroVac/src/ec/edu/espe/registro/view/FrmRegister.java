package ec.edu.espe.registro.view;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import static ec.edu.espe.registro.utils.Connection.createConnection;
import static ec.edu.espe.registro.utils.OperationMongoDB.createUser;

import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Sigma Programmers
 */
public class FrmRegister extends javax.swing.JFrame {

    DefaultTableModel model;

    DB db;
    DBCollection collection;
    BasicDBObject document = new BasicDBObject();
    MongoClient mongo = createConnection();

    /**
     * Creates new form FrmRegister
     */
    public FrmRegister() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/mechanic/images/Sigma_64.png"))); // NOI18N
        jButton3.setText("    Sigma Mechanics");
        jButton3.setContentAreaFilled(false);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel3.setText("Password:");

        jLabel2.setText("User:");

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtuser))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnRegister)
                        .addGap(62, 62, 62)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReturn)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnDelete)
                    .addComponent(btnReturn))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JSONArray jrr = new JSONArray();
        Object ob = null;
        JSONParser Jp = new JSONParser();
        //fetch file--
        try {
            FileReader file = new FileReader("UserData.json");
            ob = Jp.parse(file);
            jrr = (JSONArray) ob;
            file.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Occured While fetching");
        }

        JSONObject obj = new JSONObject();
        int size = jrr.size();
        obj.put("Username", txtuser.getText());
        obj.put("Password", txtPassword.getText());

        for (int i = 0; i < size; i++) {
            if (obj.equals(jrr.get(i))) {
                try {
                    FileWriter file = new FileWriter("UserData.json");
                    jrr.remove(i);
                    file.write(jrr.toJSONString());
                    file.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error occured");
                }
                JOptionPane.showMessageDialog(null, "Data Removed");
                break;
            } else if (i == size - 1) {
                JOptionPane.showMessageDialog(null, "Incorrect User/Password!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        FrmLogin login = new FrmLogin();
        this.setVisible(false);
        login.setVisible(true);
        dispose();


    }//GEN-LAST:event_btnReturnActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            FileReader file = new FileReader("UserData.json");
            array = (JSONArray) parser.parse(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error occured");
        }
        jsonObject.put("Username", txtuser.getText());
        jsonObject.put("Password", txtPassword.getText());
        array.add(jsonObject);
        try {
            FileWriter file = new FileWriter("UserData.json");
            file.write(array.toJSONString());
            file.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error occured");
        }
        JOptionPane.showMessageDialog(null, "Data Saved");

        if (txtuser.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "FILL ALL THE FIELDS");
        } else {
            String dataToSave = "Do you want to save this information?\n"
                    + "\nUser: " + txtuser.getText()
                    + "\nPassword: " + txtPassword.getText();

            int selection = JOptionPane.showConfirmDialog(null, dataToSave, "Person Saving",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            switch (selection) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Information was saved", txtuser.getText()
                            + "Saved", JOptionPane.INFORMATION_MESSAGE);

                    createUser(mongo,
                            "Person",
                            "Users",
                            txtuser.getText(),
                            txtPassword.getText());

                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Information was NOT saved", txtuser.getText() + "NOT saved",
                            JOptionPane.INFORMATION_MESSAGE);
                    emptyFields();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Action was cancelled", txtuser.getText() + "Cancelled",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }


    }//GEN-LAST:event_btnRegisterActionPerformed
    public void emptyFields() {
        txtuser.setText("");
        txtPassword.setText("");

    }

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
            java.util.logging.Logger.getLogger(FrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables

    private void createUser(MongoClient mongo, String person, String users, String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
