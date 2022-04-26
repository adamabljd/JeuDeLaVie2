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
    
    //=========================VARIABLES=====================
    private Cell[][] cells;

    private int minLife = 3;
    private int maxLife = 3;
    private int x;
    private int y;
    private int mortSolitude = 1;
    private int mortAsphyxie = 4;
    
    private boolean isAlive;
    private boolean previousState;
    private boolean nextState;

    //=======================================CONSTRUCTOR=========================
    public Cell(Cell[][] cells, int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.cells = cells;
        this.isAlive = alive;
        this.previousState = alive;;
        this.nextState = alive;   
    }

    //==================================FUNCTIONS=================================
    
    //Number of neighbours alive for each cell in cells
    public int nbAliveNeighbours(int size){
        int nb = 0;
        for (int i=-1; i<=1; i++) {
            for (int j = -1; j <= 1; j++) {
                    if(cells[(this.x + i +size)%size][(j + this.y + size) %size].isAlive){
                     nb++;}
  
            }
        }
        // enlever si on compte la cellule où on est
        if (cells[this.x][this.y].isAlive){
           nb-=1;
        }

        return nb;
    }
    
    
    //================================GETS AND SETS===============================
    
    public Cell[][] getCells(){
        return this.cells;
    }
    
    //states
    public boolean getIsAlive() {
        return this.isAlive;
    }
    
    public void setIsAlive(boolean newA){
        this.isAlive = newA;
    }
    
    public boolean getNextState() {
        return this.nextState;
    }
    
    
    //Poisition
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
     
    
    //lives
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
    
    
    //Mort
    public int getMSolitude(){
        return this.mortSolitude;
    }
    
    public int getMAsphyxie(){
        return this.mortAsphyxie;
    }
    
    public void setSolitude(int newS){
        this.mortSolitude = newS;
    }
   
    public void setAsphyxie(int newA){
        this.mortAsphyxie = newA;
    }
    
}
