/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teamproject;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dell
 */
public class Manager extends Account {
    public Manager(String username, String password) {
        super(username, password, true); // Manager always has the manager flag set to true
    }

    // Method to add a new exercise
    public void addExercise(IELTS_Exercises exercises, Exercise newExercise) {
        exercises.addExercise(newExercise);
        System.out.println("New exercise added by Manager.");
    }

    // Method to edit an existing exercise
    public void editExercise(IELTS_Exercises exercises, int index, Exercise updatedExercise) {
        exercises.updateExercise(index, updatedExercise);
        System.out.println("Exercise updated by Manager.");
    }

    // Method to view all exercises (for managerial purposes)
    public void viewAllExercises(IELTS_Exercises exercises) {
        List<Exercise> allExercises = exercises.getExercises();
        allExercises.forEach(exercise -> System.out.println(exercise));
    }

    // Method to manage student accounts: perhaps reset passwords, deactivate accounts, etc.
    public void manageStudentAccount(String username) {
        // Placeholder for managing student accounts
        System.out.println("Managing account for student: " + username);
    }

    // Method to view student performance
    public void viewStudentPerformance() {
        // Placeholder for viewing performance
        System.out.println("Viewing all student performance.");
    }

    // Method to manage content like news, announcements for students
    public void manageContent(String content) {
        // Placeholder for managing content
        System.out.println("Content updated: " + content);
    }
}
