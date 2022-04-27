/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;

/**
 *
 * @author ahmadnajjar
 */
public class ZoneTamponView extends VBox {
    private GridView tampon; 
    private Pane pane;
    private ComboBox tamponBox;
    private VBox top;
    private Button loadBtn;
    private BorderWithQuitEH quit; 
            
   public ZoneTamponView(){
       tampon = new GridView(10);
       
       pane = new Pane(); 
       pane.getChildren().add(tampon);
       
       loadBtn = new Button("Load");
       
       tamponBox=new ComboBox();
       tamponBox.getItems().addAll("Tampon 1", "Tampon 2");
       tamponBox.getSelectionModel().selectFirst();
       
       top = new VBox();
       top.getChildren().addAll(pane, tamponBox, loadBtn);  
       top.setSpacing(30);
       
       quit = new BorderWithQuitEH();
     
       this.setSpacing(500);
       this.getChildren().addAll(top, quit);
       this.setPadding(new Insets(10));
       
   } 
   
   
   public ComboBox getTamponBox(){
       return this.tamponBox;
   }
    
   
   public Pane getPane(){
       return this.pane; 
   }
   
   public void setPane(Pane newP){
       this.pane = newP;
   }
    
   
   public GridView getTampon(){
       return this.tampon;
   }
   
   public void setTampon(GridView newT){
       this.tampon = newT; 
   }
   
   
   public BorderWithQuitEH getBorderQuit(){
       return this.quit; 
   }
   
   
   public Button getLoadBtn(){
       return this.loadBtn; 
   }
   
   
   public VBox getTop(){
       return this.top;
   }
}
