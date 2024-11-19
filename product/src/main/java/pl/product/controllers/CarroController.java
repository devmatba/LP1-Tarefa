package pl.product.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import pl.product.dao.CarroDAO;
import pl.product.models.Carro;

import javax.swing.text.html.ImageView;
import java.sql.SQLException;

public class CarroController {
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtVelocidadeMaxima;
    @FXML
    private TableView<Carro> tableCarro;
    @FXML
    private TableColumn<Carro, String> columnMarca;
    @FXML
    private TableColumn<Carro, String> columnModelo;
    @FXML
    private TableColumn<Carro, Integer> columnVelocidadeMaxima;
    @FXML
    private TableColumn<Carro, String> columnDescricao;
    @FXML
    private ImageView img;

    private final CarroDAO carroDAO = new CarroDAO();
    private Carro carroSelecionado;

    @FXML
    public void initialize() {
        columnMarca.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMarca()));
        columnModelo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getModelo()));
        columnVelocidadeMaxima.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getVelocidadeMaxima()));
        columnDescricao.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescricao()));

        tableCarro.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            carroSelecionado = newValue;
        });

        carregarCarros();
    }


    @FXML
    private void adicionarCarro() {
        try {
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            int velocidadeMaxima = Integer.parseInt(txtVelocidadeMaxima.getText());

            String descricao;
            if (velocidadeMaxima >= 0 && velocidadeMaxima < 80) {
                descricao = "Carroça";
            } else if (velocidadeMaxima >= 80 && velocidadeMaxima < 150) {
                descricao = "Manco";
            } else if (velocidadeMaxima >= 150 && velocidadeMaxima <= 300) {
                descricao = "Tá potente, esse é o Braia!";
            } else {
                descricao = "ERRO: Por favor, acesse a tela de cadastro de foguetes.";
            }

            Carro carro = new Carro(0, marca, modelo, velocidadeMaxima, descricao);

            carroDAO.adicionarCarro(carro);

            carregarCarros();

            txtMarca.clear();
            txtModelo.clear();
            txtVelocidadeMaxima.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Carro cadastrado com sucesso!");
            alert.showAndWait();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao adicionar o carro. Verifique os dados informados.");
            alert.show();
        }
    }

    @FXML
    private void editarCarro() {
        try {
            if (carroSelecionado == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nenhum carro selecionado");
                alert.setHeaderText("Selecione um carro para editar.");
                alert.showAndWait();
                return;
            }

            carroDAO.removerCarro(carroSelecionado.getId());

            txtMarca.setText(carroSelecionado.getMarca());
            txtModelo.setText(carroSelecionado.getModelo());
            txtVelocidadeMaxima.setText(String.valueOf(carroSelecionado.getVelocidadeMaxima()));

            carregarCarros();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Carro em edição");
            alert.setHeaderText("Edite as informações e clique em 'Adicionar' para salvar novamente.");
            alert.showAndWait();

            // Limpa a seleção na tabela após a edição
            tableCarro.getSelectionModel().clearSelection();
        } catch (SQLException e) {
            exibirErro("Erro ao editar carro", "Não foi possível preparar o carro para edição.", e);
        }
    }

    @FXML
    private void excluirCarro() {
        try {
            if (carroSelecionado == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nenhum carro selecionado");
                alert.setHeaderText("Selecione um carro para remover.");
                alert.showAndWait();
                return;
            }

            carroDAO.removerCarro(carroSelecionado.getId());

            carregarCarros();
        } catch (SQLException e) {
        exibirErro("Erro ao remover carro", "Não foi possível remover o carro selecionado.", e);
    }
    }


    private void carregarCarros() {
        try {
            ObservableList<Carro> carros = FXCollections.observableArrayList(carroDAO.listarCarros());
            tableCarro.setItems(carros);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void exibirErro(String titulo, String mensagem, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

}
