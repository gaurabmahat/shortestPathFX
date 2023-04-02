package mahat.gaurab.shortestpath.View;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cirlces {

    public static StackPane makingCircles(String name) {
        Group root = new Group();
        Circle circle = new Circle();
        circle.setId("node_" + name);
/*        circle.setCenterX(100);
        circle.setCenterY(100);*/
        circle.setRadius(50);
        circle.setFill(Color.RED);

        Label label = new Label(String.format("%s", name));

        root.getChildren().addAll(circle);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(root, label);

        return stackPane;
    }
}
