/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teamproject;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class StudentView extends JFrame {

    public StudentView() {
        setTitle("Student View");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame

        JPanel examSelectionPanel = createExamSelectionPanel();
        add(examSelectionPanel);
    }

    private JPanel createExamSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel titleLabel = new JLabel("Choose an exam:");
        panel.add(titleLabel);

        // Add buttons or dropdown menu for exam selection
        JButton exam1Button = new JButton("Exam 1");
        JButton exam2Button = new JButton("Exam 2");
        JButton exam3Button = new JButton("Exam 3");
        JButton exam4Button = new JButton("Exam 4");

        exam1Button.addActionListener(e -> openExam("Exam 1"));
        exam2Button.addActionListener(e -> openExam("Exam 2"));
        exam3Button.addActionListener(e -> openExam("Exam 3"));
        exam4Button.addActionListener(e -> openExam("Exam 4"));

        panel.add(exam1Button);
        panel.add(exam2Button);
        panel.add(exam3Button);
        panel.add(exam4Button);

        return panel;
    }

    private void openExam(String examName) {
        // Open the chosen exam with content and fillable boxes
        // You can create a new frame or panel for this purpose
        JFrame examFrame = new JFrame(examName);
        examFrame.setSize(600, 400);
        // Add content and fillable boxes for answers
        // ...
        examFrame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new StudentView().setVisible(true);
        });
    }
}
