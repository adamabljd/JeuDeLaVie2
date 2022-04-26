/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import javafx.event.ActionEvent;
import Modele.*;
import Vue.*;
        
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author Perso
 */
public class ExemplaireEvent {

   
   Right right; 
   TrayView vue1;
   TrayView vue2;
    
    
    public ExemplaireEvent(TrayView vue1,TrayView vue2, Right right){
        this.vue1=vue1;
        this.vue2=vue2;
        this.right=right;

        
  
   Ecouteur ec= new Ecouteur();
   right.getCharger().addEventHandler(ActionEvent.ACTION, ec);
   
   }
    
    
    public class Ecouteur implements EventHandler{

        @Override
        public void handle(Event event) {
            if((right.getJeup()).getValue()=="exemplaire 1"){
                 right.getPane().getChildren().remove(right.getTampon());
                 right.getPane().getChildren().add(vue1.getGrid());
                 right.setTampon(vue1.getGrid());
                 
            }
           
            else if((right.getJeup()).getValue()=="exemplaire 2"){
                right.getPane().getChildren().remove(right.getTampon());
                 right.getPane().getChildren().add(vue2.getGrid());
                 right.setTampon(vue2.getGrid());
            }
        }
        
    
}
    
}




/*Pane pane=new Pane();
                 pane.getChildren().add(vue1.getGrille());
                 
                  right.gettop().getChildren().remove(right.getPane());
                  right.gettop().getChildren().add(pane);*/