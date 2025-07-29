package game;

import java.util.Scanner;

public class LocalMultiplayer {
    public static void playRound() {
        Scanner scan = new Scanner(System.in);
        int player1Action;
        int player2Action;

        System.out.println("Player 1's turn:\n[1] Cooperate\n[2] Defect");
        player1Action = scan.nextInt();

        System.out.println("\n\n");

        System.out.println("Player 2's turn:\n[1] Cooperate\n[2] Defect");
        player2Action = scan.nextInt();

        if ((player1Action != 1 && player1Action != 2) || (player2Action != 1 && player2Action != 2)) {
            System.out.println("Invalid input.");
        }

        if (player1Action == 1 && player2Action == 1) {
            System.out.println("Both players cooperated:\nPlayer 1: 3 pts\nPlayer 2: 3 pts\nThe game ends in a tie.");
        } else if (player1Action == 1 && player2Action == 2) {
            System.out.println("Player 1 cooperated, Player 2 defected:\nPlayer 1: 0 pts\nPlayer 2: 5 pts\nPlayer 2 wins.");
        } else if (player1Action == 2 && player2Action == 1) {
            System.out.println("Player 1 defected, Player 2 cooperated:\nPlayer 1: 5 pts\nPlayer 2: 0 pts\nPlayer 1 wins.");
        } else {
            System.out.println("Both players defected:\nPlayer 1: 1 pt\nPlayer 2: 1 pt\nThe game ends in a tie.");
        }

    }

}
