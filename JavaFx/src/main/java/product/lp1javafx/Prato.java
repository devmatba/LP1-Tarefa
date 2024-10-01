package product.lp1javafx;

public class Prato {

    public String material;
    public double diametro;
    public String cor;

    public Prato(String material, double diametro, String cor) {
        this.material = material;
        this.diametro = diametro;
        this.cor = cor;
    }

    public void empilhar(){
        System.out.println("Empilhando os pratos");
    }

    public void lavar(){
        System.out.println("Lavando os pratos");
    }

    public void quebrar(){
        System.out.println("Prato quebrando: PLAFT");
    }




}
