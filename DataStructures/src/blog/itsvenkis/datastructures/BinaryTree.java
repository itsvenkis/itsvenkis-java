package blog.itsvenkis.datastructures;

/**
 * @author itsvenkis
 *
 */
public interface BinaryTree<E> {
	
	public int getParentIndex(int childIndex);
	public int getLeftChildIndex(int parentIndex);
	public int getRightChildIndex(int parentIndex);
	
}
