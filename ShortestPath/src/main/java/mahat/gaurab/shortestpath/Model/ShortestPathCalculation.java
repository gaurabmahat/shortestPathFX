package mahat.gaurab.shortestpath.Model;

import java.util.*;
import java.util.stream.Stream;

public class ShortestPathCalculation {

    public static void calculateShortestPath(NodeClass source, NodeClass destination) {
        source.setDistance(0);
        Set<NodeClass> settledNode = new HashSet<>();
        Queue<NodeClass> unsettledNode = new PriorityQueue<>(Collections.singleton(source));
        while(!unsettledNode.isEmpty()) {
            NodeClass currentNode = unsettledNode.poll();
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

    private static void evaluateDistanceAndPath(NodeClass adjacentNode, Integer edgeWeight, NodeClass sourceNode) {
        Integer newDistance = sourceNode.getDistance() + edgeWeight;
        if(newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(
                    Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList()
            );
        }
    }
}
