module mahat.gaurab.shortestpath {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens mahat.gaurab.shortestpath to javafx.fxml;
    exports mahat.gaurab.shortestpath;
    exports mahat.gaurab.shortestpath.Model;
    opens mahat.gaurab.shortestpath.Model to javafx.fxml;
    exports mahat.gaurab.shortestpath.View;
    opens mahat.gaurab.shortestpath.View to javafx.fxml;
}