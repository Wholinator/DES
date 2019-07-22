
public class Driver {

	public static void main(String[] args) {
		byte[] key = {(byte) 126, (byte) 129, (byte) 82,  (byte) 238, 
				      (byte) 104, (byte) 160, (byte) 157, (byte) 204};
		
		DES d = new DES(key);
		
		String cleartext = "]";
		BitString clearBits = new BitString(cleartext.getBytes());
		
		BitString e = d.encrypt(cleartext);
		
		String text = d.decrypt(e);
		
		//System.out.println(e.toString());
		//System.out.println(clearBits.toString());
		System.out.println("end text");
		System.out.println(text);
	}

}
