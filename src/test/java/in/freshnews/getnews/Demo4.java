package in.freshnews.getnews;

/*5. Write a Java program to create a class called Circle with a private instance variable radius. Provide public getter and setter methods to access and modify the radius variable.
However, provide two methods called calculateArea() and calculatePerimeter() that return the calculated area and perimeter based on the current radius value.
 */
class Circle{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double calculateArea(){
        return Math.PI*this.radius *this.radius ;
        // or return Math.PI*radius*radius ;
    }
}
public class Demo4{
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(4);
        System.out.println(circle.calculateArea());

    }
}