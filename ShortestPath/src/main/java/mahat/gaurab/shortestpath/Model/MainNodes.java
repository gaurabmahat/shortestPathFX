package mahat.gaurab.shortestpath.Model;

import java.util.ArrayList;

public class MainNodes {

    private ArrayList<NodeClass> listOfNodes;

    public MainNodes() {
        listOfNodes = new ArrayList<>();
        makingNodes();
    }

    public ArrayList<NodeClass> getListOfNodes(){
        return this.listOfNodes;
    }

    private void makingNodes() {
        NodeClass nodeA = new NodeClass("A");
        listOfNodes.add(nodeA);
        NodeClass nodeB = new NodeClass("B");
        listOfNodes.add(nodeB);
        NodeClass nodeC = new NodeClass("C");
        listOfNodes.add(nodeC);
        NodeClass nodeD = new NodeClass("D");
        listOfNodes.add(nodeD);
        NodeClass nodeE = new NodeClass("E");
        listOfNodes.add(nodeE);
        NodeClass nodeF = new NodeClass("F");
        listOfNodes.add(nodeF);
        NodeClass nodeG = new NodeClass("G");
        listOfNodes.add(nodeG);
        NodeClass nodeH = new NodeClass("H");
        listOfNodes.add(nodeH);
        NodeClass nodeI = new NodeClass("I");
        listOfNodes.add(nodeI);
        NodeClass nodeJ = new NodeClass("J");
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


}
