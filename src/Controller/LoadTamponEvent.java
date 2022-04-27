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
 * @author ahmadnajjar
 */
public class LoadTamponEvent {

   
   private ZoneTamponView zpv; 
   private TrayView trayView1;
   private TrayView trayView2;
    
    
    public LoadTamponEvent(TrayView trayView1,TrayView trayView2, ZoneTamponView zpv){
        this.trayView1=trayView1;
        this.trayView2=trayView2;
        this.zpv=zpv;

        
  
   //Ecouteur e = new Ecouteur();
   zpv.getLoadBtn().addEventHandler(ActionEvent.ACTION, e -> {
       if((zpv.getTamponBox()).getValue()== "Tampon 1"){
                 zpv.getTamponPane().getChildren().remove(zpv.getTampon());
                 zpv.getTamponPane().getChildren().add(trayView1.getGrid());
                 zpv.setTampon(trayView1.getGrid());
                 
            } else if((zpv.getTamponBox()).getValue()=="Tampon 2"){
                 zpv.getTamponPane().getChildren().remove(zpv.getTampon());
                 zpv.getTamponPane().getChildren().add(trayView2.getGrid());
                 zpv.setTampon(trayView2.getGrid());
            }
   });
   
   }
    
    
//    public class Ecouteur implements EventHandler{
//
//        @Override
//        public void handle(Event event) {
//            
//        }
        
    
//}
    
}