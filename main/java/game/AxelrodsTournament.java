package game;

public class AxelrodsTournament {

        public static void runTournament(int playEachOther, int numBots) {
            for (int i = 0; i <= numBots; i++) {
                for (int j = 0; j <= numBots; j++) {
                    System.out.println("Matchup: Bot " + i + " vs Bot " + j);
                    BotVsBot.playMultipleRounds(playEachOther, i, j);
                }
            }
        }

}
