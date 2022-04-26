/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Modele.Grid;
import Modele.*;

/**
 *
 * @author Perso
 */
public class TrayView {
    
    private Grid g;
    private Tray tray;
    private ButtonStartPause btn;
    
    
    public TrayView(Tray tray){
        this.tray=tray;
        g=new Grid(tray.getCellNb());
        this.affichePlateau();
        btn = new ButtonStartPause(60);
        
    }
            
    
    public void affichePlateau(){
        for(int i=0;i<tray.getCellTab().length;i++){
            for(int j=0;j<tray.getCellTab()[i].length ;j++){
                if(tray.getCell(i,j).getIsAlive()){
                    g.setCellAliveColor(i, j);
                }
            }
        }
    }
    
    
    
    
    
   public void resetPlateau(){
       for(int i=0;i<tray.getCellTab().length;i++){
            for(int j=0;j<tray.getCellTab()[i].length ;j++){
                g.setCellDeadColor(i, j);
            }
       }
   }
   
   public void ChangeCellState(int i,int j){
       //this.m.game(i, j);
       //bede a3mol access lal left.buttonstartpause mechen tezbat el alive aw dead
        if(this.tray.getCell(i, j).getIsAlive() == false){
            System.out.println("Cell is now alive");
            this.g.setCellAliveColor(i, j);
            this.tray.getCell(i, j).setIsAlive(true);
        }
        else if(this.tray.getCell(i, j).getIsAlive() == true){
               this.g.setCellDeadColor(i, j);
               System.out.println("sell is dead");
               this.tray.getCell(i, j).setIsAlive(false);
             }
       
   }
    
    public Grid getGrid(){
        return g;
    }
     public void setGrid(Grid gr){
        this.g=gr;
    }
    
    public Tray getTray(){
        return this.tray;
    }
    public void setTraySize(int size){
        this.tray.setSize(size);
    }
    
    public void setTray(Tray tray){
        this.tray = tray;
    }
    
}
