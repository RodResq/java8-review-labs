package test.apiData;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ApiDatas {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasDoRio = LocalDate.of(2024, Month.APRIL, 5);

        int anos = olimpiadasDoRio.getYear() - hoje.getYear();
        System.out.println(anos);

        Period period = Period.between(hoje, olimpiadasDoRio);
        System.out.println(period.getDays());

        LocalDate proximasOlimpiadas = olimpiadasDoRio.plusYears(4);
        System.out.println(proximasOlimpiadas);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = proximasOlimpiadas.format(formatador);
        System.out.println(valorFormatado);

        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));

        LocalTime intervalor = LocalTime.of(15, 30);
        System.out.println(intervalor);

    }
}
