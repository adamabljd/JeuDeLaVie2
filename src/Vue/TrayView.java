/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Modele.*;

/**
 *
 * @author adamsayedabouljoud
 */
public class TrayView {
    
    private GridView grid;
    private Tray tray;
    private ButtonStartPause btn;
    
    
    public TrayView(Tray tray){
        this.tray=tray;
        grid = new GridView(tray.getCellNb());
        this.displayTray();
        btn = new ButtonStartPause(60);
        
        this.grid.setStyle("-fx-border-color: black");
    }
            
    //affiche le tray avec les couleurs qu'il faut
    public void displayTray(){
        for(int i=0;i<tray.getCellTab().length;i++){
            for(int j=0;j<tray.getCellTab()[i].length ;j++){
                if(tray.getCell(i,j).getIsAlive()){
                    grid.setCellAliveColor(i, j);
                }
            }
        }
    }
    
    //vide le tray, il met chaque cell en blanc
    public void resetTray(){
       for(int i=0;i<tray.getCellTab().length;i++){
            for(int j=0;j<tray.getCellTab()[i].length ;j++){
                grid.setCellDeadColor(i, j);
            }
       }
    }
   
    //Change l'etat de la cell en i j du cells
   public void ChangeCellState(int i,int j){
        if(this.tray.getCell(i, j).getIsAlive() == false){
            System.out.println("Cell is now alive");
            this.grid.setCellAliveColor(i, j);
            this.tray.getCell(i, j).setIsAlive(true);
            
        }else if(this.tray.getCell(i, j).getIsAlive() == true){
               this.grid.setCellDeadColor(i, j);
               System.out.println("Cell is dead");
               this.tray.getCell(i, j).setIsAlive(false);
            }   
    }
    
    public GridView getGrid(){
        return this.grid;
    }
    
    public void setGrid(GridView newG){
        this.grid = newG;
    }
    
    public Tray getTray(){
        return this.tray;
    }
    
    public void setTray(Tray newTray){
        this.tray = newTray;
    }
    
    public void setTraySize(int size){
        this.tray.setSize(size);
    }
    
}
