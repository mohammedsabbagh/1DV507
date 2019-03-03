package ms225hk_assign2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class CompoundInterest extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    //check if the entry is a number
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    //the compound interest equation
    public long calcInterest(double a, double r, double y) {
        return Math.round(a * Math.pow((1 + r / 100.0), y));
    }

    @Override
    public void start(Stage primaryStage) {


        primaryStage.setTitle("CompoundInterest");
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 17));
        pane.setHgap(5.5);
        pane.setVgap(5.5);


        Text titleCI = new Text(0, 0, "Compound Interest");
        titleCI.setTextAlignment(TextAlignment.CENTER);
        titleCI.setFont(Font.font("Helvetica", 30));
        pane.add(titleCI, 1, 0);

        pane.add(new Label("Start Amount: "), 0, 1);
        final TextField startAmount = new TextField();
        pane.add(startAmount, 1, 1);

        pane.add(new Label("Interest"), 0, 2);
        final TextField Interest = new TextField();
        pane.add(Interest, 1, 2);

        pane.add(new Label("Number of years"), 0, 3);
        final TextField nYears = new TextField();
        pane.add(nYears, 1, 3);

        final Label result = new Label();
        pane.add(result, 0, 5);


        Button calCulate = new Button("Calculate");
        pane.add(calCulate, 0, 4);
        GridPane.setHalignment(calCulate, HPos.LEFT);



        calCulate.setOnAction(e -> {
            String sA = startAmount.getText();
            String iN = Interest.getText();
            String nY = nYears.getText();

            if (startAmount.getText().isEmpty() || Interest.getText().isEmpty() || nYears.getText().isEmpty())
                result.setText("One Field empty");
            else if (isNumeric(sA)&&isNumeric(iN)&&isNumeric(nY)){
                long res = calcInterest(Double.parseDouble(sA), Double.parseDouble(iN), Double.parseDouble(nY));
                result.setText("Total: " + res);
            }
            else {
                result.setText("entry error");
            }


        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }
}
