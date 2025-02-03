package Collection;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class WishTemplate {

    // Method 1: Using split()
    public static String generateTemplateUsingSplit(String input) {
        String[] parts = input.split("/");

        if (parts.length != 4) {
            return "Invalid input format!";
        }

        String name = parts[0];
        String gender = parts[1];
        String dobString = parts[2];
        String address = parts[3];

        int age = calculateAge(dobString);

        return generateTemplate(name, gender, age, address);
    }

    // Method 2: Using for loop and contains() to extract parts
    public static String generateTemplateUsingLoop(String input) {
        String name = "", gender = "", dobString = "", address = "";
        int slashCount = 0, start = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '/') {
                String value = input.substring(start, i);
                if (slashCount == 0) name = value;
                else if (slashCount == 1) gender = value;
                else if (slashCount == 2) dobString = value;
                start = i + 1;
                slashCount++;
            }
        }

        // Extract last part (address)
        if (slashCount == 3) {
            address = input.substring(start);
        } else {
            return "Invalid input format!";
        }

        int age = calculateAge(dobString);
        return generateTemplate(name, gender, age, address);
    }

    // Method to calculate age from DOB
    private static int calculateAge(String dobString) {
        LocalDate dob = LocalDate.parse(dobString);
        return Period.between(dob, LocalDate.now()).getYears();
    }

    // Method to generate the welcome template
    private static String generateTemplate(String name, String gender, int age, String address) {
        String pronoun = gender.equalsIgnoreCase("male") ? "Mr." : "Ms.";
        return "Welcome " + pronoun + " " + name + "!\n"
                + "We are pleased to have a " + age + "-year-old talent like you at our company.\n"
                + "Your registered address is: " + address + ".\n"
                + "We look forward to working with you!";
    }
    public static void main(String[] args) {

        System.out.println("Enter the string url in form : yourname/gender/YYYY-MM-DD/city,Country");
        System.out.println("Enter the details:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //String input = "John Doe/male/1995-05-15/New York, USA";

        System.out.println("Using split():");
        System.out.println(generateTemplateUsingSplit(input));

        System.out.println("\nUsing loop:");
        System.out.println(generateTemplateUsingLoop(input));

    }
}
