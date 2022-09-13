module com.example.filefinderjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.filefinderjavafx to javafx.fxml;
    exports com.example.filefinderjavafx;
}