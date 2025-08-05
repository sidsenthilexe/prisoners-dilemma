package game;

import game.bots.BotMoves;
import game.objects.GamePoints;

import static game.Constants.DISPLAY_END_POINTS;

public class BotVsBot {

    public static void playRound(int bot1, int bot2) {
        GamePoints points = new GamePoints();

        botRound(points, bot1, bot2);

        System.out.println(DISPLAY_END_POINTS(points));
    }

    public static void playMultipleRounds(int numRounds, int bot1, int bot2) {
        GamePoints points = new GamePoints();

        System.out.println("This Bot vs Bot game will run for " + numRounds + " rounds");

        for (int i = 0; i < numRounds; i++) {
            botRound(points, bot1, bot2);
        }

        System.out.println(DISPLAY_END_POINTS(points));
    }


    public static void botRound(GamePoints points, int bot1, int bot2) {

        int bot1Move = botMove(points, bot1, 1);

        int bot2Move = botMove(points, bot2, 2);

        Round.play(bot1Move, bot2Move, points);

    }

    private static int botMove(GamePoints points, int bot, int playerNumber) {
        return switch (bot) {
            case 1 -> BotMoves.TitForTat(points, playerNumber);
            case 2 -> BotMoves.AlwaysDefect();
            case 3 -> BotMoves.AlwaysCooperate();
            case 4 -> BotMoves.TitForTwoTats(points, playerNumber);
            default -> 1;
        };
    }

}
