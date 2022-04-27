/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Vue.GridView;
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
 * @author ahmadnajjar
 */
public class SizeEvent {
    private ZoneParametersView zpv;
    private BorderPane root;
    private TrayView trayView; 
    
    
    public SizeEvent(ZoneParametersView zpv,BorderPane root, TrayView trayView){
        this.zpv=zpv;
        this.root=root;
        this.trayView = trayView;
        
        
    
     zpv.getTraySize().setOnKeyPressed(event -> {
        if( event.getCode() == KeyCode.ENTER ) {
            Alert myPopUp = new Alert(Alert.AlertType.CONFIRMATION);
                myPopUp.setTitle("CONFIRMATION");
                myPopUp.setHeaderText("Voulez-vous vraiment changer la taile du plateau ?");
                 Optional<ButtonType> option = myPopUp.showAndWait();

                if (option.get() == null) {
                    myPopUp.setContentText("NO SELECTION!");
                } else if (option.get() == ButtonType.OK) {
                     int newSize= Integer.parseInt(zpv.getTraySize().getText());
                    GridView g=new GridView(newSize);
                    trayView.setGrid(g);
                    trayView.displayTray();
                    root.setCenter(trayView.getGrid());
                    myPopUp.setContentText("SUCCESS!");
                 } else if (option.get() == ButtonType.CANCEL) {
                      myPopUp.setContentText("Cancelled!");
                 }
         
                  
                  
            }
          } );
  }
    
      
    
}
