module org.example.ajedrezfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ajedrezfx to javafx.fxml;
    exports org.example.ajedrezfx;
}