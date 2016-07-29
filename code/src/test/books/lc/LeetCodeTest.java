package books.lc;

import org.junit.Test;
 import static org.junit.Assert.*;

public class LeetCodeTest {

	LeetCode lCode = new LeetCode();
	
	@Test
	public void zigZagConversion_lc6(){
		String str = lCode.zigZagConversion_lc6("PAYPALISHIRING", 3);
		assertEquals("Failure ", "PAHNAPLSIIGYIR", str);
	}
}
