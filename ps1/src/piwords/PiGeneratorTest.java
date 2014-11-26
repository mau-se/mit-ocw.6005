package piwords;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PiGeneratorTest {
    @Test
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
        assertEquals(17, PiGenerator.powerMod(5, 7, 23));
        //null test
        assertEquals(-1, PiGenerator.powerMod(5, -1, 1));       
    }

    // TODO: Write more tests (Problem 1.a, 1.c)
    @Test
    public void computePiInHexTest() {
    	//null test
    	assertEquals(null, PiGenerator.computePiInHex(-1));
    	//First 2 fractional digits of pi
    	assertEquals("[2, 4]", Arrays.toString(PiGenerator.computePiInHex(2)));
    }
}
