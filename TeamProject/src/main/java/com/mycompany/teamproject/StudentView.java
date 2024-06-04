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
import java.util.List;
public class StudentView extends JFrame{
     private List<Exercise> exercises;

    public StudentView(List<Exercise> exercises) {
        setTitle("Student Dashboard");
        setSize(500, 400);
        setLayout(new BorderLayout());
        this.exercises = exercises;
        add(createExercisePanel(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel createExercisePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Exercise exercise : exercises) {
            JButton button = new JButton(exercise.getQuestion());
            button.addActionListener(e -> openExercise(exercise));
            panel.add(button);
        }
        return panel;
    }

    private void openExercise(Exercise exercise) {
        new ExerciseFrame(exercise).setVisible(true);
    }
}
