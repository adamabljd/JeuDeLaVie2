/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Vue.*;
import Controller.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Modele.Tray;
import Modele.*;
import Vue.TrayView;

/**
 *
 * @author Perso
 */
public class main extends Application {
    // le  paneau principal root est la vue du jeu
    

    
    @Override    
    public void start(Stage primaryStage) {
        Tray matrice=new Tray(100,0.4);
        
        
        BorderPane root = new BorderPane();
        root.setPrefSize(600,600);
        
        //grille(100,100)
        TrayView vue= new TrayView(matrice);
        //vue.affichePlateau();
        
        Grid center = vue.getGrille();
        Right right = new Right();
        Left left= new Left();
        
       
       //events
       //combox jeux predifinis
        exemplaire1 ex1=new exemplaire1();
        exemplaire2 ex2 =new exemplaire2();
        
        TrayView vue1= new TrayView(ex1.getMatrice());
        TrayView vue2= new TrayView(ex2.getMatrice());
        
        ExemplaireEvent exmplaireEvent= new ExemplaireEvent(vue1,vue2,right);
        
        //bouton quit
        QuitEvent quit = new QuitEvent(right.getBorderQuit().getBorderWithQuitEH());
        
        //button startPause 
        StartPauseEvent sp = new StartPauseEvent(left.getbuttonSP());
        
        //textfield: changer la taille
        SizeEvent sizeEvent=new SizeEvent(left,root,vue);
        
        //button reset
        ResetEvent resetEvent = new ResetEvent(left, vue);
       
        //InitAlea 
        ProbEvent probEvent = new ProbEvent(left, vue);
       
        //events on grid
        GridEvent cl=new GridEvent(center,vue);
        //events on tampon 
        //exemplaire1
        GridEvent c2=new GridEvent(vue1.getGrille(),vue1);
        //exemplaire2
        GridEvent c3=new GridEvent(vue2.getGrille(),vue2);
        
        //events on vieMin
        vieMinEvent vmin = new vieMinEvent(left, vue);
           
        //events on grid 
        ZoomEvent z = new ZoomEvent(center);
        
        
        root.setCenter(center);
        root.setRight(right);
        root.setLeft(left);      
        Scene scene = new Scene(root);        
        primaryStage.setTitle("Jouer ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


  /*Button quit = new Button();
        quit.setText("quit");
        
        right.getChildren().addAll(quit); 
        quit.setAlignment(Pos.BOTTOM_RIGHT);
        
        root.setCenter(grille);
        root.setRight(right);
        root.setLeft(left);*/