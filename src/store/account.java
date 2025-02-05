package store;

import java.util.ArrayList;

public abstract class account {

	private String name;
	private String phonenumber;
	private String email;
	private String password;
	
	public account() {
		
	}
	
	public account(String name, String phonenumber, String email, String password) {
		this.name = name;
		this.phonenumber=phonenumber;
		this.email =email;
		this.password = password;
	}
	abstract void menu(ArrayList<account> account,ArrayList<item> menu);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	
	
}
