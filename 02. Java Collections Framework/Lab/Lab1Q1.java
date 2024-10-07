package Lab;
import java.util.LinkedList;
import java.util.ListIterator;

public class Lab1Q1 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Kay");
        names.add("Jay");
        names.add("May");
        names.add("Fay");
        System.out.println("My list of names: " + names);

        // using an iterator to insert "Ray" after "May"
        ListIterator<String> iterator = names.listIterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("May")) {
                iterator.add("Ray");
                break;
            }
        }
        System.out.println("My list of names after inserting 'Ray': " + names);

        // delete "Jay"
        names.remove("Jay");
        System.out.println("My list of names after deleting 'Jay': " + names);

        // Use an iterator to display all from the beginning
        System.out.println("Displaying names from the beginning of the list:");
        iterator = names.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // from the end
        System.out.println("Displaying names from the end of the list:");
        iterator = names.listIterator(names.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        // again addig Kay
        names.add("Kay");
        System.out.println("My list of names after adding Kay again: " + names);

        // Use an iterator to display all the names, dupl allowed
        System.out.println("All names:");
        iterator = names.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
