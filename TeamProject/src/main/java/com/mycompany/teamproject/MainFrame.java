/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teamproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
/**
 *
 * @author Phan Thao
 */
public class MainFrame extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton createAccountButton;
    private JRadioButton studentRadioButton;
    private JRadioButton managerRadioButton;
    private ButtonGroup roleGroup;

    public MainFrame() {
        setTitle("IELTS Reading Practice App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame
        setLayout(new BorderLayout());
        add(createLoginPanel(), BorderLayout.CENTER);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(6, 1, 10, 10));

        // Username field
        loginPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        loginPanel.add(usernameField);

        // Password field
        loginPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        loginPanel.add(passwordField);

        // Radio buttons for role selection
        studentRadioButton = new JRadioButton("Student", true);
        managerRadioButton = new JRadioButton("Manager");
        roleGroup = new ButtonGroup();
        roleGroup.add(studentRadioButton);
        roleGroup.add(managerRadioButton);
        JPanel rolePanel = new JPanel(new FlowLayout());
        rolePanel.add(studentRadioButton);
        rolePanel.add(managerRadioButton);
        loginPanel.add(rolePanel);

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        loginPanel.add(loginButton);

        // Create account button
        createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
        loginPanel.add(createAccountButton);

        return loginPanel;
    }

    private void login() {
        String username = usernameField.getText();
    String password = new String(passwordField.getPassword());
    boolean isManager = managerRadioButton.isSelected();

    Account account = Account.login(username, password);
    if (account != null && account.isManager() == isManager) {
        JOptionPane.showMessageDialog(this, "Login successful!");
        dispose(); // Close the login window
        if (isManager) {
            new ManagerView(new IELTS_Exercises()).setVisible(true); // Assuming IELTS_Exercises is properly initialized
        } else {
            new StudentView(new ArrayList<>()).setVisible(true); // Assuming an empty list of exercises for simplicity
        }
    } else {
        JOptionPane.showMessageDialog(this, "Invalid credentials or role!");
    }
    }

    private void createAccount() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        boolean isManager = managerRadioButton.isSelected();

        boolean success = Account.createNewAccount(username, password, isManager);
        if (success) {
            JOptionPane.showMessageDialog(this, "Account created successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Account creation failed!");
        }
    }
    class StudentView extends JFrame {
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

    class ManagerView extends JFrame {
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
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
