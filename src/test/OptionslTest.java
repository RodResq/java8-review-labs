package test;

import org.junit.Test;

import java.util.NoSuchElementException;
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

    @Test(expected = IllegalArgumentException.class)
    public void testExcepitonOrElseThrow() {
        String nullName = null;
        Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);

    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementeException() {
        String nullName = null;
        Optional.ofNullable(nullName).orElseThrow(NoSuchElementException::new);
    }

    public String getMyDefault() {
        System.out.println("Geeting default value");
        return "Default Value";
    }

    @Test
    public void testOptionalGet() {
        Optional<String> opt = Optional.of("baeldung");
        String retorno = opt.get();

        assertEquals("baeldung", retorno);
    }

    @Test(expected = NoSuchElementException.class)
    public void testNosuchElementExceptonWithGet() {
        Optional<Object> opt = Optional.ofNullable(null);
        Object retorno = opt.get();

    }

    @Test
    public void testOptionalWithFilter() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        assertTrue(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        assertFalse(is2017);
    }

    @Test
    public void testPrincIsRange() {
        assertTrue(priecIsInRange2(new Modem(10.0)));
        assertFalse(priecIsInRange2(new Modem(9.9)));
        assertFalse(priecIsInRange2(new Modem(null)));
        assertFalse(priecIsInRange2(new Modem(15.5)));
        assertFalse(priecIsInRange2(null));
    }

    private boolean priceIsInRange1(Modem modem) {
        boolean isInRange = false;

        if (modem != null && modem.getPrice() != null
                && (modem.getPrice() >= 10)
                && (modem.getPrice() <= 15)) {

            isInRange = true;
        }
        return isInRange;
    }

    private boolean priecIsInRange2(Modem modem) {
        return Optional.ofNullable(modem)
                .map(Modem::getPrice)
                .filter(m -> m >= 10)
                .filter(m -> m <= 15)
                .isPresent();
    }

}

class Modem {
    private Double price;

    public Modem(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
