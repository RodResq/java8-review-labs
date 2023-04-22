import java.util.Arrays;
import java.util.List;

public class OperatorsLabs {

    public static void main(String[] args) {
//        List<String> names = Arrays.asList("bob", "josh", "megan");
//        names.replaceAll(name -> name.toUpperCase());
//        names.replaceAll(String::toUpperCase);
//        System.out.println(names);

//        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
//
//        int sum = values.stream()
//                .reduce(0, (i1, i2) -> i1 + i2);
//
//        System.out.println(sum);
        Thread thread1 = new Thread(() -> System.out.println("Hello From Another Thread"));
        thread1.start();
        System.out.println(thread1.getId());
        Thread thread2 = new Thread(() -> System.out.println("Hello From Another Thread"));
        thread2.start();
        System.out.println(thread2.getId());
    }
}
