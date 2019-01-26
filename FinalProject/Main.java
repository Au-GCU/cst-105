package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;


public class Main extends Application {
    // Create StackPane to hold primary background image for start screen
    BorderPane pane = new BorderPane();
    PlayerManager playerManager = new PlayerManager();


    @Override
    public void start(Stage primaryStage) throws Exception {
        // create all players
        playerManager.createPlayers("all");
        // set HBox as header/banner
        pane.setTop(getHbox());

        // set up left navigation
        VBox nav = new VBox(15);
        // create controls for vBox
        Button homeButton = new Button("Home");
        Button viewAllPlayersButton = new Button("View All Players");
        Button viewMyRosterButton = new Button("View My Roster");
        Button backButton = new Button("Back");
        nav.setAlignment(Pos.CENTER);
        nav.setPadding(new Insets(15, 15, 15, 15));
        nav.setStyle("-fx-background-color: lightgray");
        nav.getChildren().addAll(homeButton, viewAllPlayersButton, viewMyRosterButton, backButton);

        pane.setLeft(nav);
        // Create start button and set other button events
        Button startButton = new Button("Create Players");
        startButton.setOnAction(e -> {
            pane.setCenter(PrimaryPaneClass.showInfo("Welcome, Player Manager! \n Your players have been created. \n" +
                    "Use the navigation on the left hand side of this window to play!"));
        });

        homeButton.setOnAction(e -> {pane.setCenter(PrimaryPaneClass.showInfo(
                "Here's the home screen."
        ));});
        viewAllPlayersButton.setOnAction(e -> {pane.setCenter(PrimaryPaneClass.showInfo(
                "Here's all of the players"
        ));});
        viewMyRosterButton.setOnAction(e -> {pane.setCenter(PrimaryPaneClass.showInfo(
                "Here's your current roster"
        ));});
        backButton.setOnAction(e -> {pane.setCenter(PrimaryPaneClass.showInfo(
                "Here's your last screen"
        ));});

        pane.setCenter(startButton);
        //Add event handler to start button

        // Add to StackPane

        //pane.setBottom(btStart);

        // Create new scene to hold pane and place it in the stage

        Scene scene = new Scene(pane, 800, 480);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("NFL Draft Simulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private HBox getHbox() {
        HBox header = new HBox(15);
        // create logo/icon and specify dimensions, place in view
        Image icon = new Image("https://i.ibb.co/93mYBhS/football-icon.png");
        ImageView iconView = new ImageView(icon);
        iconView.setFitHeight(80);
        iconView.setFitWidth(130);
        // add icon to header
        header.setPadding(new Insets(15, 15, 15, 15));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: lightgray");
        header.getChildren().add(iconView);
        Label headerLabel = new Label("Welcome to NFL Draft in Java!");
        headerLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        header.getChildren().add(headerLabel);
        return header;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

// all this does is take a String argument in the static method and spit it out in a formatted VBox pane
// I then use this VBox to present content in the main area (pane.setCenter() in the main BorderPane).
class PrimaryPaneClass {
    private String info;
    private VBox lastPane; // still have to figure out the "back" functionality

    public PrimaryPaneClass(String info) {
        this.info = info;
        StackPane pane = new StackPane();
        Text text = new Text(info);
        pane.getChildren().add(text);
    }
    public static VBox showInfo(String info) {
        VBox pane = new VBox(15);
        pane.setPadding(new Insets(15));
        Text text = new Text(info);
        pane.getChildren().add(text);
        pane.setAlignment(Pos.CENTER);
        return pane;
    }
}
