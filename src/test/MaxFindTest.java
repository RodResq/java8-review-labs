package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MaxFindTest {

    @Test
    public void testMaxFind() {
        MaxFinder maxFinder = (a, b) -> (a > b) ? a: b;

        Assert.assertEquals(maxFinder.findMax(5,10), 10);
        Assert.assertEquals(maxFinder.findMax(5, 15), 15);
    }

    @Test
    public void testLambdaExpression() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        Function<Integer, Integer> squareNumber = num -> num * num;

        assertTrue(squareNumber.apply(nums.get(0)).equals(1));
        assertTrue(squareNumber.apply(nums.get(1)).equals(4));
        assertTrue(squareNumber.apply(nums.get(2)).equals(9));
        assertTrue(squareNumber.apply(nums.get(3)).equals(16));
    }

    @Test
    public void testPredicate() {
        Predicate<Integer> isElegibleForVoting = age -> age >= 18 && age <= 60;

        assertFalse(isElegibleForVoting.test(16));
        assertTrue(isElegibleForVoting.test(18));
        assertTrue(isElegibleForVoting.test(22));
        assertTrue(isElegibleForVoting.test(60));
        assertFalse(isElegibleForVoting.test(65));
    }


}





