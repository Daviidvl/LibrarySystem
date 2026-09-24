package entities;

public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private Integer id;


    public Livro (){

    }

    public Livro(String titulo, String autor, int ano,Integer id) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Livro{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", ano=").append(ano);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
