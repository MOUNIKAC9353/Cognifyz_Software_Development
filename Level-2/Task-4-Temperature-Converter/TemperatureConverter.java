import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;
        double temperature;
        double result;

        System.out.println("======================================");
        System.out.println("       COGNIFYZ TEMPERATURE CONVERTER");
        System.out.println("======================================");

        System.out.println("\nChoose conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Exit");

        System.out.print("\nEnter your choice: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid choice.");
            scanner.next();
            System.out.print("Enter your choice: ");
        }

        choice = scanner.nextInt();

        switch (choice) {

            case 1:

                System.out.print("Enter temperature in Celsius: ");

                while (!scanner.hasNextDouble()) {
                    System.out.println("Please enter a valid temperature.");
                    scanner.next();
                    System.out.print("Enter temperature in Celsius: ");
                }

                temperature = scanner.nextDouble();

                result = (temperature * 9 / 5) + 32;

                System.out.printf(
                    "Temperature in Fahrenheit: %.2f°F%n",
                    result
                );

                break;

            case 2:

                System.out.print("Enter temperature in Fahrenheit: ");

                while (!scanner.hasNextDouble()) {
                    System.out.println("Please enter a valid temperature.");
                    scanner.next();
                    System.out.print("Enter temperature in Fahrenheit: ");
                }

                temperature = scanner.nextDouble();

                result = (temperature - 32) * 5 / 9;

                System.out.printf(
                    "Temperature in Celsius: %.2f°C%n",
                    result
                );

                break;

            case 3:

                System.out.println("Thank you for using Temperature Converter!");

                break;

            default:

                System.out.println("Invalid choice. Please select 1, 2 or 3.");
        }

        scanner.close();
    }
}