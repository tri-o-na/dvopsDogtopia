package com.dvops.maven.eclipse;

import java.util.*;

public class DogCollection {
	public ArrayList<Dog> dogs = new ArrayList<>();
	public DogCollection() {
		dogs.add(new Dog("German Shepherd","55 - 65", "20 - 40", "Black, Black+Tan, Sable, Grey","10 - 14", "$1,500 - $3,000", 4, "german-shepherd.jpg"));
		dogs.add(new Dog("Labrador Retriever","55 - 62", "25 - 40", "Black, Chocolate, Yellow","11 - 13", "$800 - $1,200", 4, "labrador-retriever.jpg"));
	}
	
	public List<Dog> getAllDog(){
		return dogs;
	}
	
	public Dog getOneDog(String dogName) {
    	for (Dog d : dogs) { 		      
            if(d.getDogName().equals(dogName)) return d;
       }
    	return null;
	}
	
	public boolean addDog(Dog dog) {
    	for (Dog d : dogs) { 		      
            if(d.getDogName().equals(dog.getDogName())) return false;
       }
    	dogs.add(dog);
    	return true;
	}
	
	
}
