package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class FunctionAndPredicateTest {

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


}
