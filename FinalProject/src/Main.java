/**
 * @author Jack Hall
 * @professor Amr Elchouemi
 * @course CST-105
 *
 * This code was written, painstakingly, 100% by me, for this class.
 * @since 1/26/2019
 */


import javafx.application.Application;
import javafx.geometry.Insets;
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
import javafx.scene.text.Text;
import java.util.ArrayList;

public class Main extends Application {
    // Create BorderPane to hold primary background image for start screen
    private BorderPane pane = new BorderPane();

    // instantiate playerManager that will return player objects
    private PlayerManager playerManager = new PlayerManager();

    // create a VBox for "View All Players" functionality -> must hold nested panes

    // multiple ArrayLists for controls generated in loops with local variables.
    private ArrayList<Button> playerListAddButtons = new ArrayList<>();
    private ArrayList<Button> playerListStatsButtons = new ArrayList<>();
    private ArrayList<Button> playerRosterRemoveButtons = new ArrayList<>();

    // ArrayList for holding player roster
    private ArrayList<Player> playerRoster = new ArrayList<>();

    // Global navigation Button objects
    private Button homeButton = new Button("Home");
    private Button viewAllPlayersButton = new Button("View All Players");
    private Button viewMyRosterButton = new Button("View My Roster");
    private Button backButton = new Button("Back");

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create all players
        playerManager.createPlayers("all");

        // This VBox defines the left navigation
        VBox nav = new VBox(15);
        // create controls for vBox
        nav.setAlignment(Pos.CENTER);
        nav.setPadding(new Insets(15, 15, 15, 15));
        nav.setStyle("-fx-background-color: lightgray");
        nav.getChildren().addAll(homeButton, viewAllPlayersButton, viewMyRosterButton, backButton);


        // Create start button
        Button startButton = new Button("Create Players");

        // Configure View All Players Pane
        Button backButtonPlayerPane = new Button("Back");


        // NAVIGATION EVENT HANDLERS
        startButton.setOnAction(e -> {
            pane.setCenter(getHomePane());
            backButton.setOnAction(f -> pane.setCenter(getHomePane()));
        });
        homeButton.setOnAction(e -> {
            pane.setCenter(getHomePane());
        });
        viewAllPlayersButton.setOnAction(e -> pane.setCenter(getPlayersPane()));
        viewMyRosterButton.setOnAction(e -> {
            pane.setCenter(getRosterPane());
        });
        backButton.setOnAction(e -> {
            pane.setCenter(PrimaryPaneClass.showInfo(
                    "Start navigating the program by clicking on the buttons to the left."
            ));
        });
        //backButtonPlayerPane.setOnAction(e -> pane.setCenter(getPlayersPane()));

        backButton.setVisible(true);



        // Set panes
        pane.setTop(getHbox());
        pane.setLeft(nav);
        pane.setCenter(startButton);


        // Create new scene to hold pane and place it in the stage

        Scene scene = new Scene(pane, 800, 480);
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
        Image icon = new Image("https://i.ibb.co/1Rc0QtW/football-icon.png");
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

        // create players grid and set properties
        GridPane playersPane = new GridPane();
        playersPane.setAlignment(Pos.CENTER);
        playersPane.setVgap(10);
        playersPane.setHgap(10);


        // TODO: Break these two sections out into a discreet method and pass GridPane as a parameter so I can populate first row
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
            Button addButton = new Button("Add");
            playerListAddButtons.add(addButton);
            final int j = i;
            final int rowNumber = row;
            addButton.setOnAction(e -> {
                playerRoster.add(playerManager.getPlayer(j));
                playersPane.add(new Text("Added"), 7, rowNumber);
                pane.setCenter(playersPane);
            });
            playersPane.add(addButton, 5, row);
            Button statsButton = new Button("Full Stats");
            playerListStatsButtons.add(statsButton);
            // event handler sets action of "See Full Stats" button and changes action of back button to go to "View All Players" pane
            statsButton.setOnAction(e -> {
                pane.setCenter(getFullStatPane(j));
                backButton.setOnAction(f -> pane.setCenter(getPlayersPane()));
            });
            playersPane.add(statsButton, 6, row);
            row++;
        }

        return playersPane;

    }


    // set up "view full stats" pane
    private GridPane getFullStatPane(int i) {
        GridPane pane = new GridPane();
        pane.setHgap(30);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.setId("fullStatPane");
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

    private GridPane getRosterPane() {
        GridPane rosterPane = new GridPane();
        rosterPane.setAlignment(Pos.CENTER);
        rosterPane.setHgap(15);
        rosterPane.setVgap(15);
        rosterPane.setPadding(new Insets(20));
        if (playerRoster.isEmpty() == true) {
            Text text = new Text("Your roster is currently empty");
            rosterPane.add(text, 0, 0);
        } else {
            rosterPane.add(new Label("Name"), 0, 0);
            rosterPane.add(new Label("Position"), 1, 0);
            rosterPane.add(new Label("Height"), 2, 0);
            rosterPane.add(new Label("Weight"), 3, 0);
            rosterPane.add(new Label("Age"), 4, 0);
            int row = 1;
            for(int i = 0; i < playerRoster.size(); i++) {
                rosterPane.add(new Text(playerRoster.get(i).getPlayerName()), 0, row);
                rosterPane.add(new Text(playerRoster.get(i).getPosition()), 1, row);
                rosterPane.add(new Text(Integer.toString(playerRoster.get(i).getHeight())), 2, row);
                rosterPane.add(new Text(Integer.toString(playerRoster.get(i).getWeight())), 3, row);
                rosterPane.add(new Text(Integer.toString(playerRoster.get(i).getAge())), 4, row);
                Button removeButton = new Button("Remove");
                playerRosterRemoveButtons.add(removeButton);
                // event handler sets action of "Remove" button
                final int j = i; // JavaFX wants a constant for the Lambda?
                removeButton.setOnAction(e -> {
                    playerRoster.remove(j);
                    pane.setCenter(getRosterPane()); // this refreshes the pane after the player is removed.
                });
                rosterPane.add(removeButton, 6, row);
                row++;
            }
        }
        return rosterPane;
        // roster pane here
    }

    private StackPane getHomePane() {
        StackPane homePane = new StackPane();
        homePane.setAlignment(Pos.CENTER);
        homePane.setPadding(new Insets(20));
        homePane.getChildren().add(
                PrimaryPaneClass.showInfo("Welcome, Player Manager! \n Your players have been created. \n" +
                        "Use the navigation on the left hand side of this window to play!" +
                        "\nIf you want to go back at any time, just click the back button." +
                        "\nThis program was created by Jack Hall for CST-105 class" +
                        "\nProfessor Amr Elchouemi" +
                        "\n01/27/2019")

        );
        return homePane;
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
// This gives me the ability to just provide a string to temporarily fill a pane as I develop this application.
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
