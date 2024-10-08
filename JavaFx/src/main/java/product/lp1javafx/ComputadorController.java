package product.lp1javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;

public class ComputadorController {

    @FXML
    private TextField txtProcessador;

    @FXML
    private TextField txtMemoriaRam;

    @FXML
    private TextField txtArmazenamento;

    @FXML
    private Button btnLigar;

    @FXML
    private Button btnAbrirPrograma;

    @FXML
    private Label infoComputador;

    @FXML
    private ImageView imageLigado;

    @FXML
    private ImageView imageDesligado;

    @FXML
    private ImageView imageMine;

    @FXML
    private ImageView imageCs;

    @FXML
    private SplitMenuButton selectPrograma;

    private Computador computador;

    @FXML
    void initialize() {

        selectPrograma.getItems().clear();
        MenuItem minecraftItem = new MenuItem("Minecraft");
        minecraftItem.setOnAction(e -> selectPrograma.setText("Minecraft"));

        MenuItem counterStrikeItem = new MenuItem("Counter Strike");
        counterStrikeItem.setOnAction(e -> selectPrograma.setText("Counter Strike"));

        selectPrograma.getItems().addAll(minecraftItem, counterStrikeItem);

        imageDesligado.setVisible(true);  // Esconde a primeira imagem

    }

    @FXML
    void ligarComputador(ActionEvent event) {
        String processador = txtProcessador.getText();
        int memoriaRam;
        int armazenamento;

        try {
            memoriaRam = Integer.parseInt(txtMemoriaRam.getText());
            armazenamento = Integer.parseInt(txtArmazenamento.getText());
        } catch (NumberFormatException e) {
            infoComputador.setText("Memória RAM e Armazenamento devem ser números.");
            return;
        }

        computador = new Computador(processador, memoriaRam, armazenamento);
        computador.ligar();
        infoComputador.setText("Computador ligado com " + processador + ", " + memoriaRam + "GB RAM e " + armazenamento + "GB de armazenamento.");

        imageDesligado.setVisible(false);
        imageLigado.setVisible(true);
    }

    @FXML
    void abrirPrograma(ActionEvent event) {
        if (computador != null) {
            String programa = selectPrograma.getText();

            if (!programa.equals("Selecione o Programa")) {
                computador.abrirPrograma(programa);
                infoComputador.setText("Abrindo " + programa);

                // Muda a imagem com base no programa selecionado
                switch (programa) {
                    case "Minecraft":
                        imageCs.setVisible(false);
                        imageMine.setVisible(true);// Imagem do Minecraft
                        break;
                    case "Counter Strike":
                        imageMine.setVisible(false);
                        imageCs.setVisible(true); // Imagem do Counter Strike
                        break;
                    default:
                        break;
                }
            } else {
                infoComputador.setText("Selecione um programa primeiro.");
            }
        } else {
            infoComputador.setText("O computador deve estar ligado primeiro.");
        }
    }
}
