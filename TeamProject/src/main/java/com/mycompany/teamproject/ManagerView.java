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
public class ManagerView extends JFrame {

    private IELTS_Exercises exercises;

    public ManagerView(IELTS_Exercises exercises) {
        setTitle("Manager Dashboard");
        setSize(500, 400);
        setLayout(new BorderLayout());
        this.exercises = exercises;
        add(createExercisesPanel(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel createExercisesPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1)); // 1 column, many rows
        for (Exercise exercise : exercises.getExercises()) {
            JPanel exercisePanel = new JPanel(new FlowLayout());
            JLabel label = new JLabel(exercise.getQuestion());
            JButton editButton = new JButton("Edit");
            editButton.addActionListener(e -> editExercise(exercise));
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(e -> deleteExercise(exercise));
            exercisePanel.add(label);
            exercisePanel.add(editButton);
            exercisePanel.add(deleteButton);
            panel.add(exercisePanel);
        }
        JButton addButton = new JButton("Add New Exercise");
        addButton.addActionListener(e -> addExercise());
        panel.add(addButton);
        return panel;
    }

    private void editExercise(Exercise exercise) {
        new EditExerciseFrame(exercise, exercises).setVisible(true);
    }

    private void deleteExercise(Exercise exercise) {
        exercises.getExercises().remove(exercise);
        refreshView();
    }

    private void addExercise() {
        new EditExerciseFrame(new Exercise("", "", "", "", "", "", ""), exercises).setVisible(true);
    }

    private void refreshView() {
        getContentPane().removeAll();
        add(createExercisesPanel());
        revalidate();
        repaint();
    }
}
