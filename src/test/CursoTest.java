package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CursoTest {

    List<Curso> cursos = new ArrayList<>();

    @Before
    public void setup() {
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("JavaScript", 150));
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
    
    @Test
    public void testOptionalFirst() {
        Optional<Curso> retorno = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .findFirst();

        assertEquals(retorno.get().getNome(), "Java 8");

    }

    @Test
    public void testOptionalIfPresent() {
        Optional<Curso> optional = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .findAny();
//                .ifPresent(c -> System.out.println(c.getNome()));
        Optional<Curso> retorno = optional.filter(curso -> curso.getNome().contains("Java"));
        retorno.ifPresent(c -> System.out.println(c.getNome()));
    }

    @Test
    public void testStreamAverage() {
        OptionalDouble retorno = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .mapToDouble(c -> c.getAlunos())
                .average();

        assertEquals(retorno, 131.5);
    }

    @Test
    public void testStreamSum() {
        int retorno = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .mapToInt(c -> c.getAlunos())
                .sum();

        assertEquals(retorno, 263);
    }

    @Test
    public void testAnyMatch() {
        List<Integer> numeros = Arrays.asList(23, 45, 6, 78, 122);

        assertTrue(numeros.stream().anyMatch(n -> n > 1));
        assertTrue(numeros.stream().allMatch(n -> n > 1));
        assertTrue(numeros.stream().noneMatch(n -> n < 0));
    }

    @Test
    public void testStreamPeek() {
        cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .map(Curso::getNome)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    @Test
    public void testStreamLimit() {
        List<String> retorno = cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(Curso::getNome)
                .sorted(Comparator.comparingInt(String::length))
                .peek(System.out::println)
                .limit(2)
                .collect(Collectors.toList());

        assertEquals(retorno.get(0), "C");
        assertEquals(retorno.get(1), "Java 8");
    }

    @Test
    public void testStreamCount() {
        long retorno = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .count();

        assertEquals(retorno, 2);
    }

    @Test
    public void testStreamReduce() {
        Optional<Integer> retorno = Optional.ofNullable(cursos.stream()
                .map(c -> c.getAlunos())
                .reduce(0, (subtotal, total) -> subtotal + total));

        assertEquals(retorno.get(), new Integer(363));
    }

    @Test
    public void testStreamReduce2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer retorno1 = numbers.stream()
                .reduce(1, (a, b) -> a + b);
        Optional<Integer> retorno2 = numbers.stream()
                .reduce((a, b) -> a + b);
        retorno2.ifPresent(System.out::println);

        assertEquals(retorno1, new Integer(16));
        assertEquals(retorno2.get(), new Integer(15));
    }

    @Test
    public void testStramWithBigDecimal() {
        List<BigDecimal> numbers = Arrays.asList(new BigDecimal("1.2"), new BigDecimal("2.4"),
                new BigDecimal("3.7"), new BigDecimal("4.9"));
        BigDecimal retorno = numbers.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertEquals(retorno, new BigDecimal("12.2"));

    }

    @Test
    public void testStreamReduce3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Optional<Integer> retorno1 = numbers.stream()
                .reduce((x, y) -> x + y);
        Integer retorno2 = numbers.stream()
                .reduce(1, (x, y) -> x + y);

        assertEquals(retorno1.get(), new Integer(21));
        assertEquals(retorno2, new Integer(22));
    }

    @Test
    public void testStramReduce4() {
        List<String> letras = Arrays.asList("a", "b", "c", "d", "e");
        String retorno1 = letras.stream()
                .reduce("", (partialString, element) -> partialString + element);

        String retorno2 = letras.stream()
                .reduce("", String::concat);

        assertEquals(retorno1, "abcde");
        assertEquals(retorno2, "abcde");
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



