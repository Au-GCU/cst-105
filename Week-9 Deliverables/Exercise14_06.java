/**
 * @author Jack Hall
 * @professor Amr Elchouemi
 * @course CST-105
 * This code was written by me for class
 * @since 1-23-2019
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise14_06 extends Application {
    @Override // override the start method in Application class
    public void start(Stage primaryStage) {
        // create a pane to hold the nodes
        GridPane pane = new GridPane();

        // switch used to control color of cell - see Rectangle constructor below
        boolean isFilled = false;

        // nested for loop creates an 8 x 8 grid and assigns Color.BLACK to every other cell (isFilled ? True)
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rec = new Rectangle(50, 50, (isFilled) ? Color.BLACK : Color.WHITE);
                pane.add(rec,j,i);
                isFilled = !isFilled;
            }
            isFilled = !isFilled;
        }


        // place pane in scene and scene in stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 14.6");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}