package toolkit;

import static toolkit.StringUtil.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println(eq(titleize("um texto de teste"), "Um Texto De Teste"));
		System.out.println(eq(titleize("UM TEXTO DE TESTE"), "Um Texto De Teste"));
		System.out.println(eq(titleize("  um texto  de teste  "), "Um Texto  De Teste"));
		System.out.println(eq(titleize("  3SPECIALISTA 3M 3NGENHARIA     de   Software"), "3specialista 3m 3ngenharia     De   Software"));
		
	}

}
