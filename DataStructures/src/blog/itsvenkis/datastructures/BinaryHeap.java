/*
 * Heap.java
 * A heap data structure
 * 
 */
package blog.itsvenkis.datastructures;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author itsvenkis
 * 
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class BinaryHeap<E> extends AbstractBinaryTree<E> {

	// serial version ID
	private static final long serialVersionUID = 6819313981295554806L;

	// binary heap tree
	private Object[] heap;

	private int heapSize;

	private static final int DEFAULT_INITIAL_CAPACITY = 15;

	private final Comparator<? super E> comparator;

	private final boolean isMinHeap;

	public BinaryHeap(boolean isMinHeap) {
		this.heap = new Object[DEFAULT_INITIAL_CAPACITY];
		comparator = null;
		this.isMinHeap = isMinHeap;
	}

	public BinaryHeap(Comparator<? super E> comparator, boolean isMinHeap) {
		this.heap = new Object[DEFAULT_INITIAL_CAPACITY];
		this.comparator = comparator;
		this.isMinHeap = isMinHeap;
	}

	public BinaryHeap(int initialCapacity, Comparator<? super E> comparator,
			boolean isMinHeap) {
		this.heap = new Object[initialCapacity];
		this.comparator = comparator;
		this.isMinHeap = isMinHeap;
	}

	public BinaryHeap(int initialCapacity, boolean isMinHeap) {
		this.heap = new Object[initialCapacity];
		comparator = null;
		this.isMinHeap = isMinHeap;
	}

	// builds a binary heap tree with the collection passed
	public BinaryHeap(Collection<E> elementsCollection, boolean isMinHeap) {
		this(((E[]) elementsCollection.toArray()), isMinHeap);
	}

	// builds a binary heap tree with the array passed
	public BinaryHeap(E[] elementArray, boolean isMinHeap) {
		if (elementArray == null || elementArray.length == 0) {
			throw new IllegalArgumentException(
					"Source can not be null or empty");
		}
		this.isMinHeap = isMinHeap;
		this.comparator = null;
		buildHeap(elementArray);
	}

	// default constructor
	public BinaryHeap() {
		this(false);
	}

	public BinaryHeap(Comparator<? super E> comparator) {
		this(comparator, false);
	}

	public BinaryHeap(int initialCapacity, Comparator<? super E> comparator) {
		this(initialCapacity, comparator, false);
	}

	public BinaryHeap(int initialCapacity) {
		this(initialCapacity, false);
	}

	// builds a binary heap tree with the collection passed
	public BinaryHeap(Collection<E> elementsCollection) {
		this(((E[]) elementsCollection.toArray()), false);
	}

	// builds a binary heap tree with the array passed
	public BinaryHeap(E[] elementArray) {
		this(elementArray, false);
	}

	// Grow the heap twice its current length if its length is small else by 50%
	private void grow() {
		int newCapacity = (size() > 50) ? heap.length >>> 1 : heap.length << 1;
		heap = Arrays.copyOf(heap, newCapacity);
	}

	private void buildHeap(E[] elementArray) {
		if (elementArray == null || elementArray.length == 0) {
			throw new IllegalArgumentException(
					"Source can not be null or empty");
		}
		this.heap = elementArray;
		this.heapSize = elementArray.length;
		heapify();
	}

	private void heapify() {
		if (comparator == null) {
			heapifyByComparable();
		} else {
			heapifyByComparator();
		}
	}

	private void heapifyByComparable() {
		if (isMinHeap == false) {
			maxHeapifyBycomparable();
		} else {
			minHeapifyByComparable();
		}
	}

	private void heapifyByComparator() {
		if (isMinHeap == false) {
			maxHeapifyBycomparator();
		} else {
			minHeapifyBycomparator();
		}
	}

	private void maxHeapifyBycomparator() {
		int midPoint = (heapSize) >>> 1;
		for (int i = midPoint; i >= 0; i--) {
			maxHeapifyByComparator(i, heapSize);
		}
	}

	private void minHeapifyBycomparator() {
		int midPoint = (heapSize) >>> 1;
		for (int i = midPoint; i >= 0; i--) {
			minHeapifyByComparator(i, heapSize);
		}
	}

	private void maxHeapifyBycomparable() {
		int midPoint = (heapSize) >>> 1;
		for (int i = midPoint; i >= 0; i--) {
			maxHeapifyByComparable(i, heapSize);
		}
	}

	private void minHeapifyByComparable() {
		int midPoint = (heapSize) >>> 1;
		for (int i = midPoint; i >= 0; i--) {
			minHeapifyByComparable(i, heapSize);
		}
	}

	// recursive call
	private void maxHeapifyByComparator(int index, int limit) {
		int leftChildIndex = getLeftChildIndex(index);
		int rightChildIndex = getRightChildIndex(index);
		int largest = index;
		if (leftChildIndex < limit
				&& comparator.compare((E) this.heap[largest],
						(E) this.heap[leftChildIndex]) < 0) {
			largest = leftChildIndex;
		}

		if (rightChildIndex < limit
				&& comparator.compare((E) heap[largest],
						(E) this.heap[rightChildIndex]) < 0) {
			largest = rightChildIndex;
		}

		if (largest != index) {
			swap(index, largest);
			maxHeapifyByComparator(largest, limit);
		}
	}

	// recursive call
	private void maxHeapifyByComparable(int index, int limit) {
		int leftChildIndex = getLeftChildIndex(index);
		int rightChildIndex = getRightChildIndex(index);
		Comparable<? super E> compareKey = (Comparable<? super E>) this.heap[index];
		int largest = index;
		if (leftChildIndex < limit
				&& compareKey.compareTo((E) this.heap[leftChildIndex]) < 0) {
			largest = leftChildIndex;
			compareKey = (Comparable<? super E>) this.heap[largest];
		}

		if (rightChildIndex < limit
				&& compareKey.compareTo((E) this.heap[rightChildIndex]) < 0) {
			largest = rightChildIndex;
		}

		if (largest != index) {
			swap(index, largest);
			maxHeapifyByComparable(largest, limit);
		}
	}

	// recursive call
	private void minHeapifyByComparator(int index, int limit) {
		int leftChildIndex = getLeftChildIndex(index);
		int rightChildIndex = getRightChildIndex(index);
		int largest = index;
		if (leftChildIndex < limit
				&& comparator.compare((E) this.heap[largest],
						(E) this.heap[leftChildIndex]) > 0) {
			largest = leftChildIndex;
		}

		if (rightChildIndex < limit
				&& comparator.compare((E) heap[largest],
						(E) this.heap[rightChildIndex]) > 0) {
			largest = rightChildIndex;
		}

		if (largest != index) {
			swap(index, largest);
			maxHeapifyByComparator(largest, limit);
		}
	}

	// recursive call
	private void minHeapifyByComparable(int index, int limit) {
		int leftChildIndex = getLeftChildIndex(index);
		int rightChildIndex = getRightChildIndex(index);
		Comparable<? super E> compareKey = (Comparable<? super E>) this.heap[index];
		int largest = index;
		if (leftChildIndex < limit
				&& compareKey.compareTo((E) this.heap[leftChildIndex]) > 0) {
			largest = leftChildIndex;
			compareKey = (Comparable<? super E>) this.heap[largest];
		}

		if (rightChildIndex < limit
				&& compareKey.compareTo((E) this.heap[rightChildIndex]) > 0) {
			largest = rightChildIndex;
		}

		if (largest != index) {
			swap(index, largest);
			maxHeapifyByComparable(largest, limit);
		}
	}

	private void swap(int i, int j) {
		E temp = (E) heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public E get(int index) {
		return (E) heap[index];
	}

	public boolean contains(Object element) {
		return indexOf(element) >= 0;
	}

	public int indexOf(Object element) {
		for (int i = 0; i < heap.length; i++) {
			if (element.equals(heap[i])) {
				return i;
			}
		}
		return -1;
	}

	public int size() {
		return heapSize;
	}

	public void insert(E element) {
		if (heapSize == heap.length) {
			grow();
		}
		heap[heapSize] = element;
		heapSize++;
		if (heapSize > 1) {
			heapify();
		}
	}

	@Override
	public E pop() {
		if (heapSize >= 1) {
			E temp = (E) heap[0];
			swap(0, heapSize - 1);
			heap[heapSize - 1] = null;
			heapSize--;
			heapify();
			return temp;
		} 
		throw new NoSuchElementException();
	}
	
	public Iterator<E> getIterator(){
		return new Itr();
	}
		
	private final class Itr implements Iterator<E>{
		
		private int lastVisited = -1;
		
		@Override
		public boolean hasNext() {
			return (lastVisited < size()-1) ? true : false;
		}

		@Override
		public E next() {
			lastVisited ++;
			if(size() > 0 && lastVisited < size()){
				return (E) heap[lastVisited];
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
}
