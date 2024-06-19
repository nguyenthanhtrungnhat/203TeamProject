/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ielts_project;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ListStudent {

    private ArrayList<Student> list = new ArrayList<>();

    public ListStudent() {
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    public void Add(Student student) {
        list.add(student);
    }
}
