package ms225hk_assign3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RunningSanta extends Application {

    private int x_speed = 7;
    private int imageCounter = 0;
    private int width = 1000;
    private int height = 500;
    private int santaWidth = 170;
    private int santaHeight = 120;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group layout = new Group();
        Image background = new Image(getClass().getResourceAsStream("images/background.png"));
        Image[] images = new Image[11];
        images[0] = new Image(getClass().getResourceAsStream("images/Run1.png"));
        images[1] = new Image(getClass().getResourceAsStream("images/Run2.png"));
        images[2] = new Image(getClass().getResourceAsStream("images/Run3.png"));
        images[3] = new Image(getClass().getResourceAsStream("images/Run4.png"));
        images[4] = new Image(getClass().getResourceAsStream("images/Run5.png"));
        images[5] = new Image(getClass().getResourceAsStream("images/Run6.png"));
        images[6] = new Image(getClass().getResourceAsStream("images/Run7.png"));
        images[7] = new Image(getClass().getResourceAsStream("images/Run8.png"));
        images[8] = new Image(getClass().getResourceAsStream("images/Run9.png"));
        images[9] = new Image(getClass().getResourceAsStream("images/Run10.png"));
        images[10] = new Image(getClass().getResourceAsStream("images/Run11.png"));

        ImageView bg = new ImageView(background);
        bg.setFitHeight(height);
        bg.setFitWidth(width);

        Image santa = new Image(getClass().getResourceAsStream("images/Run1.png"));
        ImageView sc = new ImageView(santa);
        sc.setFitWidth(santaWidth);
        sc.setFitHeight(santaHeight);
        sc.setX(350);
        sc.setY(260);

        layout.getChildren().addAll(bg, sc);
        Scene scene = new Scene(layout, 1000, 500);
        primaryStage.setTitle("Running Santa");
        primaryStage.setScene(scene);
        primaryStage.show();

        KeyFrame k = new KeyFrame(Duration.millis(30), event -> {
            if (imageCounter == 11) {
                imageCounter = 0;
            }
            sc.setImage(images[imageCounter++]);
            sc.setX(sc.getX() + x_speed);

            if (sc.getX() <= 0 || sc.getX() >= width - santaWidth) {
                x_speed = -x_speed;
            }

            if (x_speed < 0) {
                sc.setScaleX(-1);
            } else {
                sc.setScaleX(1);
            }
        });

        Timeline tim = new Timeline(k);
        tim.setCycleCount(Timeline.INDEFINITE);
        tim.play();
    }
}
