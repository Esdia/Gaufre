package bobnard.gaufre.model;

import java.io.Serializable;

public class Score implements Serializable {
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

    public void IncreaseScore(int player){
        switch (player) {
            case 1 -> this.player1++;
            case 2 -> this.player2++;
            default -> System.out.println("Player should be 1 or 2");
        }
    }

    public void clear(){
        this.player1 = 0;
        this.player2 = 0;
    }
}
