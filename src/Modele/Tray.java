/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Random;

/**
 *
 * @author adamsayedabouljoud
 */
public class Tray {
    
    //=================================VARIABLES================================
    
    
    //Tray size
    //Number of cells for row and column
    private int size;
    private int cellNb;
    
    //Pourcentage de cellules vivantes initialement
    private double percent;
    
    //Cells 2d array
    private Cell[][] cells;
    
    


    //===============================CONSTRUCTOR================================
    
    public Tray(int size, double percent, int cellNb) {
        this.size = size;
        this.cellNb = cellNb;
        this.percent = percent;
        cells = new Cell[cellNb][cellNb];
        initTray();
    }

    //===============================FUNCTIONS==================================
    
    //Cree les cells pour la matrice cells[][],
    //et remplie leurs states randomly
    private void initTray() {
        for (int i = 1; i < this.cellNb; i++)
            for (int j = 1; j < this.cellNb; j++) {
                cells[i][j] = new Cell(cells, i, j, false);
            }
        initStateRandomly();
    }


    //cree un tableau de boolean avec une probabilite,
    //met des valeurs true par hasard, 
    //et puis il les relie avec chaque cell du cells
    private void initStateRandomly(){
        Random r = new Random();
       
        boolean[][] tab = new boolean[this.cellNb][this.cellNb];
        
        int nbBox = this.cellNb * this.cellNb;
        
        double randomBox = nbBox * this.percent;
        double n = 0.0;
        
        while(n < randomBox){
            int i = r.nextInt(this.cellNb);
            int j = r.nextInt(this.cellNb);
            tab[i][j]=true;
            n++;
        }
        
       for(int i=1;i<tab.length;i++){
           for(int j=1;j<tab[i].length;j++){
               if(tab[i][j] == true){
                   cells[i][j].setIsAlive(true);
               }
           }
       }

    }
    
    //Retourn le nb de voisins vivant de la cell en i et j du cells
    public int cellNbAliveN(int i,int j){
       return cells[i][j].nbNeighboursAlive(this.cellNb);
    }
    
    public void changeMinLife(int min){
         for (int i = 1; i < this.cellNb; i++)
            for (int j = 1; j < this.cellNb; j++) {
                cells[i][j].setMinLife(min);
            }
    }

     public void changeMaxLife(int max){
         for (int i = 1; i < this.cellNb; i++)
            for (int j = 1; j < this.cellNb; j++) {
                cells[i][j].setMaxLife(max);
            }
    }

    public void changeAsphyxie(int a){
        for (int i = 1; i < this.cellNb; i++){
            for (int j = 1; j < this.cellNb; j++) {
                this.cells[i][j].setAsphyxie(a);
            }
        }   
    }     
     
    public void changeSolitude(int s){
        for (int i = 1; i < this.cellNb; i++){
            for (int j = 1; j < this.cellNb; j++) {
                this.cells[i][j].setSolitude(s);
            }
        } 
    }

    //==========================GETS AND SETS===================================
    public int getSize(){
        return this.size;
    }
    
    public int getCellNb(){
        return this.cellNb;
    }

    public void setSize(int t){
        this.size=t;
    }


    public Cell[][] getCellTab(){
        return this.cells;
    }


    public Cell getCell(int i,int j){
        return this.cells[i][j];
    }
    
    public void setCell(int i,int j, Cell c){
        this.cells[i][j] = c;
    }

    public double getPercent(){
        return this.percent;
    }

    public void setPercent(double newP){
        this.percent = newP;
    }
     
    //Meme valeurs pour chaque cell, 
    //seulement pour eviter d'ecrire la meme chose plusieurs fois
    public int getMaxLifeFromCell(){
        return this.cells[0][0].getMaxLife();
    }

    public int getMinLifeFromCell(){
        return this.cells[0][0].getMinLife(); 
    }
    
}