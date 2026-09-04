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

    public void displayTask() {

        System.out.println("--------------------------------");
        System.out.println("Task ID     : " + id);
        System.out.println("Title       : " + title);
        System.out.println("Description : " + description);
        System.out.println("Status      : " + status);
    }
}

public class TaskManager {

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        System.out.println("======================================");
        System.out.println("       COGNIFYZ TASK MANAGER");
        System.out.println("       BASIC CRUD APPLICATION");
        System.out.println("======================================");

        do {

            displayMenu();

            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    createTask();
                    break;

                case 2:
                    readTasks();
                    break;

                case 3:
                    updateTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    System.out.println("\nThank you for using Task Manager!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n========== MENU ==========");
        System.out.println("1. Create Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Update Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.println("==========================");
    }

    private static void createTask() {

        int id = tasks.size() + 1;

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter task status: ");
        String status = scanner.nextLine();

        Task task = new Task(id, title, description, status);

        tasks.add(task);

        System.out.println("\nTask created successfully!");
        System.out.println("Task ID: " + id);
    }

    private static void readTasks() {

        if (tasks.isEmpty()) {

            System.out.println("\nNo tasks available.");

            return;
        }

        System.out.println("\n========== TASK LIST ==========");

        for (Task task : tasks) {
            task.displayTask();
        }

        System.out.println("--------------------------------");
    }

    private static void updateTask() {

        if (tasks.isEmpty()) {

            System.out.println("\nNo tasks available to update.");

            return;
        }

        System.out.print("Enter Task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

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

        System.out.println("\nTask updated successfully!");
    }

    private static void deleteTask() {

        if (tasks.isEmpty()) {

            System.out.println("\nNo tasks available to delete.");

            return;
        }

        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Task task = findTask(id);

        if (task == null) {

            System.out.println("\nTask not found.");

            return;
        }

        tasks.remove(task);

        System.out.println("\nTask deleted successfully!");
    }

    private static Task findTask(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }
}