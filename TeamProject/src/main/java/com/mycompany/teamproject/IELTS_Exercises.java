/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teamproject;

/**
 *
 * @author Dell
 */
import java.io.*;
import java.util.*;

public class IELTS_Exercises {
    private List<Exercise> exercises;

    public IELTS_Exercises() {
        this.exercises = new ArrayList<>();
        loadExercisesFromFile();    
    }

    // Load exercises from a file
    public void loadExercisesFromFile() {
        try (Scanner scanner = new Scanner(new File("exercises.txt"));
             Scanner answerScanner = new Scanner(new File("answers.txt"))) {
            while (scanner.hasNextLine() && answerScanner.hasNextLine()) {
                String exerciseData = scanner.nextLine();
                String answerData = answerScanner.nextLine();
                exercises.add(new Exercise(exerciseData.trim(), answerData.split("\\s*,\\s*"))); // Create Exercise with answers
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exercises or answers file not found: " + e.getMessage());
        }
    }

    // Add a new exercise to the list and save to file
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        saveExercisesToFile();
    }

    // Update existing exercise
    public void updateExercise(int index, Exercise newExercise) {
        if (index >= 0 && index < exercises.size()) {
            exercises.set(index, newExercise);
            saveExercisesToFile();
        } else {
            System.out.println("Invalid exercise index.");
        }
    }

    // Save all exercises to a file
    private void saveExercisesToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("exercises.txt"))) {
            for (Exercise exercise : exercises) {
                bw.write(exercise.getExerciseData());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to exercises file: " + e.getMessage());
        }
    }

    // Get a list of all exercises
    public List<Exercise> getExercises() {
        return exercises;
    }

    // Delete an exercise
    public void deleteExercise(int index) {
        if (index >= 0 && index < exercises.size()) {
            exercises.remove(index);
            saveExercisesToFile();
        } else {
            System.out.println("Invalid exercise index.");
        }
    }
}

class Exercise {
    private String exerciseData; // Store the whole line as a single string
    private String[] answers; // Array to store answers

    public Exercise(String exerciseData, String[] answers) {
        this.exerciseData = exerciseData;
        this.answers = answers;
    }

    // Getter for the exercise data
    public String getExerciseData() {
        return exerciseData;
    }

    // Getter for answers
    public String[] getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return exerciseData;
    }
}
