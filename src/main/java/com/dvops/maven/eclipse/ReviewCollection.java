package com.dvops.maven.eclipse;

import java.util.*;

public class ReviewCollection {
	public ArrayList<Review> reviews = new ArrayList<>();
	public ReviewCollection() {
		reviews.add(new Review("user1", "GERMAN SHEPHERD", "Has separation anxiety,  is extremely active, very loyal, protects all, good at tricks", 3));
		reviews.add(new Review("JaneTan", "GERMAN SHEPHERD", "Leaves fur all over the house, very fun to play with", 4));
		reviews.add(new Review("ZoeMang", "GERMAN SHEPHERD", "Very sporty and loves to go on hikes with me, learns new tricks very fast, is a great companion to have!", 5));
	}
	
	public List<Review> getAllReview(){
		return reviews;
	}
	
//	public Review addReview(String username, String review, int rating) {
//    	for (Review r : reviews) { 		      
//            if(r.getUsername().equals(username) && r.getPassword().equals(password)) return r;
//       }
//    	return null;
//	}
	
//	public boolean signUp (Review review) {
//    	for (Review r : reviews) { 		      
//            if(r.getUsername().equals(review.getUsername())) return false;
//
//       }
//        reviews.add(review);
//        return true; 
//	}
	
	public void editReview (String username, String dogName, String review, int rating, String oldpass) {
		Review updatedReview = new Review(username, dogName, review, rating);
    	for (Review r: reviews) { 		      
            if(r.getUsername().equals(username) && r.getDogName().equals(oldpass)) {
            	reviews.set(reviews.indexOf(r), updatedReview);
            };
       }
	}
	
	public boolean deleteReview (String username, String dogName) {
    	for (Review r : reviews) { 		      
            if(r.getUsername().equals(username) && r.getDogName().equals(dogName)) {
            	reviews.remove(r);
            	return true;
            };
       }
    	return false;
	}
}
