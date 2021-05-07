package bobnard.gaufre.model;

public class Score {
    private Integer player1;
    private Integer player2;

    public Score(){
        this.player1 = 0;
        this.player2 = 0;
    }

    public getScore(int player){
        if(player == 1){
            return this.player1;
        }

        if(player== 2){
            return this.player2;
        }
    }
}
