package mahat.gaurab.shortestpath.View;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import mahat.gaurab.shortestpath.Controller;

public class Cirlces {

    public static Circle makingCircles(String name) {
        Circle circle = new Circle();
        circle.setId("node_" + name);
        circle.setRadius(50);
        circle.setFill(Color.RED);

        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            Controller.addNode(name);
        });

        return circle;
    }
}
