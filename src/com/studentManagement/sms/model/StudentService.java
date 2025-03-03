package com.studentManagement.sms.model;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Students have been added successfully");
    }

    // Add this method to return the list of students for UI display
    public List<Student> getStudents() {
        return students;
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        System.out.println("Student List:");
        for (Student s : students) {
            s.displayInfo();
        }
    }
}