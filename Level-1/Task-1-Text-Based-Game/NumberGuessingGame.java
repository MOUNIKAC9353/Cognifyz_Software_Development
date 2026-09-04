import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        System.out.println("======================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("======================================");

        while (playAgain) {

            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println();
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !guessedCorrectly) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == secretNumber) {

                    guessedCorrectly = true;

                    System.out.println();
                    System.out.println("Congratulations!");
                    System.out.println("You guessed the correct number.");
                    System.out.println("Attempts used: " + attempts);

                } else if (guess < secretNumber) {

                    System.out.println("Too low! Try a higher number.");

                } else {

                    System.out.println("Too high! Try a lower number.");
                }

                if (!guessedCorrectly) {
                    System.out.println("Attempts remaining: "
                            + (maxAttempts - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println();
                System.out.println("Game Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println();
        System.out.println("======================================");
        System.out.println("       Thank you for playing!");
        System.out.println("======================================");

        scanner.close();
    }
}