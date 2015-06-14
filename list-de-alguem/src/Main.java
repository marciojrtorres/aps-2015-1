

public class Main {
	
	public static void main(String[] args) {		
		
		List lista = new LinkedList();
		
		lista.append("a");
		lista.append("b");
		lista.append("c");
		lista.append("d");
		lista.append("e");
		lista.append("f");
		
		// abstração de iteração
		// Padrão de Projeto Iterator
		
		Iterator it = lista.getIterator();
		
		while (it.hasNext()) System.out.println(it.next());
	
		
		for (Object o : lista) System.out.println(o);
		
//		for (int i = 0; i < lista.count(); i++) {
//			System.out.println(lista.get(i));			
//		}
		
	}

}

