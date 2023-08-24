import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Word {

    private static final String[] STOP_WORDS = { "the", "and", "is", "of", "in", "a", "an", "to" };

    public static void main(String[] args) {
        String inputText;
        if (args.length > 0) {
            inputText = readFromFile(args[0]);
        } else {
            inputText = readFromConsole();
        }

        if (inputText.isEmpty()) {
            System.out.println("No text provided.");
            return;
        }

        String[] words = inputText.split("[\\s,.?!;:\"'()-]+");

        int wordCount = 0;
        Set<String> stopWordsSet = new HashSet<>(Arrays.asList(STOP_WORDS));

        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            if (!word.isEmpty()) {
                wordCount++;

                if (!stopWordsSet.contains(word)) {

                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        System.out.println("Total word count: " + wordCount);

        System.out.println("Number of unique words: " + wordFrequencyMap.size());

        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return content.toString();
    }

    private static String readFromConsole() {
        System.out.println("Enter your text (type 'done' in a new line to finish):");
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null && !line.equalsIgnoreCase("done")) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading input from console: " + e.getMessage());
        }
        return content.toString();
    }
}