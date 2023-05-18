package test.apiData;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static junit.framework.TestCase.assertEquals;

public class DurationTest {

    @Test
    public void testAdcionaTempoComDuration() {
        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));

        LocalTime expect = LocalTime.of(6, 30, 30);

        assertEquals(expect, finalTime);
    }

    @Test
    public void testIntervaloTempoComDuration() {
        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));

        long retorno = Duration.between(initialTime, finalTime).getSeconds();

        assertEquals(30, retorno);
    }

    @Test
    public void testIntervaloTempoComChronoUnit() {
        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(59));

        long retorno = ChronoUnit.SECONDS.between(initialTime, finalTime);

        assertEquals(59, retorno);
    }

//    TODO continuar daqui: https://www.baeldung.com/java-8-date-time-intro#compatibility

}
