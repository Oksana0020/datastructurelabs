package Lab;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Lab1Q2 {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        // adding names to the set
        hashSet.add("Kay");
        hashSet.add("Jay");
        hashSet.add("May");
        hashSet.add("Fay");
        hashSet.add("May");

        System.out.println("HashSet: " + hashSet);

        // use iterator to display the names in the set
        System.out.println("Names in HashSet:");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<String> treeSet = new TreeSet<>();

        // Add names to the set
        treeSet.add("Kay");
        treeSet.add("Jay");
        treeSet.add("May");
        treeSet.add("Fay");
        treeSet.add("May");

        System.out.println("TreeSet: " + treeSet);

        // display the names
        System.out.println("Names in TreeSet:");
        iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
//The difference between two
//HashSet  - names in random order, duplicates not allowed
//TreeSet - names in alphabetical order, duplicates not allowed
