/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Perso
 */
public class exemplaire2 {
    Tray tray;
     
    public exemplaire2(){
         tray=new Tray(10,0.09, 10);
    }
    
    
    public Tray getMatrice(){
        return tray;
    }
    
}
