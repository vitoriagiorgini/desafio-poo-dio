package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

    private int cargaHoraria;

    // EVOLUÇÃO (ENCAPSULAMENTO): Adicionamos um construtor que exige a definição de
    // título, descrição e carga horária no momento da criação do objeto.
    // Isso garante que um Curso sempre seja criado em um estado válido e completo.
    public Curso(String titulo, String descricao, int cargaHoraria){
        // Chama os setters da classe pai (Conteudo) para definir título e descrição.
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria + // Alterado para 'cargaHoraria' diretamente
                '}';
    }
}