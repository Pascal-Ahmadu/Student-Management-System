package com.studentManagement.sms.model;

public class Main {
    public static void main(String[] args) {
        // Launch the GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            StudentManagementUI frame = new StudentManagementUI();
            frame.setVisible(true);
        });
    }
}