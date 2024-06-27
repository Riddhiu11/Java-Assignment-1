package org.example;
import java.util.Scanner;

public class TaskList {
    private String[] tasks;
    private boolean[] isCompleted;
    private int taskCount;

    public TaskList(int capacity) {
        tasks = new String[capacity];
        isCompleted = new boolean[capacity];
        taskCount = 0;
    }

    public void addTask(String task) {
        if (taskCount < tasks.length) {
            tasks[taskCount] = task;
            isCompleted[taskCount] = false;
            taskCount++;
        } else {
            System.out.println("Task list is full.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < taskCount) {
            for (int i = index; i < taskCount - 1; i++) {
                tasks[i] = tasks[i + 1];
                isCompleted[i] = isCompleted[i + 1];
            }
            taskCount--;
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < taskCount) {
            isCompleted[index] = true;
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void viewTasks() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + ". " + tasks[i] + " [" + (isCompleted[i] ? "Completed" : "Not Completed") + "]");
        }
    }

    public void viewStatistics() {
        int completedCount = 0;
        for (int i = 0; i < taskCount; i++) {
            if (isCompleted[i]) {
                completedCount++;
            }
        }
        System.out.println("Total tasks: " + taskCount);
        System.out.println("Completed tasks: " + completedCount);
        System.out.println("Percentage completed: " + ((double) completedCount / taskCount * 100) + "%");
    }

    public void sortTasksByCompletion() {
        for (int i = 0; i < taskCount - 1; i++) {
            for (int j = 0; j < taskCount - i - 1; j++) {
                if (isCompleted[j] && !isCompleted[j + 1]) {
                    // Swap tasks
                    String tempTask = tasks[j];
                    tasks[j] = tasks[j + 1];
                    tasks[j + 1] = tempTask;

                    // Swap completion status
                    boolean tempStatus = isCompleted[j];
                    isCompleted[j] = isCompleted[j + 1];
                    isCompleted[j + 1] = tempStatus;
                }
            }
        }
    }
}
