package in.freshnews.getnews;

import java.util.ArrayList;

class Products{
    String productName;
    int quantity;

    public Products(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   @Override
    public String toString() {
        return "Products{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
class Inventory{

    ArrayList<Products> inventory = new ArrayList<>();
    public void addProduct(Products products){
        inventory.add(products);
    }
    public void removeProduct(Products products){
        inventory.remove(products);
    }

    public ArrayList<Products> getInventory() {
        return inventory;
    }
    public void checkInventory(){
        for(Products product : inventory){
            if(product.getQuantity()<100){
                System.out.println("the product " +product.getProductName() + " is running low on the inventory that is " +product.getQuantity());
            }
        }
    }
}
public class Demo3 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Products product1 = new Products("LED TV", 200);
        Products product2 = new Products("Mobile", 80);
        Products product3 = new Products("Tablet", 50);
        System.out.println("Add three products in inventory:");
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        for(Products product : inventory.getInventory()){
            System.out.println(product);
          // in this case no tostring:  System.out.println("Productname : "+product.getProductName()+ ", Quantity: "+product.getQuantity());
        }
        //or

        ArrayList<Products> myInventory = inventory.getInventory();
        System.out.println(myInventory);


        inventory.checkInventory();
    }
}
