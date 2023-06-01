import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class testMockito {
    @Mock
    private List<String> mockList;

    @Spy
    private List<String> spyList = new ArrayList<>();

    @InjectMocks
    private LabSP labSP;
    
    @Test
    public void testMockObjectInvocation() {
        // Arrange
        when(mockList.size()).thenReturn(10);

        // Act
        int result = mockList.size();

        // Assert
        Assert.assertEquals(10, result);
        verify(mockList).size();
    }

    @Test
    public void testSpyObjectInvocation() {
        // Arrange
        spyList.add("Hello");

        // Act
        int size = spyList.size();
        String element = spyList.get(0);

        // Assert
        Assert.assertEquals(1, size);
        Assert.assertEquals("Hello", element);
        verify(spyList).add("Hello");
        verify(spyList).size();
        verify(spyList).get(0);
    }

    @Mock
    private List<String> mockedLines;

    @Test(expected = IOException.class)
    public void testExceptionHandling() throws IOException {
        // Arrange
        when(labSP.readLinesFromFile("Input.txt")).thenReturn(mockedLines);
        when(mockedLines.isEmpty()).thenThrow(new IOException());

        // Act
        labSP.main(new String[]{});
    }

//    @Test
//    public void testPrintMaxWords() {
//        // Arrange
//        List<String> maxWords = Arrays.asList("This", "is", "a", "test");
//
//        // Act
//        labSP.printMaxWords(maxWords);
//
//        // Assert
//        String expectedOutput = "This\nis\na\ntest\n";
//        Assert.assertEquals(expectedOutput, outputStream.toString());
//    }
    @Test
    public void testExtractWords() {
        // Підготовка тестових даних
        List<String> lines = Arrays.asList("Hello, world!", "This is a test.");

        // Виклик методу extractWords з тестовими даними
        List<String> result = LabSP.extractWords(lines);

        // Перевірка результатів
        List<String> expectedWords = Arrays.asList("Hello", "world", "This", "is", "a", "test");
        Assert.assertEquals(expectedWords, result);
    }

    @Test
    public void testFindMaxLength() {
        // Підготовка тестових даних
        List<String> words = Arrays.asList("word1", "word2", "longword", "word3");

        // Виклик методу findMaxLength
        int result = LabSP.findMaxLength(words);

        // Перевірка результатів
        Assert.assertEquals(8, result);
    }

    @Test
    public void testFilterWordsByLength() {
        // Підготовка тестових даних
        List<String> words = Arrays.asList("word1", "word2", "longword", "word3");
        int length = 8;

        // Виклик методу filterWordsByLength
        List<String> result = LabSP.filterWordsByLength(words, length);

        // Перевірка результатів
        List<String> expected = List.of("longword");
        Assert.assertEquals(expected, result);
    }
}