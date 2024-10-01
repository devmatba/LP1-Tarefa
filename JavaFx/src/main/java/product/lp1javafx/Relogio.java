package product.lp1javafx;

public class Relogio {
    public String marca;
    public String tipo;
    public String tamanho;

    public Relogio(String marca, String tipo, String tamanho) {
        this.marca = marca;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public void mostrarHora(){
        System.out.println("São 20:30");
    }

    public void ajustarAlarme(){
        System.out.println("Alarme ajustado para as 08:00");
    }

    public void ajustarData(){
        System.out.println("Data ajustada para 03/09/24");
    }
}
