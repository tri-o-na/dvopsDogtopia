package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserCollectionTest {
	
	private UserCollection uc;
	private User testUser1;
	private User testUser2;
	private User testUser3;
	private User testUser4;
	private final int USER_COLLECTION_SIZE = 4;

	@BeforeEach
	void setUp() throws Exception {
		uc = new UserCollection();
		testUser1 = new User("user1", "user1@email.com", "password1");
		testUser2 = new User("user2", "user2@gmail.com", "password2");
		testUser3 = new User("user3", "user3@email.com", "password3");
		testUser4 = new User("user4", "user4@gmail.com", "password4");
		uc.signUp(testUser1);
		uc.signUp(testUser2);
		uc.signUp(testUser3);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLogin() {
		//Testing whether user have been logged in correctly by email
		assertEquals(uc.login("user1", "password1").getEmail(), "user1@email.com");
		
		//Testing whether login returned null with wrong username
		User loggedInUserFailUser = uc.login("user3", "password1");
		assertNull(loggedInUserFailUser);
		
		//Testing whether login returned null with wrong password
		User loggedInUserFailPass = uc.login("user1", "password3");
		assertNull(loggedInUserFailPass);	
		
		//Testing whether login returned null with empty username
		User loggedInUserFailUserEmpty = uc.login("", "password3");
		assertNull(loggedInUserFailUserEmpty);
		
		//Testing whether login returned null with empty password
		User loggedInUserFailPassEmpty = uc.login("user1", "");
		assertNull(loggedInUserFailPassEmpty);
		
		//Testing whether login returned null with empty fields
		User loggedInUserFailBothEmpty = uc.login("", "");
		assertNull(loggedInUserFailBothEmpty);	
	}

	@Test
	void testSignUp() {
		//Testing whether user can sign up
		List<User> testUc = uc.getAllUser();
		assertEquals(testUc.size(), USER_COLLECTION_SIZE);
		uc.signUp(testUser4);
		assertEquals(uc.getAllUser().size(), USER_COLLECTION_SIZE+1);
		
		//Testing whether duplicated user info will be block from signing up
		uc.signUp(testUser4);
		assertEquals(uc.getAllUser().size(), USER_COLLECTION_SIZE+1);	
	}

	@Test
	void testEditUser() {
		//Testing whether user3 email is correct
		assertEquals(uc.login("user3", "password3").getEmail(), "user3@email.com");
		
		//Testing whether changing user3 email saves and work
		uc.editUser("user3", "user34@email.com", "password3", "password3");
		assertEquals(uc.login("user3", "password3").getEmail(), "user34@email.com");
		
		//Testing whether changing user3 password saves and work
		uc.editUser("user3", "user34@email.com", "password34", "password3");
		assertEquals(uc.login("user3", "password34").getEmail(), "user34@email.com");
		
		//Testing whether changing user3 email and password saves and work
		uc.editUser("user3", "user345@email.com", "password345", "password34");
		assertEquals(uc.login("user3", "password345").getEmail(), "user345@email.com");
		
	}

	@Test
	void testDeleteUser() {	
		//Testing whether deleting user works
		uc.deleteUser("user2", "password2");
		assertEquals(uc.getAllUser().size(), USER_COLLECTION_SIZE-1);	
		
		//Testing whether user1 will not be deleted with a wrong username field
		uc.deleteUser("user123", "password1");
		assertEquals(uc.getAllUser().size(), USER_COLLECTION_SIZE-1);
		
		//Testing whether user1 will not be deleted with a wrong password field
		uc.deleteUser("user1", "password123");
		assertEquals(uc.getAllUser().size(), USER_COLLECTION_SIZE-1);
		
		//Testing whether user1 will not be deleted with a empty username field
		uc.deleteUser("", "password1");
		assertEquals(uc.getAllUser().size(), USER_COLLECTION_SIZE-1);
		
		//Testing whether user1 will not be deleted with a empty password field
		uc.deleteUser("user1", "");
		assertEquals(uc.getAllUser().size(), USER_COLLECTION_SIZE-1);
	}

}
