package mahat.gaurab.shortestpath.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import mahat.gaurab.shortestpath.View.MainView;

import java.util.List;

public class DisplayPath {

    public static void changeColor(NodeClass endNode, List<NodeClass> paths) {
        paths.forEach(node -> {
            var circle = (Circle) MainView.getPane().lookup("#node_" + node.getName());
            circle.setFill(Color.RED);
        });
        var circle = (Circle) MainView.getPane().lookup("#node_" + endNode.getName());
        circle.setFill(Color.RED);
    }
}
