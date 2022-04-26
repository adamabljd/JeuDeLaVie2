/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Grid;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Perso
 */
public class Right extends VBox {
    Grid tampon; 
    BorderWithQuitEH quit; 
    ComboBox jeuP;
    Pane pane;
    Button charger;
    VBox top;
            
   public Right(){
      
       //zone tampon
       pane = new Pane(); 
       tampon = new Grid(10);
       pane.getChildren().add(tampon);
       //jeux predefini
       jeuP=new ComboBox();
       jeuP.getItems().addAll("exemplaire 1", "exemplaire 2");
       jeuP.getSelectionModel().selectFirst();
       //charger
       charger=new Button("Charger");
       top = new VBox();
       top.getChildren().addAll(pane,jeuP,charger);  
       top.setSpacing(30);
        //button quit
       quit = new BorderWithQuitEH();
       
     
       this.setSpacing(550);
       this.getChildren().addAll(top,quit);
       this.setPadding(new Insets(10));
      
       
       
       
   } 
   
   
   public ComboBox getJeup(){
       return this.jeuP;
   }
    
   public Pane getPane(){
       return this.pane; 
   }
    
   public Grid getTampon(){
       return this.tampon;
   }
   
   public void setTampon(Grid tmp){
       this.tampon = tmp; 
   }
   
   public BorderWithQuitEH getBorderQuit(){
       return this.quit; 
   }
   
   public Button getCharger(){
       return this.charger; 
   }
   public void setPane(Pane p){
       this.pane=p;
   }
   public VBox gettop(){
       return this.top;
   }
}
