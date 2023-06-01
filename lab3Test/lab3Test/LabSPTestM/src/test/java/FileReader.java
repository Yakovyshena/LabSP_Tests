//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class FileReader {
//    private String filePath;
//
//    public FileReader(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public List<String> readLines() throws IOException {
//        return Files.readAllLines(Paths.get(filePath));
//    }
//    public List<String> readLines(String filename) {
//        List<String> words = new ArrayList<>();
//        for (String line : lines) {
//            String[] parts = line.split("\\P{L}+");
//            for (String word : parts) {
//                if (word.length() > 30) {
//                    word = word.substring(0, 30);
//                }
//                if (!word.isEmpty()) {
//                    words.add(word);
//                }
//            }
//        }
//        return words;
//    }
//
//}
