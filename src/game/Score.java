package game;

/**
 * Created by spencer on 11/15/17.
 */
public class Score {
    private int rowScore;
    private int colScore;

    public Score(int rowScore, int colScore) {
        this.rowScore = rowScore;
        this.colScore = colScore;
    }

    public int getRowScore() {
        return rowScore;
    }

    public void setRowScore(int rowScore) {
        this.rowScore = rowScore;
    }

    public int getColScore() {
        return colScore;
    }

    public void setColScore(int colScore) {
        this.colScore = colScore;
    }

    public void addRowScore(int toAdd){
        this.rowScore += toAdd;
    }

    public void addColScore(int toAdd){
        this.colScore += toAdd;
    }

    @Override
    public String toString() {
        return "Score{" +
                "rowScore=" + rowScore +
                ", colScore=" + colScore +
                '}';
    }
}
