package product.lp1javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private Label acaoCarro;

    private Carro carro;

    @FXML
    void criarCarro(ActionEvent event) {
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        String velocidadeMaxima = txtVelocidadeMaxima.getText();
        carro = new Carro(marca, modelo, velocidadeMaxima);

        // Exibe os detalhes do carro criado
        infoCarro.setText("Carro: Marca - " + marca + ", Modelo - " + modelo + ", VM - " + velocidadeMaxima + " km/h");
    }

    @FXML
    void acelerar(ActionEvent event) {
        acaoCarro.setText("Acelerando meu " + carro.getMarca() + " " + carro.getModelo() + " a " + carro.getVelocidadeMaxima() + " km/h");
    }

    @FXML
    void frear(ActionEvent event) {
        acaoCarro.setText("Freiando o carro " + carro.getMarca());
    }

    @FXML
    void ligarMotor(ActionEvent event) {
        acaoCarro.setText("Ligando o motor do carro " + carro.getMarca());
    }
}
