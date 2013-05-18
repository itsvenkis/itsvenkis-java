package blog.itsvenkis.object.pool.domain;

//Super type for all poolable objects
public interface Poolable {
	
	/**
	 * performs clean up operations on the object before returning it to the
	 * pool
	 */
	public void clear();
}
