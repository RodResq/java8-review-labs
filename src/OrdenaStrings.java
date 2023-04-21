import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora caso do codigo");
        palavras.add("Caelum");

        System.out.println(palavras);

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(palavras);

    }
}

class ComparaPorTamanhao implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return 1;
        }
        if (s2.length() > s1.length()) {
            return -1;
        }
        return 0;
    }
}
