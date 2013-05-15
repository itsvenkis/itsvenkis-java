package blog.itsvenkis.datastructures;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @author itsvenkis
 * 
 * @param <E>
 */
public interface Heap<E> extends Serializable, BinaryTree<E> {
	
	public E get(int index);

	public boolean contains(Object element);

	public int indexOf(Object element);

	public int size();

	public void insert(E element);

	public E pop();

	public Iterator<E> getIterator();
}
