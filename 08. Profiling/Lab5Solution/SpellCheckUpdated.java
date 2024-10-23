package Lab5Solution;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
 */
public class SpellCheckUpdated {
    public static void main(String[] args) {
        String documentPath = "C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\08. Profiling\\Lab5Solution\\war-and-peace.txt";
        String dictionaryPath = "C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\08. Profiling\\Lab5Solution\\dictionary.txt";

        String[] collectionTypes = {"HashSet", "TreeSet", "ArrayList", "LinkedList"};

        for (String collectionType : collectionTypes) {
            try {
                // Read the dictionary words into a collection
                Collection<String> dictionaryWords = loadDictionary(dictionaryPath, collectionType);

                // Read the document words into a set
                Set<String> documentWords = readWords(documentPath);

                // Check for misspelled words
                int numberMisspelledWords = 0;
                long startTime = System.nanoTime(); // Start time for performance measurement
                for (String word : documentWords) {
                    if (!dictionaryWords.contains(word)) {
                        numberMisspelledWords++;
                        // Uncomment the following line to print misspelled words
                        // System.out.println(word);
                    }
                }
                long endTime = System.nanoTime(); // End time for performance
                long duration = endTime - startTime; // Duration in nanoseconds

                // Output results
                System.out.println("Collection type: " + collectionType);
                System.out.println("Number of misspelled words: " + numberMisspelledWords);
                System.out.println("Time taken (nanoseconds): " + duration);
                System.out.println("----------");

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
    }

    /**
     * Loads dictionary words into the specified collection type.
     */
    private static Collection<String> loadDictionary(String filename, String collectionType) throws FileNotFoundException {
        Collection<String> words;

        // Switch between different collection types
        switch (collectionType) {
            case "HashSet":
                words = new HashSet<>(); // O(1) average time complexity for contains()
                break;
            case "TreeSet":
                words = new TreeSet<>(); // O(log n) time complexity for contains()
                break;
            case "ArrayList":
                words = new ArrayList<>(); // O(n) time complexity for contains()
                break;
            case "LinkedList":
                words = new LinkedList<>(); // O(n) time complexity for contains()
                break;
            default:
                throw new IllegalArgumentException("Unknown collection type: " + collectionType);
        }

        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file.
     */
    public static Set<String> readWords(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }
}

