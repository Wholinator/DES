
public class Driver {

	public static void main(String[] args) {
		byte[] key = {(byte) 126, (byte) 129, (byte) 82,  (byte) 238, 
				      (byte) 104, (byte) 160, (byte) 157, (byte) 204};
		
		byte[] IV = {(byte) 123, (byte) 88, (byte) 85,  (byte) 21,
				     (byte) 0,   (byte) 93 ,(byte) 253, (byte) 55};
		
		DES d = new DES("CTR", key, new BitString(IV));
		//DES d = new DES(key);
		
		String cleartext = "1";
		BitString clearBits = new BitString(cleartext.getBytes());
		
		BitString e = d.encrypt(cleartext);
		
		String text = d.decrypt(e);
		
		System.out.println(e.toString());
		System.out.println(clearBits.toString());
		System.out.println("end text");
		System.out.println(text);
	}

}
