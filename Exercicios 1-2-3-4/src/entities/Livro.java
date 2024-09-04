package entities;

public class Livro {
    public String titulo;
    public String autor;
    public double numPaginas;

    public Livro(String titulo, String autor, double numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public void abrir() {
        System.out.println("Abrindo pagina");
    }

    public void virarPagina() {
        System.out.println("Virando pagina");
    }

    public void fechar() {
        System.out.println("Fechando livro");
    }
}
