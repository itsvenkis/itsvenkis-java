package blog.itsvenkis.object.pool.factory;

import org.apache.commons.pool.BasePoolableObjectFactory;

import blog.itsvenkis.object.pool.domain.Poolable;

/**
 * @author itsvenkis
 *         A factory class which creates objects which are 
 *         in turn used by object pooling. Provides life cycle methods 
 *         of the object which is to be pooled. Objects created by 
 *         this factory are required to implement {@link blog.itsvenkis.object.pool.domain.Poolable}
 *         
 * @see org.apache.commons.pool.PoolableObjectFactory
 * @see org.apache.commons.pool.BasePoolableObjectFactory
 *
 */
@SuppressWarnings("unchecked")
public class ObjectPoolFactory extends BasePoolableObjectFactory{

	private final Class<Poolable> poolableObj;
	
	protected Class<Poolable> getPoolableObject(){
		return poolableObj;
	}
	
	//Use static factory method instead
	protected ObjectPoolFactory(Class<Poolable> poolableObj){
		this.poolableObj = poolableObj;
	}
	
	//Static factory method to create instance of this factory.
	public static ObjectPoolFactory newInstance(String className) throws ClassNotFoundException{
		Class<Poolable> poolObj= (Class<Poolable>) Class.forName(className);
		ObjectPoolFactory factory = new ObjectPoolFactory(poolObj);
		return factory;
	}
	
	@Override
	/**
	 * called whenever an new instance is needed
	 * @see org.apache.commons.pool.PoolableObjectFactory#makeObject
	 */
	public Object makeObject() throws Exception {
		return poolableObj.newInstance();
	}
	
	/**
	 * invoked on every instance when it is returned to the pool.
	 * @see org.apache.commons.pool.PoolableObjectFactory#makeObject
	 */
	public void passivateObject(Object obj) {
		if(obj instanceof Poolable){
			Poolable poolObj= (Poolable) obj;
			poolObj.clear();
		}else{
			throw new RuntimeException("Object has to be instance of Poolable");
		}
	}
	
	public boolean validateObject(Object obj){
		if(obj instanceof Poolable){
			return true;
		}
		return false;
	}

}
