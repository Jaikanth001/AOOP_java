package com.todolist;

import java.util.ArrayList;
import java.util.List;

public class ToDoListApplication {
    private List<String> tasks = new ArrayList<>();

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
	        ToDoListApplication toDoList = new ToDoListApplication();
	
	        // Example usage
	        toDoList.addTask("Buy groceries");
	        toDoList.addTask("Go to the gym");
	        toDoList.updateTask(0, "Buy groceries and cook dinner");
	        toDoList.removeTask(1);
	        toDoList.displayTasks();
	    }

  
}
