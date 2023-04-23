package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class FunctionAndPredicateAndComparatorTest {

    @Test
    public void testFunction() {
//        Function<Integer, Integer> plusOne = new PLusOne();
        Function<Integer, Integer> plusOne = s -> s + 1;
        Integer result = plusOne.apply(2);

        assertEquals(new Integer(3), result);
    }

    @Test
    public void testPredicate() {
//        Predicate<String> areHappy = new AreHappy();
        Predicate<String> areHappy = s -> s.equals("test") ? true: false;
        boolean result = areHappy.test("test");

        assertTrue(String.valueOf(true), result);
    }

    @Test
    public void testMyComparator() {
        List<String> nomes = Arrays.asList("Ana", "Claudia", "Paula");

//        Comparator<String> myComporator = new MyComparator();
        Comparator<String> myComporator = (s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() > s2.length()) {
                return 1;
            }
            return 0;
        };

        Collections.sort(nomes, myComporator);

        assertEquals(new String("Ana"), nomes.get(0));
        assertEquals(new String("Paula"), nomes.get(1));
        assertEquals(new String("Claudia"), nomes.get(2));
    }


}
