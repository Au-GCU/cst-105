package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.stage.Stage;
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
    VBox playersPane = new VBox(10);

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create all players
        playerManager.createPlayers("all");


        // This VBox defines the left navigation
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


        // Create start button
        Button startButton = new Button("Create Players");

        // Configure View All Players Pane
        Button backButtonPlayerPane = new Button("Back");
        playersPane.getChildren().add(getPlayersPane());
        playersPane.getChildren().add(backButtonPlayerPane);


        // EVENT HANDLERS
        startButton.setOnAction(e -> {
            pane.setCenter(PrimaryPaneClass.showInfo("Welcome, Player Manager! \n Your players have been created. \n" +
                    "Use the navigation on the left hand side of this window to play!"));
        });

        homeButton.setOnAction(e -> {
            pane.setCenter(PrimaryPaneClass.showInfo(
                    "Here's the home screen."
            ));
        });
        viewAllPlayersButton.setOnAction(e -> {
            pane.setCenter(getPlayersPane());
        });
        viewMyRosterButton.setOnAction(e -> {
            pane.setCenter(PrimaryPaneClass.showInfo(
                    "Here's your current roster"
            ));
        });
        backButton.setOnAction(e -> {
            pane.setCenter(PrimaryPaneClass.showInfo(
                    "Here's your last screen"
            ));
        });
        backButtonPlayerPane.setOnAction(e -> pane.setCenter(getPlayersPane()));

        // Set panes
        pane.setTop(getHbox());
        pane.setLeft(nav);
        pane.setCenter(startButton);


        // Create new scene to hold pane and place it in the stage

        Scene scene = new Scene(pane, 800, 480);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("NFL Draft Simulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // This HBox defines the header/banner
    private HBox getHbox() {
        // create the pane to hold the nodes and specify properties and styles
        HBox header = new HBox(15);
        header.setPadding(new Insets(15, 15, 15, 15));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: lightgray");

        // create logo/icon and specify dimensions, place in view
        Image icon = new Image("https://i.ibb.co/93mYBhS/football-icon.png");
        ImageView iconView = new ImageView(icon);
        iconView.setFitHeight(80);
        iconView.setFitWidth(130);

        // add icon to header
        header.getChildren().add(iconView);

        // Create banner label and specify font, then add to pane
        Label headerLabel = new Label("Welcome to NFL Draft in Java!");
        headerLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        header.getChildren().add(headerLabel);

        // return pane
        return header;
    }

    // pane method for getting all players
    // there is no way I can turn in this massive method. I have to figure out something else.
    // also I need to break up the playerPane.add() statements. They are barely readable with so many nested statements.
    private GridPane getPlayersPane() {
        // Buttons for adding players
/*      *** I MAY HAVE TO KEEP THESE BECAUSE I CANT .setOnAction for anonymous button objects... I don't think. ****

        Button addPlayer1 = new Button("Add");
        Button addPlayer2 = new Button("Add");
        Button addPlayer3 = new Button("Add");
        Button addPlayer4 = new Button("Add");
        Button addPlayer5 = new Button("Add");
        Button addPlayer6 = new Button("Add");

        // Buttons for viewing stats
        Button statsPlayer1 = new Button("Full Stats");
        Button statsPlayer2 = new Button("Full Stats");
        Button statsPlayer3 = new Button("Full Stats");
        Button statsPlayer4 = new Button("Full Stats");
        Button statsPlayer5 = new Button("Full Stats");
        Button statsPlayer6 = new Button("Full Stats");*/

        // create players grid and set properties
        GridPane playersPane = new GridPane();
        playersPane.setAlignment(Pos.CENTER);
        playersPane.setVgap(10);
        playersPane.setHgap(10);

        // Label objects for header rows
        Label nameLabel = new Label("Name");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
        Label positionLabel = new Label("Position");
        positionLabel.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
        Label heightLabel = new Label("Height");
        heightLabel.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
        Label weightLabel = new Label("Weight");
        weightLabel.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
        Label ageLabel = new Label("Age");
        ageLabel.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));

        // header rows

        playersPane.add(nameLabel, 0, 0);
        playersPane.add(positionLabel, 1, 0);
        playersPane.add(heightLabel, 2, 0);
        playersPane.add(weightLabel, 3, 0);
        playersPane.add(ageLabel, 4, 0);

        // populate players rows
        int row = 1;
        // for-loop getting each player object and calling getter methods in PlayerManager
        for (int i = 0; i < playerManager.getPlayerListCount(); i++) {
            playersPane.add(new Label(playerManager.getPlayer(i).getPlayerName()), 0, row);
            playersPane.add(new Label(playerManager.getPlayer(i).getPosition()), 1, row);
            playersPane.add(new Label(Integer.toString(playerManager.getPlayer(i).getHeight())), 2, row);
            playersPane.add(new Label(Integer.toString(playerManager.getPlayer(i).getWeight())), 3, row);
            playersPane.add(new Label(Integer.toString(playerManager.getPlayer(i).getAge())), 4, row);
            playersPane.add(new Button("Add"), 5, row);
            playersPane.add(new Button("Full Stats"), 6, row);
            row++;
        }

        return playersPane;

    }


    // set up "view full stats" pane
    private GridPane getFullStatPane(int i) {
        GridPane pane = new GridPane();
        pane.setHgap(30);
        pane.setVgap(10);
        pane.add(new Label("Name"), 0, 0);
        pane.add(new Label("College"), 0, 1);
        pane.add(new Label("Position"), 0, 2);
        pane.add(new Label("Year"), 0, 3);
        pane.add(new Label("Jersey Number"), 0, 4);
        pane.add(new Label("Weight in Pounds"), 0, 5);
        pane.add(new Label("Height in Inches"), 0, 6);
        pane.add(new Label("Age"), 0, 7);
        pane.add(new Label("Seasons Played"), 0, 8);
        if (playerManager.getPlayer(i) instanceof OffensivePlayer) {
            pane.add(new Label("Passing Completions"), 0, 9);
            pane.add(new Label("Passing Attempts"), 0, 10);
            pane.add(new Label("Touchdowns"), 0, 11);
            pane.add(new Label("Interceptions"), 0, 12);
            pane.add(new Label("Yards"), 0, 13);
        } else if (playerManager.getPlayer(i) instanceof DefensivePlayer) {
            pane.add(new Label("Tackles"), 0, 9);
            pane.add(new Label("Sacks"), 0, 10);
            pane.add(new Label("Forced Fumbles"), 0, 11);
            pane.add(new Label("Interceptions"), 0, 12);

        } else {
            pane.getChildren().removeAll();
            pane.getChildren().add(PrimaryPaneClass.showInfo("You have made an invalid selection"));
        }

        pane.add(new Text(playerManager.getPlayer(i).getPlayerName()), 1, 0);
        pane.add(new Text(playerManager.getPlayer(i).getCollege()), 1, 1);
        pane.add(new Text(playerManager.getPlayer(i).getPosition()), 1, 2);
        pane.add(new Text(playerManager.getPlayer(i).getCollegeYear()), 1, 3);
        pane.add(new Text(Integer.toString(playerManager.getPlayer(i).getNumber())), 1, 4);
        pane.add(new Text(Integer.toString(playerManager.getPlayer(i).getWeight())), 1, 5);
        pane.add(new Text(Integer.toString(playerManager.getPlayer(i).getHeight())), 1, 6);
        pane.add(new Text(Integer.toString(playerManager.getPlayer(i).getAge())), 1, 7);
        pane.add(new Text(Integer.toString(playerManager.getPlayer(i).getSeasonsPlayed())), 1, 8);
        if (playerManager.getPlayer(i) instanceof OffensivePlayer) {
            pane.add(new Text(Integer.toString(((OffensivePlayer) playerManager.getPlayer(i)).getPassingCompletions())), 1, 9);
            pane.add(new Text(Integer.toString(((OffensivePlayer) playerManager.getPlayer(i)).getPassingAttempts())), 1, 10);
            pane.add(new Text(Integer.toString(((OffensivePlayer) playerManager.getPlayer(i)).getTouchdowns())), 1, 11);
            pane.add(new Text(Integer.toString(((OffensivePlayer) playerManager.getPlayer(i)).getInterceptions())), 1, 12);
            pane.add(new Text(Integer.toString(((OffensivePlayer) playerManager.getPlayer(i)).getYards())), 1, 13);
        } else if (playerManager.getPlayer(i) instanceof DefensivePlayer) {
            pane.add(new Text(Integer.toString(((DefensivePlayer) playerManager.getPlayer(i)).getTackles())), 1, 9);
            pane.add(new Text(Integer.toString(((DefensivePlayer) playerManager.getPlayer(i)).getSacks())), 1, 10);
            pane.add(new Text(Integer.toString(((DefensivePlayer) playerManager.getPlayer(i)).getForcedFumbles())), 1, 11);
            pane.add(new Text(Integer.toString(((DefensivePlayer) playerManager.getPlayer(i)).getInterceptions())), 1, 12);

        }
        return pane;
    }



    /**
     * Main method that launches program for IDEs - not required for launching from console
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

// all this does is take a String argument in the static method and spit it out in a formatted VBox pane
// I then use this VBox to present content in the main area (pane.setCenter() in the main BorderPane).
class PrimaryPaneClass {
    private String info;
    private VBox lastPane; // still have to figure out the "back" button functionality

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
