package players.AI;

import game.Board;
import players.Player;

/**
 * Created by spencer on 11/18/17.
 */
public class FictitiousPlayer extends Player {
    private double[] priors;

    public FictitiousPlayer(boolean rowPlayer, Board board) {
        super(rowPlayer, board);
        priors = new double[2];
        priors[0] = 1;
        priors[1] = 1;
    }

    @Override
    public int getMove(int move) {
        if(move == 0){
            priors[0] += 1;
        }else if(move == 1){
            priors[1] += 1;
        }
        double prob_a = priors[0]/(priors[0] + priors[1]);
        double prob_b = priors[1]/(priors[0] + priors[1]);
        if(rowPlayer){
            double score_a = prob_a * board.getScore(0,0).getRowScore() + prob_b * board.getScore(0,1).getRowScore();
            double score_b = prob_b * board.getScore(1,0).getRowScore() + prob_b * board.getScore(1,1).getRowScore();
            if (score_a > score_b) return 0;
            return 1;
        }
        else{
            double score_a = prob_a * board.getScore(0,0).getColScore() + prob_b * board.getScore(1,0).getColScore();
            double score_b = prob_b * board.getScore(0,1).getColScore() + prob_b * board.getScore(1,1).getColScore();
            if (score_a > score_b) return 0;
            return 1;
        }
    }
}
