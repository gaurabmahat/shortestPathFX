package mahat.gaurab.shortestpath.View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Lines {

    public static Line makingLines(String starting, String ending,
                                   int startX, int startY,
                                   int endX, int endY) {
        Line line = new Line(startX, startY,
                endX, endY);
        line.setId("line_"+starting+"_"+ending);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(7.5);
        return line;
    }
}
