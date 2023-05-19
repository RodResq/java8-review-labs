package test.apiData;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class ConversaoDateAndCalendarToLocalDateTimeTest {

    @Test
    public void testLocalDateToLocalDateTime() {
        LocalDateTime retorno = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());

        System.out.println(retorno);
    }

    @Test
    public void testCalendarToLocalDateTime() {
        LocalDateTime retorno = LocalDateTime.ofInstant(Calendar.getInstance().toInstant(), ZoneId.systemDefault());

        System.out.println(retorno);
    }
}
