import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class ConsumersLabs {

    public static void main(String[] args) {

//        List<String> names = Arrays.asList("Jhon", "Freddy", "Samuel");
//        names.forEach(name -> System.out.println("Hello " + name));

        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Jhon", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);
        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years hold"));

    }

}
