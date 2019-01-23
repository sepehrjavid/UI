package sample;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class EngineHandler {
    private BoardUI board;
    private MySocket socket;
    private List<PlayerUI> players;

//    public EngineHandler(List<PlayerUI> players, BoardUI board) {
//        socket = new MySocket();
//        this.players = players;
//        this.board = board;
//    }


    public void MessageHandle(String message) {
        String[] arr = message.split(" ");
        String operation = arr[0];
        String name;
        if (operation.equals("nolegalmove")){
            ShowMessage("You have no legal move!");
            name = arr[1];
            for (int i = 0; i < players.size(); i++){
                if (players.get(i).name.equals(name)){
                    players.get(i).MakeActive();
                }
            }
        }
        else if(operation.equals("invalidmove")){
            ShowMessage("Oppss...Invalid move!!");
        }
        else if (operation.equals("nobeadinselectedarea")){
            ShowMessage("You have no peace in the selected area!");
        }
        else if (operation.equals("winner")){
            name = arr[1];
            ShowMessage(name + " wins the game! :D");
            //board.EndGame();
        }
        else if (operation.equals("draw")){
            ShowMessage("Draw! No one wins");
            board.EndGame();
        }
        else if (operation.equals("nextplayer")){
            name = arr[1];
            for (int i = 0; i < players.size(); i++){
                if (players.get(i).name.equals(name)){
                    players.get(i).MakeActive();
                }
            }
        }
        else if(operation.equals("update")){
            for (int i = 1; i < arr.length; i++){
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = "";
            String temp = String.join(" ", arr);
            System.out.println(temp);
            UpdateBoard(temp);
        }
        else if(operation.equals("ok")){
        }
    }


    private void UpdateBoard(String text){
        String[] arr = text.split(" ");
        int numb = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++){
            if (arr[i].equals("add")){
                board.AddPeace(Integer.parseInt(arr[i + 1]), Integer.parseInt(arr[i + 2]), arr[i + 3]);
                i += 3;
            }
            else if (arr[i].equals("rem")){
                board.RemovePeace(Integer.parseInt(arr[i + 1]), Integer.parseInt(arr[i + 2]));
                i += 2;
            }
            else if(arr[i].equals("mov")){
                board.MovePeace(Integer.parseInt(arr[i + 1]),
                                Integer.parseInt(arr[i + 2]),
                                Integer.parseInt(arr[i + 3]),
                                Integer.parseInt(arr[i + 4]));
                i += 4;
            }
            else if (arr[i].equals("clchng")){
                board.ChanegPeaceColor(Integer.parseInt(arr[i + 1]), Integer.parseInt(arr[i + 2]), arr[i + 3]);
                i += 3;
            }
        }

    }


    private void ShowMessage(String message){
        Label text = new Label();
        text.setText(message);
        text.setStyle("-fx-text-fill: white");
        text.setPrefSize(350, 20);
        text.setFont(Font.font(15));
        Button button = new Button("Ok!");
        Stage temp = new Stage();
        button.setOnMouseClicked(event -> temp.close());
        VBox box = new VBox();
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setPrefSize(70, 30);
        text.setAlignment(Pos.TOP_CENTER);
        box.getChildren().add(text);
        box.getChildren().add(button);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(35.0);
        box.setStyle("-fx-background-color: #939393;");
        button.setStyle("-fx-background-color: #191919; -fx-text-fill: white;");
        Scene inside = new Scene(box, 400, 130);
        temp.setScene(inside);
        temp.show();
    }

}


interface BoardUI {
    void AddPeace(int x, int y, String color);
    void RemovePeace(int x, int y);
    void MovePeace(int x, int y, int new_x, int new_y);
    void ChanegPeaceColor(int x, int y, String color);
    void EndGame();
}


interface PeaceUI {

}


interface PlayerUI {
    String name = "";
    void MakeActive();
}