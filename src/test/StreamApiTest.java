package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StreamApiTest {

    List<Integer> numbers;

    @Before
    public void setup() {
        numbers = Arrays.asList(3, 1, 4, 2, 6, 8, 5, 7);
    }

    @Test
    public void testForEach() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 2, 6, 8, 5, 7);
        numbers.forEach(num -> System.out.print(String.format("%s, ", num)));
    }

    @Test
    public void testSortListNumbers() {
        List<Integer> numerosOrdenados = numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
        List<Integer> listaEsperada = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        assertArrayEquals(listaEsperada.toArray(), numerosOrdenados.toArray());
    }

    @Test
    public void testFilterNumberLessSix() {
        List<Integer> retorno = numbers
                .stream()
                .sorted()
                .filter(number -> number < 6)
                .collect(Collectors.toList());
        List<Integer> retornoExperado = Arrays.asList(1, 2, 3, 4, 5);

        assertArrayEquals(retornoExperado.toArray(), retorno.toArray());
    }

    @Test
    public void testNumrosImpares() {
        long retorno = numbers
                .stream()
                .filter(number -> number % 2 == 1)
                .count();
        assertEquals(4L, retorno);
    }
}
