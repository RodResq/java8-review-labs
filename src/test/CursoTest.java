package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;

public class CursoTest {

    List<Curso> cursos = new ArrayList<>();

    @Before
    public void setup() {
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

    }

    @Test
    public void testeTest() {
        cursos.sort(Comparator.comparingInt(Curso::getAlunos));
        cursos.forEach(curso -> System.out.println(curso.getNome()));
    }

    @Test
    public void testMapToInt() {
        int retorno = cursos.stream()
                .filter(curso -> curso.getAlunos() > 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        Assert.assertEquals(retorno, 263);
    }

    @Test
    public void testFindAnyAndIfPresent() {
        cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

    }

    @Test
    public void testCollectorToList() {
        List<String> retornoNomes = new ArrayList<>();
        cursos
            .stream()
            .filter(c -> c.getAlunos() > 100)
            .forEach(c -> retornoNomes.add(c.getNome()));


        List<String> cursosEsperados = Arrays.asList("JavaScript", "Java 8");
        Assert.assertEquals(cursosEsperados.get(0), retornoNomes.get(0));
        Assert.assertEquals(cursosEsperados.get(1), retornoNomes.get(1));
    }

    @Test
    public void testMapStream() {
        Map<String, Integer> retornoMap = cursos
                                            .stream()
                                            .filter(c -> c.getAlunos() > 100)
                                            .collect(Collectors.toMap(
                                                    c -> c.getNome(),
                                                    c -> c.getAlunos()));

        assertTrue(retornoMap.get("JavaScript").equals(150));
        assertTrue(retornoMap.get("Java 8").equals(113));
    }

}

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}


