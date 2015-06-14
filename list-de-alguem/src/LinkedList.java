public class LinkedList implements List {

	private Nodo first = null, last = null;

	public Object first() {
		return first != null ? first.getInfo() : null;
	}

	public Object last() {
		return last != null ? last.getInfo() : null;
	}

	public void append(Object o) {
		if (o == null)
			return;
		Nodo novo = new Nodo();
		novo.setInfo(o);
		if (last == null) {
			setFirst(novo);
			setLast(novo);

			first.setNext(last);
			first.setPrevious(null);

			last.setPrevious(first);
			last.setNext(null);
		} else {
			novo.setPrevious(last);
			novo.setNext(null);

			last.setNext(novo);
			last = novo;
		}
	}

	public void prepend(Object o) {
		if (o == null)
			return;
		Nodo novo = new Nodo();
		novo.setInfo(o);

		if (first == null) {
			setFirst(novo);
			setLast(novo);

			first.setNext(last);
			first.setPrevious(null);

			last.setPrevious(first);
			last.setNext(null);
		} else {
			first.setPrevious(novo);
			novo.setNext(first);
			setFirst(novo);
			first.setPrevious(null);
		}
	}

	public Object get(int index) {
		if (empty())
			return null;
		Nodo aux;
		int cont;
		if (index == 0) {
			return first.getInfo();
		} else if (index > 0) {
			aux = first;
			cont = index % count();
			while (cont > 0) {
				System.out.println("next");
				aux = aux.getNext();
				cont--;
			}
		} else {
			aux = last;
			cont = -index % count();
			while (cont < 1) {
				aux = aux.getPrevious();
				cont--;
			}
		}
		return aux.getInfo();
	}

	public boolean delete(int index) {
		if (index >= count())
			return false;
		Nodo aux = getNodo(index);
		Nodo previous = aux.getPrevious();
		Nodo next = aux.getNext();
		if (previous == null) {
			next.setPrevious(aux.getPrevious());
			first = next;
		} else if (next == null) {
			previous.setNext(aux.getNext());
			last = previous;
		} else {
			previous.setNext(aux.getNext());
			next.setPrevious(aux.getPrevious());
		}
		aux.setPrevious(null);
		aux.setNext(null);
		aux.setInfo(null);
		return true;
	}

	public void purge() {
		setFirst(null);
	}

	public boolean has(Object o) {
		Nodo aux = first;
		while (aux != null) {
			if (aux.getInfo() == o)
				return true;
			aux = aux.getNext();
		}
		return false;
	}

	public int count() {
		Nodo aux = first;
		int cont = 0;
		while (aux != null) {
			cont++;
			aux = aux.getNext();
		}
		return cont;
	}

	public boolean empty() {
		return (this.first == null);
	}

	private void setFirst(Nodo first) {
		this.first = first;
	}

	private void setLast(Nodo last) {
		this.last = last;
	}

	private Nodo getNodo(int index) {
		if (empty())
			return null;
		Nodo aux;
		int cont;
		if (index == 0) {
			return first;
		} else if (index > 0) {
			aux = first;
			cont = index % count();
			while (cont > 0) {
				aux = aux.getNext();
				cont--;
			}
		} else {
			aux = last;
			cont = -index % count();
			while (cont < 1) {
				aux = aux.getPrevious();
				cont--;
			}
		}
		return aux;
	}

	private static class Nodo {

		private Nodo next;
		private Nodo previous;
		private Object info;

		public Object getInfo() {
			return info;
		}

		public Nodo getNext() {
			return next;
		}

		public Nodo getPrevious() {
			return previous;
		}

		public void setPrevious(Nodo previous) {
			this.previous = previous;
		}

		public void setNext(Nodo next) {
			this.next = next;
		}

		public void setInfo(Object info) {
			this.info = info;
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	private class LinkedListIterator
		implements Iterator, java.util.Iterator {
		
		private Nodo no = first;		

		@Override
		public boolean hasNext() {			
			return no != null;
		}

		@Override
		public Object next() {
			Object value = no.getInfo();
			no = no.getNext();
			return value;
		}		
		
		public void remove() {}
	}
	
	@Override
	public Iterator getIterator() {
		return new LinkedListIterator(); 		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public java.util.Iterator iterator() {
		return new LinkedListIterator();
	}
}