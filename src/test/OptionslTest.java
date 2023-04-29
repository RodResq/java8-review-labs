package test;

import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class OptionslTest {

    @Test
    public void testOptionalEmpty() {
        Optional<Object> retorno = Optional.empty();

        assertFalse(retorno.isPresent());
    }

    @Test
    public void testOptionalOf() {
        String name = "baeldung";
        Optional<String> retorno = Optional.of(name);

        assertTrue(retorno.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void testPassandoNullOptional() {
        String nome = null;
        Optional.of(nome);
    }

    @Test
    public void testEsperaNullValue() {
        String nome = "baeldung";
        Optional<String> retorno = Optional.ofNullable(nome);

        assertTrue(retorno.isPresent());
    }

    @Test
    public void testPassandoObjNull() {
        String nome = null;
        Optional<String> retorno = Optional.ofNullable(nome);

        assertFalse(retorno.isPresent());
    }

    @Test
    public void testOptionalIfPresent() {
        Optional<String> retorno1 = Optional.of("Baeldung");
        assertTrue(retorno1.isPresent());

        Optional<Object> retorno2 = Optional.ofNullable(null);
        assertFalse(retorno2.isPresent());
    }
}
