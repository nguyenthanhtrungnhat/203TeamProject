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

public class ExerciseFrame extends JFrame {
    private Exercise exercise;

    public ExerciseFrame(Exercise exercise) {
        setTitle("Exercise");
        setSize(500, 400);
        setLayout(new BorderLayout());
        this.exercise = exercise;
        add(createExercisePanel(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel createExercisePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel(exercise.getQuestion()));
        for (String option : exercise.getOptions()) {
            JCheckBox checkBox = new JCheckBox(option);
            panel.add(checkBox);
        }
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submit());
        panel.add(submitButton);
        return panel;
    }

    private void submit() {
        JOptionPane.showMessageDialog(this, "Submitted!");
        dispose();
    }
}

