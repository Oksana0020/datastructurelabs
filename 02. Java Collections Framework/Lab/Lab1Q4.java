package Lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab1Q4 {
    public static void main(String[] args) {
        try {
            // absolute path to the Hamlet
            File file = new File("C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\02. Java Collections Framework\\Lab\\hamlet.txt");

            // using a Map to store words as keys and TreeSet of line numbers - values
            Map<String, TreeSet<Integer>> wordLineMap = new TreeMap<>();

            Scanner scanner = new Scanner(file);
            int lineNumber = 0;
            // tracking the current line number

            // read the file line by line
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                String[] words = line.split("\\W+"); // splitesd the line into words

                // Adding each word and the current line number to the Map
                for (String word : words) {
                    word = word.toLowerCase(); // to lowercase
                    if (!word.isEmpty()) {
                        wordLineMap.putIfAbsent(word, new TreeSet<>()); // Adding word if not present
                        //wordLineMap.put(word, lineNumber);
                        //use putIfAbsent instead to fix mistake
                        wordLineMap.get(word).add(lineNumber);
                    }
                }
            }
            scanner.close();

            // Display the words,the line numbers where we find them
            for (Map.Entry<String, TreeSet<Integer>> entry : wordLineMap.entrySet()) {
                System.out.println("Word: '" + entry.getKey() + "' occurs on lines: " + entry.getValue());
            }
            //System.out.println("Word: " + word + ", Line Number: " + lineNumber);
            //System.out.println("Map: " + wordLineMap);
            //number of unique words
            System.out.println("Number of unique words in Hamlet: " + wordLineMap.size());
            // a search for "fortune" word in the map
            String searchWord = "fortune";
            if (wordLineMap.containsKey(searchWord)) {
                System.out.println("The word '" + searchWord + "' appears on lines: " + wordLineMap.get(searchWord));
            } else {
                System.out.println("The word '" + searchWord + "' was not found.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}