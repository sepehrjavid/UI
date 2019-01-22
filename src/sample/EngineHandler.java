package sample;

import java.util.List;

public class EngineHandler {
    private BoardUI board;
    private MySocket socket;
    private List<PlayerUI> players;

    public EngineHandler(List<PlayerUI> players, BoardUI board) {
        socket = new MySocket();
        this.players = players;
        this.board = board;
    }


    public void handle(String message) {
        String[] arr = message.split(" ");
        String operation = arr[0];
        String name;
        if (operation.equals("nolegalmove")){
            //TODO tell the stage there are no legal moves
            name = arr[1];
            for (int i = 0; i < players.size(); i++){
                if (players.get(i).name.equals(name)){
                    players.get(i).MakeActive();
                }
            }
        }
        else if(operation.equals("invalidmove")){

        }
        else if (operation.equals("nobeadinselectedarea")){

        }
        else if (operation.equals("winner")){
            name = arr[1];
            //TODO make a player winner and quit the game
        }
        else if (operation.equals("draw")){
            //TODO tell the stage the game is draw
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

}


interface BoardUI {
    void AddPeace(int x, int y, String color);
    void RemovePeace(int x, int y);
    void MovePeace(int x, int y, int new_x, int new_y);
    void ChanegPeaceColor(int x, int y, String color);
}


interface PeaceUI {

}


interface PlayerUI {
    String name = "";
    void MakeActive();
}