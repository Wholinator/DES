import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BitStringTest {
	BitString b;
	
	
	@BeforeEach
	void setUp() {
		byte[] byteArray = {"1".getBytes()[0], (byte) 2};
		
		b = new BitString(byteArray);
	}

	@Test
	void testBitStringBit() {
		Bit bit = new Bit(0);
		BitString b = new BitString(bit);
		assertEquals(1, b.length);
		assertEquals(0, b.getBit(0).getValue());
	}

	@Test
	void testBitStringBitArray() {
		int length = 5;
		Bit[] bitArray = new Bit[length];
		for (int i = 0; i < length; i++) {
			bitArray[i] = new Bit(1);
		}
		BitString b = new BitString(bitArray);
		
		assertEquals(5, b.length);
		assertEquals(1, b.getBit(0).getValue());
		assertEquals(1, b.getBit(4).getValue());
		
	}

	@Test
	void testBitStringByteArray() {
		setUp();
		
		assertTrue(b.toString().equals("0011000100000010"));
	}

	@Test
	void testBitStringInt() {
		int length = 5;
		BitString b = new BitString(5);
		
		assertEquals(5, b.length);
		assertEquals(0, b.getBit(3).getValue());
		
	}

	@Test
	void testLeftShift() { //could separate out first few lines into the build up method thing
		setUp();
		
		assertTrue(b.toString().equals("0011000100000010"));
		
		b.leftShift();
		
		assertTrue(b.toString().equals("0110001000000100"));
	}

	@Test
	void testRightShift() {
		setUp();
		
		assertTrue(b.toString().equals("0011000100000010"));
		
		b.rightShift();
		
		assertTrue(b.toString().equals("0001100010000001"));
	}

	@Test
	void testSubString() {
		setUp();
		
		assertTrue(b.subString(1, 5).toString().equals("0110"));
	}

	@Test
	void testConcat() {
		setUp();
		
		byte[] byteArray = {(byte) 1};
		
		BitString c = new BitString(byteArray);
		
		assertTrue(b.concat(c).toString().equals("001100010000001000000001"));
	}

	@Test
	void testApplyPermutation() {
		fail("Not yet implemented");
	}

	@Test
	void testXor() {
		assertEquals((1^2), 3);
		
		byte[] b1 = {(byte) 1};
		byte[] b2 = {(byte) 2};
		
		BitString bit1 = new BitString(b1);
		BitString bit2 = new BitString(b2);
		
		assertTrue(bit1.xor(bit2).toString().equals("00000011"));
	}

	@Test
	void testGetBytes() {
		byte[] byteArray = {"1".getBytes()[0], (byte) 2};
		
		b = new BitString(byteArray);
		
		byte[] bytes = b.getBytes();
		
		assertTrue(Arrays.equals(b.getBytes(), byteArray));
	}

	@Test
	void testGetBlocks() {
		byte[] byteArray = "testing".getBytes();
		
		BitString b = new BitString(byteArray);
		
		BitString[] block = b.getBlocks(8);
		
		
	}

	@Test
	void testGetBits() {
		Bit[] bits = {new Bit(0), new Bit(1), new Bit(0)};
		
		b = new BitString(bits);
		
		assertTrue(Arrays.equals(b.getBits(), bits));
	}
}
