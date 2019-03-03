package ms225hk_assign3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TinyPainter extends Application {

    private Line line;
    private Rectangle rectangle;
    private Circle circle;
    private double x;
    private double y;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane layout = new Pane();
        Scene scene = new Scene(layout, 700, 500);

        ComboBox<String> shape = new ComboBox<>();
        shape.relocate(5, 5);
        shape.getItems().addAll("Line", "Dot", "Rectangle", "Circle");
        shape.getSelectionModel().selectFirst();
        ComboBox<String> size = new ComboBox<>();
        size.relocate(115, 5);
        size.getItems().addAll("1", "2", "4", "8", "12", "16", "24", "28", "32", "36", "40");
        size.getSelectionModel().selectFirst();
        ColorPicker color = new ColorPicker();
        color.relocate(180, 5);


        layout.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getX();
                y = event.getY();

                if (shape.getSelectionModel().getSelectedIndex() == 0) {
                    int lineWidth = Integer.parseInt(size.getSelectionModel().getSelectedItem());
                    line = new Line();
                    line.setStrokeWidth(lineWidth);
                    line.setStroke(color.getValue());
                    line.relocate(x, y);
                    layout.getChildren().addAll(line);
                } else if (shape.getSelectionModel().getSelectedIndex() == 1) {
                    int dotSize = Integer.parseInt(size.getSelectionModel().getSelectedItem());
                    rectangle = new Rectangle(dotSize, dotSize);
                    rectangle.setFill(color.getValue());
                    rectangle.relocate(x, y);
                    layout.getChildren().addAll(rectangle);
                } else if (shape.getSelectionModel().getSelectedIndex() == 2) {
                    rectangle = new Rectangle();
                    rectangle.relocate(x, y);
                    rectangle.setFill(color.getValue());
                    layout.getChildren().addAll(rectangle);
                } else if (shape.getSelectionModel().getSelectedIndex() == 3) {
                    circle = new Circle();
                    circle.relocate(x, y);
                    circle.setFill(color.getValue());
                    layout.getChildren().addAll(circle);
                }
            }
        });

        layout.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (shape.getSelectionModel().getSelectedIndex() == 0) {
                    line.setEndX(event.getX() - x);
                    line.setEndY(event.getY() - y);
                } else if (shape.getSelectionModel().getSelectedIndex() == 2) {
                    rectangle.setHeight(event.getY() - y);
                    rectangle.setWidth(event.getX() - x);
                } else if (shape.getSelectionModel().getSelectedIndex() == 3) {
                    circle.setRadius(event.getX() - x);
                }
            }
        });
        layout.getChildren().addAll(shape, size, color);
        scene.setFill(Color.WHITESMOKE);
        primaryStage.setTitle("Tiny Painter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
