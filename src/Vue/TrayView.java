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
    private ButtonStartPause btn;
    
    
    public TrayView(Tray m){
        this.m=m;
        g=new Grid(m.getSize());
        this.affichePlateau();
        btn = new ButtonStartPause(60);
        
    }
            
    
    public void affichePlateau(){
        for(int i=0;i<m.getCellTab().length;i++){
            for(int j=0;j<m.getCellTab()[i].length ;j++){
                if(m.getCell(i,j).getIsAlive()){
                    g.setCellAliveColor(i, j);
                }
            }
        }
    }
    
    
    
    
    
   public void resetPlateau(){
       for(int i=0;i<m.getCellTab().length;i++){
            for(int j=0;j<m.getCellTab()[i].length ;j++){
                g.setCellDeadColor(i, j);
            }
       }
   }
   
   public void GamePlateu(int i,int j){
       this.m.game(i, j);
       //bede a3mol access lal left.buttonstartpause mechen tezbat el alive aw dead
        //hone lmechkle hiye el getNextState fiyachi mech manti2 bas iza men hat chi tene btezbat
        if(m.getCell(i, j).getIsAlive() == false){
            System.out.println("Cell is now alive");
            g.setCellAliveColor(i, j);
            m.getCell(i, j).setIsAlive(true);
        }
        else if(m.getCell(i, j).getIsAlive() == true){
               g.setCellDeadColor(i, j);
               System.out.println("sell is dead");
               m.getCell(i, j).setIsAlive(false);
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
