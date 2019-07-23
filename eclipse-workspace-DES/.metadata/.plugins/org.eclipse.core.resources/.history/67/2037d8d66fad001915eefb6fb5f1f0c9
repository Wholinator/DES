import java.util.Random;



public class DESKey {
	
	private static Random rand = new Random(System.currentTimeMillis());
	
	
	public static BitString[] getKeySchedule(byte[] key) {
		int[] initial_permutation = {57, 49, 41, 33, 25, 17,  9,
									 1,  58, 50, 42, 34, 26, 18,
									 10, 2,  59, 51, 43, 35, 27,
									 19, 11, 3,  60, 52, 44, 36,
									 63, 55, 47, 39, 31, 23, 15,
									 7,  62, 54, 46, 38, 30, 22,
									 14, 6,  61, 53, 45, 37, 29,
									 21, 13, 5,  28, 20, 12, 4};
		
		int[] second_permutation = {14, 17, 11, 24, 1,  5,
									3,  28, 15, 6,  21, 10,
									23, 19, 12, 4,  26, 8,
									16, 7,  27, 20, 13, 2,
									41, 52, 31, 37, 47, 55,
									30, 40, 51, 45, 33, 48,
									44, 49, 39, 56, 34, 53,
									46, 42, 50, 36, 29, 32};
		
		BitString bits = new BitString(key);
		
		BitString p1_Key = bits.applyPermutation(initial_permutation);
		
		//Split the key into left and right halves
		BitString p1_Key_l = p1_Key.subString(0, 28);
		BitString p1_Key_r = p1_Key.subString(28, 56);
		
		BitString[] keySchedule = new BitString[16];
		
		for (int i = 0; i < 16; i++) {
			
			//shift our split keys
			if (i == 0 || i == 1 || i == 8 || i == 15) {
				//one shift
				p1_Key_l.leftShift();
				p1_Key_r.leftShift();
			} else {
				//two shifts
				p1_Key_l.leftShift();
				p1_Key_l.leftShift();
				
				p1_Key_r.leftShift();
				p1_Key_r.leftShift();
			}
			
			BitString tempKey = p1_Key_l.concat(p1_Key_r);
			
			BitString permutedKey = tempKey.applyPermutation(second_permutation);
			
			keySchedule[i] = permutedKey;
		}
		
		return keySchedule;
	}


	public static byte[] genKey() {
		byte[] bKey = new byte[8];
		rand.nextBytes(bKey);

		return bKey;
	}


}
