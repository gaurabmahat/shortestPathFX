package mahat.gaurab.shortestpath.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import mahat.gaurab.shortestpath.Model.MainNodes;
import mahat.gaurab.shortestpath.Model.Node;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    private static Scene scene;
    private static GridPane gridPane;

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        MainNodes buildingNodes = new MainNodes();

        gridPane = new GridPane();
        scene = new Scene(gridPane, 720, 640);

        adjacentNodes(buildingNodes.getListOfNodes());

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void adjacentNodes(ArrayList<Node> nodeList) {
        int x_axis = 0;
        int y_axis = 0;

        for(var node : nodeList) {
            StackPane stackPane = Cirlces.makingCircles(node.getName());
            gridPane.add(stackPane, x_axis, y_axis);
            x_axis += 3;
            y_axis += 3;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}