/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author adamsayedabouljoud
 */ 

public class ButtonStartPause extends Button {
    
    
    private Image imgPlay = new Image("Images/TP_04_play.png") ;
    private ImageView playView; 
        
    private Image imgPause = new Image("Images/TP_04_pause.png") ;
    private ImageView pauseView;
    
    private int currentImage = 1;
    private int size;
    
    boolean isActive = false;
    
    ButtonStartPause(int size){
        
        this.size = size; 
        
        playView = new ImageView(imgPlay);
        playView.setFitHeight(size);
        playView.setFitWidth(size);
        this.setGraphic(playView);
        
       pauseView = new ImageView(imgPause);
       pauseView.setFitHeight(size);
       pauseView.setFitWidth(size);
        
        
        
    }
    
    public int getCurrentImg(){
        return this.currentImage;
    }
    
    public void setCurrentImg(int n){
        this.currentImage = n; 
    }
    
    public ImageView getPlayView(){
        return this.playView;
    }
    
    public ImageView getPauseView(){
        return this.pauseView;
    }
    
    public boolean getIsActive(){
        return this.isActive;
    }
    
    public void setIsActive(boolean newA){
        this.isActive = newA;
    }
}
