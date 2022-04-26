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
    // grille a l'instant t 
    Cell[][] cells;
    //taille de la grille
    private int size;
    
    // pourcentage de cellules vivantes initialement
    double probability;

//    /
//     * constructeur par defaut, initialise la taille, le nombre de cellules initiales,
//     * ainsi que les grilles a l'instnat t et t-1
//     */
    public Tray(int size, double probability) {
        this.size = size;
        cells = new Cell[size][size];
        this.probability = probability;
        init();
    }


    /**
     * initialise les grilles a l'instant t et t-1
     * Une cellule n'est liée qu'à la grille au temps t-1
     * un clone de chaque cellule est placée dans la grille au temps t (la grille qui est affichée)
     * L'ajout de cellules  actives se fait par appel de la fonction initHasard
     */
    void init() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(cells, i, j, false);
            }
        hasard();
    }



    void hasard(){
        //initialiser un tableau boolean avec une probabilite 
        Random r = new Random();
        boolean[][] t=new boolean[this.getSize()][this.getSize()];
        int nbCases= this.getSize() * this.getSize();
        double caseAleatoire= nbCases*this.probability;
        double n=0.0;
        while(n<caseAleatoire){
            int i = r.nextInt(this.getSize());
            int j=r.nextInt(this.getSize());
            t[i][j]=true;
            n++;
        }
        //parcourir le tableau boolean a chaque fois on a true la case est vivante
       for(int i=0;i<t.length;i++){
           for(int j=0;j<t[i].length;j++){
               if(t[i][j]==true){
                   cells[i][j].setIsAlive(true);
               }
           }
       }

    }
    
    //compte les voisines et change l'etat d'une cellule en se basant sur l'état des voisins
    public int cellNbAliveN(int i,int j){
       return cells[i][j].nbAliveNeighbours(size);

    }


    public int getSize(){
        return size;
    }

    public void setSize(int t){
        this.size=t;
    }


     public Cell[][] getCellTab(){
        return cells;
    }


     public Cell getCell(int i,int j){
        return cells[i][j];
    }

     public double getProba(){
         return this.probability;
     }

     public void setProba(double proba){
         this.probability = proba;
     }

     public void displayTray(){
         for(int i=0;i<this.cells.length;i++){
           for(int j=0;j<this.cells[i].length;j++){
               if((this.cells[i][j]).getIsAlive() == true){
                   System.out.println(" * ");
               }
               else System.out.println(" - ");
           }
       }
     }

     
     public void changeMinLife(int min){
         for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                cells[i][j].setMinLife(min);
            }
     }

     public void changeMaxLife(int max){
         for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                cells[i][j].setMaxLife(max);
            }
     }

     public int getMaxLife(){
        return this.cells[0][0].getMaxLife(); //c'est la meme valeur pour toutes les cellules de la matrice
    }

     public int getMinLife(){
        return this.cells[0][0].getMinLife(); 
    }
     
    public void changeAsphyxie(int a){
         for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++) {
                this.cells[i][j].setAsphyxie(a);
            }
     }     
     
     public void changeSolitude(int s){
         for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++) {
                this.cells[i][j].setSolitude(s);
            }
     }
}