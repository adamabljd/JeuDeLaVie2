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
 * @author ahmadnajjar
 */
public class SolitudeEvent {
    
   Left left; 
   TrayView vue;
   
  public SolitudeEvent(Left left, TrayView vue){
       this.left = left;
       this.vue = vue;
       
       ComboBox sol= left.getMSolitude();
        String firstValue = (String) sol.getValue();
       
       sol.setOnAction(e -> { 
                
                String selectedSol = (String) sol.getValue();
                int sSol= parseInt(selectedSol);
                
                Alert myPopUp = new Alert(AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment modifier la valeur du parametre mortSolitude?");
                Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("aucune selection");
                } else if (option.get() == ButtonType.OK) {
                    vue.getTray().changeSolitude(sSol);
                    myPopUp.setContentText("aucune selection");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
            }
        );
      
   }   
   
}
