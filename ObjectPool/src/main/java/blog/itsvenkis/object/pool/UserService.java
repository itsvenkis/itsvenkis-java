package blog.itsvenkis.object.pool;

import org.apache.commons.pool.impl.StackObjectPool;

/**
 * @author itsvenkis
 * 
 *         This class provides operations to retrieve and return User objects
 *         to the object pool. The original pool itself is injected by spring 
 *         configuration file.
 *
 */
public class UserService {
	
	//pool of User objects. 
	private StackObjectPool userObjectPool;// Why isn't this a generic? can avoid unnecessary casting
	
	//getter
	public StackObjectPool getUserObjectPool() {
		return userObjectPool;
	}
	
	//setter
	public void setUserObjectPool(StackObjectPool userObjectPool) {
		this.userObjectPool = userObjectPool;
	}
	
	/**
	 * 
	 * @return IUser
	 *         User object from object pool
	 *         
	 * @throws Exception
	 */
	public User newUser() throws Exception {
		return (User) userObjectPool.borrowObject();
	}
	
	/**
	 * 
	 * @param user
	 * 		  The user object which is to be returned to pool.
	 *        Only objects retrieved using @{link {@link #newUser()}
	 *        can be returned to the pool.
	 * @throws Exception
	 */
	public void returnUser(User user) throws Exception{
		userObjectPool.returnObject(user);
	}
	
}
