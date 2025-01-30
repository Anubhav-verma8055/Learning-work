package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentNew {
    public  String name;
    public  int age;
    public int grade;
    public int height;

    // Constructor
    public StudentNew(String name,int age, int grade,int height) {
        this.name = name;
        this.age =age;
        this.grade = grade;
        this.height=height;
    }

    @Override
    public String toString() {
        return "StudentNew{name=" + " "+ name + "age" + " "+ age + " " +"grade=" + grade + " " + "height" + height + "}";
    }
}

class TeacherNew implements Comparable<TeacherNew> {
    private String name;
    private int age;
    private int salary;
    private int experience;

    public TeacherNew(String name, int age, int salary,int experience) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.experience=experience;
    }

    @Override
    public int compareTo(TeacherNew other) {
        return Comparator.comparing((TeacherNew t) -> t.name)
                .thenComparing(t -> t.age)
                .thenComparing(t -> t.salary)
                .thenComparing(t -> t.experience)
                .compare(this, other);
    }

    @Override
    public String toString() {
        return "Teacher{name='" + name + "', age=" + age + ", salary=" + salary + ",experience" + experience + "}";
    }
}

public class ObjectComparisonUsingLambda {
    public static void main(String[] args){
        List<StudentNew> students = new ArrayList<>();
        students.add(new StudentNew("Alice", 10, 90,150));
        students.add(new StudentNew("Bob", 15, 75,160));
        students.add(new StudentNew("Aakash", 10, 85,180));

        // Sort students by name, then age, then grade
        students.sort(Comparator.comparing((StudentNew s) -> s.name)
                .thenComparing(s -> s.age)
                .thenComparing(s -> s.grade)
                .thenComparing(s-> s.height));

        List<TeacherNew> teachers = new ArrayList<>();
        teachers.add(new TeacherNew("Anil", 15, 10000,2));
        teachers.add(new TeacherNew("Bhanu", 15, 75,4));
        teachers.add(new TeacherNew("Anil", 16, 85,2));

        // Sort teachers using Comparable implementation
        Collections.sort(teachers);

        // Print sorted students and teachers
        System.out.println("Sorted Students by Name, Age, and Grade: " + students);
        System.out.println("Sorted Teachers by Name, Age, and Salary: " + teachers);
    }

}
