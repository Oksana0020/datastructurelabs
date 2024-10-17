// CandyShop.java
package CandyLand;

import java.util.ArrayList;
import java.util.List;

public class CandyShop {
    private List<Candy> inventory;

    public CandyShop() {
        inventory = new ArrayList<>();
        // Adding some candies to the inventory
        inventory.add(new Candy("Chocolate Chip Cake", 1.99));
        inventory.add(new Candy("Apple Tart", 0.99));
        inventory.add(new Candy("Napoleon Cake", 2.49));
    }

    public void displayInventory() {
        System.out.println("Available sweets:");
        for (Candy candy : inventory) {
            System.out.println(candy);
        }
    }

    public void addCandy(String name, double price) {
        inventory.add(new Candy(name, price));
    }

    public double calculateTotalCost(List<String> selectedCandies) {
        double total = 0;
        for (String candyName : selectedCandies) {
            for (Candy candy : inventory) {
                if (candy.getName().equalsIgnoreCase(candyName)) {
                    total += candy.getPrice();
                    break;
                }
            }
        }
        return total;
    }
}
