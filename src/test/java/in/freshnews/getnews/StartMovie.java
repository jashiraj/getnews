package in.freshnews.getnews;
//17. Write a Java program to create a class called "Movie" with attributes for title, director, actors, and reviews,
// and methods for adding and retrieving reviews.

import java.util.ArrayList;

class Movie{
    String title;
    String director;
    String actorName;
    ArrayList<String> reviews ;


    public Movie(String title, String director, String actorName) {
        this.title = title;
        this.director = director;
        this.actorName = actorName;
        this.reviews = new ArrayList<String>();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    public void addReviews(String r){
        reviews.add(r);
    }
    public ArrayList<String> getReviews(){
        return reviews;
    }
    public String displayMovieInformation(){
        return "movie name: " +getTitle()+" ,director name: " +getDirector()+" ,actor: " +getActorName()+ " ,reviews:" +getReviews();
    }


  /*  @Override
    public String toString() {
        return "Movie{" +
                "reviews=" + reviews +
                '}';
    }*/
}

public class StartMovie {
    public static void main(String[] args) {
        Movie movie1 = new Movie("hum aapke hain kaun", "yash chopra", "salman khan");
        movie1.addReviews("critics1 : awesome movie");
        movie1.addReviews("critics2 : average movie");
        Movie movie2 = new Movie("agnipath", "mahesh bhatt", "Amitabh Bhachan");
        movie2.addReviews("critics1 : superb movie");
        movie2.addReviews("critics2 : not so good movie");
        System.out.println( movie1.displayMovieInformation());
        System.out.println(movie2.displayMovieInformation());

       /* ArrayList<String> myMovie1 = movie1.getReviews();
        System.out.println(movie1);
        ArrayList<String> myMovie2 = movie1.getReviews();
        System.out.println(myMovie2);*/

    }
}
