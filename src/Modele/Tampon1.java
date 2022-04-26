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
public class Tampon1 {
    private Tray tray;
     
    public Tampon1(){
        tray = new Tray(10,0.4, 10);
    }
    
    
    public Tray getTrayT1(){
        return this.tray;
    }
    
}
