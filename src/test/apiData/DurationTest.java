package test.apiData;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

import static junit.framework.TestCase.assertEquals;

public class DurationTest {

    @Test
    public void testAdcionaTempoComDuration() {
        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));

        LocalTime expect = LocalTime.of(6, 30, 30);

        assertEquals(expect, finalTime);
    }

}
