package product.lp1javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CelularController {

    @FXML
    private Label infoCelular;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtFabricante;

    @FXML
    private Label acaoCelular;

    private Celular celular;

    @FXML
    void criarCelular(ActionEvent event) {
        String modelo = txtModelo.getText();
        String fabricante = txtFabricante.getText();
        String numeroStr = txtNumero.getText();

        // Verifica se o número é um inteiro
        if (!isNumeric(numeroStr)) {
            showAlert("Erro", "O número deve ser um número inteiro.");
            return;
        }

        int numero = Integer.parseInt(numeroStr);
        celular = new Celular(modelo, numero, fabricante);

        // Exibe os detalhes do celular criado
        infoCelular.setText("Celular Criado: Modelo - " + modelo + ", Número - " + numero + ", Fabricante - " + fabricante);
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void fazerChamada(ActionEvent event) {
        if (celular != null) {
            acaoCelular.setText("Fazendo chamada para " + celular.getNumero());
        } else {
            showAlert("Erro", "Primeiro crie um celular.");
        }
    }

    @FXML
    void receberChamada(ActionEvent event) {
        if (celular != null) {
            acaoCelular.setText("Recebendo chamada de 129999-9999");
        } else {
            showAlert("Erro", "Primeiro crie um celular.");
        }
    }

    @FXML
    void desligar(ActionEvent event) {
        if (celular != null) {
            acaoCelular.setText("Desligando o celular.");
        } else {
            showAlert("Erro", "Primeiro crie um celular.");
        }
    }
}
