/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Exams;

import com.mycompany.ielts_project.ListStudent;
import com.mycompany.ielts_project.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class Exam3 extends javax.swing.JDialog {

    private ListStudent listStudent = new ListStudent();
    private Timer timer;

    /**
     * Creates new form Exam3
     */
    public Exam3(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblBody.setEditable(false);
        lblBody.setLineWrap(true); // Set line wrap to true
        lblBody.setWrapStyleWord(true); // Wrap on word boundaries

        loadTextFromFile("example3.txt");
        ImageIcon logo = new ImageIcon(".\\src\\main\\java\\icon\\logo-01.png");
        setIconImage(logo.getImage());
    }

    private void saveList() {
          try (BufferedWriter writer = new BufferedWriter(new FileWriter("ListStudent.txt", true))) {
            for (Student student : listStudent.getList()) {
                writer.write("Name: " + student.getName() + ", Age: " + student.getAge() + ", " + student.getScore() + ", Exam Type: " + student.getExamType());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Student list saved successfully to ListStudent.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving student list to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // For debugging purposes
        }
    }

    private void loadTextFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n"); // Append newline to each line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        lblBody.setText(content.toString().trim());
        lblBody.setCaretPosition(0); // Set caret position to the beginning
    }

    private void compareTextToFile() {
        String fileContent = readTextFromFile("answer3.txt");
        String[] answers = fileContent.split("\n");

        int totalPoints = 0;
        int pointsPerAnswer = 1;

        if (answers[0].equals(txtQ1.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[1].equals(txtQ2.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[2].equals(txtQ3.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[3].equals(txtQ4.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[4].equals(txtQ5.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[5].equals(txtQ6.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[6].equals(txtQ7.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[7].equals(txtQ8.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[8].equals(txtQ9.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[9].equals(txtQ10.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[10].equals(txtQ11.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[11].equals(txtQ12.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }
        if (answers[12].equals(txtQ13.getText().trim())) {
            totalPoints += pointsPerAnswer;
        }

        lblResult.setText("Total Points: " + totalPoints + "/13 questions");
    }

    private String readTextFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n"); // Append newline to each line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString().trim();
    }

    private void countdownTimer() {
        timer = new Timer(1000, new ActionListener() {
            int minutes = 20;
            int seconds = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;
                if (seconds < 0) {
                    seconds = 59;
                    minutes--;
                }
                if (minutes < 0) {
                    ((Timer) e.getSource()).stop();
                    lblTime.setText("00:00");
                    JOptionPane.showMessageDialog(null, "Time is up! Please submit.");
                    // Set text fields to be uneditable
                    txtQ1.setEditable(false);
                    txtQ2.setEditable(false);
                    txtQ3.setEditable(false);
                    txtQ4.setEditable(false);
                    txtQ5.setEditable(false);
                    txtQ6.setEditable(false);
                    txtQ7.setEditable(false);
                    txtQ8.setEditable(false);
                    txtQ9.setEditable(false);
                    txtQ10.setEditable(false);
                    txtQ11.setEditable(false);
                    txtQ12.setEditable(false);
                    txtQ13.setEditable(false);
                    return;
                }
                lblTime.setText(String.format("%02d:%02d", minutes, seconds));
            }
        });
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtExamType = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        btnShow = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblBody = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtQ1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtQ2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtQ3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQ4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtQ5 = new javax.swing.JTextField();
        txtQ6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtQ7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQ8 = new javax.swing.JTextField();
        txtQ9 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtQ10 = new javax.swing.JTextField();
        txtQ11 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtQ12 = new javax.swing.JTextField();
        txtQ13 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 234, 221));
        jPanel3.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 234, 221));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Student Infomation");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Name");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Age");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Exam");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(42, 42, 42)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtExamType, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtAge))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExamType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2);
        jPanel2.setBounds(700, 480, 190, 230);

        jPanel1.setBackground(new java.awt.Color(255, 234, 221));

        btnSubmit.setBackground(new java.awt.Color(255, 137, 137));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 234, 221));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblResult.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblResult.setForeground(new java.awt.Color(102, 102, 102));
        lblResult.setText("Total result:");

        btnShow.setBackground(new java.awt.Color(255, 137, 137));
        btnShow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnShow.setForeground(new java.awt.Color(255, 234, 221));
        btnShow.setText("Show all answers");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(102, 102, 102));
        lblTime.setText("The time count down");

        btnStart.setBackground(new java.awt.Color(255, 137, 137));
        btnStart.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 234, 221));
        btnStart.setText("Start");
        btnStart.setActionCommand("btnStart");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 60, 60));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 234, 221));
        btnExit.setText("Exit Exam");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTime)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblResult)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addGap(86, 86, 86))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTime)
                .addGap(34, 34, 34)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblResult)
                .addGap(18, 18, 18)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1);
        jPanel1.setBounds(420, 380, 253, 390);

        lblBody.setBackground(new java.awt.Color(255, 237, 235));
        lblBody.setColumns(20);
        lblBody.setForeground(new java.awt.Color(51, 51, 51));
        lblBody.setRows(5);
        jScrollPane1.setViewportView(lblBody);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 930, 320);

        jLabel1.setText("Question 27");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(60, 380, 69, 16);
        jPanel3.add(txtQ1);
        txtQ1.setBounds(130, 380, 241, 22);

        jLabel2.setText("Question 28");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(60, 410, 69, 16);
        jPanel3.add(txtQ2);
        txtQ2.setBounds(130, 410, 241, 22);

        jLabel3.setText("Question 29");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(60, 440, 63, 16);
        jPanel3.add(txtQ3);
        txtQ3.setBounds(130, 440, 241, 22);

        jLabel4.setText("Question 30");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(60, 470, 63, 16);
        jPanel3.add(txtQ4);
        txtQ4.setBounds(130, 470, 241, 22);

        jLabel5.setText("Question 31");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(60, 510, 63, 16);
        jPanel3.add(txtQ5);
        txtQ5.setBounds(130, 500, 241, 22);
        jPanel3.add(txtQ6);
        txtQ6.setBounds(130, 530, 241, 22);

        jLabel6.setText("Question 32");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(60, 530, 63, 16);

        jLabel7.setText("Question 33");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(60, 560, 63, 16);
        jPanel3.add(txtQ7);
        txtQ7.setBounds(130, 560, 241, 22);

        jLabel8.setText("Question 34");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(60, 590, 63, 16);
        jPanel3.add(txtQ8);
        txtQ8.setBounds(130, 590, 241, 22);
        jPanel3.add(txtQ9);
        txtQ9.setBounds(130, 620, 241, 22);

        jLabel9.setText("Question 35");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(60, 620, 63, 16);

        jLabel10.setText("Question 36");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(60, 650, 63, 16);
        jPanel3.add(txtQ10);
        txtQ10.setBounds(130, 640, 241, 22);
        jPanel3.add(txtQ11);
        txtQ11.setBounds(130, 670, 241, 22);

        jLabel11.setText("Question 37");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(60, 670, 63, 16);

        jLabel12.setText("Question 37");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(60, 700, 63, 16);
        jPanel3.add(txtQ12);
        txtQ12.setBounds(130, 700, 241, 22);
        jPanel3.add(txtQ13);
        txtQ13.setBounds(130, 730, 241, 22);

        jLabel13.setText("Question 39");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(60, 730, 63, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
boolean startPressed = false;
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
         if (startPressed == false) {
            JOptionPane.showMessageDialog(null, "You must Start first!");
        } else {
            // Check if required fields are filled
            if (!txtName.getText().isEmpty() && !txtAge.getText().isEmpty() && !txtExamType.getText().isEmpty()) {
                // Stop the timer if running
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
                // Perform your submission logic (e.g., compareTextToFile())
                compareTextToFile();
                startPressed = false;
                String name = txtName.getText().toString();
                String age = txtAge.getText().toString();

                String score = lblResult.getText().toString();
                String examType = txtExamType.getText().toString();
                Student student = new Student(name, age, score, examType);
                listStudent.Add(student);
                saveList();

            } else {
                // Show error message
                JOptionPane.showMessageDialog(this, "All required fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);

                // Focus on the first empty field
                if (txtName.getText().isEmpty()) {
                    txtName.requestFocusInWindow();
                } else if (txtAge.getText().isEmpty()) {
                    txtAge.requestFocusInWindow();
                } else if (txtExamType.getText().isEmpty()) {
                    txtExamType.requestFocusInWindow();
                }
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // Read answers from the file
        String fileContent = readTextFromFile("answer.txt");
        String[] answers = fileContent.split("\n");

        if (!txtQ1.getText().isEmpty() && !txtQ2.getText().isEmpty() && !txtQ3.getText().isEmpty()
                && !txtQ4.getText().isEmpty() && !txtQ8.getText().isEmpty() && !txtQ9.getText().isEmpty()
                && !txtQ10.getText().isEmpty() && !txtQ11.getText().isEmpty() && !txtQ12.getText().isEmpty()
                && !txtQ13.getText().isEmpty()) {
            // Show answers in the text fields and combo boxes
            txtQ1.setText(answers[0]);
            txtQ2.setText(answers[1]);
            txtQ3.setText(answers[2]);
            txtQ4.setText(answers[3]);
            txtQ5.setText(answers[4]);
            txtQ6.setText(answers[5]);
            txtQ7.setText(answers[6]);
            txtQ8.setText(answers[7]);
            txtQ9.setText(answers[8]);
            txtQ10.setText(answers[9]);
            txtQ11.setText(answers[10]);
            txtQ12.setText(answers[11]);
            txtQ13.setText(answers[12]);
        } else {
            JOptionPane.showMessageDialog(this, "All questions must be answered.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if (startPressed == false) {
            startPressed = true;
            txtQ1.setText(null);
            txtQ2.setText(null);
            txtQ3.setText(null);
            txtQ4.setText(null);
            txtQ5.setText(null);
            txtQ6.setText(null);
            txtQ7.setText(null);
            txtQ8.setText(null);
            txtQ9.setText(null);
            txtQ10.setText(null);
            txtQ11.setText(null);
            txtQ12.setText(null);
            txtQ13.setText(null);
            countdownTimer();
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       startPressed = false;
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Exam3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Exam3 dialog = new Exam3(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lblBody;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtExamType;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQ1;
    private javax.swing.JTextField txtQ10;
    private javax.swing.JTextField txtQ11;
    private javax.swing.JTextField txtQ12;
    private javax.swing.JTextField txtQ13;
    private javax.swing.JTextField txtQ2;
    private javax.swing.JTextField txtQ3;
    private javax.swing.JTextField txtQ4;
    private javax.swing.JTextField txtQ5;
    private javax.swing.JTextField txtQ6;
    private javax.swing.JTextField txtQ7;
    private javax.swing.JTextField txtQ8;
    private javax.swing.JTextField txtQ9;
    // End of variables declaration//GEN-END:variables
}
