/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modele.Grid;
import java.awt.event.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import Modele.Cell;
import Vue.*;

/**
 *
 * @author Adam
 */
public class ClickCellEvent {
    private Grid g;
    private TrayView v;
    private ButtonStartPause btn;
    
    public ClickCellEvent(Grid g,TrayView v){
        this.g=g;    
        this.v=v;
           
        for(int i=1;i<=g.getSize();i++){
           for(int j=1;j<=g.getSize();j++){
               int row=i;
               int column=j;
               g.getlabel(i, j).setOnMouseClicked((event)-> {
                   v.ChangeCellState(row, column);});
            }
           
           }
        }
   
}
