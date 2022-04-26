/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import static java.lang.Integer.parseInt;
import java.util.Optional;
import javafx.event.ActionEvent;
import Modele.*;
import Vue.*;
        
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
/**
 *
 * @author Perso
 */
public class AsphyxieEvent {
    
   Left left; 
    TrayView vue;
   
  public AsphyxieEvent(Left left, TrayView vue){
       this.left = left;
       this.vue = vue;
       
       ComboBox asph = left.getMAsphyxie();
       
       
       //Ecouteur e = new Ecouteur();
       asph.setOnAction(e -> { 
                
                String selectedAsph = (String) left.getMAsphyxie().getValue();
                int sAsph= parseInt(selectedAsph);
                
                Alert myPopUp = new Alert(AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment modifier la valeur du parametre mortAsphyxie?");
                Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("aucune selection");
                } else if (option.get() == ButtonType.OK) {
                    vue.getTray().changeAsphyxie(sAsph);
                    myPopUp.setContentText("aucune selection");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
            }
        );
      
   }   
 
}
