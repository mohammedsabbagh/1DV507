package ms225hk_assign2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import javax.swing.border.TitledBorder;


public class Snowman extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        // drawing the sky
        Rectangle sky = new Rectangle(0,0,500,300);
        sky.setFill(Color.rgb(51, 204,255));

        // drawing the sun
        Circle sun = new Circle(430, 70, 40);
        sun.setFill(Color.YELLOW);

        // drawing the the three circle for snowman
        Circle head = new Circle(250, 140, 20);
        head.setFill(Color.WHITE);

        Circle middle = new Circle(250, 190, 35);
        middle.setFill(Color.WHITE);

        Circle bottom = new Circle(250, 260, 50);
        bottom.setFill(Color.WHITE);

         // drawing the the three  button in the middle circle
        Circle button1 = new Circle(250, 170, 3);
        Circle button2 = new Circle(250, 185, 3);
        Circle button3 = new Circle(250, 200, 3);

        // drawing the mouth line in the head circle
        Line mouth = new Line(242, 147, 258, 147);

        // drawing the eyes
        Circle eye1 = new Circle(240, 135, 3);
        Circle eye2 = new Circle(260, 135, 3);


        //Create the root and add all nodes
        Group root = new Group();
        root.getChildren().addAll(sky, sun, bottom, middle, head, button1, button2, button3, mouth, eye1, eye2);

        //Create the scene
        Scene scene = new Scene(root, 490, 400);

        //Setting up the stage

        primaryStage.setTitle("Snowman");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);

    }
}
