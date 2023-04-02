package mahat.gaurab.shortestpath.View;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import mahat.gaurab.shortestpath.Controller;
import mahat.gaurab.shortestpath.Model.MainNodes;
import mahat.gaurab.shortestpath.Model.NodeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MainView extends Application {

    private static Scene scene;
    private static Pane gridPane;
    private static MainNodes buildingNodes;

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(MainView.class.getResource("hello-view.fxml"));

        buildingNodes = new MainNodes();
        gridPane = new Pane();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridPane);
        scene = new Scene(scrollPane, 820, 640);
        adjacentNodes(buildingNodes.getListOfNodes());

        Controller.EventHandler();

        stage.setTitle("Shortest path demonstration!");
        stage.setScene(scene);
        stage.show();
    }

    public static Pane getGridPane() {
        return gridPane;
    }

    private void adjacentNodes(ArrayList<NodeClass> nodeList) {
        for(var node : nodeList) {
            Circle circle = Cirlces.makingCircles(node.getName());
            circle.relocate(node.getX_axisForScene(), node.getY_axisForScene());
            gridPane.getChildren().add(circle);
        }
    }

    public static NodeClass getNode(String name) {
        for(var node : buildingNodes.getListOfNodes()) {
            if(name.equals(node.getName())) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        launch();
    }
}