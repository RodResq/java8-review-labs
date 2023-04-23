package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

//    Stream de elementos
    Stream<String> streamOfArray = Stream.of("alpha", "beta", "delta");

//    Stream de builder
    Stream<String> streamBuilder = Stream.<String>builder()
            .add("Alpha")
            .add("Beta")
            .add("delta")
            .build();

//    Stream de uma coleção
    List<String> ar = new ArrayList<>();
    Stream<String> streamFromCollection = ar.stream();

//    Map operation
    Stream<String> result = streamOfArray
        .map(element -> element.substring(0, 3));

//    Stream pipelani map + sort with comparator
    Stream<String> result2 = streamOfArray
        .map(element -> element.substring(0, 1))
        .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()));

//    reduce a stram of number to a single number
  int reduceResult = Stream.of(1, 2, 3)
          .reduce(10, (a, b) -> a + b);

//  parallel strams

}
