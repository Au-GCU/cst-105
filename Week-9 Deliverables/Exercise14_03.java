/**
 * @author Jack Hall
 * @professor Amr Elchouemi
 * @course CST-105
 * This code was written by me for class on 1/22/2019
 * @since 1-22-19
 */

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Exercise14_03 extends Application {
    @Override // override start method in Application
    public void start(Stage primaryStage) {
        // Create HBox pane to lay out cards
        HBox hBox = new HBox(10);

        // create array list to hold cards
        ArrayList<String> cards = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            cards.add(String.valueOf(i + 1));
        }
        // Shuffle cards as introduced in Chapter 11.12 according to problem definition
        Collections.shuffle(cards);

        // generate path for three card images and create image view
        ImageView card1 = new ImageView(new Image("images/" + cards.get(0) + ".png"));
        ImageView card2 = new ImageView(new Image("images/" + cards.get(1) + ".png"));
        ImageView card3 = new ImageView(new Image("images/" + cards.get(2) + ".png"));

        // add all nodes to pane
        hBox.getChildren().addAll(card1, card2, card3);

        // Create scene to hold pane and place scene in stage
        Scene scene = new Scene(hBox);
        primaryStage.setTitle("Exercise 14.3");
        primaryStage.setScene(scene);
        primaryStage.show();
        }


    public static void main(String args) {
        launch(args);
    }
}
