package Collection;

import java.util.*;
import java.util.stream.Stream;

public class BasicArraylistOperations {

    public static ArrayList<Integer> mergeUnique(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // Using a HashSet to ensure uniqueness
        Set<Integer> uniqueSet = new HashSet<>(list1);
        uniqueSet.addAll(list2);

        // Converting back to ArrayList
        return new ArrayList<>(uniqueSet);
    }
    public static void main(String[] args) {

        // Create two ArrayLists of Integer type
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(5,7,9,8,6,5,2,4));
        Stream<Integer> numStream = myList.stream();
        // Create an ArrayList of Integer objects
        ArrayList<Integer> intList = new ArrayList<>();

        //  Add elements to the ArrayList
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);
        intList.add(50);
        System.out.println("Original ArrayList: " + intList);

        // Add elements to ImaginaryList
        Collections.addAll(list1, 10, 20, 30, 40, 50);
        System.out.println("List1: " + list1);

        // Add elements to RealList
        Collections.addAll(list2, 30, 40, 50, 60, 70);
        System.out.println("List2: " + list2);

        // Add all elements of RealList to ImaginaryList
        list1.addAll(list2);
        System.out.println("\nAfter adding all elements from List2 to List1: " + list1);

        //  Insert an element at a specific index
        intList.add(2, 25); // Insert 25 at index 2
        System.out.println("After adding 25 at index 2: " + intList);

        //  Update/Set an element at a specific index
        intList.set(3, 35); // Update the element at index 3 to 35
        System.out.println("After updating index 3 to 35: " + intList);

        //  Get an element at a specific index
        System.out.println("Element at index 4: " + intList.get(4));

        //  Remove an element by index
        intList.remove(2); // Remove the element at index 2
        System.out.println("After removing the element at index 2: " + intList);

        //  Remove an element by value
        intList.remove(Integer.valueOf(40)); // Remove the value 40
        System.out.println("After removing the value 40: " + intList);

        //  Check if the ArrayList contains a specific element
        System.out.println("Does the list contain 50? " + intList.contains(50));

        //  Get the size of the ArrayList
        System.out.println("Size of the ArrayList: " + intList.size());

        //  Check if the ArrayList is empty
        System.out.println("Is the ArrayList empty? " + intList.isEmpty());

        //  Sort the ArrayList in ascending order
        Collections.sort(intList);
        System.out.println("\nSorted ArrayList (ascending): " + intList);

        //  Sort the ArrayList in descending order
        Collections.sort(intList, Collections.reverseOrder());
        System.out.println("Sorted ArrayList (descending): " + intList);

        //  Convert the ArrayList to an array
        Integer[] intArray = intList.toArray(new Integer[0]);
        System.out.println("\nArray representation of the ArrayList:");
        for (Integer num : intArray) {
            System.out.println(num);
        }

        //  Clear all elements from the ArrayList
        intList.clear();
        System.out.println("\nArrayList after clearing all elements: " + intList);

        //Remove duplicates from the merged list
                ArrayList<Integer> uniqueList = new ArrayList<>();
                for (Integer num : myList) {
                    if (!uniqueList.contains(num)) {
                        uniqueList.add(num);
                    }
                }

        //Merging lists with unique elements
        // Creating two ArrayLists with some duplicate values
        ArrayList<Integer> ImaginaryList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> RealList = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));

        // Merging lists with unique elements
        ArrayList<Integer> mergedList = mergeUnique(ImaginaryList, RealList);

        // Displaying the unique merged list
        System.out.println("Merged Unique List: " + mergedList);

        //find the maximum elemnts in a list
        System.out.println("Maximum elements in an list");
       System.out.println(Collections.max(mergedList));

        //find the minimum elemnts in a list
        System.out.println("Minimum elements in an list");
        System.out.println(Collections.min(mergedList));

        // Reversing the list
        Collections.reverse(mergedList);
        System.out.println("Reversed List: " + mergedList);


        //Loops iteration over ArrayList

        // 1. Using a regular for loop
        System.out.println("Using regular for loop:");
        for (int i = 0; i < mergedList.size(); i++) {
            System.out.println(mergedList.get(i));
        }

        // 2. Using enhanced for loop (for-each loop)
        System.out.println("\nUsing enhanced for loop:");
        for (Integer num : mergedList) {
            System.out.println(num);
        }

        // 3. Using while loop
        System.out.println("\nUsing while loop:");
        int i = 0;
        while (i < mergedList.size()) {
            System.out.println(mergedList.get(i));
            i++;
        }

        // 4. Using do-while loop
        System.out.println("\nUsing do-while loop:");
        int j = 0;
        do {
            System.out.println(mergedList.get(j));
            j++;
        } while (j < mergedList.size());

        // 5. Using an Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<Integer> iterator = mergedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    }

