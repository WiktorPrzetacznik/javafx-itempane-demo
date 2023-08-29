module itempanedemo {
    requires javafx.controls;
    requires javafx.fxml;

    exports itempanedemo to javafx.graphics;
    exports itempanedemo.layout to javafx.fxml;
}