package bobnard.gaufre.model;

import java.io.*;
import java.util.Stack;
import java.util.Random;

public class Game {
    Grid grid;
    Stack<Grid> undo;
    Stack<Grid> redo;
    Integer currentPlayer;
    Score score;

    public Game(int l, int c){
        Random random = new java.util.Random();
        this.grid = new Grid(l,c);
        this.undo = new Stack<>();
        this.redo = new Stack<>();
        this.score = new Score();
        this.currentPlayer = random.nextInt(2) + 1;
    }

    public void undo(){
        //last?
        if(!this.undo.isEmpty()){
            this.redo.push(this.grid.copy());
            this.grid = this.undo.pop();
        }
    }

    public void redo(){
        //last?
        if(!this.redo.isEmpty()) {
            this.undo.push(this.grid.copy());
            this.grid = this.redo.pop();
        }
    }

    public boolean UndoIsEmpty(){
        return this.undo.isEmpty();
    }

    public boolean RedoIsEmpty(){
        return this.redo.isEmpty();
    }

    public void turn(int x, int y){
        this.undo.push(this.grid.copy());
        this.redo.clear();
        this.grid.eatv1(x,y);
        changePlayer();
        if(isFinished()){
            this.score.IncreaseScore(currentPlayer);
            System.out.println("Player " + currentPlayer + " won the game");
            replay();
        }
    }

    public void changePlayer(){
        if(currentPlayer == 1) this.currentPlayer = 2;
        else this.currentPlayer = 1;
    }

    public boolean isFinished(){
        return this.grid.poisonMiamMiam();
    }


    public void save(String fileName){
        try{
            FileOutputStream fsave= new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fsave);

            out.writeObject(this.grid);
            out.writeObject(this.undo);
            out.writeObject(this.redo);
            out.writeObject(this.currentPlayer);
            out.writeObject(this.score);

            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void load(String fileName){
        try {
            FileInputStream fload = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fload);

            this.grid = (Grid) in.readObject();
            this.undo = (Stack<Grid>) in.readObject();
            this.redo = (Stack<Grid>) in.readObject();
            this.currentPlayer = (Integer) in.readObject();
            this.score = (Score) in.readObject();

            in.close();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error:");
            e.printStackTrace();

        }
    }

    public void reset(){
        replay();
        this.score.clear();
    }

    public void replay(){
        this.grid.Clear();
        this.grid.SetUpGrid(this.grid.getL(),this.grid.getC());
        this.undo.clear();
        this.redo.clear();
    }

    public Grid getGrid() {
        return this.grid;
    }

    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    public int getScore(int player) {
        return this.score.getScore(player);
    }
}