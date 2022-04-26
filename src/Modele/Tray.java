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
    
    private Cell[][] cells;
    
    //Tray size
    private int size;
    //Number of cells for row and column
    private int cellNb;
    
    //Pourcentage de cellules vivantes initialement
    private double probability;


    //Constructor
    public Tray(int size, double probability, int cellNb) {
        this.size = size;
        this.cellNb = cellNb;
        cells = new Cell[cellNb][cellNb];
        this.probability = probability;
        initTray();
    }


    //Cree cree les cells pour la matrice cells[][],
    //et remplie leurs states randomly
    private void initTray() {
        for (int i = 0; i < this.cellNb; i++)
            for (int j = 0; j < this.cellNb; j++) {
                cells[i][j] = new Cell(cells, i, j, false);
            }
        initStateRandomly();
    }


    //cree un tableau de boolean avec une probabilite,
    //met  des valeurs true par hasard, 
    //et puis il les relie avec chaque cell du cells
    private void initStateRandomly(){
        Random r = new Random();
        boolean[][] t=new boolean[this.cellNb][this.cellNb];
        int nbCases= this.cellNb * this.cellNb;
        double caseAleatoire= nbCases*this.probability;
        double n=0.0;
        while(n<caseAleatoire){
            int i = r.nextInt(this.cellNb);
            int j=r.nextInt(this.cellNb);
            t[i][j]=true;
            n++;
        }
        
       for(int i=0;i<t.length;i++){
           for(int j=0;j<t[i].length;j++){
               if(t[i][j]==true){
                   cells[i][j].setIsAlive(true);
               }
           }
       }

    }
    
    //Retourn le nb de voisins vivant de la cell en i et j du cells
    public int cellNbAliveN(int i,int j){
       return cells[i][j].nbAliveNeighbours(this.cellNb);

    }


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

     public double getProba(){
         return this.probability;
     }

     public void setProba(double proba){
         this.probability = proba;
     }

//     public void displayTrayss(){
//         for(int i=0;i<this.cells.length;i++){
//           for(int j=0;j<this.cells[i].length;j++){
//               if((this.cells[i][j]).getIsAlive() == true){
//                   System.out.println(" * ");
//               }
//               else System.out.println(" - ");
//           }
//       }
//     }

     
     public void changeMinLife(int min){
         for (int i = 0; i < this.cellNb; i++)
            for (int j = 0; j < this.cellNb; j++) {
                cells[i][j].setMinLife(min);
            }
     }

     public void changeMaxLife(int max){
         for (int i = 0; i < this.cellNb; i++)
            for (int j = 0; j < this.cellNb; j++) {
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
         for (int i = 0; i < this.cellNb; i++)
            for (int j = 0; j < this.cellNb; j++) {
                this.cells[i][j].setAsphyxie(a);
            }
     }     
     
     public void changeSolitude(int s){
         for (int i = 0; i < this.cellNb; i++)
            for (int j = 0; j < this.cellNb; j++) {
                this.cells[i][j].setSolitude(s);
            }
     }
}