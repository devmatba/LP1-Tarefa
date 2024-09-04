package entities;

public class Cadeira {
    public String material;
    public String cor;
    public String altura;

    public Cadeira(String altura, String cor, String material) {
        this.altura = altura;
        this.cor = cor;
        this.material = material;
    }

    public void sentar() {
        System.out.println("Sentando na cadeira");
    }

    public void ajustarAltura() {
        System.out.println("Ajustando altura da cadeira");
    }

    public void reclinar() {
        System.out.println("Reclinando a cadeira para tirar uma soninho gostoso");
    }
}
