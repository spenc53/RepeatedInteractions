package game;

/**
 * Created by spencer on 11/15/17.
 */
public class Board {

    public static final String PRISONER = "Prisoner";
    public static final String CHICKEN = "Chicken";
    public static final String STAG_HUNT = "Stag Hunt";
    public static final String[] BOARD_TYPES = {PRISONER, CHICKEN, STAG_HUNT};

    public static Board prisoner;
    public static Board chicken;
    public static Board stag_hunt;

    static{
        prisoner = new Board();
        chicken = new Board();
        stag_hunt = new Board();

        prisoner.setScore(0,0, new Score(3,3));
        prisoner.setScore(0,1, new Score(0,5));
        prisoner.setScore(1,0, new Score(5,0));
        prisoner.setScore(1,1, new Score(1,1));

        chicken.setScore(0,0, new Score(3,3));
        chicken.setScore(0,1, new Score(1,4));
        chicken.setScore(1,0, new Score(4,1));
        chicken.setScore(1,1, new Score(0,0));

        stag_hunt.setScore(0,0, new Score(4,4));
        stag_hunt.setScore(0,1, new Score(-3,3));
        stag_hunt.setScore(1,0, new Score(3,-3));
        stag_hunt.setScore(1,1, new Score(2,2));

    }

    public static Board getBoard(String boardType){
        switch (boardType){
            case PRISONER:
                return prisoner;
            case CHICKEN:
                return chicken;
            case STAG_HUNT:
                return stag_hunt;
            default:
                break;
        }
        return null;
    }

    private Score[][] scores = new Score[2][2];

    public Board(){}

    public Board(Score row0col0, Score row0col1, Score row1col0, Score row1col1){
        scores[0][0] = row0col0;
        scores[0][1] = row0col1;
        scores[1][0] = row1col0;
        scores[1][1] = row1col1;
    }

    public void setScore(int r, int c, Score s){
        scores[r][c] = s;
    }

    public Score getScore(int r, int c){
        return scores[r][c];
    }
}
