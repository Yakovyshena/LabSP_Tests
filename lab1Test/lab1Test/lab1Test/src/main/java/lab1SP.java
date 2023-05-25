import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class lab1SP {
    public static void main(String[] args) throws IOException {
        try {
            List<String> lines = new ArrayList<>();
            lines = Files.readAllLines(Paths.get("Input.txt"));
            // Решта коду
            List<String> words = new ArrayList<>();

            int length = 0;
            int count = 0;
            for(String line : lines)
            {
                String[] parts = line.split( "[^a-zA-z'А-Яа-яіїє-]");
                for(String word : parts)
                {
                    if (word.length() > 30){
                        word = word.substring(0,29);
                    }
                    words.add(word);
                    if (word.contains("'") || word.contains("-")){
                        for (int i = 0; i < word.length(); i++) {
                            if (word.charAt(i) == '\'') {
                                count++;
                            }
                            if (word.charAt(i) == '-') {
                                count++;
                            }
                        }
                        if (length < word.length() - count) length = word.length() - count;
                        count = 0;
                    }
                    else {if (length < word.length()) length = word.length();}
                }
            }
            MaxWords(words, count, length);
        } catch (IOException e) {
              e.printStackTrace();
        }


    }

    public static List<String> MaxWords(List<String> words, int count, int length) {
            if (length < 0) {
                throw new IllegalArgumentException("MaxLength cannot be negative");
            }
            List<String> MaxWords = new ArrayList<>();
            for(String word : words)
            {
                if (word.contains("'") || word.contains("-")){
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == '\'') {
                            count++;
                        }
                        if (word.charAt(i) == '-') {
                            count++;
                        }
                    }
                    if (word.length() - count == length) {
                        System.out.println(word);
                        MaxWords.add(word);
                    }
                    count = 0;
                }
                else {
                    if (word.length() == length) {
                        System.out.println(word);
                        MaxWords.add(word);
                    }

                }
            }
            return MaxWords;
        }


}