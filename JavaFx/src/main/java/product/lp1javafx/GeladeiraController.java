package product.lp1javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class GeladeiraController {

    @FXML
    private Slider slider;

    @FXML
    private Button modoTurbo;

    @FXML
    private Button congelar;

    @FXML
    private Button gelar;

    @FXML
    private Label temperatura;


    @FXML
    private void initialize() {
        slider.valueProperty().addListener((obs, oldVal, newVal) ->
                temperatura.setText(String.format("%.2f", newVal.doubleValue()))
        );
    }

    @FXML
    void congelar(ActionEvent event) {
           slider.setValue(-20);
    }

    @FXML
    void modoTurbo(ActionEvent event) {
      slider.setValue(-40);
    }

    @FXML
    void gelar(ActionEvent event) {
     slider.setValue(0);
    }

}
