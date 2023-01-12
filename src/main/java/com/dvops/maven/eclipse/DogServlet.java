package com.dvops.maven.eclipse;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DogServlet")
public class DogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DogCollection dogCollection = new DogCollection();

	public DogServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DogServlet doGet");
		String action = request.getServletPath(); //Get the route name
		switch (action) {
		case "/DogServlet/desc":
			getDogDesc(request, response);
			break;
		case "/DogServlet/home" :
			listDogs(request, response);
			break;
		}
	}

	private void getDogDesc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		Dog currentDog = new Dog("","","","","","",0,"");
		Dog d = dogCollection.getOneDog(name);
		currentDog = new Dog(d.getDogName(), d.getHeightRange(), d.getWeightRange(), d.getColours(), d.getLifeSpan(), d.getPriceRange(), d.getRating(), d.getImageFile());
		request.setAttribute("dog", currentDog);
		request.getRequestDispatcher("/dogDesc.jsp").forward(request, response);
	}

	private void listDogs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dog> dogs = new ArrayList <>();
		System.out.println("DogServlet array");
		for(Dog d : dogCollection.dogs) {
			String dogName = d.getDogName();
			String heightRange = d.getHeightRange();
			String weightRange = d.getWeightRange();
			String colours = d.getColours();
			String lifeSpan = d.getLifeSpan();
			String priceRange = d.getPriceRange();
			int rating = d.getRating();
			String imageFile = d.getImageFile();
			
			dogs.add(new Dog(dogName, heightRange, weightRange, colours, lifeSpan, priceRange, rating, imageFile));
			System.out.println(d.getDogName());
		}
		System.out.println(dogCollection.dogs);
		request.setAttribute("listDogs", dogs);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DogServlet doPost");
		doGet(request, response);
	}

}
