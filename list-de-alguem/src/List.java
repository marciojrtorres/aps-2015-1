public interface List extends Iterable {

    public void append(Object o);
    public void prepend(Object o);

    public Object get(int index);
    public Object first();
    public Object last();

    public boolean delete(int index);
    public void purge();

    public boolean has(Object o);
    public int count();
    public boolean empty();
    
    public Iterator getIterator();

}