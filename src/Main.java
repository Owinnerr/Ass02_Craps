import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random gen = new Random();
        Scanner in = new Scanner(System.in);
        int point = 0; // Initialize point variable
        String yesOrNo = ""; // Initialize yesOrNo variable (for prompting user to play again)
        boolean done1 = false; // Initialize done1 variable and set to false for do while loop
        boolean done2 = false; // Initialize done2 variable and set to false for do while loop
        do {
            int die1 = gen.nextInt(6) + 1; // Generates a random int between 1 and 6, and sets as a variable
            int die2 = gen.nextInt(6) + 1; // Generates a random int between 1 and 6, and sets as a variable
            int crapsRoll = die1 + die2; // Initialize crapsRoll variable and set to the sum of both die rolls (Gaussian range from 2 to 12 as in rolling two dice)
            System.out.println("Die 1 is: " + die1); // Output the die 1 roll
            System.out.println("Die 2 is: " + die2); // Output the die 2 roll
            System.out.println("The sum of those rolls is " + crapsRoll); // Output the sum of the rolls (crapsRoll)
            if (crapsRoll == 7 || crapsRoll == 11) { // Condition: If crapsRoll variable equals 7 OR crapsRoll variable equals 11,
                System.out.println("You won with a natural!"); // Output that the user won
            } else if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) { // Condition: If crapsRoll variable equals 2 OR crapsRoll variable equals 3 OR crapsRoll variable equals 12,
                System.out.println("You crapped out."); // Output that the user crapped out
            } else {
                point = crapsRoll; // Set the point variable to the crapsRoll (because the user did not roll 7, 11, 2, 3, or 12)
                System.out.println("The sum, " + crapsRoll + ", is now the point."); // Output that the crapsRoll is now the point
                do {
                    die1 = gen.nextInt(6) + 1; // Regenerates a random int between 1 and 6
                    die2 = gen.nextInt(6) + 1; // Regenerates a random int between 1 and 6
                    crapsRoll = die1 + die2; // Set crapsRoll variable to the sum of both die rolls
                    System.out.println("Die 1 is: " + die1); // Output the die 1 roll
                    System.out.println("Die 2 is: " + die2); // Output the die 2 roll
                    System.out.println("The sum of those rolls is " + crapsRoll + ", and you are trying for the point."); // Output the sum of the rolls and tell the user that they are trying for the point
                    if (crapsRoll == point) { // Condition: If crapsRoll variable is equal to the point variable,
                        System.out.println("Since you matched the point, you win!"); // Output that the user won
                        done1 = true; // Set done1 to true to stop the loop
                    } else if (crapsRoll == 7) { // Condition: If crapsRoll variable is equal to 7,
                        System.out.println("Since you rolled a 7, you lose."); // Output that the user lost
                        done1 = true; // Set done1 to true to stop the loop
                    } else {
                        System.out.println("You didn't roll the point or a 7, so you will re-roll"); // Output that there will be a re-roll
                    }
                } while(!done1); // Loop: While done1 variable is false (loop will stop when done1 is true, or in other words when the user rolls a 7 or the point)
            }
            do {
                System.out.print("Would you like to play again? [Y or N]: "); // Prompt the user to play again
                yesOrNo = in.nextLine(); // Reads a string value from the user
                yesOrNo = yesOrNo.toUpperCase(); // Sets user input to uppercase in case they typed in lowercase
                if (yesOrNo.equals("Y") || yesOrNo.equals("N")) { // Condition: If yesOrNo variable equals Y or equals N,
                    done2 = true; // Set done2 to true so we can stop this loop
                } else {
                    System.out.println("You have to enter Y or N."); // Output that the user has to enter a valid answer
                }
            } while(!done2); // Loop: While done2 variable is false (loop will stop when done2 is true, or in other words when the user enters a valid answer)
        } while(yesOrNo.equals("Y")); // Loop: While yesOrNo equals Y (when the user enters N the program will stop)
    }
}