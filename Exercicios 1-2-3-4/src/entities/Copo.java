package entities;

public class Copo {
    public String material;
    public double capacidade;
    public String cor;

    public Copo(String material, double capacidade, String cor) {
        this.material = material;
        this.capacidade = capacidade;
        this.cor = cor;
    }

    public void encher(double quantidade) {
        if (quantidade > capacidade) System.out.println("O copo transbordou");
        else System.out.println("Voce encheu o copo com " + quantidade + " de coca cola geladinha");
    }

    public void esvaziar() {
        System.out.println("O copo foi esvaziado");
    }

    public void lavar() {
        System.out.println("Lavando o copo");
    }
}
