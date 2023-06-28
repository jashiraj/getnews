package in.freshnews.getnews;

import java.util.Calendar;
import java.util.Scanner;

/*5. Write a Java program to compare two strings lexicographically.
Two strings are lexicographically equal if they are the same length and contain the same characters in the same positions.*/
class Word{
   public void comp(String str1,String str2){
       int result = str1.compareToIgnoreCase(str2);
       int result1 = str1.compareTo(str2);
       boolean r = str1.equals(str2);
       boolean result2 = str1.contentEquals(str2);
       boolean result3 = str1.equalsIgnoreCase(str2);

       System.out.println(result );
       System.out.println(result2);
       System.out.println(result3);
       System.out.println(r);


      /* if (result > 1) {
           System.out.println("string1 is greater than string2");
       } else if (result == 1) {
           System.out.println("both the strings are equal");
       }
       else {
           System.out.println("string1 is smaller than string2");
       }*/
   }
}
public class Demo5 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n", c, c, c);
        System.out.format("%tl:%tM %tp%n", c, c, c);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word1 ");
        String word1 = scanner.nextLine();
        System.out.println("Enter a word2");
        String word2 = scanner.nextLine();

        Word w = new Word();
        w.comp(word1,word2);

    }
}
