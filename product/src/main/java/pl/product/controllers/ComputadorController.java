package pl.product.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import pl.product.dao.ComputadorDAO;
import pl.product.models.Computador;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class ComputadorController {

    @FXML
    private TableView<Computador> tableProgramas;

    @FXML
    private TableColumn<Computador, String> columnProgramas;

    @FXML
    private TableView<Computador> tableMonitoramento;

    @FXML
    private TableColumn<Computador, Integer> columnUso;

    @FXML
    private TableColumn<Computador, String> columnComponente;

    @FXML
    private ImageView img;

    @FXML
    private Label nomeProgramaSelecionado;

    private final ComputadorDAO computadorDAO = new ComputadorDAO();
    private String programaSelecionado = null; // Armazena o programa selecionado

    @FXML
    public void initialize() {
        columnProgramas.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrograma()));
        columnComponente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getComponente()));
        columnUso.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getUso()).asObject());
        carregarProgramas();
    }

    @FXML
    void desligar(ActionEvent event) {
        Image imgDesligado = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/computador_desligado.png")));
        img.setImage(imgDesligado);

        computadorDAO.atualizarUso("GPU", 0);
        computadorDAO.atualizarUso("CPU", 0);

        carregarProgramas();
    }

    @FXML
    void ligar(ActionEvent event) {
        Image imgLigado = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/computador_ligado.png")));
        img.setImage(imgLigado);

        computadorDAO.atualizarUso("GPU", 50);
        computadorDAO.atualizarUso("CPU", 50);

        carregarProgramas();
    }


    @FXML
    void instalarPrograma(ActionEvent event) {
        if (programaSelecionado != null && !programaSelecionado.isEmpty()) {
            computadorDAO.adicionarPrograma(programaSelecionado);
            carregarProgramas();

            Alert alertaSucesso = new Alert(Alert.AlertType.INFORMATION);
            alertaSucesso.setTitle("Instalação bem-sucedida");
            alertaSucesso.setHeaderText(null);
            alertaSucesso.setContentText("O programa \"" + programaSelecionado + "\" foi instalado com sucesso!");
            alertaSucesso.showAndWait();

            nomeProgramaSelecionado.setText("");
            programaSelecionado = null;
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.WARNING);
            alertaErro.setTitle("Erro na instalação");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Nenhum programa selecionado para instalação!");
            alertaErro.showAndWait();
        }
    }

    @FXML
    void removerPrograma(ActionEvent event) {
        Computador programaSelecionado = tableProgramas.getSelectionModel().getSelectedItem();

        if (programaSelecionado != null) {

            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmar Remoção");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza de que deseja remover o programa \"" + programaSelecionado.getPrograma() + "\"?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    // Remove do banco de dados
                    computadorDAO.removerPrograma(programaSelecionado.getId());

                    carregarProgramas();

                    // Alerta de sucesso
                    Alert alertaSucesso = new Alert(Alert.AlertType.INFORMATION);
                    alertaSucesso.setTitle("Remoção bem-sucedida");
                    alertaSucesso.setHeaderText(null);
                    alertaSucesso.setContentText("O programa \"" + programaSelecionado.getPrograma() + "\" foi removido com sucesso!");
                    alertaSucesso.showAndWait();
                }
            });
        } else {
            Alert alertaErro = new Alert(Alert.AlertType.WARNING);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Nenhum programa foi selecionado para remoção!");
            alertaErro.showAndWait();
        }
    }

    @FXML
    void selecionePrograma(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione um programa para instalar");

        // Configuração de filtros para tipos de arquivos (opcional)
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Arquivos Executáveis", "*.exe", "*.msi"),
                new FileChooser.ExtensionFilter("Todos os Arquivos", "*.*")
        );

        // Abre a janela de seleção de arquivos
        File arquivoSelecionado = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

        if (arquivoSelecionado != null) {
            programaSelecionado = arquivoSelecionado.getName(); // Armazena o nome do arquivo
            nomeProgramaSelecionado.setText(programaSelecionado);
        }
    }

    private void carregarProgramas() {
        ObservableList<Computador> programas = FXCollections.observableArrayList(computadorDAO.listarProgramas());
        tableProgramas.setItems(programas);
        List<Computador> componentes = computadorDAO.listarComponentes();
        ObservableList<Computador> observableComponentes = FXCollections.observableArrayList(componentes);
        tableMonitoramento.setItems(observableComponentes);
    }

    @FXML
    void abrirPrograma(ActionEvent event) {
        Computador programaSelecionado = tableProgramas.getSelectionModel().getSelectedItem();

        if (programaSelecionado != null) {
            String nomePrograma = programaSelecionado.getPrograma().toLowerCase();

            // Atualizar imagem e valores de uso
            int gpuUso = 50; // Valores padrão
            int cpuUso = 50;

            switch (nomePrograma) {
                case "cs.exe":
                    img.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/cs.gif"))));
                    gpuUso = 100;
                    cpuUso = 50;
                    break;

                case "minecraft.exe":
                    img.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/minecraft.png"))));
                    gpuUso = 60;
                    cpuUso = 100;
                    break;

                default:
                    img.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/azul.png"))));
                    break;
            }

            // Atualizar valores de uso no banco
            computadorDAO.atualizarUso("GPU", gpuUso);
            computadorDAO.atualizarUso("CPU", cpuUso);

            // Atualizar a tabela de monitoramento
            carregarProgramas();
        }
    }

}