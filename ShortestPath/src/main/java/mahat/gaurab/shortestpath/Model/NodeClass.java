package mahat.gaurab.shortestpath.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
public class NodeClass implements Comparable<NodeClass>{
    private final String name;
    private Integer distance = Integer.MAX_VALUE;
    private List<NodeClass> shortestPath = new LinkedList<>();
    private Map<NodeClass, Integer> adjacentNodes = new HashMap<>();

    public void addAdjacentNodes(NodeClass node, int weight) {
        adjacentNodes.put(node, weight);
    }

    @Override
    public int compareTo(NodeClass node) {
        return Integer.compare(this.distance, node.getDistance());
    }
}
