package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Arraylist {

    // Find the second largest element in a list
    public static int findSecondLargest(List<Integer> list) {
        if (list.size() < 2) {
            throw new IllegalArgumentException("List must have at least two elements.");
        }
        Collections.sort(list);
        return list.get(list.size() - 2);
    }

    // Remove all occurrences of a specific element
    public static void removeElement(List<Integer> list, int element) {
        list.removeIf(n -> n == element);
    }

    // Check if the list contains duplicates
    public static boolean hasDuplicates(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : list) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Merge two lists of strings
    public static List<String> mergeLists(List<String> list1, List<String> list2) {
        list1.addAll(list2);
        return list1;
    }

    // Find the frequency of a specific element in a list
    public static int getFrequency(List<Integer> list, int element) {
        int count = 0;
        for (Integer num : list) {
            if (num == element) {
                count++;
            }
        }
        return count;
    }

    // Check if the list is a palindrome
    public static boolean isPalindrome(List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Find the longest string in a list of strings
    public static String findLongest(List<String> list) {
        String longest = "";
        for (String str : list) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }
        return longest;
    }

    // Remove every other element from a list
    public static void removeEveryOther(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
    }

    // Find elements common to two lists
    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        HashSet<Integer> set1 = new HashSet<>(list1);
        HashSet<Integer> common = new HashSet<>();
        for (int num : list2) {
            if (set1.contains(num)) {
                common.add(num);
            }
        }
        return new ArrayList<>(common);
    }

    // Shift elements by one position to the left
    public static void shiftLeft(List<Integer> list) {
        if (list.isEmpty()) return;
        int first = list.get(0);
        list.remove(0);
        list.add(first);
    }

    // Count subarrays with sum less than or equal to S
    public static int SubarraysWithSumLessThanS(List<Integer> list, int S) {
        int left = 0, count = 0, currentSum = 0;

        for (int right = 0; right < list.size(); right++) {
            currentSum += list.get(right);

            while (currentSum > S) {
                currentSum -= list.get(left);
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> sample = new ArrayList<>();
        sample.add(10);
        sample.add(20);
        sample.add(4);
        sample.add(15);
        sample.add(30);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        // Example usage of methods
        System.out.println("Second largest element: " + findSecondLargest(sample));

        removeElement(sample, 10);
        System.out.println("After removal: " + sample);

        System.out.println("Contains duplicates: " + hasDuplicates(sample));

        List<String> mergedList = mergeLists(
                new ArrayList<>(List.of("Apple", "Banana", "Cherry")),
                new ArrayList<>(List.of("Date", "Elderberry", "Fig"))
        );
        System.out.println("Merged ArrayList: " + mergedList);

        int element = 10;
        System.out.println("Frequency of " + element + ": " + getFrequency(sample, element));

        System.out.println("Is palindrome? " + isPalindrome(sample));

        List<String> stringList = new ArrayList<>(List.of("Apple", "Banana", "Cherry", "Date", "Elderberry"));
        System.out.println("Longest string: " + findLongest(stringList));

        System.out.println("Common elements: " + findCommonElements(list1, list2));

        System.out.println("Before shift: " + numbers);
        shiftLeft(numbers);
        System.out.println("After shift: " + numbers);

        System.out.println("Subarrays with sum less than or equal to 10: " +
                SubarraysWithSumLessThanS(sample, 10));
    }
}
