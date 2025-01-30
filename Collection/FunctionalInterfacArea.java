package Collection;

import Collection.AreaInterface;

public class FunctionalInterfacArea {
     public static void main(String[] args){

          AreaInterface squareArea = (dimensions) -> dimensions[0] * dimensions[0];


         AreaInterface rectangleArea = (dimensions) -> dimensions[0] * dimensions[1];


          AreaInterface triangleArea = (dimensions) ->  (dimensions[0] * dimensions[1])/2;

          AreaInterface circleArea = (dimensions) -> 3.14 * dimensions[0];


          FunctionalInterfacArea calculator = new FunctionalInterfacArea();

          double squareSide = 5.0;
          double squareAreaResult = squareArea.calculate(squareSide);
          System.out.println("Area of the square: " + squareAreaResult);

          double rectangleLength = 10.0;
          double rectangleWidth = 4.0;
          double rectangleAreaResult = rectangleArea.calculate(rectangleLength, rectangleWidth);
          System.out.println("Area of the rectangle: " + rectangleAreaResult);

          double triangleBase = 8.0;
          double triangleHeight = 6.0;
          double triangleAreaResult = triangleArea.calculate(triangleBase, triangleHeight);
          System.out.println("Area of the triangle: " + triangleAreaResult);

          double circleSide = 5.0;
          double circleAreaResult = circleArea.calculate(circleSide);
          System.out.println("Area of the circle: " + circleAreaResult);


     }
}