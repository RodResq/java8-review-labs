package test;

import java.util.function.Function;
import java.util.function.Predicate;


public class PLusOne implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer value) {
        return value + 1;
    }
}

