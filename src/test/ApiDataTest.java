package test;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

import static junit.framework.TestCase.assertEquals;

public class ApiDataTest {

    @Test
    public void testDiferencaEntreDuasDatas() {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        LocalDate proximaCopa = LocalDate.of(2024, 7, 1);
        System.out.println(proximaCopa);

        Period periodoProximaCopa = Period.between(hoje, proximaCopa);

        System.out.println(periodoProximaCopa);
        assertEquals(1, periodoProximaCopa.getYears());
        assertEquals(1, periodoProximaCopa.getMonths());
        assertEquals(23, periodoProximaCopa.getDays());
    }

    @Test
    public void testDiasMesesAnosAnterior() {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        LocalDate ontem = hoje.minusDays(1);
        System.out.println(ontem);
        LocalDate anteOntem = hoje.minusDays(2);
        System.out.println(anteOntem);

        LocalDate mesPassado = hoje.minusMonths(1);
        System.out.println(mesPassado);

        LocalDate anoPassado = hoje.minusYears(1);
        System.out.println(anoPassado);

        assertEquals(DayOfWeek.SUNDAY, ontem.getDayOfWeek());
        assertEquals(DayOfWeek.SATURDAY, anteOntem.getDayOfWeek());

        assertEquals(Month.APRIL, mesPassado.getMonth());
        assertEquals(2022, anoPassado.getYear());
    }
}
