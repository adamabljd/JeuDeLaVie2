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

public class GridView extends GridPane {
    
    
    private int size ;
    private int gap = 3 ;
    private int cellSize = 5 ;
    
    private Label grid[][]; 
    
    private String white ="#FFFFFF";
    private String red ="#FF0000";
    
    public GridView(int size){
        super();
        this.size = size;
        this.setVgap(gap);
        this.setHgap(gap);
        
        this.grid = new Label[size + 1][size + 1]; 
        
        for(int i = 1; i <= this.size; i++){
           for(int j = 1; j <= this.size; j++){
           Label cell= new Label();
           cell.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
           cell.setPrefSize(cellSize, cellSize);
           cell.setMaxSize(cellSize, cellSize);
           cell.setMinSize(cellSize, cellSize);;
           this.add(cell, i, j);  
           grid[i][j] = cell ;
           }    
       } 
        
    }
    
    //colorie la cellule en rouge
    public void setCellAliveColor(int x, int y) {        
        if ((x>0 && x <=this.size) && (y>0 && y <=this.size)) {
            grid[x][y].setStyle("-fx-background-color: "+ red +";");
        } 
    }
 
    //colorie la cellule en blanc
    public void setCellDeadColor(int x, int y){                
        if ((x>0 && x <=this.size) && (y>0 && y <=this.size)) {
            grid[x][y].setStyle("-fx-background-color: " + white + ";");  
        }
    }
    
    public void setSize(int newS){
        this.size=newS;
    }
    public int getSize( ){
        return this.size;
    }
    
    public Label getlabelFromGrid(int i,int j){
        return this.grid[i][j];
    }
    
    
    
}
