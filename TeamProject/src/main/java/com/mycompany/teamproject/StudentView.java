/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teamproject;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentView extends JPanel {

    private JComboBox<String> examComboBox;
    private JButton openExamButton;

    public StudentView() {
        setLayout(new BorderLayout());

        // Exam selection panel
        JPanel examPanel = new JPanel();
        examPanel.add(new JLabel("Choose Exam:"));
        examComboBox = new JComboBox<>(new String[]{"Exam 1", "Exam 2", "Exam 3"});
        examPanel.add(examComboBox);
        add(examPanel, BorderLayout.NORTH);

        // Open exam button
        openExamButton = new JButton("Open Exam");
        openExamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openExam();
            }
        });
        add(openExamButton, BorderLayout.SOUTH);
    }

    private void openExam() {
        String selectedExam = (String) examComboBox.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Opening " + selectedExam);
        // Add logic to open and display the selected exam content
    }
}
