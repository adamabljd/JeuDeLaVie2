/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Vue.Grid;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import Modele.*;
import Vue.*;

/**
 *
 * @author Perso
 */
public class SizeEvent {
    Left left;
    BorderPane root;
    TrayView vue; 
    
    
    public SizeEvent(Left left,BorderPane root, TrayView vue){
        this.left=left;
        this.root=root;
        this.vue = vue;
        
        
    
     left.getTailleP().setOnKeyPressed( event -> {
        if( event.getCode() == KeyCode.ENTER ) {
            Alert myPopUp = new Alert(Alert.AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment changer la taile du plateau ?");
                 Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("aucune selection");
                } else if (option.get() == ButtonType.OK) {
                     int newSize= Integer.parseInt(left.getTailleP().getText());
                    Grid g=new Grid(newSize);
                    vue.setGrid(g);
                    vue.affichePlateau();
                    root.setCenter(vue.getGrid());
                    myPopUp.setContentText("done!");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
         
                  
                  
            }
          } );
  }
    
      
    
}
