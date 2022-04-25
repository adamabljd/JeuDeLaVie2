/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Modele.*;

/**
 *
 * @author Perso
 */
public class TrayView {
    
    private Grid g;
    private Tray m;
    
    public TrayView(Tray m){
        this.m=m;
        g=new Grid(m.getSize());
        this.affichePlateau();
        
    }
            
    
    public void affichePlateau(){
        for(int i=0;i<m.getCellTab().length;i++){
            for(int j=0;j<m.getCellTab()[i].length ;j++){
                if(m.getCell(i,j).getIsAlive()){
                    g.setCellAlive(i, j);
                }
            }
        }
    }
    
    
    
    
    
   public void resetPlateau(){
       for(int i=0;i<m.getCellTab().length;i++){
            for(int j=0;j<m.getCellTab()[i].length ;j++){
                System.out.println("reset");
                g.resetCell(i, j);
            }
       }
   }
   
   public void GamePlateu(int i,int j){
       this.m.game(i, j);
       //hone lmechkle hiye el getNextState fiyachi mech manti2 bas iza men hat chi tene btezbat
       if(m.getCell(i, j).getNextState()){
           System.out.println("Cell is now alive");
           g.setCellAlive(i, j);
       }
       else{
              g.resetCell(i, j);
              System.out.println("sell is dead");
               }
   }
    
    public Grid getGrille(){
        return g;
    }
     public void setGrille(Grid gr){
        this.g=gr;
    }
    
    public Tray getMatrice(){
        return this.m;
    }
    public void setSizeMatrice(int size){
        this.m.setSize(size);
    }
    
    public void setMatrice(Tray m){
        this.m = m;
    }
    
}
