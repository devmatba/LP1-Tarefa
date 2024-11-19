package pl.product.models;

public class Computador {
    private int id;
    private String programa;
    private String componente;
    private int uso;


    public Computador(int id, String programa) {
        this.id = id;
        this.programa = programa;
    }

    public Computador(int id, String programa, String componente, int uso) {
        this.id = id;
        this.programa = programa;
        this.componente = componente;
        this.uso = uso;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public int getUso() {
        return uso;
    }

    public void setUso(int uso) {
        this.uso = uso;
    }

    @Override
    public String toString() {
        return programa != null ? programa : componente;
    }
}
