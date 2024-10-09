package product.lp1javafx;

public class Carro {
    public String marca;
    public String modelo;
    public String velocidadeMaxima;

    public Carro(String marca, String modelo, String velocidadeMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public String getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(String velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

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
