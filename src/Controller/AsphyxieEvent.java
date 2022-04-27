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
public class AsphyxieEvent {
    
   private ZoneParametersView zpv; 
   private TrayView trayView;
   
  public AsphyxieEvent(ZoneParametersView zpv, TrayView trayView){
       this.zpv = zpv;
       this.trayView = trayView;
       
       ComboBox asph = zpv.getMAsphyxie();
       
       asph.setOnAction(e -> { 
                
                String selectedAsph = (String) zpv.getMAsphyxie().getValue();
                int sAsph= parseInt(selectedAsph);
                
                Alert myPopUp = new Alert(AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment modifier la valeur du parametre mortAsphyxie?");
                
                Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("NO SELECTION!");
                } else if (option.get() == ButtonType.OK) {
                    trayView.getTray().changeAsphyxie(sAsph);
                    myPopUp.setContentText("SUCCESS!");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
            }
        );
      
   }   
 
}
