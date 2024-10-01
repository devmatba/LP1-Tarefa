package product.lp1javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
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
    private ImageView image;

    @FXML
    private SplitMenuButton selectPrograma;

    private Computador computador;

    @FXML
    void initialize() {
        // Define as opções do seletor de programas
        selectPrograma.getItems().clear();
        MenuItem minecraftItem = new MenuItem("Minecraft");
        minecraftItem.setOnAction(e -> selectPrograma.setText("Minecraft"));

        MenuItem counterStrikeItem = new MenuItem("Counter Strike");
        counterStrikeItem.setOnAction(e -> selectPrograma.setText("Counter Strike"));

        selectPrograma.getItems().addAll(minecraftItem, counterStrikeItem);

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

        // Muda a imagem para o computador ligado
        image.setImage(new Image("/product/lp1javafx/images/computador_ligado.png"));
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
                        image.setImage(new Image("/product/lp1javafx/images/mine.png")); // Imagem do Minecraft
                        break;
                    case "Counter Strike":
                        image.setImage(new Image("/product/lp1javafx/images/cs.png")); // Imagem do Counter Strike
                        break;
                    default:
                        // Se não corresponder a nenhum programa, mantenha a imagem atual ou adicione um caso padrão
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
