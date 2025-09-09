import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo; //
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){
        Curso curso1 = new Curso("curso java", "descrição curso java", 8);
        Curso curso2 = new Curso("curso js", "descrição curso js", 9);
        Mentoria mentoria = new Mentoria("mentoria java", "descrição mentoria java", LocalDate.now());

        /*

        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(9);

        mentoria.setTitulo("mentoria java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());
        */

        // System.out.println(curso1);
        // System.out.println(curso2);
        // System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        //adicionando um novo metodo 'adicionarConteudo' do Bootcamp.
        bootcamp.adicionarConteudo(curso1);
        bootcamp.adicionarConteudo(curso2);
        bootcamp.adicionarConteudo(mentoria);

        Dev devVitoria = new Dev("Vitoria");
        devVitoria.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos por Vitoria: " + devVitoria.getConteudosInscritos());
        devVitoria.progredir();
        System.out.println("-----------------------------------");
        System.out.println("Conteúdos inscritos por Vitoria: " + devVitoria.getConteudosInscritos());
        System.out.println("Conteúdos concluídos por Vitoria: " + devVitoria.getConteudosConcluidos());
        System.out.println("XP: " + devVitoria.calcularTotalXp()); // O metodo calcularTotalXp() usa Polimorfismo.

        System.out.println("-------------------------------");

        Dev devBeatriz = new Dev("Beatriz");
        devBeatriz.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos por Beatriz: " + devBeatriz.getConteudosInscritos());
        devBeatriz.progredir();
        devBeatriz.progredir();
        devBeatriz.progredir();
        System.out.println("-----------------------------------");
        System.out.println("Conteúdos inscritos por Beatriz: " + devBeatriz.getConteudosInscritos());
        System.out.println("Conteúdos concluídos por Beatriz: " + devBeatriz.getConteudosConcluidos());
        System.out.println("XP: " + devBeatriz.calcularTotalXp()); // O metodo calcularTotalXp() usa Polimorfismo.

        // Teste de progredir sem conteúdos
        System.out.println("-------------------------------");
        Dev devTeste = new Dev("Teste");
        System.out.println("Conteúdos inscritos Teste: " + devTeste.getConteudosInscritos());
        devTeste.progredir();
        System.out.println("XP Teste: " + devTeste.calcularTotalXp());
        //testando atualização do codigo
        System.out.println("Fim");
    }
}