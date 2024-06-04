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

public class MainFrame extends JFrame {

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

        loginPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        loginPanel.add(usernameField);

        loginPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        loginPanel.add(passwordField);

        studentRadioButton = new JRadioButton("Student", true);
        managerRadioButton = new JRadioButton("Manager");
        roleGroup = new ButtonGroup();
        roleGroup.add(studentRadioButton);
        roleGroup.add(managerRadioButton);
        JPanel rolePanel = new JPanel(new FlowLayout());
        rolePanel.add(studentRadioButton);
        rolePanel.add(managerRadioButton);
        loginPanel.add(rolePanel);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        loginPanel.add(loginButton);

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
        if (account != null) {
            if (account.isManager() == isManager) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                if (isManager) {
                    openManagerView();
                } else {
                    openStudentView();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid role!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!");
        }
    }

    private void openStudentView() {
        EventQueue.invokeLater(() -> {
            new StudentView().setVisible(true);
        });
    }

    private void openManagerView() {
        EventQueue.invokeLater(() -> {
            new ManagerView().setVisible(true);
        });
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
