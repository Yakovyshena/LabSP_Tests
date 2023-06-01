import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LabSP {
    private static PrintStream output = System.out;

    // ...

    public static void printMaxWords(List<String> maxWords) {
        for (String word : maxWords) {
            output.println(word);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            List<String> lines = readLinesFromFile("Input.txt");
            List<String> words = extractWords(lines);
            int maxLength = findMaxLength(words);
            List<String> maxWords = filterWordsByLength(words, maxLength);
            printMaxWords(maxWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readLinesFromFile(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename));
    }

    public static List<String> extractWords(List<String> lines) {
        List<String> words = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split("\\P{L}+");
            for (String word : parts) {
                if (word.length() > 30) {
                    word = word.substring(0, 30);
                }
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }
        return words;
    }


    public static int findMaxLength(List<String> words) {
        int maxLength = 0;
        for (String word : words) {
            int length = word.length();
            if (word.contains("'") || word.contains("-")) {
                length -= countOccurrences(word, '\'') + countOccurrences(word, '-');
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static int countOccurrences(String word, char ch) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static List<String> filterWordsByLength(List<String> words, int length) {
        if (length < 0) {
            throw new IllegalArgumentException("MaxLength cannot be negative");
        }
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            int wordLength = word.length();
            if (word.contains("'") || word.contains("-")) {
                wordLength -= countOccurrences(word, '\'') + countOccurrences(word, '-');
            }
            if (wordLength == length) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }

//    public static void printMaxWords(List<String> maxWords) {
//        for (String word : maxWords) {
//            System.out.println(word);
//        }
//    }

}
