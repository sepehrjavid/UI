package sample;

import java.awt.font.*;
import java.awt.*;

import javax.swing.*;


import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class BoardUi extends GridPane implements BoardUI{
    //int length,width;
    Stage primaryStage;
    Scene first_scene;
    private static Button buttons[][] = new Button[6][6]; //create 9 buttons
    public BoardUi(Stage primaryStage, Scene first_Scene){
        this.primaryStage=primaryStage;
        this.first_scene=first_Scene;
        for (int i=0;i<6;i++) {
            for (int j=0;j<6;j++){
                if((j==2|j==1)&&i!=5){this.getRowConstraints().add(new RowConstraints(150));continue;}
                if((i==3|i==4)&&j!=0){this.getColumnConstraints().add(new ColumnConstraints(150));continue;}
                if(i==5&j!=0){buttons[i][j] = new Button("O");
                    BorderPane.setAlignment(buttons[i][j], Pos.CENTER_RIGHT);
                    buttons[i][j].setPrefSize(150 ,150);
                    buttons[i][j].setOnMouseClicked(new PlayerListener());
                    this.add(buttons[i][j],j,i);
                    continue;
                }
                if(j==0&i!=5) {
                    buttons[i][j] = new Button("X");
                    BorderPane.setAlignment(buttons[i][j], Pos.CENTER_RIGHT);
                    buttons[i][j].setPrefSize(150 ,150);
                    buttons[i][j].setOnMouseClicked(new PlayerListener());
                    this.add(buttons[i][j],j,i);
                    continue;
                }
                else {buttons[i][j] = new Button("");
                }
                BorderPane.setAlignment(buttons[i][j], Pos.CENTER_RIGHT);
                buttons[i][j].setPrefSize(150 ,150);
                buttons[i][j].setOnMouseClicked(new PlayerListener());
                this.add(buttons[i][j],j,i);

            }
        }}

    @Override
    public void AddPeace(int x, int y, String color) {


    }

    @Override
    public void RemovePeace(int x, int y) {

    }

    @Override
    public void MovePeace(int x, int y, int new_x, int new_y) {
    buttons[new_x][new_y].setText( buttons[x][y].getText());

    }

    @Override
    public void ChanegPeaceColor(int x, int y, String color) {
    }

    @Override
    public void EndGame() {
        for (int i=0;i<6;i++) {
            for (int j=0;j<6;j++){
                if((j==2|j==1)&&i!=5){this.getRowConstraints().add(new RowConstraints(150));continue;}
                if((i==3|i==4)&&j!=0){this.getColumnConstraints().add(new ColumnConstraints(150));continue;}
                if(i==5&j!=0){buttons[i][j] = new Button("O");
                    BorderPane.setAlignment(buttons[i][j], Pos.CENTER_RIGHT);
                    buttons[i][j].setPrefSize(150 ,150);
                    buttons[i][j].setOnMouseClicked(new PlayerListener());
                    this.add(buttons[i][j],j,i);
                    continue;
                }
                if(j==0&i!=5) {
                    buttons[i][j] = new Button("X");
                    BorderPane.setAlignment(buttons[i][j], Pos.CENTER_RIGHT);
                    buttons[i][j].setPrefSize(150 ,150);
                    buttons[i][j].setOnMouseClicked(new PlayerListener());
                    this.add(buttons[i][j],j,i);
                    continue;
                }
                else {buttons[i][j] = new Button("");
                }
                BorderPane.setAlignment(buttons[i][j], Pos.CENTER_RIGHT);
                buttons[i][j].setPrefSize(150 ,150);
                buttons[i][j].setOnMouseClicked(new PlayerListener());
                this.add(buttons[i][j],j,i);

            }}
    primaryStage.setScene(first_scene);

    }
}