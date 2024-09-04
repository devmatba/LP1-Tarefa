package entities;

public class Carro {
    public String marca;
    public String modelo;
    public int velocidadeMaxima;

    // public Carro(String modelo, double velocidadeMaxima, String marca) {
    //    this.modelo = modelo;
    //    this.velocidadeMaxima = velocidadeMaxima;
    //    this.marca = marca;
    //}

    public void acelerar() {
        System.out.println("Acelerando meu " + marca + " " + modelo + " a " + velocidadeMaxima );
    }

    public void frear() {
        System.out.println("Freiando!");
    }

    public void ligarMotor() {
        System.out.println("Ligando o motor Vruuum, vruuum, vruuuuuum...");
    }
}
