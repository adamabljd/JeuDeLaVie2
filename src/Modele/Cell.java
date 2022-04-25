/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;


/**
 *
 * @author adamsayedabouljoud
 */
public class Cell {
    Cell[][] cells;

    private int minLife = 3;
    private int maxLife = 3;
    private int x;
    private int y;
    private static final int mortSolitude = 1;
    private static final int mortAsphyxie = 4;
    
    //states
    private boolean isAlive;
    private boolean previousState;
    private boolean nextState;

    //constructor
    public Cell(Cell[][] cells, int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.cells = cells;
        this.isAlive = alive;
        this.previousState = alive;;
        this.nextState = alive;   
    }

    //Number of alive neighbours
    public void  nbAliveNeighbours(){
        int c = 0;
        for (int x=-1; x<=1; x++) {
            for (int y = -1; y <= 1; y++) {
                    if(cells[this.x + x][y + this.y].isAlive){
                     c++;}
  
            }
        }
        // enlever si on compte la cellule où on est
        if (cells[this.x][this.y].isAlive){
           c=c-1;
        }

        previousState = isAlive;
        if (isAlive && (c <= mortSolitude || c >= mortAsphyxie)) {
            previousState = false;
        } else if (c >= minLife && c <= maxLife) {
                nextState = true;
        }
    }
    
    //getters and setters
    public boolean getIsAlive() {
        return this.isAlive;
    }
    
    public void setIsAlive(boolean newA){
        this.isAlive = newA;
    }
    
    public boolean getNextState() {
        return this.nextState;
    }
    
     
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
     
    
    public int getMaxLife(){
        return this.maxLife; 
    }
    
    public int getMinLife(){
        return this.minLife; 
    }
    
    public void setMinLife(int newMinLife){
        this.minLife = newMinLife;
    }
   
    public void setMaxLife(int newMaxLife){
        this.maxLife = newMaxLife;
    }
    
}
