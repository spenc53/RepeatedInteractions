package game;

import players.AbstractPlayerFactory;
import players.Player;

/**
 * Created by spencer on 11/15/17.
 */
public class Play {

    Player player1;
    Player player2;

    private Board board;

    private int roundsToPlay;

    public Play(String player1Type, String player2Type, String boardType, int roundsToPlay){
        this.board = Board.getBoard(boardType);
        player1 = AbstractPlayerFactory.getPlayer(player1Type, true, board);
        player2 = AbstractPlayerFactory.getPlayer(player2Type, false, board);
        this.roundsToPlay = roundsToPlay;
    }

    //this will need to be a tuple
    public double[] playGame(){

        Score scoreOfGame = new Score(0,0);

        int player1move = -1;
        int player2move = -1;
        for(int i = 0; i < roundsToPlay; i++){

            int p1 = player1.getMove(player2move);
            int p2 = player2.getMove(player1move);

            player1move = p1;
            player2move = p2;

            Score score = board.getScore(p1, p2);

            scoreOfGame.addRowScore(score.getRowScore());
            scoreOfGame.addColScore(score.getColScore());
        }
        double scores[] = new double[2];
        scores[0] = (double)scoreOfGame.getRowScore()/(double)roundsToPlay;
        scores[1] = (double)scoreOfGame.getColScore()/(double)roundsToPlay;
        return scores;
    }

    public static void main(String args[]){
        Play play = new Play(Player.BULLY, Player.RANDOM, Board.CHICKEN, 1);
        double scores[] = play.playGame();
        System.out.println("Player1 score: " + scores[0]);
        System.out.println("Player2 score: " + scores[1]);
    }
}
