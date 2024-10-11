package Lab;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Lab1Q3 {
    public static void main(String[] args) {
        try {
            // Using absolute path worked perfect
            File file = new File("C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\02. Java Collections Framework\\Lab\\hamlet.txt");

            // Using relative path -both didn't work, though file in root directory
            // File file = new File("src/main/resources/hamlet.txt");
            // File file = new File("hamlet.txt");

            TreeSet<String> uniqueWords = new TreeSet<>();

            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                uniqueWords.add(word.toLowerCase()); // converting to lowercase
            }
            scanner.close();

            System.out.println("Unique words:");
            Iterator<String> iterator = uniqueWords.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            System.out.println("Number of unique words in Hamlet: " + uniqueWords.size());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}