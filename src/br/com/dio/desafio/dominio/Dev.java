package br.com.dio.desafio.dominio;

import java.util.Collections; // Import para Collections.unmodifiableSet
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;

    // EVOLUÇÃO (ENCAPSULAMENTO): As coleções são inicializadas no construtor ou diretamente.
    // Usamos LinkedHashSet para manter a ordem de inscrição e conclusão dos conteúdos.
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    // EVOLUÇÃO (ENCAPSULAMENTO): Adicionamos um construtor que exige o nome do Dev.
    // Isso assegura que todo Dev seja criado com um nome.
    public Dev(String nome) {
        this.nome = nome;
    }

    // EVOLUÇÃO (ENCAPSULAMENTO): O método inscreverBootcamp agora usa os métodos
    // 'adicionarConteudo' e 'adicionarDev' do Bootcamp, se existissem.
    // No seu caso, o Dev adiciona a si mesmo ao bootcamp e copia os conteúdos.
    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp != null) {
            // Adiciona todos os conteúdos do bootcamp ao conjunto de conteúdos em que o Dev está inscrito.
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            // Também adiciona este Dev à lista de Devs inscritos no bootcamp.
            // EVOLUÇÃO (ENCAPSULAMENTO): Chamamos o método adicionarDev do Bootcamp,
            // em vez de acessar diretamente o Set interno.
            bootcamp.adicionarDev(this);
        }
    }

    public void progredir() {
        // Busca o primeiro conteúdo em que o Dev está inscrito (se houver).
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();

        // Optional evita erro de NullPointerException, pois pode ou não haver conteúdo.
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            // EVOLUÇÃO (FEEDBACK): Melhoria na mensagem de erro para ser mais clara.
            System.err.println("Você não está matriculado em nenhum conteúdo para progredir!");
        }
    }

    // EVOLUÇÃO (ENCAPSULAMENTO): O cálculo de XP é uma responsabilidade do Dev,
    // que ele executa iterando sobre seus conteúdos concluídos e chamando o método
    // polimórfico calcularXp() de cada Conteudo.
    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp) // Usa o polimorfismo aqui!
                .sum();
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    // EVOLUÇÃO (ENCAPSULAMENTO): Setter para nome, se for permitido mudar.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // EVOLUÇÃO (ENCAPSULAMENTO): Retorna uma visão imutável do Set.
    // Impede modificações externas diretas nas coleções de conteúdos do Dev.
    public Set<Conteudo> getConteudosInscritos() {
        return Collections.unmodifiableSet(conteudosInscritos);
    }

    // EVOLUÇÃO (ENCAPSULAMENTO): Removemos o setter. A gestão de conteúdos inscritos
    // deve ser feita pelos métodos 'inscreverBootcamp' e 'progredir'.
    // public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) { this.conteudosInscritos = conteudosInscritos; }

    // EVOLUÇÃO (ENCAPSULAMENTO): Retorna uma visão imutável do Set.
    public Set<Conteudo> getConteudosConcluidos() {
        return Collections.unmodifiableSet(conteudosConcluidos);
    }

    //  Removi o setter. A gestão de conteúdos concluídos
    // public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) { this.conteudosConcluidos = conteudosConcluidos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}