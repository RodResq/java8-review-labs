import java.util.HashMap;

public class InterfaceFuncionalLabs {

    public static void main(String[] args) {
        HashMap<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("Jhon", s -> s.length());
        Integer jhon = nameMap.computeIfAbsent("Jhon", String::length);

        System.out.println(jhon);

    }
}
