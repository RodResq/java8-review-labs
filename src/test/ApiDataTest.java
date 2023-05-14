package test;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import static junit.framework.TestCase.*;

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

    @Test
    public void testLocalDate() {
        LocalDate dataHoje = LocalDate.of(2023, Month.MAY, 13);
        LocalDate retorno = LocalDate.now();

        assertEquals(dataHoje, retorno);
    }

    @Test
    public void testMethodOfAndParse() {
        LocalDate parse = LocalDate.parse("2015-02-20");
        LocalDate retorno = LocalDate.of(2015, 02, 20);

        assertEquals(parse, retorno);
    }

    @Test
    public void testAdcionarUmDiaDataAtual() {
        LocalDate amanha = LocalDate.of(2023, Month.MAY, 14);
        LocalDate retorno = LocalDate.now().plusDays(1);

        assertEquals(amanha, retorno);
    }

    @Test
    public void testRecuperandoMesAnterior() {
        LocalDate mesAnterior = LocalDate.parse("2023-04-13");
//        LocalDate retorno = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        LocalDate retorno = LocalDate.now().minusMonths(1);
        assertEquals(mesAnterior, retorno);
    }

    @Test
    public void testRecuperarDiaSemana() {
        DayOfWeek retorno = LocalDate.parse("2016-06-12").getDayOfWeek();

        assertEquals(DayOfWeek.SUNDAY, retorno);
    }

    @Test
    public void testRecuperarDiaDoMes() {
        int retorno = LocalDate.parse("2016-06-12").getDayOfMonth();

        assertEquals(12, retorno);
    }

    @Test
    public void testSeDataOcorre() {
        boolean retorno = LocalDate.now().isLeapYear();
        System.out.println(retorno);
    }

    @Test
    public void testSeDataAnterior() {
        boolean retorno = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
        assertFalse(retorno);
    }

    @Test
    public void testSeDataPosterior() {
        boolean retorno = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-10"));
        assertTrue(retorno);
    }

    @Test
    public void testRecuperarInicioData() {
        LocalDateTime retorno = LocalDate.parse("2016-06-12").atStartOfDay();
        System.out.println(retorno);
    }

    @Test
    public void testRecuperaPrimeiroDiaDoMesDadaData() {
        LocalDate retorno = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
        LocalDate parse = LocalDate.parse("2016-06-01");

        assertEquals(parse, retorno);
    }

//    TODO continuar deste ponto: https://www.baeldung.com/java-8-date-time-intro#2-working-with-localtime

}
