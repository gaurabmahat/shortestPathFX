package mahat.gaurab.shortestpath.Model;

import java.util.*;
import java.util.stream.Stream;

public class ShortestPathCalculation {

    public void calculateShortestPath(Node source, Node destination) {
        source.setDistance(0);
        Set<Node> settledNode = new HashSet<>();
        Queue<Node> unsettledNode = new PriorityQueue<>(Collections.singleton(source));
        while(!unsettledNode.isEmpty()) {
            Node currentNode = unsettledNode.poll();
            currentNode.getAdjacentNodes()
                    .entrySet().stream()
                    .filter(entry -> !settledNode.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettledNode.add(entry.getKey());
                    });
            settledNode.add(currentNode);
            if(currentNode.equals(destination)) {
                break;
            }
        }
    }

    private void evaluateDistanceAndPath(Node adjacentNode, Integer edgeWeight, Node sourceNode) {
        Integer newDistance = sourceNode.getDistance() + edgeWeight;
        if(newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(
                    Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList()
            );
        }
    }
}
