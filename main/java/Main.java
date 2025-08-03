import game.LocalMultiplayer;

import static game.Constants.HELP;

import java.util.Scanner;



// Std options: 1. Cooperate 2. Defect

public class Main {
    public static void main(String[] args) {
        int chosenOption;

        System.out.println("Welcome to the Prisoner's Dilemma game!");

        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("[1] Display game help\n[2] Play Local Multiplayer\n[3] Exit");
            chosenOption = scan.nextInt();

            switch (chosenOption) {
                case 1:
                    System.out.println(HELP);
                    break;
                case 2:
                    System.out.println("[1] Play Single Round\n[2] Play Multiple Rounds");
                    chosenOption = scan.nextInt();

                    if (chosenOption == 1) {
                        LocalMultiplayer.playRound();
                    } else {
                        System.out.println("Enter number of rounds to be played");
                        chosenOption = scan.nextInt();
                        LocalMultiplayer.playMultipleRounds(chosenOption);
                    }

                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (chosenOption != 3);
    }
}
