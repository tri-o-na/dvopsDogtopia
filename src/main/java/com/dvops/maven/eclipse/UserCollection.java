package com.dvops.maven.eclipse;

import java.util.*;

public class UserCollection {
	public ArrayList<User> users = new ArrayList<>();
	public UserCollection() {
		users.add(new User("user1", "user1@email.com", "password1"));
	}
	
	public List<User> getAllUser(){
		return users;
	}
	
	public User login(String username, String password) {
    	for (User u : users) { 		      
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) return u;
       }
    	return null;
	}
	
	public boolean signUp (User user) {
    	for (User u : users) { 		      
            if(u.getUsername().equals(user.getUsername())) return false;

       }
        users.add(user);
        return true; 
	}
	
	public void editUser (String username, String email, String password, String oldpass) {
    	users.add(new User(username, email, password)); 
    	if (oldpass == password) {
        	for (User u : users) { 		      
                if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                	users.remove(u);
                };
           }
    	}
    	else {
        	for (User u : users) { 		      
                if(u.getUsername().equals(username) && u.getPassword().equals(oldpass)) {
                	users.remove(u);
                };
           }
    	}

	}
	
	public boolean deleteUser (String username, String password) {
    	for (User u : users) { 		      
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
            	users.remove(u);
            	return true;
            };
       }
    	return false;
	}
}
