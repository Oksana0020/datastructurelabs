package Lab;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class Lab1Q4Test {

    @Test
    public void testMain() {
        // testing that the main method does not throw any exceptions
        Lab1Q4.main(new String[0]);
    }

    @Test
    public void testWordLineMap_EmptyFile() throws FileNotFoundException {
        // testing the wordLineMap is empty for an empty file
        File file = new File("empty.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                fail("Failed to create empty file for testing.");
            }
        }

        Map<String, TreeSet<Integer>> wordLineMap = getWordLineMap(file);
        assertNotNull(wordLineMap);
        assertEquals(0, wordLineMap.size());
    }

    @Test
    public void testSearchWord() {
        // Testing that the search word is correctly found
        File file = new File("C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\02. Java Collections Framework\\Lab\\hamlet.txt");
        try {
            Map<String, TreeSet<Integer>> wordLineMap = getWordLineMap(file);
            String searchWord = "fortune";
            assertTrue(wordLineMap.containsKey(searchWord));
        } catch (FileNotFoundException e) {
            fail("FileNotFoundException was thrown");
        }
    }


    @Test(expected = FileNotFoundException.class)
    public void testWordLineMap_FileNotFound() throws FileNotFoundException {
        // Test that the wordLineMap throws a FileNotFoundException for a non-existent file
        File file = new File("non-existent.txt");
        getWordLineMap(file);
    }

    private Map<String, TreeSet<Integer>> getWordLineMap(File file) throws FileNotFoundException {
        Map<String, TreeSet<Integer>> wordLineMap = new TreeMap<>();
        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                String[] words = line.split("\\W+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (!word.isEmpty()) {
                        wordLineMap.putIfAbsent(word, new TreeSet<>());
                        wordLineMap.get(word).add(lineNumber);
                    }
                }
            }
        }
        return wordLineMap;
    }
    //ran with coverage 100%
}