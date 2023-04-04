package mahat.gaurab.shortestpath.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import mahat.gaurab.shortestpath.View.MainView;

import java.util.List;

public class DisplayPath {

    public static void startingNodeColor(String startingNode) {
        var circle = (Circle) MainView.getPane().lookup("#node_" + startingNode);
        circle.setFill(Color.RED);
    }

    public static void endingNodeColor(String endingNode) {
        var circle = (Circle) MainView.getPane().lookup("#node_" + endingNode);
        circle.setFill(Color.GREEN);
    }

    public static void pathsColor(NodeClass endNode, List<NodeClass> paths) {
        for(int i = 1; i < paths.size(); i++) {
            var circle = (Circle) MainView.getPane().lookup("#node_" + paths.get(i).getName());
            circle.setFill(Color.YELLOW);
        }
    }
}
