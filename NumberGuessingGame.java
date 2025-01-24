import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int totalCorrectGuesses = 0;

        // Main game loop for multiple rounds
        do {
            // Generate random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10; // Limit number of attempts

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            boolean correctGuess = false;

            // Guessing loop
            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    correctGuess = true;
                    System.out.println("Congratulations! You've guessed the number correctly in " + attempts + " attempts.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                if (attempts == maxAttempts && !correctGuess) {
                    System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + targetNumber + ".");
                }
            }

            totalRounds++;
            if (correctGuess) {
                totalCorrectGuesses++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // Consume newline
        } while (scanner.nextLine().equalsIgnoreCase("yes"));

        // Show the score
        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Correct Guesses: " + totalCorrectGuesses);
        double score = ((double) totalCorrectGuesses / totalRounds) * 100;
        System.out.println("Your Score: " + score + "%");
    }
}
