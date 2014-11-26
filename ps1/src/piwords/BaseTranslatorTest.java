package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseTranslatorTest {
    @Test
    public void basicBaseTranslatorTest() {
        // Expect that .01 in base-2 is .25 in base-10
        // (0 * 1/2^1 + 1 * 1/2^2 = .25)
        int[] input = {0, 1};
        int[] expectedOutput = {2, 5};
        assertArrayEquals(expectedOutput,
                          BaseTranslator.convertBase(input, 2, 10, 2));
        //First 23 fraction digits of pi
        //Pi base-26 is: http://www.cadaeic.net/picode.htm (3, 17, 18, 16)
        input = new int[] {1, 4, 1, 5, 9, 2, 6, 5, 3,
        				   5, 8, 9, 7, 9, 3, 2, 3, 8,
        				   4, 6, 2, 6, 4};
        expectedOutput = new int[] {3, 17, 18, 16};
        assertArrayEquals(expectedOutput,
                BaseTranslator.convertBase(input, 10, 26, 4));
        //null test for (baseA < 2) || (baseB < 2) || (precisionB < 1)
        assertArrayEquals(null,
                BaseTranslator.convertBase(input, 1, 1, 0));
        //null test for (newDigits[j] < 0) || (newDigits[j] >= baseA)
        input = new int[] { 6, 8 };
        assertArrayEquals(null,
                BaseTranslator.convertBase(input, 3, 26, 4));
    }
    // TODO: Write more tests (Problem 2.a)
}
