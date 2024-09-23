import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPipelineExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        // Stream pipeline to filter, double, and collect even numbers
        List<Integer> doubledEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)        // Step 1: Filter even numbers
                .map(n -> n * 2)               // Step 2: Double the even numbers
                .collect(Collectors.toList()); // Step 3: Collect into a list

        System.out.println("Doubled even numbers: " + doubledEvenNumbers);
    }
}
