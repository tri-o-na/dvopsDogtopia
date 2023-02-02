package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ReviewCollectionTest {
	private ReviewCollection rc = new ReviewCollection();
	private Review testReview1;
	private Review testReview2;
	private Review testReview3;
	private Review testReview4;
	private Review testReview5;
	private final int REVIEW_COLLECTION_SIZE = 3;

	@BeforeEach
	void setUp() throws Exception {
		rc = new ReviewCollection();
		testReview1 = new Review("user2", "GERMAN SHEPHERD",
				"Has separation anxiety,  is extremely active, very loyal, protects all, good at tricks", 3);
		testReview2 = new Review("JaneTan", "GOLDEN RETRIEVER", "Leaves fur all over the house, very fun to play with",
				4);
		testReview3 = new Review("ZoeMang", "GERMAN SHEPHERD",
				"Very sporty and loves to go on hikes with me, learns new tricks very fast, is a great companion to have!",
				5);

		testReview4 = new Review("User4", "GERMAN SHEPHERD",
				"Testing",
				5);
		testReview5 = new Review("User4", "GERMAN SHEPHERD",
				"Testing",
				5);
		rc.addReview(testReview1);
		rc.addReview(testReview2);
		rc.addReview(testReview3);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllReview() {
		System.out.println(rc.getAllReview());
		// Testing that all the reviews are inside.
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE);

		// Testing specific fields being able to retrieved through the list
		List<Review> testRc = rc.getAllReview();
		assertEquals(testRc.get(0).getUsername(), "user2");
		assertEquals(testRc.get(2).getUsername(), "ZoeMang");
	}

	@Test
	void testGetOneDogReview() {
		// Testing specific dog's reviews has been retrieved and all information is
		// correct.
		List<Review> testReview = rc.getOneDogReview("GERMAN SHEPHERD");
		assertEquals(testReview.get(0).getUsername(), "user2");
		assertEquals(testReview.get(0).getDogName(), "GERMAN SHEPHERD");
		assertEquals(testReview.get(0).getReview(),
				"Has separation anxiety,  is extremely active, very loyal, protects all, good at tricks");
		assertEquals(testReview.get(0).getRating(), 3);

		// Testing specific dog is not found and returned a null value
		List<Review> failTestReview = rc.getOneDogReview("NOT SHEPHERD");
		if (failTestReview.isEmpty()) {
			assertEquals(failTestReview.size(), 0);
		}
	}

	@Test
	void testGetOneReview() {
		// Testing specific dog's reviews has been retrieved and all information is correct.
		assertEquals(rc.getOneReview("user2", "GERMAN SHEPHERD").getReview(), "Has separation anxiety,  is extremely active, very loyal, protects all, good at tricks");
		assertEquals(rc.getOneReview("user2", "GERMAN SHEPHERD").getRating(), 3);
		Review testReview = rc.getOneReview("user2", "GERMAN SHEPHERD");
		assertEquals(testReview.getUsername(), "user2");
		assertEquals(testReview.getDogName(), "GERMAN SHEPHERD");
		assertEquals(testReview.getReview(),
				"Has separation anxiety,  is extremely active, very loyal, protects all, good at tricks");
		assertEquals(testReview.getRating(), 3);

		// Testing specific dog is not found and returned a null value
		Review failTestReview = rc.getOneReview("notuser2", "NOT SHEPHERD");
		assertNull(failTestReview);
	}

	@Test
	void testAddReview() {
		// Testing whether rating can sign up
		List<Review> testRc = rc.getAllReview();

		assertEquals(testRc.size(), REVIEW_COLLECTION_SIZE);
		rc.addReview(testReview4);
		testRc = rc.getAllReview();
		for (Review a : testRc) {
			System.out.println(a.getUsername());
			System.out.println(a.getDogName());
			System.out.println(a.getReview());
			System.out.println(a.getRating());
			System.out.println("review ends here");
			System.out.println("");

		}
		assertEquals(testRc.size(), REVIEW_COLLECTION_SIZE + 1);
		
		// Testing whether duplicated rating info will be block from signing up
		rc.addReview(testReview5);
		testRc = rc.getAllReview();
		assertEquals(testRc.size(), REVIEW_COLLECTION_SIZE + 1);
	}

	@Test
	void testEditReview() {
		
		assertEquals(rc.getOneReview("ZoeMang", "GERMAN SHEPHERD").getReview(), "Very sporty and loves to go on hikes with me, learns new tricks very fast, is a great companion to have!");
		assertEquals(rc.getOneReview("ZoeMang", "GERMAN SHEPHERD").getRating(), 5);

		// Testing whether changing ZoeMang review saves and work
		rc.editReview("ZoeMang", "GERMAN SHEPHERD","good",5);
		assertEquals(rc.getOneReview("ZoeMang", "GERMAN SHEPHERD").getReview(), "good");
		assertEquals(rc.getOneReview("ZoeMang", "GERMAN SHEPHERD").getRating(), 5);

		// Testing whether changing ZoeMang rating saves and work
		rc.editReview("ZoeMang", "GERMAN SHEPHERD","good",4); 
		assertEquals(rc.getOneReview("ZoeMang", "GERMAN SHEPHERD").getReview(),"good");
		assertEquals(rc.getOneReview("ZoeMang", "GERMAN SHEPHERD").getRating(), 4);

		// Testing whether changing ZoeMang review and rating saves and work
		rc.editReview("ZoeMang", "GERMAN SHEPHERD","Very good",3);
		assertEquals(rc.getOneReview("ZoeMang", "GERMAN SHEPHERD").getReview(), "Very good");
		assertEquals(rc.getOneReview("ZoeMang", "GERMAN SHEPHERD").getRating(), 3);

	}

	@Test
	void testDeleteReview() {
		// Testing whether deleting review works
		rc.deleteReview("user2", "GERMAN SHEPHERD");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE - 1);

		// Testing whether user2's review will not be deleted with a wrong username
		// field
		rc.deleteReview("user223", "GERMAN SHEPHERD");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE - 1);

		// Testing whether user2's review will not be deleted with a wrong dog field
		rc.deleteReview("user2", "GOLDEN RETRIEVER");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE - 1);

		// Testing whether user2's review will not be deleted with a empty username
		// field
		rc.deleteReview("", "GERMAN SHEPHERD");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE - 1);

		// Testing whether user2's will not be deleted with a empty dog field
		rc.deleteReview("user2", "");
		assertEquals(rc.getAllReview().size(), REVIEW_COLLECTION_SIZE - 1);
	}

}
