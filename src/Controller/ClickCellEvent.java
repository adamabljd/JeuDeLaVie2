/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Vue.GridView;
import java.awt.event.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import Modele.Cell;
import Vue.*;

/**
 *
 * @author adamsayedbouljoud
 */
public class ClickCellEvent {
    private GridView grid;
    private TrayView trayView;
    private ButtonStartPause btn;
    
    public ClickCellEvent(GridView grid,TrayView trayView){
        this.grid = grid;    
        this.trayView = trayView;
           
        for(int i = 1; i <= grid.getSize(); i++){
           for(int j = 1; j <= grid.getSize(); j++){
               int x = i;
               int y = j;
               grid.getlabelFromGrid(i, j).setOnMouseClicked((event)-> {
                   trayView.ChangeCellState(x, y);});
            }
           
           }
        }
   
}
