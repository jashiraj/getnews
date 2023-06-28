package in.freshnews.getnews;
import java.util.Random;


//19. Write a Java program to create a class with methods to search for flights and hotels, and to book and cancel reservations.

import java.util.ArrayList;

class Flight {
    private int flightNumber;
    private String passengerName;
    private String origin;
    private String destination;
    private String date;
    private int numPassengers;
    private double price;
    private int confirmationNumber;

    public Flight(int flightNumber, String passengerName, String origin, String destination, String date, int numPassengers, double price) {
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.numPassengers = numPassengers;
        this.price = price;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public double getPrice() {
        return price;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}

class Hotel {
    private int hotelId;
    private String name;
    private String location;
    private String checkIn;
    private String checkOut;
    private int numGuests;
    private double price;
    private int confirmationNumber;

    public Hotel(int hotelId, String name, String location, String checkIn, String checkOut, int numGuests, double price) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numGuests = numGuests;
        this.price = price;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public double getPrice() {
        return price;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}

class Booking {
    ArrayList<Flight> flights = new ArrayList<>();
    ArrayList<Hotel> hotels = new ArrayList<>();

    public void searchFlights( String origin, String destination, String date, int numPassengers){
        System.out.println("searching flight from  " +origin + "to " + destination +"for " +date  +"for "+numPassengers +" passengers");
    }
    public void searchHotels(String location, String checkIn, String checkOut, int numGuests){
        System.out.println("searching hotels for " +location + "from "+checkIn + "to " +checkOut +"for "+numGuests +" guest");
    }
    public void bookFlight(Flight flight) {
        int confirmationNumber = generateConfirmationNumber();
        flights.add(flight);
        System.out.println("Flight booked! Confirmation number: " + confirmationNumber);
    }
    public void bookHotel(Hotel hotel) {
        int confirmationNumber = generateConfirmationNumber();
        hotels.add(hotel);
        System.out.println("Hotel booked! Confirmation number: " + confirmationNumber);
    }


    private int generateConfirmationNumber() {
        // Generate a random 6-digit confirmation number
        Random rand = new Random();
        return rand.nextInt(900000) + 100000;
    }
}

public class MyApp {
    public static void main(String[] args) {
        Booking app = new Booking();
        Flight flight1 = new Flight(12345670, "Martin Nadine", "New York", "London", "2022-08-01", 1, 700.00);
        Flight flight2 = new Flight(67843513, "Jennifer Ulrike", "New York", "London", "2022-08-01", 1, 655.00);
        Hotel hotel1 = new Hotel(98765432, "Martin Nadine", "London", "2022-09-01", "2022-09-05", 1, 100.00);
        app.searchFlights("New York", "London", "2022-09-01", 1);
        app.searchHotels("London", "2022-08-01", "2022-09-05", 2);
        app.bookFlight(flight1);
        app.bookFlight(flight2);
        app.bookHotel(hotel1);
    }
}
