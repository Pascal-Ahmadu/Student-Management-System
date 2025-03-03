package com.studentManagement.sms.model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class StudentManagementUI extends JFrame {
    private final JTextField idField;
    private final JTextField nameField;
    private final JTextField ageField;
    private final DefaultTableModel tableModel;
    private final StudentService studentService;

    public StudentManagementUI() {
        studentService = new StudentService();

        // UI Title
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel (top)
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Student"));

        inputPanel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Student Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        JButton addButton = new JButton("Add Student");
        inputPanel.add(addButton);

        JButton listButton = new JButton("List Students");
        inputPanel.add(listButton);

        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"ID", "NAME", "AGE"}, 0);
        JTable studentTable = new JTable(tableModel);
        add(new JScrollPane(studentTable), BorderLayout.CENTER);

        // Button Listeners
        addButton.addActionListener(_ -> addStudent());

        listButton.addActionListener(_ -> listStudents());
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());

            Student student = new Student(id, name, age);
            studentService.addStudent(student);

            JOptionPane.showMessageDialog(this, "Student added successfully!");
            idField.setText("");
            nameField.setText("");
            ageField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter correct values");
        }
    }

    private void listStudents() {
        List<Student> students = studentService.getStudents();
        tableModel.setRowCount(0);
        for (Student student : students) {
            tableModel.addRow(new Object[]{student.getId(), student.getName(), student.getAge()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentManagementUI frame = new StudentManagementUI();
            frame.setVisible(true);
        });
    }
}