package test;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    @Test
    public void testDiaMesAnoPosterior() {
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);
        LocalDate mesSeguinte = hoje.plusMonths(1);
        LocalDate anoSeguinte = hoje.plusYears(1);

        assertEquals(DayOfWeek.TUESDAY, amanha.getDayOfWeek());
        assertEquals(Month.JUNE, mesSeguinte.getMonth());
        assertEquals(2024, anoSeguinte.getYear());
    }

    @Test
    public void testFormatadorDeData() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoje = LocalDate.now();
        String dataFormatada = hoje.format(formatador);

        assertEquals("08/05/2023", dataFormatada);
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formataDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        System.out.println(agora.format(formataDataHora));
    }

    @Test
    public void testYearMonth() {
        YearMonth anoMes = YearMonth.of(2015, Month.JANUARY);
        System.out.println(anoMes.format(DateTimeFormatter.ofPattern("MM/yyyy")));

        assertEquals("2015-01", anoMes.toString());
    }

    @Test
    public void testLocalTime() {
//        Serve para trabalhar apenas com tempo
        LocalTime intervalo = LocalTime.of(12, 30);
        System.out.println(intervalo.format(DateTimeFormatter.ofPattern("hh-mm")));

        assertEquals("12:30", intervalo.toString());
    }
}
