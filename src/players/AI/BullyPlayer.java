package players.AI;

import game.Board;
import players.Player;

/**
 * Created by Andrew on 11/18/17.
 */
public class BullyPlayer extends Player {
    public BullyPlayer(boolean rowPlayer, Board board) {
        super(rowPlayer, board);
    }

    @Override
    public int getMove(int move) {
        int maxValue = Integer.MIN_VALUE;
        int location = -1;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int currentValue = rowPlayer ? board.getScore(i, j).getRowScore() : board.getScore(i, j).getColScore();
                if (currentValue > maxValue) {
                    maxValue = currentValue;
                    location = rowPlayer ? i : j;
                }
            }
        }
        return location;
    }
}
