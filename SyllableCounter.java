import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SyllableCounter {
    public static void main(String[] args) {
        SyllableCounter syllableCounter = new SyllableCounter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String word = "";
            while ((word = reader.readLine()) != null) {
                System.out.println(syllableCounter.countSyllables(word));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }

    /**
     * 
     * Counts the number of syllables in the given word using regular expressions
     * and pattern matching.
     * 
     * @param word The input word for which the syllable count needs to be
     *             calculated.
     * @return The number of syllables in the word. Returns 0 if the input word is
     *         invalid.
     */
    public int countSyllables(String word) {
        SyllableCounter counter = new SyllableCounter();
        int numSyllables = 0;
        word = word.toLowerCase();
        if (counter.validWord(word) == false) {
            System.err.println("Invalid input");
            return 0;
        }

        // if word len is less or equal to 3 return a syllable count of 1
        if (word.length() <= 3) {
            return 1;
        }

        // count num of syllables based on number of vowels - add number to syllable
        // count
        Pattern vowelPattern = Pattern.compile("[aeiouy]");
        Matcher vowelMatcher = vowelPattern.matcher(word);
        while (vowelMatcher.find()) {
            numSyllables++;
        }

        // count number of diphtongs and triphongs - subtract number from syllable count
        Pattern diphthongPattern = Pattern.compile("[aeiouy]{2}");
        Matcher diphthongMatcher = diphthongPattern.matcher(word);

        while (diphthongMatcher.find()) {
            numSyllables--;
        }
        Pattern triphthongPattern = Pattern.compile("[aeiouy]{3}");
        Matcher triphthongMatcher = triphthongPattern.matcher(word);

        while (triphthongMatcher.find()) {
            numSyllables--;
        }

        // subtract a syllable if the word ends in e
        Pattern endwithePattern = Pattern.compile("[b-df-hj-np-tv-z]e$");
        Matcher endwitheMatcher = endwithePattern.matcher(word);
        if (endwitheMatcher.find()) {
            numSyllables--;
        }

        // add a syllable if the word ends with a constanent followed by le or les
        Pattern endwithlePattern = Pattern.compile("([b-df-hj-np-tv-z]le|les)$");
        Matcher endwithleMatcher = endwithlePattern.matcher(word);
        if (endwithleMatcher.find()) {
            numSyllables++;
        }

        return numSyllables;
    }

    /**
     * 
     * Checks if the input word is valid by ensuring it only contains lowercase
     * letters from 'a' to 'z'.
     * 
     * @param word The input word to be validated.
     * 
     * @return true if the word is valid and contains only lowercase letters from
     *         'a' to 'z'; false otherwise.
     */
    public boolean validWord(String word) {
        Pattern validWordPattern = Pattern.compile("[^a-z]");
        Matcher wordMatacher = validWordPattern.matcher(word);

        if (wordMatacher.find()) {
            return false;
        } else {
            return true;
        }
    }
}