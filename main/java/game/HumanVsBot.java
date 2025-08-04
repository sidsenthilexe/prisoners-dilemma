package game;

import game.bots.BotMoves;
import game.objects.GamePoints;

import java.util.Scanner;

import static game.Constants.DISPLAY_END_POINTS;
import static game.Constants.PLAY_PROMPT;

public class HumanVsBot {

    public static void playRound(int botNumber) {
        GamePoints points = new GamePoints();
        Scanner scan = new Scanner(System.in);

        botRound(points, scan, botNumber);

        System.out.println(DISPLAY_END_POINTS(points));
    }

    public static void playMultipleRounds(int numRounds, int botNumber) {
        GamePoints points = new GamePoints();
        Scanner scan = new Scanner(System.in);

        System.out.println("This Bot game will run for " + numRounds + " rounds");

        for (int i = 0; i < numRounds; i++) {
            botRound(points, scan, botNumber);
        }

        System.out.println(DISPLAY_END_POINTS(points));
    }

    private static void botRound(GamePoints points, Scanner scan, int botNumber) {
        int player1Move, botMove = 0;
        boolean validMove = false;

        System.out.println("Player's turn");

        do {
            System.out.println(PLAY_PROMPT);
            player1Move = scan.nextInt();
            if (player1Move == 1 || player1Move == 2) {
                validMove = true;
            }
        } while (!validMove);

        switch (botNumber) {
            case 1:
                botMove = BotMoves.TitForTat(points);
                break;
            case 2:
                botMove = BotMoves.AlwaysDefect();
            case 3:
                botMove = BotMoves.AlwaysCooperate();
            case 4:
                botMove = BotMoves.TitForTwoTats(points);
        }

        Round.play(player1Move, botMove, points);

    }

}
