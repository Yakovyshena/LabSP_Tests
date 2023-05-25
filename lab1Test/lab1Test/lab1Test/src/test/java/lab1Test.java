import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class lab1Test {
    private List<String> lines;

    @BeforeEach
    public void setup() {
        lines = new ArrayList<>();
        lines.add("This is a test line");
        lines.add("Another line for testing purposes");
    }

//    @Test
//    public void testMaxWords_returnsListWithMaxLengthWords() {
//        List<String> expected = List.of();
//        List<String> actual = lab1SP.MaxWords(lines, 0, 0);
//        assertTrue(actual.containsAll(expected));
//
//    }

    @Test
    public void testMaxWords_returnsEmptyListWhenNoMaxLengthWordsFound() {
        List<String> actual = lab1SP.MaxWords(lines, 0, 100);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testMaxWords_doesNotContainWordsExceedingMaxAllowedLength() {
        List<String> actual = lab1SP.MaxWords(lines, 0, 4);
        assertTrue(actual.stream().allMatch(word -> word.length() <= 4));
    }

    @Test
    public void testMaxWords_throwsExceptionForNegativeMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            lab1SP.MaxWords(lines, 0, -5);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"wordone", "wordtwo", "wordthree"})
    public void testMaxWords_containsParameterizedWords(String word) {
        lines.add(word);
        List<String> actual = lab1SP.MaxWords(lines, 0, word.length());
        assertTrue(actual.contains(word));
    }
}
