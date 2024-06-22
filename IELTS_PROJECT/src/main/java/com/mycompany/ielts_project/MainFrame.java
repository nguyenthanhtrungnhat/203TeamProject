/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ielts_project;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import net.miginfocom.swing.MigLayout;

public class MainFrame extends javax.swing.JFrame {

    private ManageOwner manageOwner = new ManageOwner();

    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        // Initialize manageOwner and load existing owners
        manageOwner = new ManageOwner();
        ImageIcon icon = new ImageIcon(".\\src\\main\\java\\icon\\logo1.png");
        if (icon != null) {
            Big_logo_signinpage.setIcon(icon);
        }
        ImageIcon logo = new ImageIcon(".\\src\\main\\java\\icon\\logo-01.png");
        setIconImage(logo.getImage());
        loadOwners();

    }

    private void loadOwners() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Account.Dat"))) {
            manageOwner.setListOwner((ArrayList<Owner>) ois.readObject());
        } catch (FileNotFoundException e) {
            // File does not exist, this might be normal on first run
            manageOwner.setListOwner(new ArrayList<>());
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error loading owners from file: " + e.getMessage());
            manageOwner.setListOwner(new ArrayList<>()); // Reset list on error
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPasswd = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        myCombobox = new javax.swing.JComboBox<>();
        btnSignup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        rdShowpass = new javax.swing.JRadioButton();
        btnRefresh = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Big_logo_signinpage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ReadPeak");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 234, 221));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 234, 221));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel3.setFont(new java.awt.Font("MHei PRC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOGIN");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("User");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("PassWord");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 102, 102));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 234, 221));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        myCombobox.setBackground(new java.awt.Color(255, 102, 102));
        myCombobox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        myCombobox.setForeground(new java.awt.Color(255, 234, 221));
        myCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Manager" }));
        myCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myComboboxActionPerformed(evt);
            }
        });

        btnSignup.setBackground(new java.awt.Color(255, 102, 102));
        btnSignup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(255, 234, 221));
        btnSignup.setText("Signup");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(105, 105, 105));
        jLabel4.setText("Welcome ReadPeak");

        btnExit.setBackground(new java.awt.Color(255, 60, 60));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 234, 221));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        rdShowpass.setText("Show password");
        rdShowpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdShowpassActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdShowpass)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(myCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSignup, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdShowpass)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin)
                    .addComponent(btnSignup))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnRefresh))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(400, 0, 400, 490);

        jPanel5.setBackground(new java.awt.Color(255, 137, 137));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 500));

        Big_logo_signinpage.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(0, 350, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Big_logo_signinpage)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(59, 59, 59)
                .addComponent(Big_logo_signinpage)
                .addGap(91, 91, 91))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Constants for fixed values
        final String ADMIN_USERNAME = "admin";
        final String ADMIN_PASSWORD = "admin";
        final String ROLE_MANAGER = "Manager";
        final String ROLE_STUDENT = "Student";
        String selectedRole = myCombobox.getSelectedItem().toString();
        String username = txtUser.getText();
        char[] passwordArray = txtPasswd.getPassword(); // JPasswordField method
        String password = new String(passwordArray); // Convert char array to String
        if (txtUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username can not be empty");
            txtUser.requestFocus();
            return;
        } else if (txtUser.getText().contains(" ")) {
            JOptionPane.showMessageDialog(this, "Username can not contain space");
            txtUser.requestFocus();
            return;
        } else if (txtPasswd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password can not be empty");
            txtPasswd.requestFocus();
            return;
        } else {
            if (selectedRole.equals(ROLE_MANAGER)) {
                // Validate the username and password for Manager role
                if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    JOptionPane.showMessageDialog(null, "Successful!");
                    ManagerView managerView = new ManagerView(this, true);
                    managerView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password, try again!");
                }
            } else if (selectedRole.equals(ROLE_STUDENT)) {
                if (!username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    JOptionPane.showMessageDialog(null, "Wrong role, please choose again!");
                } else {
                    if (checkUsername()) {
                        if (checkPassword()) {
                            JOptionPane.showMessageDialog(this, "Login successfully");
                            StudentView studentView = new StudentView(this, true);
                            studentView.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Wrong Password");
                            txtPasswd.requestFocus();
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong Username");
                        txtUser.requestFocus();
                        return;
                    }
                }
            }
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        SignUpDialog s = new SignUpDialog(this, true);
        s.setVisible(true);
    }//GEN-LAST:event_btnSignupActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void myComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myComboboxActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       System.exit(0);
      //  dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void rdShowpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdShowpassActionPerformed
        if (rdShowpass.isSelected()) {
            txtPasswd.setEchoChar((char) 0); // Show the password
        } else {
            txtPasswd.setEchoChar('*'); // Hide the password
        }
    }//GEN-LAST:event_rdShowpassActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadOwners();
        JOptionPane.showMessageDialog(null, "Refreshed");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private boolean checkUsername() {
        for (Owner owner : manageOwner.getListOwner()) {
            if (owner.getUsername().equals(txtUser.getText().trim())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPassword() {
        for (Owner owner : manageOwner.getListOwner()) {
            if (owner.getUsername().equals(txtUser.getText().trim()) && owner.getPassword().equals(txtPasswd.getText().trim())) {
                return true;
            }
        }
        return false;
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Big_logo_signinpage;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> myCombobox;
    private javax.swing.JRadioButton rdShowpass;
    private javax.swing.JPasswordField txtPasswd;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

//    private void setIconImage() {
//        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo-01.png")));
//        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo-01.png")));
//    }
}
