module com.assignment11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    opens com.assignment11 to javafx.fxml;
    exports com.assignment11;
}