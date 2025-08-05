package game;

import game.objects.GamePoints;

public final class Constants {

    private Constants() {}

    public static final String PLAY_PROMPT = "[1] Cooperate\n[2] Defect";

    public static final String BOTS_LIST = "[1] Tit for Tat\n[2] Always Defect\n[3] Always Cooperate\n[4] Tit for Two Tats";

    public static String DISPLAY_END_POINTS(GamePoints points) {
        if (points.getWinner() != 0) {
            return "Player " + points.getWinner()  + " wins with " + points.getWinnerScore() + " points\nPlayer " + points.getLoser() + " lost with " + points.getLoserScore() + " points";
        } else {
            return "The game was tied at " + points.getWinnerScore() + " points";
        }
    }

    public static final String HELP = "The Prisoner's Dilemma Game is played between 2 players. Each round, each player can choose to cooperate or defect.\nIf both players cooperate, they each receive 3 points.\nIf one player defects while the other cooperates,\nthe defecting player receives 5 points and the cooperating player receives 0.\nIf both players defect, they each receive 1 point.";

}
