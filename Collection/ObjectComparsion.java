package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
   public  String name;
   public  int age;
   public int grade;

    // Constructor
    public Student(String name,int age, int grade) {
        this.name = name;
        this.age =age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{name=" + " "+ name + "  " + "age" + " "+ age + " " +"grade=" + grade + " " + "}";
    }
}

class Teacher implements Comparable<Teacher> {
    private String name;
    private int age;
     private int salary;


    public Teacher(String name,int age,int salary) {
        this.name = name;
        this.age=age;
        this.salary = salary;

    }

    @Override
    public int compareTo(Teacher other) {

        //  // First, compare by name

        //Method 1 : Using compare method to compare  students based on their name attribute
       // int nameComparison = CharSequence.compare(this.name,other.name);

        //method 5 : using compareTo method
        //int nameComparison = this.name.compareTo(other.name);

        //        if (nameComparison != 0) {
        //        return nameComparison;
        //        }


        //Method 2 : using the char based comparison - iterate over character to check difference
//        int minLength = Math.min(this.name.length(), other.name.length());
//
//        for(int i =0;i< minLength;i++) {
//         int charComparison = this.name.charAt(i) - other.name.charAt(i);
//            if (charComparison != 0) {
//                return charComparison;
//            }
//        }

        //Method 3
//        if(this.name != other.name) {
//            for (int i = 0; i <= 1; i++) {
//                return this.name.charAt(i) - other.name.charAt(i);
//            }
//        }

        //method 4 : - using charArray
        if(this.name != other.name) {
           char t[] = this.name.toCharArray();
           char o[] = other.name.toCharArray();
            for (int i = 0; i < Math.min(t.length, o.length); i++) {
            if (t[i] != o[i]) {
                return t[i] - o[i];
            }
        }

        // If all compared characters are the same, the shorter name comes first
        return t.length - o.length;
        }
        //return this.name.length() - other.name.length();
//
        // If names are equal, compare by age
        if (this.age != other.age) {
            return Integer.compare(this.age, other.age);
        }


        // If both name and age are the same, compare by grade
        return Integer.compare(this.salary, other.salary);

    }

        @Override
        public String toString() {
            return "Teacher{name='" + name + " " + "', age=" + age + " " + ", salary=" + salary + " " +"}";
        }
}

class NameComparator implements Comparator<Student> {
    // Compare students by name
    @Override
    public int compare(Student s1, Student s2) {
        int nameCompare = CharSequence.compare(s1.name, s2.name);
        if (nameCompare != 0) {
            return nameCompare;
        }

        if (s1.age != s2.age) {
            return Integer.compare(s1.age, s2.age);
        }
        return Integer.compare(s1.grade, s2.grade);

    }
}


     class SameObjectComparartor implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
//            int nameCompare = s1.name.compareTo(s2.name);
//            if (nameCompare != 0) {
//                return nameCompare;
//            } else if (s1.age != s2.age) {
//                return Integer.compare(s1.age, s2.age);
//            } else if (s1.grade != s2.grade) {
//                return Integer.compare(s1.grade, s2.grade);
//            } else {
//                return 0;
//            }
             return 0;
        }
    }


    public  class ObjectComparsion {
        public static void main(String[] args) {
            List<Student> students = new ArrayList<>();
            students.add(new Student("Alice", 10, 90));
            students.add(new Student("Bob", 15, 75));
            students.add(new Student("Aakash", 10, 85));

            //same attribute student object
            List<Student> SameStudents = new ArrayList<>();
            SameStudents.add(new Student("Alice", 10, 90));
            SameStudents.add(new Student("Bhanu", 15, 80));

            List<Teacher> teachers = new ArrayList<>();
            teachers.add(new Teacher("Anil", 15, 10000));
            teachers.add(new Teacher("Bhanu", 15, 75));
            teachers.add(new Teacher("Anil", 16, 85));
            teachers.add(new Teacher("Harsh", 15, 100));
            teachers.add(new Teacher("Hrithik", 20, 75000));
            teachers.add(new Teacher("Harsh", 19, 100));

            // Sort students by name using a custom comparator
            // Collections.sort(students, new NameComparator());
          //  Collections.sort(SameStudents, new SameObjectComparartor());

             Collections.sort(teachers);


            // Print sorted list by name
           // System.out.println("Sorted Students by Name: " + SameStudents);
            for(Teacher teacher : teachers ) {
                System.out.println("Sorted Students by Name: " + teacher);
            }
        }
    }

