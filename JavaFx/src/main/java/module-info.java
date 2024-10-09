module product.lp1javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens product.lp1javafx to javafx.fxml;
    exports product.lp1javafx;
}