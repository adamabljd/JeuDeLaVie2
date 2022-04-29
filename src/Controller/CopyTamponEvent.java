/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modele.*;
import Vue.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 *
 * @author ahmadnajjar
 */
public class CopyTamponEvent {
    private ZoneTamponView zpv;
    
    public CopyTamponEvent(ZoneTamponView zpv){
        this.zpv = zpv;
        
        zpv.getCopyBtn().addEventHandler(ActionEvent.ACTION, e -> {
            GridView newGTp = copyTampon(zpv.getTampon(), zpv.getTampon().getSize());
            pasteTampon(newGTp);
   });
        
        
    }
    
    
    public GridView copyTampon(GridView gtp, int size){
        GridView newgTp = new GridView(10);
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                newgTp.add(getNodeFromGridPane(gtp, i, j), i, j);
            }
        }
        return newgTp;
    }
    
    public void pasteTampon(GridView gtp){
        System.out.println(gtp);
    }
    
    private Node getNodeFromGridPane(GridView gv, int col, int row) {
    for (Node node : gv.getChildren()) {
        if (GridView.getColumnIndex(node) == col && GridView.getRowIndex(node) == row) {
            return node;
        }
    }
    return null;
}
}
