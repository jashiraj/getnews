package in.freshnews.getnews;
//1. Write a Java program to implement a lambda expression to find the sum of two integers.

@FunctionalInterface
interface Add{
    int sum(int a , int b);

}
/*class MyClass implements Add{

    @Override
    public int sum(int a, int b) {
     return (a+b);
    }
}*/
public class LambadaImplementation {
    public static void main(String[] args) {
        Add add = (a, b) -> a + b;
        System.out.println( add.sum(5, 6));
    }
}
