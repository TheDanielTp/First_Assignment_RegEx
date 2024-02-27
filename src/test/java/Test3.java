import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Test3 {

    static Exercise3 handle;

    @BeforeAll
    static void setup() {
        handle = new Exercise3();
    }

    @Test
    void findWordsWithRepeatLettersTest1() {
        String text = "apple orange pear pineapple banana";
        List<String> expected = List.of("apple", "pineapple", "banana");
        List<String> result = handle.findWordsWithRepeatLetters(text);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void findWordsWithRepeatLettersTest2() {
        String text = "no words with repeat letters in this text";
        List<String> expected = List.of("repeat", "letters", "text");
        List<String> result = handle.findWordsWithRepeatLetters(text);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void findWordsWithRepeatLettersTest3() {
        String text = "apple apple orange orange";
        List<String> expected = List.of("apple", "apple");
        List<String> result = handle.findWordsWithRepeatLetters(text);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void findWordsWithRepeatLettersTest4() {
        String text = "word with repeat letters hello";
        List<String> expected = List.of("repeat", "letters", "hello");
        List<String> result = handle.findWordsWithRepeatLetters(text);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }
}
