package blog.itsvenkis.object.pool;

import blog.itsvenkis.object.pool.domain.Poolable;

/**
 * @author itsvenkis
 *         A simple Java bean
 *
 */
public class User implements Poolable{

	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password2) {
		this.password = password2;
	}
	
	//clear the fields before returning to the pool
	public void clear() {
		this.userName = null;
		this.firstName = null;
		this.lastName = null;
		this.password = null;
	}

}
