/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;


import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

/**
 *
 * @author Perso
 */
public class ZoneParametersView extends VBox{
    private Button resetBtn;
    private Button randomInitBtn;
    private ButtonStartPause buttonSP; 
    
    private TextField traySize;
    private TextField percentage;
    
    private ComboBox mSolitude;
    private ComboBox mAsphyxie;
    private ComboBox vieMin;
    private ComboBox vieMax;
    
    public ZoneParametersView(){
        
        
        VBox top = new VBox();
        
        Label label=new Label("Tray Size");
        label.setAlignment(Pos.CENTER);
        
        traySize = new TextField();
        traySize.setPromptText("Enter size");
        
        resetBtn= new Button("Reset");
        
        percentage = new TextField();
        percentage.setPromptText("Enter a percentage");
        
        randomInitBtn = new Button("Random Init"); 
        
        top.getChildren().addAll(label, traySize, resetBtn, percentage, randomInitBtn);
        top.setSpacing(5);
        
        //parametre du jeu 
        VBox center = new VBox();
        
        Label mortsolitude = new Label("Mort solitude"); 
        mSolitude = new ComboBox();
        mSolitude.getItems().addAll("0","1","2","3","4","5","6","7","8");
        mSolitude.setValue("1");
        
        Label mortasphyxie = new Label("Mort asphyxie"); 
        mAsphyxie = new ComboBox();
        mAsphyxie.getItems().addAll("0","1","2","3","4","5","6","7","8");
        mAsphyxie.setValue("4");

        Label viemin = new Label("Vie Min"); 
        vieMin = new ComboBox();
        vieMin.getItems().addAll("0","1","2","3","4","5","6","7","8");
        vieMin.setValue("3");
        
        Label viemax = new Label("Vie Max"); 
        vieMax = new ComboBox();
        vieMax.getItems().addAll("0","1","2","3","4","5","6","7","8");
        vieMax.setValue("3");
        
        center.setSpacing(5);
        center.getChildren().addAll(mortsolitude, mSolitude, mortasphyxie, mAsphyxie, viemin, vieMin, viemax, vieMax);
        
        buttonSP = new ButtonStartPause(60);
        
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setSpacing(180);
        this.getChildren().addAll(top, center, buttonSP);
    }
    
    public ButtonStartPause getbuttonSP(){
        return buttonSP;
    }
    
    public Button getReset(){
        return this.resetBtn;
    }
    public TextField getTraySize(){
            return this.traySize;
    }
    
    public Button getRandomInitBtn(){
        return this.randomInitBtn;
    }
    
    public TextField getPercentage(){
            return this.percentage;
    }
    
    
    public ComboBox getVieMin(){
        return this.vieMin;
    }
    
    public ComboBox getVieMax(){
        return this.vieMax;
    }
    
    public ComboBox getMSolitude(){
        return this.mSolitude;
    }
    
    public ComboBox getMAsphyxie(){
        return this.mAsphyxie;
    }
}
