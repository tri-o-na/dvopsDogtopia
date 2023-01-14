package com.dvops.maven.eclipse;

public class Dog {
	private String dogName;
	private String heightRange;
	private String weightRange;
	private String colours;
	private String lifeSpan;
	private String priceRange;
	private int rating;
	private String imageFile;
	
	public Dog(String dogName, String heightRange, String weightRange, String colours, String lifeSpan, String priceRange, int rating, String imageFile) {
		super();
		this.setDogName(dogName);
		this.setHeightRange(heightRange);
		this.setWeightRange(weightRange);
		this.setColours(colours);
		this.setLifeSpan(lifeSpan);
		this.setPriceRange(priceRange);
		this.setRating(rating);
		this.setImageFile(imageFile);
	}

	
	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getHeightRange() {
		return heightRange;
	}

	public void setHeightRange(String heightRange) {
		this.heightRange = heightRange;
	}

	public String getWeightRange() {
		return weightRange;
	}

	public void setWeightRange(String weightRange) {
		this.weightRange = weightRange;
	}

	public String getColours() {
		return colours;
	}

	public void setColours(String colours) {
		this.colours = colours;
	}

	public String getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(String lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getImageFile() {
		return imageFile;
	}


	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
}
