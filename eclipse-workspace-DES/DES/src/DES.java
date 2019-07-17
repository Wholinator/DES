import java.util.Random;

public class DES {
	private byte[] key;
	private Random rand;
	
	public DES(byte[] key) {
		setRand();
		setKey(key);
	}
	
	public DES(String key) {
		setRand();
		
		byte[] b = key.getBytes();
		if (b.length == 7) {
			setKey(b);
		} else {
			System.out.println("Key not valid length: Generating new key");
			setKey(genKey());
		}
	}
	
	public DES() {
		setRand();
		setKey(genKey());
	}
	


	//generates random 64 bit key
	public byte[] genKey() {
		byte[] bKey = new byte[8];
		rand.nextBytes(bKey);

		return bKey;
	}
	
	
	//encrypts plaintext
	public String encrypt(String plaintext) {
		byte[][] blocks = getBlocks(plaintext);
		
		return plaintext;
	}
	
	//transforms a string into an array of byte[8] arrays
	//each byte[8] array is 64 bits and considered a block in DES
	private byte[][] getBlocks(String plaintext) {
		byte[] bytes = plaintext.getBytes();
		int numBlocks = (int) Math.ceil(bytes.length / 8.0);
		
		byte[][] blocks = new byte[numBlocks][8];
		
		int c = 0;
		int block = 0;
		while (c < bytes.length) {
			int byteNum = c % 8;
			
			blocks[block][byteNum] = bytes[c];
			
			if (byteNum == 7) {
				block++;
			}
			c++;
		}
		return blocks;
	}

	
	//Getter: key
	public byte[] getKey() {
		return key;
	}

	//Setter: key
	public void setKey(byte[] key) {
		this.key = key;
	}
	
	
	public Random getRand() {
		return rand;
	}

	public void setRand() {
		this.rand = new Random(System.currentTimeMillis());
	}
}
