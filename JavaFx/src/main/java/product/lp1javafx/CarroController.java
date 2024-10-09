package product.lp1javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class CarroController {

    @FXML
    private Label infoCarro;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtVelocidadeMaxima;

    @FXML
    private ImageView freiando;

    @FXML
    private ImageView ligando;

    @FXML
    private ImageView acelerando;

    @FXML
    private ImageView carros;

    @FXML
    private Label acaoCarro;

    private Carro carro;

    @FXML
    void initialize() {
        acelerando.setVisible(false);
        ligando.setVisible(false);
        freiando.setVisible(false);
    }
    @FXML
    void criarCarro(ActionEvent event) {
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        String velocidadeMaxima = txtVelocidadeMaxima.getText();
        carro = new Carro(marca, modelo, velocidadeMaxima);

        if (marca.isEmpty() || modelo.isEmpty() || velocidadeMaxima.isEmpty()) {
            infoCarro.setText("Por favor, preencha todos os campos antes de adicionar o carro.");
            return;
        }

        // Exibe os detalhes do carro criado
        infoCarro.setText("Carro: Marca - " + marca + ", Modelo - " + modelo + ", VM - " + velocidadeMaxima + " km/h");
    }

    @FXML
    void acelerar(ActionEvent event) {
        carros.setVisible(false);
        ligando.setVisible(false);
        freiando.setVisible(false);
        acelerando.setVisible(true);

        acaoCarro.setText("Acelerando meu " + carro.getMarca() + " " + carro.getModelo() + " a " + carro.getVelocidadeMaxima() + " km/h");
    }

    @FXML
    void frear(ActionEvent event) {
        carros.setVisible(false);
        ligando.setVisible(false);
        freiando.setVisible(true);
        acelerando.setVisible(false);

        acaoCarro.setText("Freiando meu " + carro.getMarca());
    }

    @FXML
    void ligarMotor(ActionEvent event) {
        carros.setVisible(false);
        ligando.setVisible(true);
        freiando.setVisible(false);
        acelerando.setVisible(false);

        acaoCarro.setText("Ligando o meu " + carro.getMarca());
    }
}
