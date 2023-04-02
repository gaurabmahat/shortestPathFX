package mahat.gaurab.shortestpath.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import mahat.gaurab.shortestpath.Controller;
import mahat.gaurab.shortestpath.Model.MainNodes;
import mahat.gaurab.shortestpath.Model.NodeClass;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    private static GridPane gridPane;
    private static MainNodes buildingNodes;

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        buildingNodes = new MainNodes();

        gridPane = new GridPane();
        adjacentNodes(buildingNodes.getListOfNodes());

        Scene scene = new Scene(gridPane, 720, 640);

        Controller.EventHandler();

        stage.setTitle("Shortest path demonstration!");
        stage.setScene(scene);
        stage.show();
    }

    public static GridPane getGridPane() {
        return gridPane;
    }

    private void adjacentNodes(ArrayList<NodeClass> nodeList) {
        int x_axis = 0;
        int y_axis = 0;

        for(var node : nodeList) {
            Circle circle = Cirlces.makingCircles(node.getName());
            gridPane.add(circle, x_axis, y_axis);
            x_axis += 3;
            y_axis += 3;
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