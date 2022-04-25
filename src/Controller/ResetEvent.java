/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Optional;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import Modele.Tray;
import Vue.*;

/**
 *
 * @author Perso
 */
public class ResetEvent {
    Left left;
    TrayView vue;
    
    
    public ResetEvent(Left left, TrayView vue){
        this.left=left;
        this.vue=vue;
        
        left.getReset().setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                 Alert myPopUp = new Alert(Alert.AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment réinitialiser le plateau ?");
                 Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("aucune selection");
                } else if (option.get() == ButtonType.OK) {
                    vue.resetPlateau();
                    myPopUp.setContentText("done!");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
            }
        });
        
    }
    
    
}
