// Main.java
package CandyLand;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CandyShop shop = new CandyShop();
        shop.displayInventory();

        // customer buying some sweets
        double totalCost = shop.calculateTotalCost(Arrays.asList("Chocolate Chip Cake", "Apple Tart"));
        System.out.println("\nTotal cost of selected candies: $" + totalCost);

        // Adding a new cake to the shop
        shop.addCandy("Red Velvet Cake", 1.29);
        System.out.println("\nUpdated Inventory:");
        shop.displayInventory();
    }
}
