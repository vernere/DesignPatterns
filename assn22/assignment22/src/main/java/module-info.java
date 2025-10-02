module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example to javafx.fxml;
    exports com.example;
    exports com.example.gui;
    exports com.example.commands;
    exports com.example.receivers;
    exports com.example.invokers;
}
