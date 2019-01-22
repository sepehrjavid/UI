package sample;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

public class Main extends Application {


    Scene scene1,scene2,scene3;
    @Override
    public void start(Stage primaryStage) throws Exception {

        BoardUi board = new BoardUi();
        VBox wrap = new VBox(10);
        wrap.getChildren().add(board);
        scene3 = new Scene(wrap, 900, 900);
        ///////////////////////////////////
        Image background1=new Image("File:tic-tac-toe-backgrounds-wallpapers.jpg");
        ImageView iv=new ImageView(background1);
        Label wellcome = new Label("Wellcome !");
        Button newgame = new Button("New Game");
        newgame.setPrefSize(150, 150);
        //newgame.setStyle();
        newgame.setOnAction(e -> primaryStage.setScene(scene3));
        Button quit = new Button("Quit");

        quit.setPrefSize(150, 150);
        quit.setOnAction(ae -> {
            primaryStage.close();
        });
        VBox wrap1 = new VBox(10);

        StackPane root = new StackPane();

        quit.setLayoutX(0);
        quit.setLayoutY(0);
        newgame.setLayoutX(300);
        newgame.setLayoutY(100);
        root.getChildren().add(iv);
        root.getChildren().add(newgame);
        root.getChildren().add(quit);

        root.setCenterShape(true);

        root.setAlignment(newgame, Pos.TOP_CENTER);
        scene1 = new Scene(root, 900, 900);

        primaryStage.setScene(scene1);

        ////////////////////////////////////////////////////////////
        TextField name1=new TextField();
        if (primaryStage.getScene() == scene1) {
            primaryStage.setScene(scene1);
            primaryStage.show();
        } else {


            primaryStage.setScene(scene2);
            primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
