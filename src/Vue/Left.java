/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Perso
 */
public class Left extends VBox{
    private TextField tailleP;
    private ButtonStartPause buttonSP; 
    private Button reset;
    private Button prob;
    private TextField initAlea;
    private ComboBox vieMin;
    private ComboBox vieMax;
    private ComboBox mSolitude;
    private ComboBox mAsphyxie;
    
    public Left(){
        
        //edition du plateau
        VBox edition= new VBox();
        Label label=new Label("Edition du plateau");
        label.setAlignment(Pos.CENTER);
        tailleP= new TextField();
        tailleP.setPromptText("entrer la taille du plateau");
        reset= new Button("Reset");
        initAlea = new TextField();
        initAlea.setPromptText("entrer une probabilité ");
        prob = new Button("Initialisation aleatoire"); 
        edition.getChildren().addAll(label,tailleP,reset,initAlea, prob);
        edition.setSpacing(5);
        
        //parametre du jeu 
        VBox center = new VBox();
        
        Label mortsolitude = new Label("mort solitude"); 
        mSolitude = new ComboBox();
        mSolitude.getItems().addAll("0","1","2","3","4","5","6","7","8");
        mSolitude.setValue("1");
        
        Label mortasphyxie = new Label("mort asphyxie"); 
        mAsphyxie = new ComboBox();
        mAsphyxie.getItems().addAll("0","1","2","3","4","5","6","7","8");
        mAsphyxie.setValue("4");

        Label viemin = new Label("vie Min"); 
        vieMin = new ComboBox();
        vieMin.getItems().addAll("0","1","2","3","4","5","6","7","8");
        vieMin.setValue("3");
        
        Label viemax = new Label("vie Max"); 
        vieMax = new ComboBox();
        vieMax.getItems().addAll("0","1","2","3","4","5","6","7","8");
        vieMax.setValue("3");
        
        center.setSpacing(5);
        center.getChildren().addAll(mortsolitude, mSolitude, mortasphyxie, mAsphyxie, viemin, vieMin, viemax, vieMax);
        //buttonstartPause
        buttonSP=new ButtonStartPause(60);
        
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setSpacing(180);
        this.getChildren().addAll(edition,center,buttonSP);
    }
    
    public ButtonStartPause getbuttonSP(){
        return buttonSP;
    }
    
    public Button getReset(){
        return this.reset;
    }
    public TextField getTailleP(){
            return this.tailleP;
    }
    
    public Button getProb(){
        return this.prob;
    }
    
    public TextField getInitAlea(){
            return this.initAlea;
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
