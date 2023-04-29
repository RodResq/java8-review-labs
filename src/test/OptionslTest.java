package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class OptionslTest {

    @Test
    public void testOptionalEmpty() {
        Optional<Object> retorno = Optional.empty();
        Assert.assertFalse(retorno.isPresent());
    }
}
