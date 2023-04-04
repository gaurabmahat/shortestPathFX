package mahat.gaurab.shortestpath;

import javafx.scene.input.MouseEvent;
import mahat.gaurab.shortestpath.Model.DisplayPath;
import mahat.gaurab.shortestpath.Model.NodeClass;
import mahat.gaurab.shortestpath.Model.ShortestPathCalculation;
import mahat.gaurab.shortestpath.View.MainView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private static ArrayList<String> startingAndEndingNode = new ArrayList<>();

    public static void EventHandler() {
        MainView.getPane().setOnMouseClicked((MouseEvent event) -> {
            if(startingAndEndingNode.size() == 2) {
                var startingNode = MainView.getNode(startingAndEndingNode.get(0));
                var endNode = MainView.getNode(startingAndEndingNode.get(1));

                if(startingNode != null && endNode != null) {
                    ShortestPathCalculation.calculateShortestPath(startingNode, endNode);
                    printPaths(Arrays.asList(endNode));
                    DisplayPath.changeColor(endNode, endNode.getShortestPath());
                }

                startingAndEndingNode.clear();
            }
        });
    }

    public static void addNode(String node) {
        startingAndEndingNode.add(node);
    }

    private static void printPaths(List<NodeClass> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(NodeClass::getName)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getName(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance()))
            );
        });
    }

}