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
        Random random = new java.util.Random(); //TODO Test random(aled)
        this.grid = new Grid(l,c);
        this.undo = new Stack<>();
        this.redo = new Stack<>();
        this.score = new Score();
        this.currentPlayer = random.nextInt(2) + 1;
    }

    void undo(){
        //last?
        if(!this.undo.isEmpty()){
            this.grid = this.undo.lastElement();
            this.redo.add(this.undo.pop());
        }
    }

    void redo(){
        //last?
        if(!this.redo.isEmpty()) {
            this.grid = this.redo.lastElement();
            this.undo.add(this.redo.pop());
        }
    }

    void turn(int x, int y){
        // TODO recup coord
        this.undo.add(this.grid);
        this.grid.eatv2(x,y);
        changePlayer();
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
            out.writeObject(this.score);    
            out.writeObject(this.currentPlayer);
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void load(String fileName){
        try {
            FileInputStream fload = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fload);
            this.grid = (Grid) in.readObject();
            this.undo = (Stack<Grid>) in.readObject();
            this.redo = (Stack<Grid>) in.readObject();
            this.score = (Score) in.readObject();
            this.currentPlayer = (Integer) in.readObject();
            // TODO Test save/load(oskour)
            in.close();
            System.out.println(this.grid);
            System.out.println(this.undo);
            System.out.println(this.redo);
        }
        catch (IOException e) {
            System.out.println("Error:");
            e.printStackTrace();

        }
        catch (ClassNotFoundException e) {
            System.out.println("Error:");
            e.printStackTrace();
        }
    }
    public void reset(){
        this.grid.Clear();
        this.grid.SetUpGrid(this.grid.getL(),this.grid.getC());
        this.undo.clear();
        this.redo.clear();
        this.score.clear();
    }
}