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
public class vieMinEvent {
    
   Left left; 
   TrayView vue;
   
  public vieMinEvent(Left left, TrayView vue){
       this.left = left;
       this.vue = vue;
       
       ComboBox vieMin = left.getVieMin();
       ComboBox vieMax = left.getVieMax(); 
       
       //Ecouteur e = new Ecouteur();
       vieMin.setOnAction(e -> { 
            int selectedMax = vue.getMatrice().getMaxLife();
            String selectedMin = (String) left.getVieMin().getValue();
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
                    myPopUp.setContentText("aucune selection");
                } else if (option.get() == ButtonType.OK) {
                    vue.getMatrice().changeMinLife(sMin);
                    myPopUp.setContentText("aucune selection");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
            }
        });
      
   }   
}
