package mahat.gaurab.shortestpath.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mahat.gaurab.shortestpath.Controller;
import mahat.gaurab.shortestpath.Model.MainNodes;
import mahat.gaurab.shortestpath.Model.NodeClass;

import java.io.IOException;
import java.util.ArrayList;

public class MainView extends Application {

    private static Scene scene;
    private static Pane pane;
    private static MainNodes buildingNodes;

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(MainView.class.getResource("hello-view.fxml"));

        buildingNodes = new MainNodes();
        pane = new Pane();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        scene = new Scene(scrollPane, 820, 640);
        makingLines(buildingNodes.getListOfNodes());
        makingCircles(buildingNodes.getListOfNodes());

        Controller.EventHandler();

        stage.setTitle("Shortest path demonstration!");
        stage.setScene(scene);
        stage.show();
    }

    public static Pane getPane() {
        return pane;
    }

    private void makingLines(ArrayList<NodeClass> nodeList) {
        //Make lines and text for path weights
        for(var node : nodeList) {
            node.getAdjacentNodes().forEach((key, value) -> {
                var lineNode1 = pane.lookup("#line_" + node.getName() + "_" + key.getName());
                var lineNode2 = pane.lookup("#line_" + key.getName() + "_" + node.getName());
                if(lineNode1 == null && lineNode2 == null) {
                    Line line = Lines.makingLines(node.getName(), key.getName(),
                            node.getX_axisForScene()+50, node.getY_axisForScene()+50,
                            key.getX_axisForScene()+50, key.getY_axisForScene()+50);

                    Text text = new Text(Integer.toString(value));
                    text.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

                    int textx_axis = (node.getX_axisForScene()+ key.getX_axisForScene()) / 2 + 20;
                    int texty_axis = ((node.getY_axisForScene()+key.getY_axisForScene()) /2) + 10;
                    text.relocate(textx_axis, texty_axis);

                    pane.getChildren().addAll(line,text);
                }
            });
        }
    }

    private void makingCircles(ArrayList<NodeClass> nodeList) {
        //Then make circles
        for(var node : nodeList) {
            Circle circle = Cirlces.makingCircles(node.getName());
            circle.relocate(node.getX_axisForScene(), node.getY_axisForScene());
            pane.getChildren().add(circle);
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