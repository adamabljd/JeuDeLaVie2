/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author adamsayedabouljoud
 */
public class BorderWithQuitEH extends BorderPane{
     Button button = new Button();
    
     
    
    public BorderWithQuitEH(){
        this.button = new Button("Quit");
        
        this.setAlignment(this.button, Pos.BOTTOM_RIGHT);
        this.setBottom(this.button);
        
    }   
    
    public Button getBorderWithQuitEH(){
        return this.button;
    }
       
}
