package mahat.gaurab.shortestpath.Model;

import javafx.animation.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
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

    public static void pathsColor(String endNode, List<NodeClass> paths) {
        String startingNode = paths.get(0).getName();

        for(int i = 1; i < paths.size(); i++) {
            //Find the path and color it
            var line = (Line) MainView.getPane().lookup("#line_"+
                    startingNode + "_" + paths.get(i).getName());

            if(line == null) {
                line = (Line) MainView.getPane().lookup("#line_"+
                        paths.get(i).getName() + "_" + startingNode);
            }

            startingNode = paths.get(i).getName();

            StrokeTransition strokeTransition = new StrokeTransition(Duration.seconds(i+2), line);
            strokeTransition.setToValue(Color.YELLOW);
            strokeTransition.play();

            //Find the node and color it
            var circle = (Circle) MainView.getPane().lookup("#node_" + paths.get(i).getName());

            FillTransition fillTransition = new FillTransition(Duration.seconds(i+2),
                    circle, Color.BLACK, Color.YELLOW);
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.1));
            SequentialTransition sequentialTransition = new SequentialTransition(pauseTransition, fillTransition);
            sequentialTransition.play();
        }

        //For the last line to reach the end node
        var line = (Line) MainView.getPane().lookup("#line_"+
                startingNode + "_" + endNode);

        if(line == null) {
            line = (Line) MainView.getPane().lookup("#line_"+
                    endNode + "_" + startingNode);
        }

        StrokeTransition strokeTransition = new StrokeTransition(Duration.seconds(paths.size()+2), line);
        strokeTransition.setToValue(Color.YELLOW);
        strokeTransition.play();

        //After the nodes and paths has been colored, clear the linked list
        MainView.clearLinkedList();

    }
}
