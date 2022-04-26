/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modele.Grid;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
import Vue.*;

/**
 *
 * @author Perso
 */
public class ZoomEvent {
    
    Grid grille; 
    
    public ZoomEvent(Grid grille){
        
        //Ecouteur e = new Ecouteur();
        //grille.setOnScroll(e);
        
        grille.setOnScroll(
        new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                double zoomFactor = 1.05;
                double deltaY = event.getDeltaY();

                if (deltaY < 0){
                    zoomFactor = 0.95;
                }
                grille.setScaleX(grille.getScaleX() * zoomFactor);
                grille.setScaleY(grille.getScaleY() * zoomFactor);
                event.consume();
            }
        });
    }
    
   /*public class Ecouteur implements EventHandler<ScrollEvent>{
    
        @Override
        public void handle(ScrollEvent event) {
            if (event.getDeltaY()>0){
                grille.setTranslateX(event.getDeltaX());
            }
        }
   }*/
   
}
