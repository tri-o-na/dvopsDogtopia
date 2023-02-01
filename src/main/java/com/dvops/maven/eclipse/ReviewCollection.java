package com.dvops.maven.eclipse;

import java.util.*;

public class ReviewCollection { 
	public ArrayList<Review> reviews = new ArrayList<>();
	public ReviewCollection() {
		reviews.add(new Review("user2", "GERMAN SHEPHERD", "Has separation anxiety,  is extremely active, very loyal, protects all, good at tricks", 3));
		reviews.add(new Review("JaneTan", "GOLDEN RETRIEVER", "Leaves fur all over the house, very fun to play with", 4));
		reviews.add(new Review("ZoeMang", "GERMAN SHEPHERD", "Very sporty and loves to go on hikes with me, learns new tricks very fast, is a great companion to have!", 5));
	}
	
	public List<Review> getAllReview(){
		return reviews;
	}
	
	public List<Review> getOneDogReview(String dogName) {
		ArrayList<Review> dogReviews = new ArrayList<>();
    	for (Review r : reviews) { 		      
            if(r.getDogName().equals(dogName)) dogReviews.add(r);
       }
    	if(dogReviews.size() != 0 || dogReviews != null) {
    		List<Review> finalList  = dogReviews; 
    		return finalList;
    	}
    	else {
    		return null;
    	}
	}
	
	public Review getOneReview(String username, String dogName) {
    	for (Review r : reviews) { 		      
            if(r.getDogName().equals(dogName) && r.getUsername().equals(username)) return r;
       }
    	return null;
	}
//	public Review addReview(String username, String review, int rating) {
//    	for (Review r : reviews) { 		      
//            if(r.getUsername().equals(username) && r.getPassword().equals(password)) return r;
//       }
//    	return null;
//	}
	
	public boolean addReview (Review review) {
    	for (Review r : reviews) { 		       
            if(r.getUsername().equals(review.getUsername()) && r.getDogName().equals(review.getDogName())) return false;
       } 
        reviews.add(review); 
        return true;  
	}
	
	public void editReview (String username, String dogName, String review, int rating) {
		Review updatedReview = new Review(username, dogName, review, rating);
    	for (Review r: reviews) { 		      
            if(r.getUsername().equals(username) && r.getDogName().equals(dogName)) {
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
