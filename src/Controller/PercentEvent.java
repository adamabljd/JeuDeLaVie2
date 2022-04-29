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
import Vue.GridView;
import Vue.ZoneParametersView;
import Vue.TrayView;

/**
 *
 * @author adamsayedabouljoud
 */
public class PercentEvent {
    
    private ZoneParametersView zpv;
    private TrayView trayView;
    
    public PercentEvent(ZoneParametersView zpv, TrayView trayView){
        this.zpv = zpv;
        this.trayView = trayView;
        
    
     zpv.getPercentage().setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Alert myPopUp = new Alert(Alert.AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment initialiser le plateau aléatoirement?");
                 Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("NO SELECTION!");
                } else if (option.get() == ButtonType.OK) {
                    double newProb= Double.parseDouble(zpv.getPercentage().getText());
                    Tray tray=new Tray(trayView.getTray().getSize(),newProb, trayView.getTray().getCellNb());
                    trayView.resetTray();
                    trayView.setTray(tray);
                    trayView.displayTray();
                    myPopUp.setContentText("SUCCESS!");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
               
            }
        });
    }
}
