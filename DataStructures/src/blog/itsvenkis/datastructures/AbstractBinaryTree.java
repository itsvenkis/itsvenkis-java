package blog.itsvenkis.datastructures;
//TEST COMMIT 123 456
public abstract class AbstractBinaryTree<E> implements Heap<E> {

	private static final long serialVersionUID = -6331938602286520514L;
	
	/**
	 * 
	 * @param childIndex
	 * 		  The index to which parent index is to be returned
	 * @return int
	 *        Parent node index
	 */
	public int getParentIndex(int childIndex){
		return (childIndex - 1) >>> 1;
	}
	
	public int getLeftChildIndex(int parentIndex){
		return (parentIndex << 1)+1;
	}
	
	public int getRightChildIndex(int parentIndex){
		return (parentIndex << 1)+2;
	}
	
}
