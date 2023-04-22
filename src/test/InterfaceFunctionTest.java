package test;


import org.junit.Test;

import java.util.function.Function;

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
}
//5. Primitive Function Specializations
