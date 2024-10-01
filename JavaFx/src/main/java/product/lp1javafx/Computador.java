package product.lp1javafx;

public class Computador {
    public String processador;
    public int memoriaRam;
    public int armazenamento;

    public Computador(String processador, int memoriaRam, int armazenamento) {
        this.processador = processador;
        this.memoriaRam = memoriaRam;
        this.armazenamento = armazenamento;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void ligar(){
        System.out.println("Ligando o Computador");
    }

    public void abrirPrograma(String programa){
        System.out.println("Abrindo " + programa);
    }

    public void telaAzul(){
        System.out.println("ERROR ERROR ERROR BLUE SCREEN");
    }
}
