package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class BoardUi extends GridPane {
    //int length,width;
    private static Button buttons[] = new Button[25]; //create 9 buttons
    public BoardUi(){

        for (int i=0;i<6;i++) {
            for (int j=0;j<6;j++){
                if((j==2|j==1)&&i!=5){this.getRowConstraints().add(new RowConstraints(150));continue;}
                if((i==3|i==4)&&j!=0){this.getColumnConstraints().add(new ColumnConstraints(150));continue;}
                if(i==5&j!=0){buttons[i] = new Button("O");
                    BorderPane.setAlignment(buttons[i], Pos.CENTER_RIGHT);
                    buttons[i].setPrefSize(150 ,150);
                    buttons[i].setOnMouseClicked(new PlayerListener());
                    this.add(buttons[i],j,i);
                    continue;
                }
                if(j==0&i!=5) {
                    buttons[i] = new Button("X");
                    BorderPane.setAlignment(buttons[i], Pos.CENTER_RIGHT);
                    buttons[i].setPrefSize(150 ,150);
                    buttons[i].setOnMouseClicked(new PlayerListener());
                    this.add(buttons[i],j,i);
                    continue;
                }
                else {buttons[i] = new Button("");
                }
                BorderPane.setAlignment(buttons[i], Pos.CENTER_RIGHT);
                buttons[i].setPrefSize(150 ,150);
                buttons[i].setOnMouseClicked(new PlayerListener());
                this.add(buttons[i],j,i);

            }
        }}}
