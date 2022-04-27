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
 * @author adamsayedabouljoud
 */
public class vieMinEvent {
    
   private ZoneParametersView zpv; 
   private TrayView trayView;
   
  public vieMinEvent(ZoneParametersView zpv, TrayView trayView){
       this.zpv = zpv;
       this.trayView = trayView;
       
       ComboBox vieMin = zpv.getVieMin();
       ComboBox vieMax = zpv.getVieMax(); 
       
       vieMin.setOnAction(e -> { 
            int selectedMax = trayView.getTray().getMaxLifeFromCell();
            String selectedMin = (String) zpv.getVieMin().getValue();
            int sMin = parseInt(selectedMin);

            if (selectedMax<sMin){
                Alert myPopUp = new Alert(AlertType.ERROR);
                myPopUp.setTitle("ERROR");
                myPopUp.setContentText("vieMax < vieMin");
                myPopUp.show();
            }
            else{
                Alert myPopUp = new Alert(AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment modifier la valeur vieMin?");
                Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("NO SELECTION!");
                } else if (option.get() == ButtonType.OK) {
                    trayView.getTray().changeMinLife(sMin);
                    myPopUp.setContentText("SUCCESS!");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
            }
        });
      
   }   
}
