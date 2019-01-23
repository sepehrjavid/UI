package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

import java.sql.SQLOutput;

import static sample.EngineHandler.ShowMessage;

enum TYPE{
    CPU,HUMAN,NONE
}
public class Main extends Application {
    String name_1=null;
    String name_2=null;
    TYPE type_1=TYPE.NONE;
    TYPE type_2=TYPE.NONE;
    static Stage primaryStage1;

    Scene scene_first, scene_hu_cp, scene_get_player, scene_game;

    @Override

    public void start(Stage primaryStage) throws Exception {
        EngineHandler a = new EngineHandler();
        primaryStage1 = primaryStage;
        Image background1 = new Image("File:tic-tac-toe-backgrounds-wallpapers.jpg");
        ImageView iv = new ImageView(background1);
        ///////////

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setBackground(new Background(new BackgroundImage(background1, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        Label player_1 = new Label("First Player:");
        ToggleGroup tg1 = new ToggleGroup();
        grid.add(player_1, 0, 2);
        Label lable = new Label("Human or computer?");

        lable.setPrefSize(200, 200);
        grid.add(lable, 0, 0);
        RadioButton human = new RadioButton("human");
        human.setPrefSize(200, 200);
        human.setToggleGroup(tg1);
        grid.add(human, 0, 4);
        RadioButton cpu = new RadioButton("computer");
        cpu.setToggleGroup(tg1);
        grid.add(cpu, 0, 6);

        ToggleGroup tg2 = new ToggleGroup();

         ImageView imv = new ImageView();
         Image image2 = new Image("File:human.png");

        Image image3 = new Image("File:cpuu.png");
        imv.setImage(image2);
    imv.setFitHeight(150);
    imv.setFitWidth(150);
        final HBox pictureRegion = new HBox();

        pictureRegion.getChildren().add(imv);
        grid.add(pictureRegion, 3, 4);


        final HBox pictureRegion2 = new HBox();

        ImageView imv2 = new ImageView();
        imv2.setImage(image3);
        imv2.setFitHeight(100);
        imv2.setFitWidth(100);
        pictureRegion2.getChildren().add(imv2);
        grid.add(pictureRegion2, 3, 6);


        Label player_2 = new Label("Second Player:");
        grid.add(player_2, 1, 2);
        RadioButton human2 = new RadioButton("human");
        human2.setToggleGroup(tg2);
        human2.setPrefSize(200, 200);
        grid.add(human2, 1, 4);
        RadioButton cpu2 = new RadioButton("computer");
        grid.add(cpu2, 1, 6);
        cpu2.setToggleGroup(tg2);

        tg1.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)tg1.getSelectedToggle();

                if (rb != null) {
                    if(rb.getText()=="cpu")
                    type_1 = TYPE.CPU;
                    else{
                            type_1 = TYPE.HUMAN;
                    }
                }

            }
        });


        tg2.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)tg2.getSelectedToggle();

                if (rb != null) {
                    if(rb.getText()=="cpu")
                        type_2 = TYPE.CPU;
                    else{
                        type_2= TYPE.HUMAN;
                    }
                }
            }
        });

        Button button = new Button("OK");
        button.setPrefSize(50, 50);
        grid.add(button, 0, 8);
        button.setOnAction(e -> {
            if(type_1==TYPE.NONE||type_2==TYPE.NONE){
                ShowMessage("No options have been selected!");

                primaryStage1.setScene(scene_hu_cp);
            }
            else {
            primaryStage1.setScene(scene_get_player);
            }});
        grid.setAlignment(Pos.TOP_CENTER);

        scene_hu_cp = new Scene(grid, 900, 900);

        ///////////////////////////////////////////////////////
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);

        grid1.setPadding(new Insets(25, 25, 25, 25));
        grid1.setVgap(5);
        grid1.setHgap(5);
        grid1.setBackground(new Background(new BackgroundImage(background1, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        Label userName = new Label("please enter name of first player:");
        grid1.add(userName, 0, 1);

        TextField userTextField = new TextField();
        // userTextField.setp
        userTextField.setPromptText("Name of first player");
        userTextField.setFocusTraversable(false);

        grid1.add(userTextField, 1, 1);
        Label userName2 = new Label("please enter name of second player:");
        grid1.add(userName2, 0, 15);


        TextField userTextField2 = new TextField();
        // userTextField.setp
        userTextField2.setPromptText("Name of second player");
        userTextField2.setFocusTraversable(false);

        grid1.add(userTextField2, 1, 15);
        Button submit = new Button("OK");
        grid1.add(submit, 0, 20);
        submit.setOnAction(e -> {
            System.out.println(userTextField.getText());
            System.out.println(userTextField2.getText());
            if (userTextField.getText().equals(userTextField2.getText())) {
                ShowMessage("Same Name!names must be different.");
                System.out.println("dhbjjdc");
                userTextField.setText("");
                userTextField2.setText("");
                primaryStage1.setScene(scene_get_player);
                primaryStage1.show();
            } else {
                name_1 = userTextField.getText();
                name_2 = userTextField2.getText();
                primaryStage1.setScene(scene_game);
                primaryStage1.show();
            }
        });

        scene_get_player = new Scene(grid1, 900, 900);
        ////////////////////////////////////////////////////
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setBackground(new Background(new BackgroundImage(background1, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setVgap(21);
        gridPane.setHgap(21);

        Label wellcome = new Label("Wellcome !");
        Button newgame = new Button("New Game");
        newgame.setPrefSize(100, 100);
        //newgame.setStyle();
        Scene finalScene = scene_hu_cp;
        newgame.setOnAction(e -> {
            primaryStage1.setScene(finalScene);
        });
        Button quit = new Button("Quit");

        quit.setPrefSize(100, 100);
        quit.setOnAction(ae -> {
            primaryStage1.close();
        });
        gridPane.add(newgame, 0, 1);

        gridPane.add(quit, 0, 3);
        scene_first = new Scene(gridPane, 900, 900);

        primaryStage1.setScene(scene_first);


        BoardUi board = new BoardUi(primaryStage1, scene_first);
        VBox wrap = new VBox(10);
        wrap.getChildren().add(board);
        scene_game = new Scene(wrap, 900, 900);
        ///////////////////////////////////
        ///////////////////////////////////

        ////////////////////////////////////////////////////////////
        TextField name1 = new TextField();
        if (primaryStage1.getScene() == scene_first) {
            primaryStage1.setScene(scene_first);
            primaryStage1.show();
        } else if (primaryStage1.getScene() == scene_get_player) {


            primaryStage1.setScene(scene_get_player);
            primaryStage1.show();
        }
        else if (primaryStage1.getScene() == scene_game) {


            primaryStage1.setScene(scene_game);
            primaryStage1.show();}
        else {
            primaryStage1.setScene(scene_hu_cp);
            primaryStage1.show();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
