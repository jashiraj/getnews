package in.freshnews.getnews.services;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//1. Write a Java program to calculate the average of a list of integers using streams
//2. Write a Java program to convert a list of strings to uppercase or lowercase using streams
//3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
//4. Write a Java program to remove all duplicate elements from a list using streams.
//5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.
//6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
//7. Write a Java program to find the maximum and minimum values in a list of integers using streams.
//8. Write a Java program to find the second smallest and largest elements in a list of integers using streams.
public class StreamsJava {
    public static void main(String[] args) {

        /*1    List<Integer> list = new ArrayList<>();
            list.add(2);
            list.add(4);
            list.add(6);
            list.add(7);
            list.add(8);

            double average = list.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
            System.out.println(average);

       2 List<String> list = new ArrayList<>();
        list.add("red");
        list.add("yellow");
        list.add("brown");
        list.add("pink");
        List<String> newList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(average);

       3 List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(8);
        int sumOfOdd = list.stream().filter(n->n%2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println(sumOfOdd);
        int sumOfEven = list.stream().filter(n->n%2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sumOfEven);

      4  List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(4);
        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);

      5  List<String> list = new ArrayList<>();
        list.add("red");
        list.add("yellow");
        list.add("rani");
        list.add("pink");
        long list1 = list.stream().filter(n->n.startsWith("r")).count();
        System.out.println(list1);

     6   List<String> list = new ArrayList<>();
        list.add("red");
        list.add("yellow");
        list.add("rani");
        list.add("pink");
        List list1 = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list1);
        List list2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list2);

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(4);
        int x = list.stream().max((a,b)->Integer.compare(a,b)).orElse(null);
        System.out.println(x);*/


    }
}
