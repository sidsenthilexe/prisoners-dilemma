package game.objects;

import java.util.ArrayList;

// Both Cooperate: 3 | 3
// One Defects:    5 | 0
// Both Defect:    1 | 1

public class GamePoints {
    private ArrayList<Integer> player1Points;
    private ArrayList<Integer> player2Points;

    public GamePoints() {
        player1Points = new ArrayList<>();
        player2Points = new ArrayList<>();
    }

    public int getPlayer1Score() {
        int sum = 0;
        for (int point : player1Points) {
            sum += point;
        }
        return sum;
    }

    public int getPlayer1Size() {
        return player1Points.size();
    }

    public int getPlayer1Move(int index) {
        return player1Points.get(index);
    }

    public void addPlayer1Move(int score) {
        player1Points.add(score);
    }

    public int getPlayer2Score() {
        int sum = 0;
        for (int point : player2Points) {
            sum += point;
        }
        return sum;
    }

    public int getPlayer2Size() {
        return player2Points.size();
    }

    public int getPlayer2Move(int index) {
        return player2Points.get(index);
    }

    public void addPlayer2Move(int score) {
        player2Points.add(score);
    }

    public void addPlayerMoves(int player1Score, int player2Score) {
        player1Points.add(player1Score);
        player2Points.add(player2Score);
    }

    public int getWinner() {
        if (getPlayer1Score() > getPlayer2Score()) {
            return 1;
        } else if (getPlayer2Score() > getPlayer1Score()) {
            return 2;
        } else {
            return 0;
        }
    }

    public int getLoser() {
        return switch(getWinner()) {
            case (1) -> 2;
            case (2) -> 1;
            case (0) -> 0;
            default -> 0;
        };
    }

    public int getWinnerScore() {
        return switch (getWinner()) {
            case (1), (0) -> getPlayer1Score();
            case (2) -> getPlayer2Score();
            default -> 0;
        };
    }

    public int getLoserScore() {
        return switch (getLoser()) {
            case (1), (0) -> getPlayer1Score();
            case (2) -> getPlayer2Score();
            default -> 0;
        };
    }

    public String toString() {
        if (getWinner() != 0) {
            return "Player " + getWinner() + " wins";
        } else {
            return "The game was tied";
        }
    }

}
