import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class OrdenaStrings {

    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora caso do codigo");
        palavras.add("Caelum");

        System.out.println(palavras);

//        Comparator<String> comparaStrings = new ComparaStrings();
//        palavras.sort(comparaStrings);

//        Comparator<String> comparaStrings = new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                if (s1.length() < s2.length()) {
//                    return -1;
//                }
//                if (s1.length() > s2.length()) {
//                    return 1;
//                }
//                return 0;
//            }
//        };
//        palavras.sort(comparaStrings);

//        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

//        Function<String, Integer> funcaoCompararLambda = s -> s.length();
//        Function<String, Integer> funcaoCompararMethodRef = String::length;
//        Comparator<String> comparador = Comparator.comparing(funcaoCompararMethodRef);
//        palavras.sort(comparador);

//        palavras.sort(Comparator.comparing(s -> s.length()));
//        palavras.sort(Comparator.comparing(String::length)); //Método Reference
        palavras.sort(String.CASE_INSENSITIVE_ORDER);
//        System.out.println(palavras);

        palavras.forEach(System.out::println);

    }
}


class ComparaStrings implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}

