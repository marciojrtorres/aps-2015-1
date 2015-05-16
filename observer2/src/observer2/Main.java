package observer2;


public class Main {

	public static void main(String[] args) throws Exception {
		
		FormAdicionaContato f = new FormAdicionaContato();
		
		f.open();
		
		FormListaContatos d = new FormListaContatos();
		
		d.open();
	}
}