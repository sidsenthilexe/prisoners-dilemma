package game;

import game.bots.BotMoves;
import game.objects.GamePoints;

public class BotVsBot {

    private static void botVBotRound(GamePoints points, int bot1, int bot2) {

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
