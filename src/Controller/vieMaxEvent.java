/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Vue.Left;
import Vue.TrayView;
import static java.lang.Integer.parseInt;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;

/**
 *
 * @author adamsayedabouljoud
 */
public class vieMaxEvent {
    Left left; 
   TrayView vue;
   
  public vieMaxEvent(Left left, TrayView vue){
       this.left = left;
       this.vue = vue;
       
       ComboBox vieMin = left.getVieMin();
       ComboBox vieMax = left.getVieMax(); 
       
       vieMax.setOnAction(e -> { 
            int selectedMin = vue.getTray().getMinLifeFromCell();
            String selectedMax = (String) left.getVieMax().getValue();
            int sMax = parseInt(selectedMax);

            if (selectedMin>sMax){
                Alert myPopUp = new Alert(Alert.AlertType.ERROR);
                myPopUp.setTitle("ERROR");
                myPopUp.setContentText("vieMax < vieMin");
                myPopUp.show();
            }
            else{
                Alert myPopUp = new Alert(Alert.AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment modifier la valeur vieMax?");
                Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("aucune selection");
                } else if (option.get() == ButtonType.OK) {
                    vue.getTray().changeMinLife(sMax);
                    myPopUp.setContentText("aucune selection");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
            }
        });
      
   }   
}
