/**
 * @author Jack Hall
 * @professor Amr Elchouemi
 * @course CST-105
 * This code was written by me for class
 * @since 1-23-19
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

public class Exercise14_04 extends Application {
    @Override // override start method in Application
    public void start(Stage primaryStage) {
        // Create pane to hold nodes, setting padding and positioning
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5, 5, 5, 5));
        hBox.setAlignment(Pos.CENTER);



        // assign random color and opacity and add to pane
        for (int i = 0; i < 5; i++) {
            // Create text
            Text text = new Text("Java");
            // Assign text font properties
            text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
            // set random colors and opacity with Math.random
            text.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
            //rotate text
            text.setRotate(90);
            // add nodes to pane
            hBox.getChildren().add(text);
        }



        // set pane in scene, set scene in stage
        Scene scene = new Scene(hBox, 400, 100);
        primaryStage.setTitle("Exercise 14.4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
