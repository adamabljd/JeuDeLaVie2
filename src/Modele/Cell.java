/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javafx.scene.paint.Color;

/**
 *
 * @author adamsayedabouljoud
 */
public class Cell {
    Cell[][] cells;
    
    static final public Color deadColor = Color.WHITE;
    static final public Color aliveColor = Color.RED;
    
    int minLife = 3;
    int maxLife = 3;
    int x;
    int y;
    static final int mortSolitude = 1;
    static final int mortAsphyxie = 4;
    
    //states
    boolean isAlive;
    boolean previousState;
    boolean nextState;

    //constructor
    public Cell(Cell[][] cells, int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.cells = cells;
        this.isAlive = alive;
        this.previousState = alive;;
        this.nextState = alive;   
    }
    
    //Changes the color depending on the cell's state
    public void changeColor(){
        Color color = null;
        if(this.isAlive != this.nextState){
            if (this.nextState) color = Cell.aliveColor;
            else color = Cell.deadColor;
        }
    }
    
    
    //ajouter les cellules à la grille
   /* public void addcell(){
       
               grille[this.x][this.y]= new Cellule(grille,this.x,this.y,this.vivante);
        
    }*/

 
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
        } else
            if (c >= minLife && c <= maxLife) {
                nextState = true;
            }
  
    }
    
    

     /*//change l'etat actuel vers l'etat suivant
    public void avancer()
    {
        if(!transition) vivante = etatSuivant;
    }*/

    
    //getters and setters
    public boolean getIsAlive() {
        return this.isAlive;
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
