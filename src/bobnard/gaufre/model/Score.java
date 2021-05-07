package bobnard.gaufre.model;

public class Score {
    private Integer player1;
    private Integer player2;

    public Score(){
        this.player1 = 0;
        this.player2 = 0;
    }

    public int getScore(int player){
        switch(player){
            case 1:
                return this.player1;

            case 2:
                return this.player2;

            default:
                System.out.println("Player should be 1 or 2");
                return -1;
        }
    }

    public void clear(){
        this.player1 = 0;
        this.player2 = 0;
    }
}
