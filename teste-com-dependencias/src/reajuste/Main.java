package reajuste;


public class Main {

	public static void main(String[] args) throws Exception {
		
		Pagamento p = new Pagamento(100.0, 10);
		
		System.out.println(p.calcula());
		
	}
	
}
