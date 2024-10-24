
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Save Tasks");
            System.out.println("5. Load Tasks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;
                case 2:
                    todoList.displayTasks();
                    System.out.print("Enter the task number to remove: ");
                    int taskNumber = scanner.nextInt();
                    todoList.removeTask(taskNumber);
                    break;
                case 3:
                    todoList.displayTasks();
                    break;
                case 4:
                    todoList.saveTasks();
                    break;
                case 5:
                    todoList.loadTasks();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }
}

