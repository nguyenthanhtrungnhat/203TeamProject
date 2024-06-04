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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManagerView extends JFrame {

    public ManagerView() {
        setTitle("Manager View");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close to close only this window
        setLocationRelativeTo(null);  // Center the frame
        setLayout(new BorderLayout());
        add(createManagerPanel(), BorderLayout.CENTER);
    }

    private JPanel createManagerPanel() {
        JPanel managerPanel = new JPanel();
        managerPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton addExerciseButton = new JButton("Add Exercise");
        addExerciseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IELTS_Exercises iELTS_Exercises=new IELTS_Exercises();
                iELTS_Exercises.loadExercisesFromFile();
                
            }
        }); 
        managerPanel.add(addExerciseButton);

        JButton editExerciseButton = new JButton("Edit Exercise");
        editExerciseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle editing exercises
            }
        });
        managerPanel.add(editExerciseButton);

        JButton manageAccountsButton = new JButton("Manage Accounts");
        manageAccountsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle managing accounts
            }
        });
        managerPanel.add(manageAccountsButton);

        return managerPanel;
    }
   
}
