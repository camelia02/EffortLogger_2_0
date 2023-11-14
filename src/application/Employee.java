/**
 * 
 */
package application;

/**
 * 
 */
public class Employee {

	private int id;
	private int rank;
	private String fName;
	private String mName = "";
	private String lName;
	private String email;
	private String password;
	
	public Employee(int id, int rank, String fName, String mName, String lName, String email, String password) {
		this.id = id;
		this.rank = rank;
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public String getFullName() {
		return this.fName + " " + this.mName + " " + this.lName;
	}
}
