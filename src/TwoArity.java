import java.util.HashMap;

public class TwoArity {

    public static void main(String[] args) {
        HashMap<String, Integer> salarios = new HashMap<>();
        salarios.put("Jhon", 40000);
        salarios.put("Freddy", 30000);
        salarios.put("Samuel", 50000);

        salarios.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue: oldValue + 10000);

        System.out.println(salarios);
    }
}
