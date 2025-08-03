package game;

import game.objects.GamePoints;

import java.util.Scanner;

import static game.Constants.PLAY_PROMPT;
import static game.Constants.DISPLAY_END_POINTS;

public class LocalMultiplayer {

    public static void playRound() {
        GamePoints points = new GamePoints();
        Scanner scan = new Scanner(System.in);

        multiplayerRound(points, scan);

        System.out.println(DISPLAY_END_POINTS(points));
    }

    public static void playMultipleRounds(int numRounds) {
        GamePoints points = new GamePoints();
        Scanner scan = new Scanner(System.in);

        System.out.println("This Local Multiplayer game will run for " + numRounds + " rounds");

        for (int i = 0; i < numRounds; i++) {
            multiplayerRound(points, scan);
        }

        System.out.println(DISPLAY_END_POINTS(points));
    }

    private static void multiplayerRound(GamePoints points, Scanner scan) {

        int player1Move, player2Move;
        boolean validMove = false;

        System.out.println("Player 1's turn");

        do {
            System.out.println(PLAY_PROMPT);
            player1Move = scan.nextInt();
            if (player1Move == 1 || player1Move == 2) {
                validMove = true;
            }
        } while (!validMove);

        validMove = false;

        System.out.println("Player 2's turn");

        do {
            System.out.println(PLAY_PROMPT);
            player2Move = scan.nextInt();
            if (player2Move == 1 || player2Move == 2) {
                validMove = true;
            }
        } while (!validMove);

        Round.play(player1Move, player2Move, points);

    }

}
