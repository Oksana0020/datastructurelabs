package Lab;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MyLinkedList {
    public static void main(String[] args) {
        List<String> sweets = new LinkedList<>();

        // Add cakes to my list
        sweets.add("Chocolate cake");
        sweets.add("Red velvet cake");
        sweets.add("Vanilla cake");
        sweets.add("Red velvet cake");
        sweets.add("Carrot cake");
        sweets.add("Croissants");
        sweets.add("Muffins");
        sweets.add("Scones");
        sweets.add("Croissants");
        sweets.add("Red velvet cake");

        System.out.println("List of Sweets:");
        for (String sweet : sweets) {
            System.out.println(sweet);
            //printing out list of sweets
        }

        // try remove duplicates Croissants using a Set
        Set<String> uniqueSweets = new LinkedHashSet<>(sweets);
        System.out.println("\nMy unique List of Sweets:");
        for (String sweet : uniqueSweets) {
            System.out.println(sweet);
        }

        // here converting the set back to a List
        List<String> uniqueSweetsList = new LinkedList<>(uniqueSweets);
        System.out.println("\nUnique List of Sweets (as a List):");
        for (String sweet : uniqueSweetsList) {
            System.out.println(sweet);
        }
    }
}
