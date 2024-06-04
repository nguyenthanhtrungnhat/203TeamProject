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
public class IELTS_Exercises {
    private List<Exercise> exercises;

    public IELTS_Exercises() {
        this.exercises = new ArrayList<>();
        loadExercisesFromFile();
    }

    // Load exercises from a file
    public void loadExercisesFromFile() {
        try (Scanner scanner = new Scanner(new File("exercises.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] details = line.split(",");
                // Assuming each line in the file is formatted as "question,imagePath,optionA,optionB,optionC,optionD,correctOption"
                if (details.length == 7) {
                    Exercise exercise = new Exercise(details[0], details[1], details[2], details[3], details[4], details[5], details[6]);
                    exercises.add(exercise);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exercises file not found: " + e.getMessage());
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
                bw.write(exercise.toString());
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
}

class Exercise {
    private String question;
    private String imagePath;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;

    public Exercise(String question, String imagePath, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.question = question;
        this.imagePath = imagePath;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    // Getters
    public String getQuestion() {
        return question;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    // Setters
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    @Override
    public String toString() {
        return question + "," + imagePath + "," + optionA + "," + optionB + "," + optionC + "," + optionD + "," + correctOption;
    }
    
}
