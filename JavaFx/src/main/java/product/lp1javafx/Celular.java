package product.lp1javafx;

public class Celular {
    public String modelo;
    public int numero;
    public String fabricante;

    public Celular(String modelo, int numero, String fabricante) {
        this.modelo = modelo;
        this.numero = numero;
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

}
