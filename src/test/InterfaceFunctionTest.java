package test;


import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;


public class InterfaceFunctionTest {

    @Test
    public void testQuoteIntToString() {
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        assertEquals("'5'", quoteIntToString.apply(5));
    }

    @Test
    public void testRetirarBarra() {
        Function<String, String> retiraBarra =
                s -> s.replace("/", "").replace("[", "").replace("]", "");
        String nomeFormatado = retiraBarra.apply("[/a/b/c/d]");

        assertEquals("abcd", nomeFormatado);
    }

    @Test
    public void whenPassingMethodReferenceToComputeIfAbsent_thenTheValueGetsComputedAndPutIntoMap() {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", String::length);

        assertEquals(new Integer(4), nameMap.get("John"));
        assertEquals(new Integer(4), value);
    }

    @Test
    public void whenUsingConsumerInForEach_thenConsumerExecutesForEachListElement() {
        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(System.out::println);
    }

    @Test
    public void testPredicateNoFilter() {
        List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");
        List<String> namesStartWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        assertEquals(2, namesStartWithA.size());
        assertTrue(names.contains("Angela"));
        assertTrue(names.contains("Aaron"));
    }

    @Test
    public void testComReduci() {
        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        int sum = values.stream()
                .reduce(0, (i1, i2) -> i1 + i2);

        assertEquals(37, sum);
    }

    @Test
    public void testInterfaceFuncionalDefinida() {
        OperationExample operation = num -> num * num;
        System.out.println(OperationExample.getOperationNature());

        assertEquals(25, operation.square(5));
    }

    @Test
    public void testExemploComFuncion() {
        Function<Integer, Integer> operatios = value -> value * value;

        assertEquals(new Integer(25), operatios.apply(5));
    }

    @Test
    public void testPassandoUmaFuncaoComoParametroDeUmMetodoFunction() {
        Integer retorno = compute(value -> value * value, 5);

        assertEquals(new Integer(25), retorno);
    }

    @Test
    public void testPassandoUmaFuncaoComoParametroDeUmMetodoPredicate() {
        Boolean retorno = isMaiorIdade(idade -> idade >= 18, 18);

        assertTrue(retorno);
    }

    @Test
    public void testComposeFunction() {
        Function<Integer, Integer> function = num -> num * num;
    }

    private Integer compute(Function<Integer, Integer> operation, int param) {
        return operation.apply(param);
    }

    private Boolean isMaiorIdade(Predicate<Integer> predicate, int param) {
        return predicate.test(param);
    }

}

