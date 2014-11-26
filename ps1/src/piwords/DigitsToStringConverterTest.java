package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsToStringConverterTest {
	 @Test
	    public void basicNumberSerializerTest() {
	        // Input is a 4 digit number, 0.123 represented in base 4
	        int[] input = {0, 1, 2, 3};

	        // Want to map 0 -> "d", 1 -> "c", 2 -> "b", 3 -> "a"
	        char[] alphabet = {'d', 'c', 'b', 'a'};

	        String expectedOutput = "dcba";
	        assertEquals(expectedOutput,
	                     DigitsToStringConverter.convertDigitsToString(
	                             input, 4, alphabet));
	        //Map first nine digits to first nine alphabets
	        input = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
	        alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
	        expectedOutput = "abcdefghi";
	        assertEquals(expectedOutput,
                    DigitsToStringConverter.convertDigitsToString(
                            input, 9, alphabet));
	        //null test: alphabet.length != base
	        assertEquals(null,
                    DigitsToStringConverter.convertDigitsToString(
                            input, 2, alphabet));
	    }

    // TODO: Write more tests (Problem 3.a)
}
