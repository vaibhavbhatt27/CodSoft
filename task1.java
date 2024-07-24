import java.util.Random;
import java.util.Scanner;

public class task1{
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; 
        Scanner scanner = new Scanner(System.in);
        int guess = 0;

        System.out.println("I have generated a random number between 1 and 100.");

        while (guess != randomNumber) {
            System.out.print("Enter your guess: ");
            try {
                guess = scanner.nextInt();
                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
