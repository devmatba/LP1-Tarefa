package product.lp1javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadeiraController {

    @FXML
    private Label infoCadeira;

    @FXML
    private TextField txtCor;

    @FXML
    private Button btnCriarCadeira;

    @FXML
    private TextField txtMaterial;

    @FXML
    private TextField txtAltura;

    @FXML
    private Label acaoCadeira;

    Cadeira cadeira;


    @FXML
    void criarCadeira(ActionEvent event) {
        String material = txtMaterial.getText();
        String cor = txtCor.getText();
        String altura = txtAltura.getText();
        cadeira = new Cadeira(altura, cor, material);

        // Exibe os detalhes da cadeira criada
        infoCadeira.setText("Cadeira Criada: Material - " + material + ", Cor - " + cor + ", Altura - " + altura);
    }
    @FXML
    void sentar(ActionEvent event) {
       acaoCadeira.setText("Sentando na Cadeira");
    }

    @FXML
    void reclinar(ActionEvent event) {
        acaoCadeira.setText("Reclinando a cadeira para um sono gostosinho.");
    }

    @FXML
    void ajustarAltura(ActionEvent event) {
        acaoCadeira.setText("Subindo a cadeira");
    }




}