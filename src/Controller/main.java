/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Vue.GridView;
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
 * @author adamsayedabouljoud
 */
public class main extends Application {
    
    @Override    
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPrefSize(600,600);
        
        
        Tray tray=new Tray(200,0.4, 100);
        TrayView trayView= new TrayView(tray);
        
        
        GridView center = trayView.getGrid();
        ZoneTamponView right = new ZoneTamponView();
        ZoneParametersView left= new ZoneParametersView();
        
       
       //events
       //combox jeux predifinis
        Tampon1 t1=new Tampon1();
        Tampon2 t2 =new Tampon2();
        
        TrayView trayView1= new TrayView(t1.getTrayT1());
        TrayView trayView2= new TrayView(t2.getTrayT2());
        
        LoadTamponEvent exmplaireEvent= new LoadTamponEvent(trayView1,trayView2,right);
        
        //bouton quit
        QuitEvent quit = new QuitEvent(right.getBorderQuit().getBorderWithQuitEH());
        
        //button startPause 
        StartPauseEvent sp = new StartPauseEvent(left.getbuttonSP(), tray, trayView);
        
        //textfield: changer la taille
        SizeEvent sizeEvent=new SizeEvent(left,root,trayView);
        
        //button reset
        ResetEvent resetEvent = new ResetEvent(left, trayView);
       
        //InitAlea 
        ProbEvent probEvent = new ProbEvent(left, trayView);
       
        //events on grid
        ClickCellEvent cl=new ClickCellEvent(center,trayView);
        //events on tampon 
        //exemplaire1
        ClickCellEvent c2=new ClickCellEvent(trayView1.getGrid(),trayView1);
        //exemplaire2
        ClickCellEvent c3=new ClickCellEvent(trayView2.getGrid(),trayView2);
        
        
        //events on vieMin
        vieMinEvent vmin = new vieMinEvent(left, trayView);
        //events on vieMax
        vieMaxEvent vmax = new vieMaxEvent(left, trayView);
        //mort Asph
        AsphyxieEvent asp = new AsphyxieEvent(left, trayView);
        //mort solitude
        SolitudeEvent mSol = new SolitudeEvent(left, trayView);
           
        
        //events on grid 
        ZoomEvent z = new ZoomEvent(center);
        
        
        root.setCenter(center);
        root.setRight(right);
        root.setLeft(left);      
        Scene scene = new Scene(root);        
        primaryStage.setTitle("Game Of Life");
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