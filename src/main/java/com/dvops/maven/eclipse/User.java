/**
 * 
 */
package com.dvops.maven.eclipse;

import java.util.Objects;

public class User {
	private String username;
	private String email;
	private String password;

	public User(String username, String email, String password) {
		super();
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
	}
	
	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
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

//	@Override
//	public int hashCode() {
//		return Objects.hash(username, email, password);
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!(obj instanceof User))
//			return false;
//		User other = (User) obj;
//		return Objects.equals(username, other.username) && Objects.equals(email, other.email) && Objects.equals(password, other.password);
//	}

}
