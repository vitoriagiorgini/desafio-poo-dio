import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;


import java.time.LocalDate;

public class Main {

    public static void main(String[] args){
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(9);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());


        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devVitoria = new Dev();
        devVitoria.setNome("Vitoria");
        devVitoria.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Vitoria" + devVitoria.getConteudosInscritos());
        devVitoria.progredir();
        System.out.println("-----------------------------------");
        System.out.println("Conteúdos inscritos Vitoria" + devVitoria.getConteudosInscritos());
        System.out.println("Conteúdos concluídos Vitoria" + devVitoria.getConteudosConcluidos());
        System.out.println("XP: " +devVitoria.calcularTotalXp());


        System.out.println("-------------------------------");


        Dev devBeatriz = new Dev();
        devBeatriz.setNome("Beatriz");
        devBeatriz.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Beatriz" + devBeatriz.getConteudosInscritos());
        devBeatriz.progredir();
        devBeatriz.progredir();
        devBeatriz.progredir();
        System.out.println("-----------------------------------");
        System.out.println("Conteúdos inscritos Beatriz" + devBeatriz.getConteudosInscritos());
        System.out.println("Conteúdos concluídos Beatriz" + devBeatriz.getConteudosConcluidos());
        System.out.println("XP: " +devBeatriz.calcularTotalXp());



    }
}
