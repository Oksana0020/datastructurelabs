package Lab5Solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lab5 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Oksana\\IdeaProjects\\MTUSep24DSC\\08. Profiling\\Lab5Solution\\words_alpha.txt"; // Adjust the path if necessary
        int[] sizes = {10, 100, 1000, 10000, 100000, 1000000}; // Sizes to test
        int reps = 500; // Reduced number of repetitions for larger sizes

        try {
            List<String> words = loadWords(filePath); // Load words from file
            for (int size : sizes) {
                // Create ArrayList and LinkedList with the specified size
                List<String> arrayList = new ArrayList<>(words.subList(0, size));
                List<String> linkedList = new LinkedList<>(words.subList(0, size));

                // Time the get() method for ArrayList
                long arrayListTime = timeGetMethod(arrayList, reps, size);
                // Time the get() method for LinkedList
                long linkedListTime = timeGetMethod(linkedList, reps, size);

                // Output the results
                System.out.printf("ArrayList get() method for size %d: %.4f ms%n", size, arrayListTime / 1_000_000.0);
                System.out.printf("LinkedList get() method for size %d: %.4f ms%n", size, linkedListTime / 1_000_000.0);
            }
        } catch (IOException e) {
            System.out.println("Error loading words: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static List<String> loadWords(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        }
        return words;
    }

    private static long timeGetMethod(List<String> list, int reps, int size) {
        long startTime = System.nanoTime();
        for (int i = 0; i < reps; i++) {
            for (int j = 0; j < size; j++) {
                list.get(j);
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime; // Return elapsed time in nanoseconds
    }
}
//ArrayList get() method for size 10: 0.2680 ms
//LinkedList get() method for size 10: 0.3906 ms
//ArrayList get() method for size 100: 1.4231 ms
//LinkedList get() method for size 100: 2.4660 ms
//ArrayList get() method for size 1000: 2.1752 ms
//LinkedList get() method for size 1000: 133.1777 ms
//ArrayList get() method for size 10000: 15.2957 ms
//LinkedList get() method for size 10000: 14670.7043 ms
//no outputs for 100000, waited for a while