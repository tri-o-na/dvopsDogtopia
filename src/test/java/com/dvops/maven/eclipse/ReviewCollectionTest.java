package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

public class ReviewCollectionTest {
	private ReviewCollection rc;
	private Review testReview1;
	private Review testReview2;
	private Review testReview3;
	private final int REVIEW_COLLECTION_SIZE = 3;

	@BeforeEach
	void setUp() throws Exception {
		rc = new ReviewCollection();
		testReview1 = new Review("user1", "GERMAN SHEPHERD", "Has separation anxiety,  is extremely active, very loyal, protects all, good at tricks", 3);
		testReview2 = new Review("JaneTan", "GOLDEN RETRIEVER", "Leaves fur all over the house, very fun to play with", 4);
		testReview3 = new Review("ZoeMang", "GERMAN SHEPHERD", "Very sporty and loves to go on hikes with me, learns new tricks very fast, is a great companion to have!", 5);
		rc.addReview(testReview1);
		rc.addReview(testReview2);
		rc.addReview(testReview3);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetAllReview() {
		//Testing that all the dogs are inside.
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE);
		 
		//Testing specific fields being able to retrieved through the list
		List<Review> testRc = rc.getAllReview();
		assertEquals(testRc.get(0).getUsername(), "user1");
		assertEquals(testRc.get(2).getUsername(), "ZoeMang");
	}

	@Test
	void testGetOneDogReview() {
		//Testing specific dog's reviews has been retrieved and all information is correct.
		Review testReview = rc.getOneDogReview("GERMAN SHEPHERD");
		assertEquals(testReview.getUsername(), "user1");
		assertEquals(testReview.getDogName(), "GERMAN SHEPHERD");
		assertEquals(testReview.getReview(), "Has separation anxiety,  is extremely active, very loyal, protects all, good at tricks");
		assertEquals(testReview.getReview(), 3);
		
		//Testing specific dog is not found and returned a null value
		Review failTestReview = rc.getOneDogReview("NOT SHEPHERD");
		assertNull(failTestReview);
	}
	
	@Test
	void testGetOneReview() {
		//Testing specific dog's reviews has been retrieved and all information is correct.
		Review testReview = rc.getOneReview("user1", "GERMAN SHEPHERD");
		assertEquals(testReview.getUsername(), "user1");
		assertEquals(testReview.getDogName(), "GERMAN SHEPHERD");
		assertEquals(testReview.getReview(), "Has separation anxiety,  is extremely active, very loyal, protects all, good at tricks");
		assertEquals(testReview.getRating(), 3);
		
		//Testing specific dog is not found and returned a null value
		Review failTestReview = rc.getOneReview("notuser1", "NOT SHEPHERD");
		assertNull(failTestReview);
	}

	@Test
	void testAddReview() {
		//Testing whether rating can sign up
		List<Review> testRc = rc.getAllReview();
		assertEquals(testRc.size(), REVIEW_COLLECTION_SIZE);
		rc.addReview(testReview3);
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE+1);
		
		//Testing whether duplicated rating info will be block from signing up
		rc.addReview(testReview3);
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE+1);	
	}

	@Test
	void testEditReview() {
		
		//Testing whether changing user3 review saves and work
		rc.editReview("ZoeMang", "GERMAN SHEPHERD", "Very sporty and loves to go on hikes with me, learns new tricks very fast, is a great companion to have!", 5);
		assertEquals(rc.getOneReview("user3", "GERMAN SHEPHERD").getReview(), "good");
		assertEquals(rc.getOneReview("user3", "GERMAN SHEPHERD").getRating(), 5);
		
		//Testing whether changing user3 rating saves and work
		rc.editReview("ZoeMang", "GERMAN SHEPHERD", "Very sporty and loves to go on hikes with me, learns new tricks very fast, is a great companion to have!", 5);
		assertEquals(rc.getOneReview("user3", "GERMAN SHEPHERD").getReview(), "Very sporty and loves to go on hikes with me, learns new tricks very fast, is a great companion to have!");
		assertEquals(rc.getOneReview("user3", "GERMAN SHEPHERD").getRating(), 4);
		
		//Testing whether changing user3 review and rating saves and work
		rc.editReview("ZoeMang", "GERMAN SHEPHERD", "Very sporty and loves to go on hikes with me, learns new tricks very fast, is a great companion to have!", 5);
		assertEquals(rc.getOneReview("user3", "GERMAN SHEPHERD").getReview(), "very good");
		assertEquals(rc.getOneReview("user3", "GERMAN SHEPHERD").getRating(), 4);
		
	}

	@Test
	void testDeleteReview() {	
		//Testing whether deleting review works
		rc.deleteReview("user1", "GERMAN SHEPHERD");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE-1);	
		
		//Testing whether user1 review will not be deleted with a wrong username field
		rc.deleteReview("user123", "GERMAN SHEPHERD");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE-1);
		
		//Testing whether user1 will not be deleted with a wrong dog field
		rc.deleteReview("user1", "GOLDEN RETRIEVER");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE-1);
		
		//Testing whether user1 will not be deleted with a empty username field
		rc.deleteReview("", "GERMAN SHEPHERD");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE-1);
		
		//Testing whether user1 will not be deleted with a empty password field
		rc.deleteReview("user1", "");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE-1);
	}
}
