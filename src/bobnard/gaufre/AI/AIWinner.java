package bobnard.gaufre.AI;

import bobnard.gaufre.UI.GameController;

import java.util.Random;

public class AIWinner extends AI {
    private final int l;
    private final int c;

    public AIWinner(GameController controller) {
        super(controller);

        this.l = this.controller.getGame().getGrid().getL();
        this.c = this.controller.getGame().getGrid().getC();
    }

    @Override
    public void play() {

        if(this.controller.getGame().getGrid().getCell(1,1) == 0) {
            int x = c;
            int y = l;
            do {
                x--;
            } while (this.controller.getGame().getGrid().getCell(0, x) == 0);
            do {
                y--;
            } while (this.controller.getGame().getGrid().getCell(y, 0) == 0);
            if(x>y){
                x = y+1;
                this.controller.play(x,0);
            }
            if(x<y){
                y = x+1;
                this.controller.play(0,y);
            }
            if(x==y){
                this.controller.play(0,y);
            }
        }
        else{
            this.controller.play(1, 1);
        }

    }
}
