package in.freshnews.getnews;

import java.util.ArrayList;

class Book1{
    String bookName;
    String bookAuthor;

    public Book1(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "Book1{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
}
class Library{
   ArrayList<Book1> bookCollection = new ArrayList<>();
    public void addBook(Book1 book) {
        bookCollection.add(book);
    }
    public void removeAccount(Book1 book) {
        bookCollection.remove(book);
    }
    public ArrayList < Book1 > getBookCollection() {
        return bookCollection;
    }


}
public class Demo2 {

    public static void main(String[] args) {

        Book1 b1 = new Book1("modern physics" , "HC Verma");
        Book1 b2 = new Book1("chemistry NCERT" , "vvhgh");
        Book1 b3 = new Book1("advance maths" , "bbjhg");
         /* Library library = new Library();
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
       ArrayList<Book1> myCollection = library.getBookCollection();
        System.out.println(myCollection);
        output: [Book1{bookName='modern physics', bookAuthor='HC Verma'}, Book1{bookName='chemistry NCERT', bookAuthor='vvhgh'}, Book1{bookName='advance maths', bookAuthor='bbjhg'}]*/

        ArrayList<Book1> myCollection1 = new ArrayList<>();
        myCollection1.add(b1);
        myCollection1.add(b2);
        myCollection1.add(b3);

        for(Book1 element : myCollection1){
            System.out.println(element);
        }
    }
}
