import java.util.Scanner;

public class NumberPattern {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("     NUMBER PATTERN GENERATOR");
        System.out.println("================================");

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("\nNumber Pyramid:\n");

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        scanner.close();
    }
}