/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import Vue.*;
import Modele.*;

/**
 *
 * @author adamsayedabouljoud
 */
public class StartPauseEvent {
    
    private Tray tray;
    private TrayView tv;
    
    ButtonStartPause btn; 
    public StartPauseEvent(ButtonStartPause btn, Tray tray, TrayView tv){
        this.btn = btn;
        this.tray = tray;
        this.tv = tv;
        Ecouteur e = new Ecouteur();
        btn.addEventHandler(ActionEvent.ACTION, e);
    }
    


public class Ecouteur implements EventHandler{
    
        @Override
        public void handle(Event event) {
           
            if (btn.getCurrentImg() == 1){
                ButtonStartPause btn = (ButtonStartPause )event.getSource();
                btn.setGraphic(btn.getPauseView());
                btn.setCurrentImg(2); 
                btn.setIsActive(true);
                System.out.println(btn.getIsActive());
                runev(btn.getIsActive());
            }
            
            else {
                ButtonStartPause btn = (ButtonStartPause )event.getSource();
                btn.setGraphic(btn.getPlayView());
                btn.setCurrentImg(1); 
                btn.setIsActive(false);
                System.out.println(btn.getIsActive());
                runev(btn.getIsActive());
            }
            
        }

    }


    public void runev(boolean play){
        while(play){
            for(int i = 1 ; i <= tray.getCellNb(); i++){
                for (int j = 1 ; j <= tray.getCellNb(); j++){

                        int voisins = 0;

                        if(tray.getCell((i-1+tray.getSize())%tray.getSize(), (j-1+tray.getSize())%tray.getSize()).getIsAlive())
                                voisins++;

                        if(tray.getCell(i,(j-1+tray.getSize())%tray.getSize()).getIsAlive())
                                voisins++;

                        if(tray.getCell((i+1)%tray.getSize(), (j-1+tray.getSize())%tray.getSize()).getIsAlive())
                                voisins++;

                        if(tray.getCell((i+1)%tray.getSize(), j).getIsAlive())
                                voisins++;

                        if(tray.getCell((i+1+tray.getSize())%tray.getSize(), (j+1+tray.getSize())%tray.getSize()).getIsAlive())
                                voisins++;

                        if(tray.getCell(i, (j+1)%tray.getSize()).getIsAlive())
                                voisins++;

                        if(tray.getCell((i-1+tray.getSize())%tray.getSize(), (j+1)%tray.getSize()).getIsAlive())
                                voisins++;

                        if(tray.getCell((i-1+tray.getSize())%tray.getSize(), j).getIsAlive())
                                voisins++;

//                        int voisins = tray.cellNbAliveN(i, j);

                        if(tray.getCell(i, j).getIsAlive()){
                                //conditions de décès:
                                if(voisins <= 1){
                                    tv.ChangeCellState(i, j);
                                }


                        }else{
                                //conditions de naissance:
                                if(voisins == 3){
                                        tv.ChangeCellState(i, j);
                                }
                        }
                }
            }
        }
            
        }
    
}

        