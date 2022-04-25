/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import javafx.application.Platform;
import Modele.*;
import Vue.*;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author Perso
 */
public class QuitEvent {
    
    Button quit;
    
    public QuitEvent(Button quit){
        this.quit = quit; 
        
        quit.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Platform.exit();
            }
        });
    }
    
}
