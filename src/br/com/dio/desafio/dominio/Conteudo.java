package br.com.dio.desafio.dominio;

public abstract class Conteudo {

    // 'protected' permite que subclasses acessem, 'final' garante que não mude.
    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    //  Setters permitem a modificação de título e descrição.
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}