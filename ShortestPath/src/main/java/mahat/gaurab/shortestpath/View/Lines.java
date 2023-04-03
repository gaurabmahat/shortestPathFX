package mahat.gaurab.shortestpath.View;

import javafx.scene.shape.Line;

public class Lines {

    public static Line makingLines(String starting, String ending,
                                   int startX, int startY,
                                   int endX, int endY) {
        Line line = new Line(startX, startY,
                endX, endY);
        line.setId("line_"+starting+"_"+ending);
        line.setStrokeWidth(5);
        return line;
    }
}
