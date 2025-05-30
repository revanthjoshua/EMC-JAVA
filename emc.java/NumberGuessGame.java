import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int roundsWon = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game - CodSoft Internship Task 1");
        System.out.print("🧑 Please enter your name: ");
        String playerName = scanner.nextLine();

        while (true) {
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean isGuessed = false;

            System.out.println("\n🔢 A number between 1 and 100 has been generated.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                    isGuessed = true;
                    roundsWon++;
                    break;
                } else {
                    int difference = userGuess - numberToGuess;

                    if (difference >= 20) {
                        System.out.println("🔺 Too High!");
                    } else if (difference > 0) {
                        System.out.println("🔼 High!");
                    } else if (difference <= -20) {
                        System.out.println("🔻 Too Low!");
                    } else {
                        System.out.println("🔽 Low!");
                    }

                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (!isGuessed) {
                System.out.println("❌ You've used all attempts. The correct number was: " + numberToGuess);
            }

            totalRounds++;

            System.out.print("\n🔁 Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume leftover newline
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\n🏁 Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thanks for playing, " + playerName + "!");

        scanner.close();
    }
}