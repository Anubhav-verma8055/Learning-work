package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    public static void main(String[] args) {

        //create a stream of Integer passed as a List
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        Stream<Integer> num = Stream.of(9, 8, 7, 6, 5, 4, 3);

       //using to define the run method in runnable interface
//        Thread t1 = new Thread(() ->
//                System.out.println("this is thread"));

//       //using lambda expression to implement functional interface
        MathOperations addition = (a,b) ->  a+b;
        MathOperations substraction =(a,b) -> a - b;
        MathOperations multiplication = (a,b )-> a * b;
        MathOperations division = (a,b )-> {
            if (b != 0) return a / b;
            else return Float.NaN;  // Prevent division by zero
        };

        // 1. map() - Square each number
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared Numbers: " + squaredNumbers);

        // 2. filter() - Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);

        // 3. reduce() - Sum of all numbers
        Optional<Integer> sum = numbers.stream().
                reduce((a,b) -> a+b);
        sum.ifPresent(s -> System.out.println("Sum of Numbers: " + s));

        // 4. sorted() - Sort names alphabetically
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Names: " + sortedNames);

        // 6. collect() - Collect names with length > 3
        List<String> longNames = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());
        System.out.println("Names with length > 3: " + longNames);

        // 7. distinct() - Remove duplicate names (if any)
        List<String> duplicateNames = Arrays.asList("Alice", "Bob", "Bob", "Charlie", "Alice");

        List<String> distinctNames = duplicateNames.stream()
                .distinct().collect(Collectors.toList());
        System.out.println("Distinct Names: " + distinctNames);

        //8.peek - check the stream processing
        ArrayList<Integer> duplicate = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4));
        List<Integer> unique = duplicate.stream().distinct()
                .peek(n -> System.out.println("Processing" +n )).collect(Collectors.toList());

        // 9. anyMatch() - Check if any element is greater than 5
        System.out.println("\nUsing anyMatch() to check if any number is greater than 5:");
        boolean anyGreaterThanFive = numbers.stream()
                .anyMatch(n -> n > 5);
        System.out.println(anyGreaterThanFive);

        // 10. allMatch() - Check if all elements are positive
        System.out.println("\nUsing allMatch() to check if all numbers are positive:");
        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println(allPositive);

        //11. flatmap()
       // Explanation: Similar to map(), but instead of transforming each element
        // into a single new value, it transforms each element into a stream (or collection)
        // of values and flattens the results into a single stream.
       List<String> words= Arrays.asList("hello","world");
       List<String> letters = words.stream()
               .flatMap(w -> Arrays.stream(w.split("")))
               .collect(Collectors.toList());

       //12. limit()
       // Explanation: Limits the number of elements in
        // the stream to a specified count. It is useful
        // when you only need the first n elements.
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5)  // Limits to the first 5 elements
                .collect(Collectors.toList());

        //13.skip - Explanation: Skips the first n elements and
        // returns a new stream with the remaining elements.
        List<Integer> skippedNumbers = numbers.stream()
                .skip(3)  // Skips the first 3 elements
                .collect(Collectors.toList());

        //14.mapToInt(), mapToDouble(), mapToLong()
        //Explanation: Maps the elements of the stream
        // to a specific primitive type (like int, double, or long).
        List<String> sample = Arrays.asList("apple", "banana", "cherry");
        int totalLength = sample.stream()
                .mapToInt(String::length)  // Maps each word to its length
                .sum();



//        System.out.println("Performing operations on: " + a + " and " + b);
//        addition.display(a, b, addition, "Addition");
//        subtraction.display(a, b, subtraction, "Subtraction");
//        multiplication.display(a, b, multiplication, "Multiplication");
//        division.display(a, b, division, "Division");

    }
}
interface MathOperations{
    public float operation(float a,float b);

    // Display the result of the operation
    default void display(float a, float b, MathOperations operation, String operationName) {
        float result = operation.operation(a, b);
        System.out.println(operationName + ": " + a + " and " + b + " => " + result);
    }
}
