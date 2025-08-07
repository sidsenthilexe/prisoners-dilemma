package game.objects;
import java.util.ArrayList;

import game.Constants.Move;
import game.Constants.PlayerType;
import game.Constants.PlayerID;
import game.Constants.Points;

public class GameData {
    private int round;

    private ArrayList<Move> player1Moves;
    private ArrayList<Move> player2Moves;

    private ArrayList<Integer> player1Points;
    private ArrayList<Integer> player2Points;

    private PlayerType player1Type;
    private PlayerType player2Type;

    private PlayerID player1ID;
    private PlayerID player2ID;

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



}
