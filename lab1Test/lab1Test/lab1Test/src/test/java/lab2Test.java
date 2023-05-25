import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lab2Test {
    private List<String> lines;
    private List<String> words;

    @BeforeClass
    public void setup() throws IOException {
        lines = Files.readAllLines(Paths.get("Input.txt"));
    }

    @BeforeMethod
    public void resetWords() {
        words = new ArrayList<>();
    }

    @Test
    public void testMaxWordsWithMaxLength() {
        // Arrange
        words.add("word1");
        words.add("word2");

        // Act
        List<String> result = lab1SP.MaxWords(words, 0, 5);

        // Assert
        Assert.assertEquals(result.size(), 2);
        Assert.assertTrue(result.contains("word1"));
        Assert.assertTrue(result.contains("word2"));
    }

    @Test
    public void testMaxWordsWithNegativeMaxLength() {
        // Arrange
        words.add("word1");
        words.add("word2");

        // Act & Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            lab1SP.MaxWords(words, 0, -1);
        });
    }

    @DataProvider(name = "wordDataProvider")
    public Iterator<Object[]> wordDataProvider() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"longword", 8});
        data.add(new Object[]{"anotherword", 11});
        return data.iterator();
    }

    @Test(dataProvider = "wordDataProvider")
    public void testMaxWordsWithDataProvided(String word, int expectedLength) {
        // Arrange
        words.add(word);

        // Act
        List<String> result = lab1SP.MaxWords(words, 0, expectedLength);

        // Assert
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0), word);
    }

}
