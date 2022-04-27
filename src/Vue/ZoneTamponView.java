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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author ahmadnajjar
 */
public class ZoneTamponView extends BorderPane {
    private GridView tampon; 
    private Pane tamponPane;
    private ComboBox tamponBox;
    private VBox top;
    private Button loadBtn;
    private BorderWithQuitEH quitBtn; 
            
   public ZoneTamponView(){
       tampon = new GridView(10);
       
       tamponPane = new Pane(); 
       tamponPane.getChildren().add(tampon);
       
       loadBtn = new Button("Load");
       
       tamponBox=new ComboBox();
       tamponBox.getItems().addAll("Tampon 1", "Tampon 2");
       tamponBox.getSelectionModel().selectFirst();
       
       top = new VBox();
       top.getChildren().addAll(tamponPane, tamponBox, loadBtn);  
       top.setSpacing(10);
       
       quitBtn = new BorderWithQuitEH();
     
       this.setTop(top);
       this.setBottom(quitBtn);
       this.setPadding(new Insets(10));
       
   } 
   
   
   public ComboBox getTamponBox(){
       return this.tamponBox;
   }
    
   
   public Pane getTamponPane(){
       return this.tamponPane; 
   }
   
   public void setTamponPane(Pane newTP){
       this.tamponPane = newTP;
   }
    
   
   public GridView getTampon(){
       return this.tampon;
   }
   
   public void setTampon(GridView newT){
       this.tampon = newT; 
   }
   
   
   public BorderWithQuitEH getBorderQuit(){
       return this.quitBtn; 
   }
   
   
   public Button getLoadBtn(){
       return this.loadBtn; 
   }
   
   
   public VBox getTopTampon(){
       return this.top;
   }
}
