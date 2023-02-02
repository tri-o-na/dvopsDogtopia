package com.dvops.maven.eclipse;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class DogCollectionTest {
	
	private DogCollection dc;
	private Dog testDog1;
	private Dog testDog2;
	private Dog testDog3;
	private Dog testDog4;
	private Dog testDog5;
	private Dog testDog6;
	private final int DOG_COLLECTION_SIZE = 6;
	
	
	@BeforeMethod
	@BeforeEach
	void setUp() throws Exception {
		dc = new DogCollection();
		testDog1 = new Dog("IRISH WOLFHOUND","71 - 86", "40 - 55", "Red, Brindle, Black, Fawn, Gray","6 - 8", "$1,400 - $2,500", 4, "german-shepherd.jpg");
		
	}

	@AfterMethod
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllDog() {
		//Testing that all the dogs are inside.
		AssertJUnit.assertEquals(dc.getAllDog().size(), DOG_COLLECTION_SIZE);
		
		//Testing specific fields being able to retrieved through the list
		List<Dog> testDc = dc.getAllDog();
		AssertJUnit.assertEquals(testDc.get(0).getDogName(), "GERMAN SHEPHERD");
		AssertJUnit.assertEquals(testDc.get(4).getDogName(), "GOLDEN RETRIEVER");
	}

	@Test
	void testGetOneDog() {
		//Testing specific dog has been retrieved and all information is correct.
		Dog testDog = dc.getOneDog("GERMAN SHEPHERD");
		AssertJUnit.assertEquals(testDog.getDogName(), "GERMAN SHEPHERD");
		AssertJUnit.assertEquals(testDog.getHeightRange(), "55 - 65");
		AssertJUnit.assertEquals(testDog.getWeightRange(), "20 - 40");
		AssertJUnit.assertEquals(testDog.getColours(), "Black, Black+Tan, Sable, Grey");
		AssertJUnit.assertEquals(testDog.getLifeSpan(), "10 - 14");
		AssertJUnit.assertEquals(testDog.getPriceRange(), "$1,500 - $3,000");
		AssertJUnit.assertEquals(testDog.getRating(), 4);
		AssertJUnit.assertEquals(testDog.getImageFile(), "german-shepherd.jpg");
		
		//Testing specific dog is not found and returned a null value 
		Dog failTestDog = dc.getOneDog("NOT SHEPHERD");
		AssertJUnit.assertNull(failTestDog);
	}

	@Test
	void testAddDog() {	
		//Testing adding 1 dog and affecting the size of the DogCollection
		List<Dog> testDc = dc.getAllDog();
		AssertJUnit.assertEquals(testDc.size(),DOG_COLLECTION_SIZE);
		dc.addDog(testDog1);
		AssertJUnit.assertEquals(dc.getAllDog().size(), DOG_COLLECTION_SIZE+1);
		
		//Testing adding 1 dog but failed due to duplicated dogName and returned a null value.
		dc.addDog(testDog1);
		AssertJUnit.assertEquals(dc.getAllDog().size(), DOG_COLLECTION_SIZE+1);
		AssertJUnit.assertEquals(dc.addDog(testDog1), false);
	}

}
