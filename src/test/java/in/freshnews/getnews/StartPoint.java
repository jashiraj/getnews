package in.freshnews.getnews;


import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;

@Data
class Book{
    private String title;
    private String author;
    private int ISBN;
    public Book(String title , String author, int ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

/*    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN=" + ISBN +
                '}';
    }*/

   /* public void display(){
        System.out.println("my name is " + this.name + " and my age is " + this.age);
    }*/

  /*  public void setBase(int b) {
        this.base = b;
    }
    public void setHeight(int h) {
        this.height = h;
    }
    public int getBase(){
        return base;
    }
    public int getHeight(){
        return height;
    }
    public int area(){
        int area;
        area = height*base;
        return area;
    }
    public int perimeter(){
        int perimeter;
        perimeter = 2 * (height*base);
        return perimeter;
    }*/

}
public class StartPoint{
    public static void main(String[] args) {
        Book b1 =  new Book("aim", "vishal" , 123);
        Book b2 =  new Book("success", "Jassi" , 223);
        ArrayList<Book> bookCollection = new ArrayList<>();
        bookCollection.add(b1);
        bookCollection.add(b2);
        for(Book element : bookCollection){
            System.out.println(element);
        }
    }
}