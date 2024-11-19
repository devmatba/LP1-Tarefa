module pl.product {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens pl.product to javafx.fxml;
    exports pl.product;
    exports pl.product.controllers;
    opens pl.product.controllers to javafx.fxml;
    opens pl.product.models to javafx.base;
}
