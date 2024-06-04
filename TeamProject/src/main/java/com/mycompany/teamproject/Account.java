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

public class Account {
    private String username;
    private String password;
    private boolean isManager;

    public Account(String username, String password, boolean isManager) {
        this.username = username;
        this.password = password;
        this.isManager = isManager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    // Save account information to a text file
    public void saveAccountToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt", true))) {
            bw.write(username + "," + password + "," + isManager + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Verify account information with a text file
    public static Account login(String username, String password) {
        try (Scanner scanner = new Scanner(new File("accounts.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] details = line.split(",");
                if (details[0].equals(username) && details[1].equals(password)) {
                    return new Account(details[0], details[1], Boolean.parseBoolean(details[2]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Accounts file not found: " + e.getMessage());
        }
        return null; // return null if no account matches
    }

    // Create a new account and save it to the file if it doesn't exist
    public static boolean createNewAccount(String username, String password, boolean isManager) {
        if (login(username, password) == null) { // Check if the account already exists
            Account newAccount = new Account(username, password, isManager);
            newAccount.saveAccountToFile();
            return true;
        } else {
            System.out.println("Account already exists.");
            return false;
        }
    }

    // Retrieve all accounts from the file
    public static List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("accounts.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] details = line.split(",");
                accounts.add(new Account(details[0], details[1], Boolean.parseBoolean(details[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Accounts file not found: " + e.getMessage());
        }
        return accounts;
    }

    // Delete an account with the given username
    public static boolean deleteAccount(String username) {
        List<Account> accounts = getAllAccounts();
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getUsername().equals(username)) {
                iterator.remove();
                saveAccountsToFile(accounts);
                return true;
            }
        }
        return false; // return false if the account was not found
    }

    // Save accounts to the file
    private static void saveAccountsToFile(List<Account> accounts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt"))) {
            for (Account account : accounts) {
                bw.write(account.getUsername() + "," + account.getPassword() + "," + account.isManager() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
