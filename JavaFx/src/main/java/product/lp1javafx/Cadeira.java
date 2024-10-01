package product.lp1javafx;

public class Cadeira {
    public String material;
    public String cor;
    public String altura;

    public Cadeira(String altura, String cor, String material) {
        this.altura = altura;
        this.cor = cor;
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
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
