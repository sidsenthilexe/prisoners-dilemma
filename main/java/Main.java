import game.LocalMultiplayer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int chosenOption;

        System.out.println("Welcome to the Prisoner's Dilemma game!");

        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("[1] Play Local Multiplayer\n[2] Exit");
            chosenOption = scan.nextInt();

            switch (chosenOption) {
                case 1:
                    LocalMultiplayer.playRound();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (chosenOption != 2);
    }
}
