
public class BitString {
	private Bit[] bits;
	
	
	//bit array constructor
	public BitString(Bit[] bits) {
		setBits(bits);
	}
	
	public BitString(byte[] bytes) {
		int bitLength = 8 * bytes.length;
		
		//instantiate the bit array
		bits = initBits(new Bit[bitLength]);
		
		int byteNum = 0;
		for (int i = 0; i < bitLength; i++) {
			int index = i % 8;
			
			//acquire index value from the byteNum byte
			int value = (bytes[byteNum] >> index) & 1;

			//populate bitArray 
			
			//reverses order of bits in each individual byte because we read bits little-endian
			int index_to_change = (((byteNum + 1) * 8) - index) - 1;
			setBit(index_to_change, value);
			
			if (i % 8 == 0 && i != 0) {
				byteNum++;
			}
		}
	}
	
	private Bit[] initBits(Bit[] b) {
		for (int i = 0; i < b.length; i++) {
			b[i] = new Bit();
		}
		
		return b;
	}

	public Bit[] getBits() {
		return bits;
	}

	public void setBits(Bit[] bits) {
		this.bits = bits;
	}
	
	public void setBit(int index, int value) {
		bits[index].setValue(value);
	}
	
	public String toString() {
		String s = "";
		
		for (Bit b : bits) {
			s = s + b.getValue();
		}
		
		return s;
		
	}
	
}
