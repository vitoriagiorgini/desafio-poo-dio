package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Collections; // Import para Collections.unmodifiableSet
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    // Usamos HashSet para devsInscritos pois a ordem não é relevante e não haverá duplicatas.
    private Set<Dev> devsInscritos = new HashSet<>();
    // Usamos LinkedHashSet para conteudos para garantir a ordem de inserção dos conteúdos.
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    // EVOLUÇÃO (ENCAPSULAMENTO): Adicionamos um construtor para garantir que nome e descrição
    // sejam definidos no momento da criação do Bootcamp.
    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    // Isso impede que um código externo modifique a lista de devs inscritos diretamente,
    // garantindo que as alterações passem por métodos controlados dentro da classe Bootcamp.
    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);
    }


    // A gestão de quais devs e conteúdos fazem parte do bootcamp deve ser feita internamente
    // ou através de métodos de adição controlados.

    // Garante que a coleção de conteúdos do bootcamp não seja alterada externamente.
    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }

    // public void setConteudos(Set<Conteudo> conteudos) { this.conteudos = conteudos; }

    // metodo para adicionar um Dev ao bootcamp.
    public void adicionarDev(Dev dev) {
        if (dev != null) {
            this.devsInscritos.add(dev);
        }
    }

    public void adicionarConteudo(Conteudo conteudo) {
        if (conteudo != null) {
            this.conteudos.add(conteudo);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) &&
                Objects.equals(descricao, bootcamp.descricao) &&
                Objects.equals(dataInicial, bootcamp.dataInicial) &&
                Objects.equals(dataFinal, bootcamp.dataFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal);
    }
}