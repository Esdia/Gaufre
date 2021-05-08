package bobnard.gaufre.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Grid implements Serializable {
    private final ArrayList<ArrayList<Integer>> grid;
    private final Integer l;
    private final Integer c;

    public Grid(int l, int c) {
        this.l = l;
        this.c = c;
        this.grid= new ArrayList<>();

        SetUpGrid(l,c);

    }

    public void SetUpGrid(int l, int c){
        int i,j;
        for (i = 0; i < l; i++) {
            ArrayList<Integer> line = new ArrayList<>();

            for (j = 0; j < c; j++) {
                line.add(1);
            }
            this.grid.add(line);
        }
        this.grid.get(0).set(0,2);
    }

    public boolean poisonMiamMiam(){
        return (this.grid.get(0).get(0) == 0);
    }

    public void eatv1(int x, int y) {
        int i, j;
        for (i = y; i < this.l; i++) {
            for (j = x; j < this.c; j++) {
                this.grid.get(i).set(j, 0);
            }
        }
    }

    public void eatv2(int x, int y){
        int i,j;
        for(i = 0 ; i<this.l; i++){
            if(i>= y){
                for(j=x; j<this.c; j++){
                    this.grid.get(i).set(j,0);
                }
            }
            else{
                for(j=x+1; j<this.c; j++){
                    this.grid.get(i).set(j,0);
                }
            }
        }

    }
    public int getCell(int l, int c){
        return grid.get(l).get(c);
    }

    public int getL(){
        return this.l;
    }

    public int getC(){
        return this.c;
    }
    
    public void Clear(){
        this.grid.clear();
    }

    @Override
    public String toString() {
        return "grid=" + grid ;
    }

    @SuppressWarnings("unchecked")
    public Grid copy() {
        Grid clone = new Grid(this.l, this.c);
        clone.grid.clear();
        for (ArrayList<Integer> row: this.grid) {
            clone.grid.add((ArrayList<Integer>) row.clone());
        }

        return clone;
    }
}
