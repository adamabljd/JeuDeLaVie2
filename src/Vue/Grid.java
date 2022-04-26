/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author ahmadnajjar
 */

public class Grid extends GridPane {
    
    
    private int size ;
    private final int GAP = 3 ;
    private final int CELL_SIZE = 5 ; 
    private Label boardContent[][]; 
    private String WHITE_BACKGROUND="#FFFFFF";
    private String RED_BACKGROUND="#FF0000";
    
    public Grid(int size){
        super();
        this.size = size;
        this.setVgap(GAP);
        this.setHgap(GAP);
        
        boardContent = new Label[size+1][size+1]; 
        
        for(int i=1;i<=this.size;i++){
           for(int j=1;j<=this.size;j++){
           Label cell= new Label();
           cell.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
           cell.setPrefSize(CELL_SIZE, CELL_SIZE);
           cell.setMaxSize(CELL_SIZE, CELL_SIZE);
           cell.setMinSize(CELL_SIZE, CELL_SIZE);;
           this.add(cell, i, j);  
           boardContent[i][j] = cell ;
           }    
       } 
        
    }
    
    //colorie la cellule en rouge
    public void setCellAliveColor(int x, int y) {        
        if ((x>0 && x <=this.size) && (y>0 && y <=this.size)) {
            boardContent[x][y].setStyle("-fx-background-color: "+RED_BACKGROUND+";");
        } 
    }
 
    //colorie la cellule en blanc
    public void setCellDeadColor(int x, int y){                
        if ((x>0 && x <=this.size) && (y>0 && y <=this.size)) {
            boardContent[x][y].setStyle("-fx-background-color: "+WHITE_BACKGROUND+";");  
        }
    }
    
    public void setSize(int newS){
        this.size=newS;
    }
    public int getSize( ){
        return this.size;
    }
    
    public Label getlabel(int i,int j){
        return this.boardContent[i][j];
    }
    
    
    
}
