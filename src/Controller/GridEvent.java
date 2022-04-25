/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class GridEvent {
    private Grid g;
    private TrayView v;
    private ButtonStartPause btn;
    
    public GridEvent(Grid g,TrayView v){
        this.g=g;    
        this.v=v;
    
   //g.setOnMouseClicked((evt)-> {System.out.println("aa"+(g.getColumnIndex((Node) evt.getTarget()))+"bb"+(g.getRowIndex((Node) evt.getSource())));;});

   /*  g.setOnMouseClicked((event)-> {
                    Node node = (Node) event.getTarget();
                    int row = g.getRowIndex(node);
                    int column = g.getColumnIndex(node);
                    System.out.println("row "+row+"col "+column);
                    //v.GamePlateu(row, column);
                    Cellule cl=v.getMatrice().getcellule(row, column);
                    g.setCell(cl.getX(),cl.getY());
                });
           }*/
           
    //hay ma lezim tkun grid event, hay bs enta 3m tna2e ayyehon bedak yehon alive w ayehon dead, ba3den lezim na3mol event wen lama tkun play, tbalich el simulation.
        for(int i=1;i<=g.getSize();i++){
           for(int j=1;j<=g.getSize();j++){
               int row=i;
               int column=j;
               g.getlabel(i, j).setOnMouseClicked((event)-> {
                   v.GamePlateu(row, column);});
            }
           
           }
        }
   
}
