package test;

import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.*;

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
    public void testOptionalIsPresent() {
        Optional<String> retorno1 = Optional.of("Baeldung");
        assertTrue(retorno1.isPresent());

        Optional<Object> retorno2 = Optional.ofNullable(null);
        assertFalse(retorno2.isPresent());
    }

    @Test
    public void testOptionalIfPresent() {
        Optional<String> retorno = Optional.of("Baeldung");
        retorno.ifPresent(ret -> System.out.println(ret.length()));
    }

    @Test
    public void testDefaultValueWithOrElse() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("Jhon");

        assertEquals("Jhon", name);
    }

    @Test
    public void testDefaultValueWithOrElseGet() {
        String nullName = null;
        String retorno = Optional.ofNullable(nullName).orElseGet(() -> "Jhon");

        assertEquals("Jhon", retorno);
    }

    @Test
    public void testOrElseAndOrElseGet() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);

        String retorno = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", retorno);

    }

    @Test
    public void testOrElseAndOrElseGetWithDefaultMethod() {
        String text = "Text present";

        System.out.println("Using orElseGet:");
        String defaultText =
                Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Text present", defaultText);

        System.out.println("Using OrElse");
        String retorno = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Text present", retorno);
    }

    public String getMyDefault() {
        System.out.println("Geeting default value");
        return "Default Value";
    }

}
