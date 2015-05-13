package observer2;

public class Main {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		
		Form f = new Form(usuario);
		
		f.open();
		
		Display d = new Display(usuario);
		
		d.open();
	}
}