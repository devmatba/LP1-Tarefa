package product.lp1javafx;

public class Sofa {
    public String material;
    public int numAssentos;
    public String cor;

    public Sofa(String material, int numAssentos, String cor) {
        this.material = material;
        this.numAssentos = numAssentos;
        this.cor = cor;
    }

    public void massageador() {
        System.out.println("Reclinando o massageador do sofa");
    }

    public void pessoasSentadas() {
        System.out.println(numAssentos + " pessoas sentadas");
    }

    public void dobrarDescanso(){
        System.out.println("Dobrando o descanço de pé");
    }
}
