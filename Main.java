package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList(100); // Adjust capacity as needed
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. View Task Statistics");
            System.out.println("6. Sort Tasks by Completion Status");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    taskList.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter the task number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    taskList.removeTask(removeIndex);
                    break;
                case 3:
                    System.out.print("Enter the task number to mark as completed: ");
                    int completeIndex = scanner.nextInt() - 1;
                    taskList.markTaskAsCompleted(completeIndex);
                    break;
                case 4:
                    taskList.viewTasks();
                    break;
                case 5:
                    taskList.viewStatistics();
                    break;
                case 6:
                    taskList.sortTasksByCompletion();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
