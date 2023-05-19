package test.apiData;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static junit.framework.TestCase.assertEquals;

public class FormatandoDatTimeTest {

    @Test
    public void testFormataData() {
        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
        String retorno = localDateTime.format(DateTimeFormatter.ISO_DATE);

        assertEquals("2015-01-25", retorno);
    }

    @Test
    public void testFormatacaoCustomizada() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String retorno = localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        assertEquals("18/05/2023", retorno);
    }

    @Test
    public void testStyloFormatacao() {
        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
        String retorno = localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK));

        System.out.println(retorno);
    }
}
