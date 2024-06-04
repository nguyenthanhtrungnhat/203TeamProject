/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teamproject;



/**
 *
 * @author Dell
 */
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class StudentView extends JFrame {
    private IELTS_Exercises ieltsExercises;

    public StudentView() {
        setTitle("Student View");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame

        ieltsExercises = new IELTS_Exercises();

        JPanel examSelectionPanel = createExamSelectionPanel();
        add(examSelectionPanel);
    }

    private JPanel createExamSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel titleLabel = new JLabel("Choose an exam:");
        panel.add(titleLabel);

        JButton exam1Button = new JButton("Exam 1");
        JButton exam2Button = new JButton("Exam 2");
        JButton exam3Button = new JButton("Exam 3");
        JButton exam4Button = new JButton("Exam 4");

        exam1Button.addActionListener(e -> openExam(0));
        exam2Button.addActionListener(e -> openExam(1));
        exam3Button.addActionListener(e -> openExam(2));
        exam4Button.addActionListener(e -> openExam(3));

        panel.add(exam1Button);
        panel.add(exam2Button);
        panel.add(exam3Button);
        panel.add(exam4Button);

        return panel;
    }

    private void openExam(int examIndex) {
        List<Exercise> exercises = ieltsExercises.getExercises();

        if (!exercises.isEmpty() && examIndex >= 0 && examIndex < exercises.size()) {
            Exercise exercise = exercises.get(examIndex);
            String[] answers = exercise.getAnswers();

            JFrame examFrame = new JFrame("Exam");
            examFrame.setSize(600, 400);

            JPanel contentPanel = new JPanel(new GridLayout(7, 1));
            JLabel questionLabel = new JLabel("Question: " + exercise.getExerciseData());
            contentPanel.add(questionLabel);

            for (int i = 0; i < answers.length; i++) {
                JLabel answerLabel = new JLabel("Option " + (char) ('A' + i) + ": " + answers[i]);
                contentPanel.add(answerLabel);
            }

            examFrame.add(contentPanel);
            examFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No exercises available for the selected exam!");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new StudentView().setVisible(true);
        });
    }
}
