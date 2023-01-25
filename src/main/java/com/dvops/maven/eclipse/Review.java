/**
 * 
 */
package com.dvops.maven.eclipse;

import java.util.Objects;

public class Review {
	private String username;
	private String dogName;
	private String review;
	private int rating;

	public Review(String username, String dogName, String review, int rating) {
		super();
		this.setUsername(username);
		this.setDogName(dogName);
		this.setReview(review);
		this.setRating(rating);
	}
	
	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	
	public String getReview() {
		return review;
	}

	
	public void setReview(String review) {
		this.review = review;
	}


	public int setRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
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
