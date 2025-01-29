package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsClass {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        //find maximum elements
        int max = Collections.max(numbers);
        System.out.println("Maximum: " + max);

        // Find the minimum element
        int min = Collections.min(numbers);
        System.out.println("Minimum: " + min);

        // Calculate the range (max - min)
        int range = max - min;
        System.out.println("Range: " + range);

        // Filter the list (e.g., keep only numbers greater than 10)
        List<Integer> filteredList = numbers.stream()
                .filter(num -> num > 10)
                .collect(Collectors.toList());
        System.out.println("Filtered List (greater than 10): " + filteredList);

        //map a list(ex multiply each number by 5)
        List<Integer> mappedList = numbers.stream().
                map(num -> num*5)
                .collect(Collectors.toList());
        System.out.println("Mapped List (each element * 5): " + mappedList);

        //get a subList
        List<Integer> sublist=numbers.subList(2,5);
        System.out.println("Sublist (index 2 to 5): " + sublist);

    }

}
