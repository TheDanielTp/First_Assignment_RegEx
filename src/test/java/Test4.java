import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Test4 {

    static Exercise3 handle;

    @BeforeAll
    static void setup() {
        handle = new Exercise3();
    }

    @Test
    void findRepeatedWords_shouldReturnRepeatedWords() {
        String input = "appleapple orange pearpear pineapple";
        List<String> expectedOutput = Arrays.asList("appleapple", "pearpear");

        List<String> actualOutput = handle.findRepeatedWords(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void findRepeatedWords_shouldReturnEmptyListForNoRepeatedWords() {
        String input = "apple orange pear pineapple";
        List<String> expectedOutput = Arrays.asList();

        List<String> actualOutput = handle.findRepeatedWords(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void findRepeatedWords() {
        String input = "haha you are so funny";
        List<String> expectedOutput = List.of("haha");

        List<String> actualOutput = handle.findRepeatedWords(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void findRepeatedWords_shouldReturnEmptyListForEmptyInput() {
        String input = "";
        List<String> expectedOutput = Arrays.asList();

        List<String> actualOutput = handle.findRepeatedWords(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
