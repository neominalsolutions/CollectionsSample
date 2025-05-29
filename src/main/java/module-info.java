module com.collectionssample {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.collectionssample to javafx.fxml;
    exports com.collectionssample;
}