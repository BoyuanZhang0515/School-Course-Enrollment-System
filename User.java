
abstract class User {
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
		// Default constructor
	public User() {
		
	}
	// Constructor 
	public User(String userName, String passWord, String f, String l) {
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = f;
		this.lastName = l;
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	// print user info method
	public void printUserInfo() {
		System.out.print("FIRSTNAME: "+this.firstName+"\nLASTNAME: "+this.lastName+"\n");
	}
	// abstract method
	abstract void printPassword();
}
