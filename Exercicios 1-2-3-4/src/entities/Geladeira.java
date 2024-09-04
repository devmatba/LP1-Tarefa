package entities;

public class Geladeira {
    public String marca;
    public double capacidade;
    public double temperaturaAtual;

    public Geladeira(String marca, double capacidade, double temperaturaAtual) {
        this.marca = marca;
        this.capacidade = capacidade;
        this.temperaturaAtual = temperaturaAtual;
    }

    public void resfriar() {
        System.out.println("Resfriando");
    }

    public void ajustarTemperatura(double novaTemperatura) {
        System.out.println("Temperatura definida para " + novaTemperatura);
    }

    public void descongelar() {
        System.out.println("Descongelando");
    }
}
