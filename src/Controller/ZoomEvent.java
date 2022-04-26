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
 * @author ahmadnajjar
 */
public class ZoomEvent {
    
    private Grid grid; 
    
    public ZoomEvent(Grid grid){
        this.grid = grid;
        
        grid.setOnScroll(
        new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                double zoomFactor = 1.05;
                double deltaY = event.getDeltaY();

                if (deltaY < 0){
                    zoomFactor = 0.95;
                }
                grid.setScaleX(grid.getScaleX() * zoomFactor);
                grid.setScaleY(grid.getScaleY() * zoomFactor);
                event.consume();
            }
        });
    }
}
