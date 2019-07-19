
public class Driver {

	public static void main(String[] args) {
		DES d = new DES();
		
		BitString e = d.encrypt("testing tatesting toe talla prrrrrraaal");
		
		System.out.println(e.toString());
	}

}
