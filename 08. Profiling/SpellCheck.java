/*****************************************************
 * Title: SpellCheck source code
 * Author: Horstmann
 * Site owner/sponsor: Wiley
 * Date:
 * Code version: edited October 9th 2023
 * Availability: Instructor Companion Site (online) to Big Java: Late Objects,
 * 1st Edition (Wiley) (Accessed 9th October 2023)
 * Modified:
 * Collection used instead of Set for dictionaryWords to allow us to experiment
 * with different collections.
 *****************************************************/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
 */
public class SpellCheck {
    public static void main(String[] args) {
        String documentPath = "C:\\Users\\Oksana\\Documents\\war-and-peace.txt";
        String dictionaryPath = "C:\\Users\\Oksana\\Documents\\dictionary.txt";

        try {
            // Read the dictionary words into a collection
            Collection<String> dictionaryWords = readDictionary(dictionaryPath);
            // Read the document words into a set
            Set<String> documentWords = readWords(documentPath);

            // Print all words that are in the document but not in the dictionary
            int numberMisspelledWords = 0;
            for (String word : documentWords) {
                if (!dictionaryWords.contains(word)) {
                    numberMisspelledWords++;
                    // Uncomment the following line to print misspelled words
                    // System.out.println(word);
                }
            }
            System.out.println("Number of misspelled words: " + numberMisspelledWords);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static Collection<String> readDictionary(String filename) throws FileNotFoundException {
        Collection<String> words = new LinkedList<>();
        Scanner in = new Scanner(new File(filename));
        // Use any characters other than a-z or A-Z as delimiters
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
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
     */
    public static Set<String> readWords(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        // Use any characters other than a-z or A-Z as delimiters
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }
}