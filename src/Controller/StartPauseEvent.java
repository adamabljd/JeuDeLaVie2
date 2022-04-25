/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import Vue.ButtonStartPause;

/**
 *
 * @author Perso
 */
public class StartPauseEvent {
    
    ButtonStartPause btn; 
    public StartPauseEvent(ButtonStartPause btn){
        this.btn = btn;
         Ecouteur e = new Ecouteur();
        btn.addEventHandler(ActionEvent.ACTION, e);
    }
    


public class Ecouteur implements EventHandler{
    
        @Override
        public void handle(Event event) {
           
            if (btn.getCurrentImg() == 1){
                ButtonStartPause btn = (ButtonStartPause )event.getSource();
                btn.setGraphic(btn.getPauseView());
                btn.setCurrentImg(2); 
                btn.setIsActive(true);
                System.out.println(btn.getIsActive());
            }
            
            else {
                ButtonStartPause btn = (ButtonStartPause )event.getSource();
                btn.setGraphic(btn.getPlayView());
                btn.setCurrentImg(1); 
                btn.setIsActive(false);
                System.out.println(btn.getIsActive());
            }
            
        }

    }
}

        