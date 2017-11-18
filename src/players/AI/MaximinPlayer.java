package players.AI;

import game.Board;
import players.Player;

/**
 * Created by Andrew on 11/18/17.
 */
public class MaximinPlayer extends Player {
    int choice = -1;

    public MaximinPlayer(boolean rowPlayer, Board board) {
        super(rowPlayer, board);
        if (rowPlayer) {
            int c = board.getScore(0, 0).getRowScore() < board.getScore(0, 1).getRowScore() ? board.getScore(0, 0).getRowScore() : board.getScore(0, 1).getRowScore();
            int d = board.getScore(1, 0).getRowScore() < board.getScore(1, 1).getRowScore() ? board.getScore(1, 0).getRowScore() : board.getScore(1, 1).getRowScore();
            this.choice = c > d ? 0 : 1;
        }
        else {
            int c = board.getScore(0, 0).getColScore() < board.getScore(1, 0).getColScore() ? board.getScore(0, 0).getColScore() : board.getScore(1, 0).getColScore();
            int d = board.getScore(0, 1).getColScore() < board.getScore(1, 1).getColScore() ? board.getScore(0, 1).getColScore() : board.getScore(1, 1).getColScore();
            this.choice = c > d ? 0 : 1;
        }
    }

    @Override
    public int getMove(int move) {
        return this.choice;
    }
}