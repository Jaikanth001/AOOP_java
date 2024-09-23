package com.taskmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManagementSystem {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void updateTask(int index, String newDescription) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newDescription);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Example usage
        system.addTask("Complete assignment");
        system.addTask("Read a book");
        system.updateTask(0, "Complete Java assignment");
        system.removeTask(1);
        system.displayTasks();
    }
}

