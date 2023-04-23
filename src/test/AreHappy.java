package test;

import java.util.function.Predicate;

public class AreHappy implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return true;
    }
}
