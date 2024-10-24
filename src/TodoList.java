import java.util.ArrayList;
import java.io.*;

public class TodoList {
    private ArrayList<String> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    // Add a task to the list
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Remove a task from the list
    public void removeTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            String removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("\n--- To-Do List ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Save tasks to a file
    public void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
            System.out.println("Tasks saved to tasks.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving tasks.");
        }
    }

    // Load tasks from a file
    public void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            tasks.clear(); // Clear current tasks
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
            System.out.println("Tasks loaded from tasks.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while loading tasks.");
        }
    }
}
