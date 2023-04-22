package test;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;


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
}
//5. Primitive Function Specializations
