package players.AI;

import game.Board;
import players.Player;

/**
 * Created by Andrew on 11/18/17.
 */
public class OurAlgorithmPlayer extends Player {
    int choice = -1;

    public OurAlgorithmPlayer(boolean rowPlayer, Board board) {
        super(rowPlayer, board);
        int max = Integer.MIN_VALUE;
        this.choice = -1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int square = board.getScore(i, j).getRowScore() - board.getScore(i, j).getColScore();
                square *= rowPlayer ? 1 : -1;
                if (square > max) {
                    max = square;
                    this.choice = i;
                }
            }
        }
    }

    @Override
    public int getMove(int move) {
        return choice;
    }
}