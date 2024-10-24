package Lab5Solution;

import javax.swing.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SprobaAlice {
    public static void main(String[] args) {
        try {
            // Read the document words
            Set<String> documentWords = readWords("C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\08. Profiling\\Lab5Solution\\war-and-peace.txt");

            // Profile contains() method for different collections
            profileContainsMethod();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private static void profileContainsMethod() {
        try {
            // Read the dictionary words into different collections
            Collection<String> linkedListWords = readDictionary("C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\08. Profiling\\Lab5Solution\\words.txt", new LinkedList<>());
            System.out.println("Size of LinkedList: " + linkedListWords.size());

            Collection<String> arrayListWords = readDictionary("C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\08. Profiling\\Lab5Solution\\words.txt", new ArrayList<>());
            System.out.println("Size of ArrayList: " + arrayListWords.size());

            Collection<String> hashSetWords = readDictionary("C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\08. Profiling\\Lab5Solution\\words.txt", new HashSet<>());
            System.out.println("Size of HashSet: " + hashSetWords.size());

            Collection<String> treeSetWords = readDictionary("C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\08. Profiling\\Lab5Solution\\words.txt", new TreeSet<>());
            System.out.println("Size of TreeSet: " + treeSetWords.size());

            // Profile each collection
            profileCollection(linkedListWords, "LinkedList");
            profileCollection(arrayListWords, "ArrayList");
            profileCollection(hashSetWords, "HashSet");
            profileCollection(treeSetWords, "TreeSet");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private static void profileCollection(Collection<String> dictionaryWords, String collectionName) {
        try {
            Set<String> documentWords = readWords("C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\08. Profiling\\Lab5Solution\\war-and-peace.txt");

            long startTime = System.nanoTime();
            int numberMisspeltWords = 0;

            for (String word : documentWords) {
                if (!dictionaryWords.contains(word)) {
                    numberMisspeltWords++;
                }
            }

            long endTime = System.nanoTime();
            long duration = endTime - startTime; // Duration in nanoseconds

            System.out.println("Collection: " + collectionName);
            System.out.println("Number of misspelt words: " + numberMisspeltWords);
            //System.out.println("Time taken (ms): " + duration / 1_000_000.0);
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private static Collection<String> readDictionary(String filename, Collection<String> words) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

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