package bobnard.gaufre.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Grid implements Serializable {
    ArrayList<ArrayList<Integer>> grille;
    int l, c;

    public Grid(int l, int c) {
        this.l = l;
        this.c = c;
        this.grille= new ArrayList<>();

        SetUpGrid(l,c);

    }

    public void SetUpGrid(int l, int c){
        int i,j;
        for (i = 0; i < l; i++) {
            ArrayList<Integer> line = new ArrayList<>();

            for (j = 0; j < c; j++) {
                line.add(1);
            }
            this.grille.add(line);
        }
        this.grille.get(0).set(0,2);
    }

    public boolean poisonMiamMiam(){
        return (this.grille.get(0).get(0) == 0);
    }

    public void eatv1(int x, int y) {
        int i, j;
        for (i = y; i < this.l; i++) {
            for (j = x; j < this.c; j++) {
                this.grille.get(i).set(j, 0);
            }
        }
    }

    public void eatv2(int x, int y){
        int i,j;
        for(i = 0 ; i<this.l; i++){
            if(i>= y){
                for(j=x; j<this.c; j++){
                    this.grille.get(i).set(j,0);
                }
            }
            else{
                for(j=x+1; j<this.c; j++){
                    this.grille.get(i).set(j,0);
                }
            }
        }

    }

    public void Clear(){
        this.grille.clear();
    }

    @Override
    public String toString() {
        return "grille=" + grille ;
    }
}
