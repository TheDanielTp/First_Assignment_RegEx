import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    /*
    the method that extracts a URL from a string
    */

    public static String extractURL(String text) {
        //regex defined such that it matches with any string that has HTTPS:// and the rest of the string
        String regex = "https?://\\S+"; //the s? checks if 's' is repeated zero or one time and then \\S matches any non-space characters and + means it matches one or more characters

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(); //returns the part which matched the matcher
        }
        else {
            return null;
        }
    }

    /*
    the method to validate an email address
    */

    public static boolean validateEmail(String email) {
        //regex defined such that it starts from the beginning of the string and search for any allowed character, then for zero or more of any allowed characters
        //then for an @ sign, and then again for one or more of any allowed characters. then for one or more "dot", and then for any english letter
        String regex = "^[a-zA-Z0-9_+.&*-]+(?:\\.[a-zA-Z0-9_+.&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            return true;
        }
        else {
            return false;
        }
    }

    /*
    function that checks if a word has repeated letters
    */

    public static boolean hasRepeatedLetters(String word) {
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i); //starts from the first letter and continues

            for (int j = 0; j < word.length(); j++) {
                if (currentChar == word.charAt(j) && i != j) { //checks every other letter to see if they match
                    return true;
                }
            }
        }
        return false;
    }

    /*
    the method that returns a list of words with repeated letters
    */

    public static List<String> findWordsWithRepeatLetters(String input) {
        List<String> wordsWithRepeatLetters = new ArrayList<>();
        String[] words = input.split("\\s+"); //splits the string into separate words

        for (String word : words) {
            if (hasRepeatedLetters(word)) { //calling the function and if true, adding the word into the list
                wordsWithRepeatLetters.add(word);
            }
        }

        return wordsWithRepeatLetters;
    }

    /*
    the method that returns a list of words that are repeated twice accidentally in a string
    */

    public static List<String> findRepeatedWords(String input) {
        List<String> repeatedWords = new ArrayList<>();

        //expression pattern to match repeated words
        Pattern pattern = Pattern.compile("\\b(\\w+)\\1\\b"); //checks word boundary then any word character and then an exact reference to the previous word
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            repeatedWords.add(matcher.group()); //add the matched word to the list of repeated words
        }

        return repeatedWords;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //testing extractURL function
        String inputURL = input.nextLine();
        String URL = extractURL(inputURL);
        System.out.println(URL);

        //testing validateEmail function
        String inputEmail = input.nextLine();
        Boolean validate = validateEmail(inputEmail);
        System.out.println(validate);

        //testing findWordsWithRepeatLetters function
        String inputWords1 = input.nextLine();
        List<String> wordsWithRepeatLetters = findWordsWithRepeatLetters(inputWords1);
        System.out.println(wordsWithRepeatLetters);

        //testing findRepeatedWords function
        String inputWords2 = input.nextLine();
        List<String> repeatedWords = findRepeatedWords(inputWords2);
        System.out.println(repeatedWords);
    }
}
