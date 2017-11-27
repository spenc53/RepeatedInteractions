package players.AI;

import game.Board;
import players.Player;

import java.util.Random;

/**
 * Created by Andrew on 11/18/17.
 */
public class OurAlgorithmPlayer extends Player {
    int choice = -1;
    double priors[];

    int coop = 0;
    int retal = 1;
    Random random;

    int total_moves = -1;

    public OurAlgorithmPlayer(boolean rowPlayer, Board board) {
        super(rowPlayer, board);
//        int max = Integer.MIN_VALUE;
//        int location[] = {-1, -1};
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                int square = board.getScore(i, j).getRowScore() + board.getScore(i, j).getColScore();
//                //square *= rowPlayer ? 1 : -1;
//                if ((square == max
//                    && (rowPlayer ? board.getScore(i, j).getRowScore() : board.getScore(i, j).getColScore()) > (rowPlayer ? board.getScore(location[0], location[1]).getRowScore() : board.getScore(location[0], location[1]).getColScore()))
//                    || square > max) {
//                    max = square;
//                    location[0] = i;
//                    location[1] = j;
//                }
//            }
//        }
//        this.choice = rowPlayer ? location[0] : location[1];
        priors = new double[2];
        priors[0] = 0;
        priors[1] = 0;

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

        coop = 0;
//        if(board.getScore(0,1).getRowScore() == 1) retal = 0;
        random = new Random();
    }

    @Override
    public int getMove(int move) {
        total_moves ++;
        if(move == 0){
            priors[0] += 1;
        }else if(move == 1){
            priors[1] += 1;
        }
        double sum = priors[0] + priors[1];
        double prob1 = priors[0];
        double prob2 = priors[1];

        if(sum != 0 && total_moves >= 20 && (prob1/sum >= .7 || prob2/sum >= .7)){
            System.out.println(prob1/sum);
            System.out.println(prob2/sum);
            System.out.println("\n");
            if(rowPlayer){
                double score_a = (prob1/sum) * board.getScore(0,0).getRowScore() + (prob2/sum) * board.getScore(0,1).getRowScore();
                double score_b = (prob1/sum) * board.getScore(1,0).getRowScore() + (prob2/sum) * board.getScore(1,1).getRowScore();
                if (score_a > score_b) return 0;
                return 1;
            }
            else{
                double score_a = (prob1/sum) * board.getScore(0,0).getColScore() + (prob2/sum) * board.getScore(1,0).getColScore();
                double score_b = (prob1/sum) * board.getScore(0,1).getColScore() + (prob2/sum) * board.getScore(1,1).getColScore();
                if (score_a > score_b) return 0;
                return 1;
            }
        }
        else {
            if(move == -1) return 0;
            return move;
        }

////        if(move == -1) return 1;
////        return move;
//
//        if(move == coop){
//            return coop;
//        }
////        if(random.nextDouble() > .3){
////            return coop;
////        }
//        return retal;

//        return choice;
    }
}