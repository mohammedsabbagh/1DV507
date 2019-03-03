package ms225hk_assign2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Yahtzee extends Application {


    public int[] rollDice = new int[5];
    public int play = 3;
    public Image d1 = new Image(new FileInputStream("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign2\\d1.png"));
    public Image d2 = new Image(new FileInputStream("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign2\\d2.png"));
    public Image d3 = new Image(new FileInputStream("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign2\\d3.png"));
    public Image d4 = new Image(new FileInputStream("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign2\\d4.png"));
    public Image d5 = new Image(new FileInputStream("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign2\\d5.png"));
    public Image d6 = new Image(new FileInputStream("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign2\\d6.png"));

    public Yahtzee() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * to get the image and match it with right dice face number
     *
     * @param n the dice face value of the dice
     * @return image with right value
     */
    public Image getImage(int n) {

        int diceValue = 0;

        diceValue = (int) (Math.random() * 6 + 1);

        Image tImage = null;

        switch (diceValue) {
            case 1:
                tImage = d1;
                break;
            case 2:
                tImage = d2;
                break;
            case 3:
                tImage = d3;
                break;
            case 4:
                tImage = d4;
                break;
            case 5:
                tImage = d5;
                break;
            case 6:
                tImage = d6;
                break;
            default:
                System.err.println("Invalid value");
                break;
        }
        rollDice[n - 1] = diceValue;

        return tImage;
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        Text text = new Text("Yahtzee");
        text.setFont(Font.font(20));
        pane.add(text, 0, 0);

        /* add images to panel */
        ImageView dice1 = new ImageView(d1);
        pane.add(dice1, 0, 1);
        ImageView dice2 = new ImageView(d2);
        pane.add(dice2, 1, 1);
        ImageView dice3 = new ImageView(d3);
        pane.add(dice3, 2, 1);
        ImageView dice4 = new ImageView(d4);
        pane.add(dice4, 3, 1);
        ImageView dice5 = new ImageView(d5);
        pane.add(dice5, 4, 1);


        //creating checkboxes
        CheckBox ch1 = new CheckBox();
        ch1.setDisable(true);
        pane.add(ch1, 0, 2);

        CheckBox ch2 = new CheckBox();
        ch2.setDisable(true);
        pane.add(ch2, 1, 2);

        CheckBox ch3 = new CheckBox();
        ch3.setDisable(true);
        pane.add(ch3, 2, 2);

        CheckBox ch4 = new CheckBox();
        ch4.setDisable(true);
        pane.add(ch4, 3, 2);

        CheckBox ch5 = new CheckBox();
        ch5.setDisable(true);
        pane.add(ch5, 4, 2);


        //creating a label
        Label rollsLeft = new Label();
        rollsLeft.setText("You have 3 rolls left");
        pane.add(rollsLeft, 1, 3);

        //creating roll the dice button
        Button bt = new Button("Roll the Dice!");
        pane.add(bt, 0, 3);

        bt.setOnAction(e -> {
            play--;

            if (play >= 0) {   // activate check boxes to select
                System.out.println(play);
                ch1.setDisable(false);
                ch2.setDisable(false);
                ch3.setDisable(false);
                ch4.setDisable(false);
                ch5.setDisable(false);

                //display the selected dice face
                if (!ch1.isSelected()) {
                    Image i = getImage(1);
                    dice1.setImage(i);
                }
                if (!ch2.isSelected()) {
                    Image i = getImage(2);
                    dice2.setImage(i);
                }
                if (!ch3.isSelected()) {
                    Image i = getImage(3);
                    dice3.setImage(i);
                }
                if (!ch4.isSelected()) {
                    Image i = getImage(4);
                    dice4.setImage(i);
                }
                if (!ch5.isSelected()) {
                    Image i = getImage(5);
                    dice5.setImage(i);
                }
                rollsLeft.setText("You have " + play + " roll(s) left.");
            }

            if (play == 0) {
                rollsLeft.setText(displayResult());
            }
        });

        Scene sc = new Scene(pane);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Yahtzee");
        primaryStage.show();


    }

    public String displayResult() {
        boolean threeofK = false;
        boolean pair = false;


        //Check if yahtzee
        for (int i = 0; i <= 5; i++) {
            int matches = 0;
            for (int j = 0; j < 5; j++) {
                if (rollDice[j] == i) {
                    matches++;
                }
                if (matches == 5) {
                    return "Yahtzee!";
                }
            }
        }

        //Check if four of a kind
        for (int i = 0; i <= 5; i++) {
            int matches = 0;
            for (int j = 0; j < 5; j++) {
                if (rollDice[j] == i) {
                    matches++;
                }
                if (matches == 4) {
                    return "Four of a kind";
                }
            }
        }

        //Check if three of a kind

        for (int i = 0; i <= 5; i++) {
            int matches = 0;
            for (int j = 0; j < 5; j++) {
                if (rollDice[j] == i) {
                    matches++;
                }
                if (matches == 3) {
                    threeofK=true;
                    return "three of a kind";
                }
            }
        }

        //a small straight is 4 consecutive faces
        //Check if Small Straight
        if ((rollDice[0] == 1 && rollDice[1] == 2 && rollDice[2] == 3 && rollDice[3] == 4) ||
                (rollDice[1] == 2 && rollDice[2] == 3 && rollDice[3] == 4 && rollDice[4] == 5) ||
                (rollDice[2] == 3 && rollDice[3] == 4 && rollDice[4] == 5 && rollDice[5] == 6)) {
            return "Small Straight";
        }


        //there are only two possible large straights: {1, 2, 3, 4, 5} and {2, 3, 4, 5, 6}.
        //Check if Large Straight
        if ((rollDice[0] == 1 && rollDice[1] == 2 && rollDice[2] == 3 && rollDice[3] == 4 && rollDice[4] == 5) ||
                (rollDice[0] == 2 && rollDice[1] == 3 && rollDice[2] == 4 && rollDice[3] == 5 && rollDice[4] == 6)) {
            return "Large Straight";
        }

        //Check if pair
        for (int i = 0; i <= 5; i++) {
            int matches = 0;
            for (int j = 0; j < 5; j++) {
                if (rollDice[j] == i) {
                    matches++;
                }
                if (matches == 2) {
                    pair= true;
                    return "Pair";
                }
            }
        }

        //a Full House is a roll where you have both a 3 of a kind, and a pair.
        //check if Full House


        if (pair==threeofK)
        {

            return "Full House";
        }


        return "No combinations";
    }

}
