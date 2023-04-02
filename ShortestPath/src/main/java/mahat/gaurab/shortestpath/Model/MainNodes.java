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
        nodeA.setX_axisForScene(500);
        nodeA.setY_axisForScene(50);
        listOfNodes.add(nodeA);

        NodeClass nodeB = new NodeClass("B");
        nodeB.setX_axisForScene(800);
        nodeB.setY_axisForScene(170);
        listOfNodes.add(nodeB);

        NodeClass nodeC = new NodeClass("C");
        listOfNodes.add(nodeC);
        nodeC.setX_axisForScene(1100);
        nodeC.setY_axisForScene(390);

        NodeClass nodeD = new NodeClass("D");
        nodeD.setX_axisForScene(200);
        nodeD.setY_axisForScene(190);
        listOfNodes.add(nodeD);

        NodeClass nodeE = new NodeClass("E");
        nodeE.setX_axisForScene(600);
        nodeE.setY_axisForScene(390);
        listOfNodes.add(nodeE);

        NodeClass nodeF = new NodeClass("F");
        nodeF.setX_axisForScene(190);
        nodeF.setY_axisForScene(440);
        listOfNodes.add(nodeF);

        NodeClass nodeG = new NodeClass("G");
        nodeG.setX_axisForScene(510);
        nodeG.setY_axisForScene(690);
        listOfNodes.add(nodeG);

        NodeClass nodeH = new NodeClass("H");
        nodeH.setX_axisForScene(900);
        nodeH.setY_axisForScene(590);
        listOfNodes.add(nodeH);

        NodeClass nodeI = new NodeClass("I");
        nodeI.setX_axisForScene(290);
        nodeI.setY_axisForScene(900);
        listOfNodes.add(nodeI);

        NodeClass nodeJ = new NodeClass("J");
        nodeJ.setX_axisForScene(700);
        nodeJ.setY_axisForScene(900);
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
