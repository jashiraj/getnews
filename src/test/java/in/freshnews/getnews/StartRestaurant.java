package in.freshnews.getnews;

import lombok.Getter;

import java.util.ArrayList;

//18. Write a Java program to create a class called "Restaurant" with attributes for menu items, prices,
      //  and ratings,and methods to add and remove items, and to calculate average rating.
class FoodItems{
        String itemName;
        double price;
        int rating;


        public FoodItems(String itemName, double price, int rating) {
                this.itemName = itemName;
                this.price = price;
                this.rating = rating;
        }

        public String getItemName() {
                return itemName;
        }

        public void setItemName(String itemName) {
                this.itemName = itemName;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public int getRating() {
                return rating;
        }

        public void setRating(int rating) {
                this.rating = rating;
        }

        @Override
        public String toString() {
                return "FoodItems{" +
                        "itemName='" + itemName + '\'' +
                        ", price=" + price +
                        ", rating=" + rating +
                        '}';
        }
}

class Restaurant{

        String restaurantName;
        double overallRatings;
        ArrayList<FoodItems> menuCard ;

        public Restaurant(String restaurantName){
                this.restaurantName = restaurantName;
                this.menuCard = new ArrayList<>();
        }
        public double getOverallRatings() {
                return overallRatings;
        }
       /*public void addItems(String itemName, double price, int rating){
                FoodItems foodItems = new FoodItems(itemName, price, rating);
                menuCard.add(foodItems);
        } or */

        public void addItems(FoodItems item){
                menuCard.add(item);
                this.overallRatings = saveOverallRating(menuCard);
        }

        private double saveOverallRating(ArrayList<FoodItems> menuCard) {
                double a = 0;
                for(FoodItems element : menuCard){

                        double b = a + element.getRating();
                        a = b;
                }
                return a / menuCard.size();

        }

        public void removeItems(FoodItems item){
                menuCard.remove(item);
                this.overallRatings = saveOverallRating(menuCard);
        }
        public int calculateRatings(){
                int a= 0;
                for(FoodItems element : menuCard){

                     int b = a + element.getRating();
                     a = b;
                }
                return a / menuCard.size();
        }
}

public class StartRestaurant {
        public static void main(String[] args) {
                Restaurant restaurant = new Restaurant("kaveri");
                FoodItems foodItems1 = new FoodItems("paneer chilli", 12.0, 4);
                FoodItems foodItems2 = new FoodItems("mushroom chilli", 12.0, 5);
                FoodItems foodItems3 = new FoodItems("gobhi chilli", 12.0, 3);
                restaurant.addItems(foodItems1);
                restaurant.addItems(foodItems2);
                restaurant.addItems(foodItems3);
                System.out.println(restaurant.getOverallRatings());
        }
}
