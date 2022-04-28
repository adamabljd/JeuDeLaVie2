/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author adamsayedabouljoud
 */
public class Tampon {
    private Tray tray;
    private int size;
    private double percent;
    private int nbCells;
    
    public Tampon(int size, double percent, int nbCells){
        this.size = size;
        this.percent = percent;
        this.nbCells = nbCells;
        tray = new Tray(size, percent, nbCells);
    }
    
    
    public Tray getTamponTray(){
        return this.tray;
    }
    
    public int getTamponSize(){
        return this.size;
    }
    
    public double getTamponPercent(){
        return this.percent;
    }
    
    public int getTamponNbCells(){
        return this.nbCells;
    }
}
