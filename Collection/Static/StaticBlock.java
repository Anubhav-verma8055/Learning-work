package Collection.Static;

import Collection.AreaInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StaticBlock  {
    static ArrayList<Integer> numbers = new ArrayList<>();

    static class Teachers implements Comparable<Teachers>{
        public String name;
        private int age;
        private int salary;
        private int experience;

        @Override
        public String toString() {
            return "Teachers{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", experience=" + experience +
                    '}';
        }

        public Teachers(String name, int age, int salary, int experience) {
            this.name=name;
            this.age=age;
            this.salary=salary;
            this.experience=experience;
        }

        @Override
        public int compareTo(Teachers others) {
//            if(this.name != others.name) {
//                char[] t = this.name.toCharArray();
//                char[] o = others.name.toCharArray();
//
//                for (int i = 0; i < Math.min(t.length, o.length); i++) {
//                    if (t[i] != o[i]) {
//                        return t[i] - o[i];
//                    }
//                }
//                return t.length - o.length;
//            }
//            if(this.age != others.age) {
//                return Integer.compare(this.age,others.age);
//            }
//            if(this.salary != others.salary) {
//                return Integer.compare(this.salary,others.salary);
//            }
//            return Integer.compare(this.experience, others.experience);
            return Comparator.comparing((Teachers t) -> t.name)
                    .thenComparing(t ->t.age)
                    .thenComparing(t->t.salary).thenComparing(t ->experience)
                    .compare(this,others);
        }
    }


    static class Student{
       public  String name;
       public  int age;
       public  int grade;
       public int height;

       public Student(String name,int age,int grade,int height) {
           this.name=name;
           this.age=age;
           this.grade=grade;
           this.height=height;
       }

        @Override
        public String toString() {
            return "Student{name=" + " "+ name + " " + "age" + " "+ age + " " +"grade=" + grade + " " + "height" + height + " " + "}";
        }
    }
    static{
      //list of students to sort using comparator(lambda expression0
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 10, 90,150));
        students.add(new Student("Bob", 15, 75,160));
        students.add(new Student("Aakash", 10, 85,180));

        //list of teachers to sort using natural ordering(comparable - compareTo() method)

        List<Teachers> teachers = new ArrayList<>();
        teachers.add(new Teachers("Anil", 15, 10000,2));
        teachers.add(new Teachers("Bhanu", 15, 75,3));
        teachers.add(new Teachers("Anil", 16, 85,4));
        teachers.add(new Teachers("Harsh", 15, 100,2));
        teachers.add(new Teachers("Hrithik", 20, 75000,3));
        teachers.add(new Teachers("Harsh", 19, 100,4));

        //override the operation function :- achieving inheritance (overriding the class method in static)
        Operation operation = new Operation() {
            @Override
            public int mathematicalOperation(int a, int b) {
                return a + b;
            }
        };

        System.out.println("Mathematical Operation result: " + operation.mathematicalOperation(5, 10));

      //polymorphism using functional Interface and lambda expressions
        AreaInterface squareArea = (dimensions) -> dimensions[0] * dimensions[0];
        AreaInterface rectangleArea = (dimensions) -> dimensions[0] * dimensions[1];
        AreaInterface triangleArea = (dimensions) ->  (dimensions[0] * dimensions[1])/2;
        AreaInterface circleArea = (dimensions) -> 3.14 * dimensions[0] * dimensions[0];


        //area of square
        double squareSide=6.0;
        System.out.println("Area of the square :" + squareArea.calculate(squareSide));
    //Area of rectangle
        double length=10.0;
        double breadth = 4.0;
        System.out.println("Area of the rectangle :" + rectangleArea.calculate(length,breadth));
        //Area of traiangle
        double a=8.0;
        double b = 6.0;
        System.out.println("Area of the triangle :" + triangleArea.calculate(a,b));
        //Area of circle
        double radius=5.0;
        System.out.println("Area of the circle :" + circleArea.calculate(squareSide));


        System.out.println("This is able to perform any operation");
        Collections.addAll(numbers,9,2,7,1,6,3);
        System.out.println("Numbers are :" + " " + numbers);
        Collections.sort(numbers);
        System.out.println("Numbers are :" + " " + numbers);

        students.sort(Comparator.comparing((Student s) -> s.name)
                .thenComparing(s -> s.age)
                .thenComparing(s -> s.grade)
                .thenComparing(s-> s.height));
        students.forEach(System.out::println);

        Collections.sort(teachers);
        teachers.forEach(System.out::println);
    }

    public static void main(String[] args) {

    }

    static class Operation{
        int a;
        int b;

        public Operation() {
        }
        public int mathematicalOperation(int a,int b) {
            return 0;
        }
    }
}
