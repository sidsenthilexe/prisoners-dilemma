package game.objects;
import java.util.ArrayList;
import java.util.Scanner;

import game.Constants.Move;
import game.Constants.PlayerType;
import game.Constants.PlayerID;
import game.Constants.Points;
import game.Bots;

public class GameData {
    private int round;

    private final ArrayList<Move> player1Moves;
    private final ArrayList<Move> player2Moves;

    private final ArrayList<Integer> player1Points;
    private final ArrayList<Integer> player2Points;

    private final PlayerType player1Type;
    private final PlayerType player2Type;

    private final PlayerID player1ID;
    private final PlayerID player2ID;

    public GameData(PlayerType player1Type, PlayerType player2Type, PlayerID player1ID, PlayerID player2ID) {
        this.player1Type = player1Type;
        this.player2Type = player2Type;

        this.player1ID = player1ID;
        this.player2ID = player2ID;

        player1Moves = new ArrayList<>();
        player2Moves = new ArrayList<>();

        player1Points = new ArrayList<>();
        player2Points = new ArrayList<>();
    }

    public void Round(Move player1Move, Move player2Move) {
        this.player1Moves.add(player1Move);
        this.player2Moves.add(player2Move);

        if (player1Move == Move.COOPERATE && player2Move == Move.COOPERATE) {
            this.player1Points.add(Points.TIE_BOTH_COOPERATE);
            this.player2Points.add(Points.TIE_BOTH_COOPERATE);
        } else if (player1Move == Move.COOPERATE && player2Move == Move.DEFECT) {
            this.player1Points.add(Points.LOSE_VS_DEFECT);
            this.player2Points.add(Points.WIN_VS_COOPERATE);
        } else if (player1Move == Move.DEFECT && player2Move == Move.COOPERATE) {
            this.player1Points.add(Points.WIN_VS_COOPERATE);
            this.player2Points.add(Points.LOSE_VS_DEFECT);
        } else if (player1Move == Move.DEFECT && player2Move == Move.DEFECT) {
            this.player1Points.add(Points.TIE_BOTH_DEFECT);
            this.player2Points.add(Points.TIE_BOTH_DEFECT);
        }
    }

    public int getLatestRoundNumber() {
        return this.player1Moves.size();
    }

    public int getPlayer1Points() {
        int sum = 0;
        for (int point : player1Points) {
            sum += point;
        }
        return sum;
    }

    public int getPlayer2Points() {
        int sum = 0;
        for (int point : player2Points) {
            sum += point;
        }
        return sum;
    }

    public Move getPlayer1Move(int index) {
        return this.player1Moves.get(index);
    }

    public Move getPlayer2Move(int index) {
        return this.player2Moves.get(index);
    }

    public PlayerType getPlayer1Type() {
        return this.player1Type;
    }

    public PlayerType getPlayer2Type() {
        return this.player2Type;
    }

    public PlayerID getPlayer1ID() {
        return this.player1ID;
    }

    public PlayerID getPlayer2ID() {
        return this.player2ID;
    }

    public int getWinner() {
        int player1Points = getPlayer1Points();
        int player2Points = getPlayer2Points();

        if (player1Points > player2Points) {
            return 1;
        } else if (player1Points < player2Points) {
            return 2;
        } else {
            return 0;
        }
    }

    public Move getInput(PlayerType playerType, PlayerID playerID) {
        if (playerType == PlayerType.PLAYER) {
            Scanner scan = new Scanner(System.in);
            boolean failedInput = false;
            Move output = null;
            do {
                if (failedInput) System.out.println("Invalid Input");
                System.out.println("[1] COOPERATE\n[2] DEFECT");
                int userInput = scan.nextInt();

                if (userInput == 1) output = Move.COOPERATE;
                else if (userInput == 2) output = Move.DEFECT;
                else failedInput = true;
            } while (failedInput);

            return output;
        } else {
            return Bots.botMove(playerID);
        }
    }

}
