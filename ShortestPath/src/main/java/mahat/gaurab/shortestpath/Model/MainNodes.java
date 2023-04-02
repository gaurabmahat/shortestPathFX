package mahat.gaurab.shortestpath.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainNodes {

    private ArrayList<Node> listOfNodes;

    public MainNodes() {
        listOfNodes = new ArrayList<>();
        makingNodes();
    }

    public ArrayList<Node> getListOfNodes(){
        return this.listOfNodes;
    }

    private void makingNodes() {
        Node nodeA = new Node("A");
        listOfNodes.add(nodeA);
        Node nodeB = new Node("B");
        listOfNodes.add(nodeB);
        Node nodeC = new Node("C");
        listOfNodes.add(nodeC);
        Node nodeD = new Node("D");
        listOfNodes.add(nodeD);
        Node nodeE = new Node("E");
        listOfNodes.add(nodeE);
        Node nodeF = new Node("F");
        listOfNodes.add(nodeF);
        Node nodeG = new Node("G");
        listOfNodes.add(nodeG);
        Node nodeH = new Node("H");
        listOfNodes.add(nodeH);
        Node nodeI = new Node("I");
        listOfNodes.add(nodeI);
        Node nodeJ = new Node("J");
        listOfNodes.add(nodeJ);

        nodeA.addAdjacentNodes(nodeB, 5);
        nodeA.addAdjacentNodes(nodeD, 2);

        nodeB.addAdjacentNodes(nodeA, 5);
        nodeB.addAdjacentNodes(nodeC, 7);
        nodeB.addAdjacentNodes(nodeE, 4);

        nodeC.addAdjacentNodes(nodeB, 7);
        nodeC.addAdjacentNodes(nodeE, 4);
        nodeC.addAdjacentNodes(nodeG, 5);
        nodeC.addAdjacentNodes(nodeH, 8);

        nodeD.addAdjacentNodes(nodeA, 2);
        nodeD.addAdjacentNodes(nodeF, 1);

        nodeE.addAdjacentNodes(nodeB, 4);
        nodeE.addAdjacentNodes(nodeC, 4);
        nodeE.addAdjacentNodes(nodeF, 3);

        nodeF.addAdjacentNodes(nodeD, 1);
        nodeF.addAdjacentNodes(nodeE, 3);
        nodeF.addAdjacentNodes(nodeG, 9);
        nodeF.addAdjacentNodes(nodeI, 12);

        nodeG.addAdjacentNodes(nodeC, 5);
        nodeG.addAdjacentNodes(nodeF, 9);
        nodeG.addAdjacentNodes(nodeI, 2);
        nodeG.addAdjacentNodes(nodeJ, 1);

        nodeH.addAdjacentNodes(nodeC, 8);
        nodeH.addAdjacentNodes(nodeJ, 3);

        nodeI.addAdjacentNodes(nodeF, 12);
        nodeI.addAdjacentNodes(nodeG, 2);
        nodeI.addAdjacentNodes(nodeJ, 10);

        nodeJ.addAdjacentNodes(nodeG, 1);
        nodeJ.addAdjacentNodes(nodeH, 3);
        nodeJ.addAdjacentNodes(nodeI, 10);

        /*var spc = new ShortestPathCalculation();
        spc.calculateShortestPath(nodeB, nodeJ);
        printPaths(Arrays.asList(nodeJ));*/
    }

    private static void printPaths(List<Node> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(Node::getName)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getName(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance()))
            );
        });
    }
}
