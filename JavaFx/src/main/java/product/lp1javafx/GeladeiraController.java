package product.lp1javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GeladeiraController {

    @FXML
    private Slider slider;

    @FXML
    private Label temperatura;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtCapacidade;

    @FXML
    private TextField txtTemperatura;

    @FXML
    private Label infoGeladeira;

    @FXML
    private ImageView modoTurbo;

    @FXML
    private ImageView congelar;

    @FXML
    private ImageView gelar;

    private Geladeira geladeira;

    @FXML
    private void initialize() {

        slider.valueProperty().addListener((obs, oldVal, newVal) ->
                temperatura.setText(String.format(" %.2f °C", newVal.doubleValue()))
        );

        modoTurbo.setVisible(false);
        congelar.setVisible(false);
        gelar.setVisible(false);
    }

    @FXML
    void adicionarGeladeira(ActionEvent event) {
        String marca = txtMarca.getText();
        String capacidadeStr = txtCapacidade.getText();
        String temperaturaStr = txtTemperatura.getText();

        if (marca.isEmpty() || capacidadeStr.isEmpty() || temperaturaStr.isEmpty()) {
            infoGeladeira.setText("Preencha todos os campos.");
            return;
        }

        double capacidade = Double.parseDouble(capacidadeStr);
        double temperaturaInicial = Double.parseDouble(temperaturaStr);

        geladeira = new Geladeira(marca, capacidade, temperaturaInicial);

        infoGeladeira.setText("Geladeira adicionada: Marca " + marca + ", Capacidade: " + capacidade + "L, Temp: " + temperaturaInicial + "°C");
        slider.setValue(temperaturaInicial);
    }

    @FXML
    void congelar(ActionEvent event) {
        if (geladeira != null) {
            geladeira.ajustarTemperatura(-20);
            slider.setValue(-20);

            // Exibe a imagem de congelamento e oculta as outras
            congelar.setVisible(true);
            modoTurbo.setVisible(false);
            gelar.setVisible(false);
        }
    }

    @FXML
    void modoTurbo(ActionEvent event) {
        if (geladeira != null) {
            geladeira.ajustarTemperatura(-40);
            slider.setValue(-40);

            // Exibe a imagem de modo turbo e oculta as outras
            modoTurbo.setVisible(true);
            congelar.setVisible(false);
            gelar.setVisible(false);
        }
    }

    @FXML
    void gelar(ActionEvent event) {
        if (geladeira != null) {
            geladeira.ajustarTemperatura(0);
            slider.setValue(0);

            // Exibe a imagem de gelar e oculta as outras
            gelar.setVisible(true);
            modoTurbo.setVisible(false);
            congelar.setVisible(false);
        }
    }
}
