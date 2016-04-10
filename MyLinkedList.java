
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements ListInterface<T> {
	// dummy head
	Node<T> head;
	int numItems;

	public MyLinkedList() {
		head = new Node<T>(null);
	}

    /**
     * {@code Iterable<T>}를 구현하여 iterator() 메소드를 제공하는 클래스의 인스턴스는
     * 다음과 같은 자바 for-each 문법의 혜택을 볼 수 있다.
     * 
     * <pre>
     *  for (T item: iterable) {
     *  	item.someMethod();
     *  }
     * </pre>
     * 
     * @see PrintCmd#apply(MovieDB)
     * @see SearchCmd#apply(MovieDB)
     * @see java.lang.Iterable#iterator()
     */
    public final Iterator<T> iterator() {
    	return new MyLinkedListIterator<T>(this);
    }

	@Override
	public boolean isEmpty() {
		return head.getNext() == null;
	}

	@Override
	public int size() {
		return numItems;
	}

	@Override
	public T first() {
		return head.getNext().getItem();
	}

	@Override
	public void add(T item) {
		Node<T> last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.insertNext(item);
		numItems += 1;
	}

	@Override
	public void removeAll() {
		head.setNext(null);
	}
	
	public void sortedAdd(T item) {
		if (isEmpty())
			add(item);
		
		else if (head.getNext().getItem().compareTo(item) == 1)
		{
			head.insertNext(item);
			numItems += 1;
		}
		
		else
		{
			Node<T> prev = head.getNext(); 
			Node<T> curr = prev.getNext();
			
			while (prev.getItem().compareTo(item) == -1)
			{
				if (curr == null)
				{
					prev.insertNext(item);
					numItems += 1;
					break;
				}
				
				else if (curr.getItem().compareTo(item) == 1)// add item between prev & curr
				{
					prev.insertNext(item);
					numItems += 1;
					break;
				}
				
				else if (curr.getItem().compareTo(item) == 0) // do nothing when same item exists
					break;

				else if (curr.getItem().compareTo(item) == -1) //proceed
				{
					prev = curr;
					curr = curr.getNext();
				}			
			}
		}
	}
	
	public void remove(T item){
		Node<T> prev = head;
		Node<T> curr = head.getNext();
		
		while (curr != null)
		{
			if (curr.getItem().equals(item))
			{
				prev.removeNext();
				numItems -= 1;
				break;
			}
			
			else
			{
				prev = curr;
				curr = curr.getNext();
			}		
		}
	}
	
	// FIXME
	/*
	@Override
	public boolean equals(Object obj){
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        MyLinkedList other = (MyLinkedList) obj;
        Iterator it = other.iterator();
        if (isEmpty() != other.isEmpty())
        		return false;
        else if (numItems != other.size())
        	return false;
        
	}
	
	@Override
	public int hashCode(){
		
	}
	*/
}

class MyLinkedListIterator<T extends Comparable<T>> implements Iterator<T> {
	private MyLinkedList<T> list;
	private Node<T> curr;
	private Node<T> prev;

	public MyLinkedListIterator(MyLinkedList<T> list) {
		this.list = list;
		this.curr = list.head;
		this.prev = null;
	}

	@Override
	public boolean hasNext() {
		return curr.getNext() != null;
	}

	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();

		prev = curr;
		curr = curr.getNext();

		return curr.getItem();
	}

	@Override
	public void remove() {
		if (prev == null)
			throw new IllegalStateException("next() should be called first");
		if (curr == null)
			throw new NoSuchElementException();
		prev.removeNext();
		list.numItems -= 1;
		curr = prev;
		prev = null;
	}
}