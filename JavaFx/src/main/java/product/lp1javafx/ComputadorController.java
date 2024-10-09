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
        imageDesligado.setVisible(true);
        imageLigado.setVisible(false);
        imageMine.setVisible(false);
        imageCs.setVisible(false);
    }

    @FXML
    void ligarComputador(ActionEvent event) {
        String processador = txtProcessador.getText();
        String memoriaRamStr = txtMemoriaRam.getText();
        String armazenamentoStr = txtArmazenamento.getText();

        if (processador.isEmpty() || memoriaRamStr.isEmpty() || armazenamentoStr.isEmpty()) {
            infoComputador.setText("Por favor, preencha todos os campos.");
            return;
        }

        int memoriaRam = Integer.parseInt(memoriaRamStr);
        int armazenamento = Integer.parseInt(armazenamentoStr);

        computador = new Computador(processador, memoriaRam, armazenamento);

        infoComputador.setText("Computador ligado: " + computador.getProcessador() + ", RAM: " + computador.getMemoriaRam() + " GB, Armazenamento: " + computador.getArmazenamento() + " GB");
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
                    case "League of Legends":
                        imageCs.setVisible(false);
                        imageMine.setVisible(true);
                        break;
                    case "Counter Strike":
                        imageMine.setVisible(false);
                        imageCs.setVisible(true);
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

    @FXML
    void abrirLol(ActionEvent event) {
        selectPrograma.setText("League of Legends");
    }

    @FXML
    void abrirCs(ActionEvent event) {
        selectPrograma.setText("Counter Strike");
    }
}
