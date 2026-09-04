import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Task {

    private int id;
    private String title;
    private String description;
    private String status;

    public Task(int id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toFileFormat() {
        return id + "|" + title + "|" + description + "|" + status;
    }

    public void display() {

        System.out.println("--------------------------------");
        System.out.println("Task ID     : " + id);
        System.out.println("Title       : " + title);
        System.out.println("Description : " + description);
        System.out.println("Status      : " + status);
        System.out.println("--------------------------------");
    }
}

public class PersistentTaskManager {

    private static final String FILE_NAME = "tasks.txt";

    private static ArrayList<Task> tasks = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadTasks();

        System.out.println("======================================");
        System.out.println("   COGNIFYZ PERSISTENT TASK MANAGER");
        System.out.println("======================================");

        boolean running = true;

        while (running) {

            showMenu();

            int choice = readInteger("Enter your choice: ");

            switch (choice) {

                case 1:
                    createTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    updateTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    saveTasks();
                    System.out.println("\nThank you for using Persistent Task Manager!");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select 1 to 5.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {

        System.out.println("\n========== MENU ==========");
        System.out.println("1. Create Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Update Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.println("==========================");
    }

    private static void createTask() {

        int id = getNextId();

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter task status: ");
        String status = scanner.nextLine();

        Task task = new Task(id, title, description, status);

        tasks.add(task);

        if (saveTasks()) {

            System.out.println("\nTask created and saved successfully!");
            System.out.println("Task ID: " + id);

        } else {

            System.out.println("\nTask created, but could not be saved.");
        }
    }

    private static void viewTasks() {

        System.out.println("\n========== TASK LIST ==========");

        if (tasks.isEmpty()) {

            System.out.println("No tasks available.");
            return;
        }

        for (Task task : tasks) {
            task.display();
        }
    }

    private static void updateTask() {

        if (tasks.isEmpty()) {

            System.out.println("\nNo tasks available to update.");
            return;
        }

        int id = readInteger("Enter Task ID to update: ");

        Task task = findTask(id);

        if (task == null) {

            System.out.println("\nTask not found.");
            return;
        }

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new description: ");
        String description = scanner.nextLine();

        System.out.print("Enter new status: ");
        String status = scanner.nextLine();

        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);

        if (saveTasks()) {

            System.out.println("\nTask updated and saved successfully!");

        } else {

            System.out.println("\nTask updated, but could not be saved.");
        }
    }

    private static void deleteTask() {

        if (tasks.isEmpty()) {

            System.out.println("\nNo tasks available to delete.");
            return;
        }

        int id = readInteger("Enter Task ID to delete: ");

        Task task = findTask(id);

        if (task == null) {

            System.out.println("\nTask not found.");
            return;
        }

        tasks.remove(task);

        if (saveTasks()) {

            System.out.println("\nTask deleted and changes saved successfully!");

        } else {

            System.out.println("\nTask deleted, but could not save changes.");
        }
    }

    private static Task findTask(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }

    private static int getNextId() {

        int maxId = 0;

        for (Task task : tasks) {

            if (task.getId() > maxId) {
                maxId = task.getId();
            }
        }

        return maxId + 1;
    }

    private static int readInteger(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static boolean saveTasks() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Task task : tasks) {

                writer.write(task.toFileFormat());
                writer.newLine();
            }

            return true;

        } catch (IOException e) {

            System.out.println("Error saving tasks: " + e.getMessage());

            return false;
        }
    }

    private static void loadTasks() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            System.out.println("No existing task file found.");
            System.out.println("A new task file will be created.");

            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length == 4) {

                    try {

                        int id = Integer.parseInt(data[0]);

                        Task task = new Task(
                                id,
                                data[1],
                                data[2],
                                data[3]
                        );

                        tasks.add(task);

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Skipping invalid task record."
                        );
                    }
                }
            }

            System.out.println("Tasks loaded successfully from file.");

        } catch (IOException e) {

            System.out.println(
                    "Error loading tasks: " + e.getMessage()
            );
        }
    }
}