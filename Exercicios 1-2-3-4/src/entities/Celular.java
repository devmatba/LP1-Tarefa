package entities;

public class Celular {
    public String modelo;
    public int numero;
    public String fabricante;

    public Celular(String modelo, int numero, String fabricante) {
        this.modelo = modelo;
        this.numero = numero;
        this.fabricante = fabricante;
    }

    public void fazerChamada(int numero) {
        System.out.println("Fazendo chamada para " + numero);
    }

    public void receberChamada() {
        System.out.println("Recebendo chamada de 129999-9999");
    }

    public void desligar() {
        System.out.println("Desligando");
    }
}
