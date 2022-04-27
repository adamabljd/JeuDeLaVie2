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
                nextGeneration(btn.getIsActive());
            }
            
            else {
                ButtonStartPause btn = (ButtonStartPause )event.getSource();
                btn.setGraphic(btn.getPlayView());
                btn.setCurrentImg(1); 
                btn.setIsActive(false);
                System.out.println(btn.getIsActive());
                
            }
            
        }

    }



    public void nextGeneration(boolean play){
        
            // Loop through every cell
                for (int l = 1; l < tray.getCellNb(); l++)
                {
                    for (int m = 1; m < tray.getCellNb(); m++)
                    {
                        // finding no Of Neighbours that are alive
                        int aliveNeighbours = 0;
                        for (int i = -1; i <= 1; i++)
                            for (int j = -1; j <= 1; j++)
                              if ((l+i>=1 && l+i<tray.getCellNb()) && (m+j>=1 && m+j<tray.getCellNb()))
                                  if(tray.getCell(l + i,m + j).getIsAlive())
                                        aliveNeighbours ++;

                        // The cell needs to be subtracted from
                        // its neighbours as it was counted before
                        if(tray.getCell(l , m).getIsAlive()){
                            aliveNeighbours-=1;

                        }
                        // Implementing the Rules of Life

                        // Cell is lonely and dies
                        if ((tray.getCell(l , m).getIsAlive()) && (aliveNeighbours < 2)){
                            tv.ChangeCellState(l, m);
                        }
                        // Cell dies due to over population
                        else if ((tray.getCell(l , m).getIsAlive()) && (aliveNeighbours > 3)){
                            tv.ChangeCellState(l, m);
                        }
                        // A new cell is born
                        else if ((tray.getCell(l , m).getIsAlive() == false) && (aliveNeighbours == 3)){
                            tv.ChangeCellState(l, m);
                        }
                       
                    }
                }
            }
    
}

        