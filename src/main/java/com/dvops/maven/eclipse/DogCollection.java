package com.dvops.maven.eclipse;

import java.util.*;

public class DogCollection {
	public ArrayList<Dog> dogs = new ArrayList<>();
	public DogCollection() {
		dogs.add(new Dog("GERMAN SHEPHERD","55 - 65", "20 - 40", "Black, Black+Tan, Sable, Grey","10 - 14", "$1,500 - $3,000", 4, "german-shepherd.jpg"));
		dogs.add(new Dog("LABRADOR RETRIEVER","55 - 62", "25 - 40", "Black, Chocolate, Yellow","11 - 13", "$800 - $1,200", 4, "labrador-retriever.jpg"));
		dogs.add(new Dog("FRENCH BULLDOG","39 - 47", "9 - 14", "White, Brindle, Fawn, Brindle+White, Tan","11 - 14", "$1,500 - $3,000", 4, "french-bulldog.jpg"));
		dogs.add(new Dog("STANDARD POODLE","45 - 60", "20 - 32", "Black, White, Apricot, Cream, Brown","12 - 15", "$500 - $2,000", 3, "standard-poodle.jpg"));
		dogs.add(new Dog("GOLDEN RETRIEVER","51 - 60", "25 - 34", "Dark/Light Golden, Cream, Golden","10 - 12", "$1,000 - $3,500", 5, "golden-retriever.jpg"));
		dogs.add(new Dog("DACHSHUND","33 - 37", "9 - 12", "Black, Cream, Tan, Red, Blue & Tan","12 - 16", "$400 - $1,100", 3, "dachshund.jpg"));
		
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
