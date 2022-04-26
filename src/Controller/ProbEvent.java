/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import Modele.Tray;
import Vue.Grid;
import Vue.Left;
import Vue.TrayView;

/**
 *
 * @author Perso
 */
public class ProbEvent {
    
    Left left;
    TrayView vue;
    
    public ProbEvent(Left left, TrayView vue){
        this.left=left;
        this.vue = vue;
        
    
     left.getProb().setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Alert myPopUp = new Alert(Alert.AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment initialiser le plateau aléatoirement?");
                 Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("aucune selection");
                } else if (option.get() == ButtonType.OK) {
                    double newProb= Double.parseDouble(left.getInitAlea().getText());
                    Tray tray=new Tray(vue.getTray().getSize(),newProb, vue.getTray().getCellNb());
                    vue.resetPlateau();
                     vue.setTray(tray);
                     vue.affichePlateau();
                    myPopUp.setContentText("done!");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
               
            }
        });
    }
}
