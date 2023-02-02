package com.dvops.maven.eclipse;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import java.lang.reflect.Method;

import org.openqa.selenium.Dimension;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class DVOPSTest {
	// Note: In the future, when using cssSelector, we can find the values inside a
	// div/img/a/etc using the following format:
	// {div/img/a/etc} [ {attribute(Like src, href, etc)} = "{value of said
	// attribute}" ]

	// declare Selenium WebDriver
	private WebDriver webDriver;

	@Test
	public void checkDogDesc() {
		// Note: Must have server running to access the following test
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		// For some reason selenium doesnt want to cooperate, so I decided to do a more
		// "horrible" fix and make it work
		// Just making the window be clickable, idk why selenium really likes to click
		// outside of the area.
		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		// Find clickable img.
		webDriver.findElement(By.id("GERMAN SHEPHERD")).click();

		// Confirm that it works by comparing the Title of the addReview.jsp.
		AssertJUnit.assertEquals(webDriver.findElement(By.className("dog-title")).getText(), "GERMAN SHEPHERD");
	}

	@Test(priority = 1)
	public void checkSignUp() {
		// Note: Must have server running to access the following test.
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		// For some reason selenium doesnt want to cooperate, so I decided to do a more
		// "horrible" fix and make it work.
		// Just making the window be clickable, idk why selenium really likes to click
		// outside of the area.
		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		webDriver.findElement(By.id("signUpNav")).click();
		webDriver.findElement(By.name("rusername")).click();
		webDriver.findElement(By.name("rusername")).sendKeys("testuser1");
		webDriver.findElement(By.name("remail")).click();
		webDriver.findElement(By.name("remail")).sendKeys("testuser1@gmail.com");
		webDriver.findElement(By.name("rpassword")).click();
		webDriver.findElement(By.name("rpassword")).sendKeys("testpassword1");
		webDriver.findElement(By.cssSelector(".formButton")).click();

		// Confirm that it works by comparing the Text inside accountTitle.
		AssertJUnit.assertEquals(webDriver.findElement(By.className("accountTitle")).getText(), "Please sign in.");
	}

	@Test(priority = 2)
	public void checkLogin() {
		// Note: Must have server running to access the following test.
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		// For some reason selenium doesnt want to cooperate, so I decided to do a more
		// "horrible" fix and make it work.
		// Just making the window be clickable, idk why selenium really likes to click
		// outside of the area.
		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		webDriver.findElement(By.id("signUpNav")).click();
		webDriver.findElement(By.id("loginJspLink")).click();
		webDriver.findElement(By.name("lusername")).click();
		webDriver.findElement(By.name("lusername")).sendKeys("testuser1");
		webDriver.findElement(By.name("lpassword")).click();
		webDriver.findElement(By.name("lpassword")).sendKeys("testpassword1");
		webDriver.findElement(By.cssSelector(".formButton")).click();

		// Confirm that it works by comparing the Text inside accountTitle.
		AssertJUnit.assertEquals(webDriver.findElement(By.id("navAccount")).getText(), "ACCOUNT");
	}

	@Test(priority = 3)
	public void checkLogOut() {

		// Note: Must have server running to access the following test.
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		// For some reason selenium doesnt want to cooperate, so I decided to do a more
		// "horrible" fix and make it work.
		// Just making the window be clickable, idk why selenium really likes to click
		// outside of the area.
		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		webDriver.findElement(By.className("top_title_logout")).click();
		webDriver.switchTo().alert().accept();

		// Confirm that it works by comparing the Text inside accountTitle.
		AssertJUnit.assertEquals(webDriver.findElement(By.className("top_title_main")).getText(), "HOME");

	}

	@Test(priority = 3)
	public void checkUpdateUser() {
		// Note: Must have server running to access the following test.
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		// For some reason selenium doesnt want to cooperate, so I decided to do a more
		// "horrible" fix and make it work.
		// Just making the window be clickable, idk why selenium really likes to click
		// outside of the area.
		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		webDriver.findElement(By.id("signUpNav")).click();
		webDriver.findElement(By.id("loginJspLink")).click();
		webDriver.findElement(By.name("lusername")).click();
		webDriver.findElement(By.name("lusername")).sendKeys("testuser1");
		webDriver.findElement(By.name("lpassword")).click();
		webDriver.findElement(By.name("lpassword")).sendKeys("testpassword1");
		webDriver.findElement(By.cssSelector(".formButton")).click();

		webDriver.findElement(By.id("navAccount")).click();
		webDriver.findElement(By.name("epassword")).sendKeys("3");
		webDriver.findElement(By.name("updateUser")).click();
		webDriver.findElement(By.className("top_title_logout")).click();
		webDriver.switchTo().alert().accept();

		webDriver.findElement(By.id("signUpNav")).click();
		webDriver.findElement(By.id("loginJspLink")).click();
		webDriver.findElement(By.name("lusername")).click();
		webDriver.findElement(By.name("lusername")).sendKeys("testuser1");
		webDriver.findElement(By.name("lpassword")).click();
		webDriver.findElement(By.name("lpassword")).sendKeys("testpassword13");
		webDriver.findElement(By.cssSelector(".formButton")).click();

		// Confirm that it works by comparing the Text inside accountTitle.
		AssertJUnit.assertEquals(webDriver.findElement(By.id("navAccount")).getText(), "ACCOUNT");
		webDriver.findElement(By.className("top_title_logout")).click();
		webDriver.switchTo().alert().accept();
	}

	@Test(priority = 4)
	public void checkDeleteUser() {
		// Note: Must have server running to access the following test.
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		// For some reason selenium doesnt want to cooperate, so I decided to do a more
		// "horrible" fix and make it work.
		// Just making the window be clickable, idk why selenium really likes to click
		// outside of the area.
		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		webDriver.findElement(By.id("signUpNav")).click();
		webDriver.findElement(By.id("loginJspLink")).click();
		webDriver.findElement(By.name("lusername")).click();
		webDriver.findElement(By.name("lusername")).sendKeys("testuser1");
		webDriver.findElement(By.name("lpassword")).click();
		webDriver.findElement(By.name("lpassword")).sendKeys("testpassword13");
		webDriver.findElement(By.cssSelector(".formButton")).click();

		webDriver.findElement(By.id("navAccount")).click();
		webDriver.findElement(By.name("deleteUser")).click();

		webDriver.findElement(By.id("signUpNav")).click();
		webDriver.findElement(By.id("loginJspLink")).click();
		webDriver.findElement(By.name("lusername")).click();
		webDriver.findElement(By.name("lusername")).sendKeys("testuser1");
		webDriver.findElement(By.name("lpassword")).click();
		webDriver.findElement(By.name("lpassword")).sendKeys("testpassword13");
		webDriver.findElement(By.cssSelector(".formButton")).click();

		// Confirm that it works by comparing the Text inside accountTitle.
		AssertJUnit.assertEquals(webDriver.switchTo().alert().getText(),
				"User does not exist, or inputted User/Password incorrect");
		webDriver.switchTo().alert().accept();
	}

	// addreview, edit review, list review, delete review, 1 checking scenario
//		sendKeys is type, click is press, linkText=id
//	  can use testUser2
	@Test(priority = 5)
	public void checkListReviews() {
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		// Find clickable img.
		webDriver.findElement(By.id("GERMAN SHEPHERD")).click();

		// then make sure got reviews
		AssertJUnit.assertEquals(webDriver.findElement(By.className("review-username")).getText(), "user2");
	}

	@Test(priority = 6)
	public void checkAddReview() {
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		// signs in 1st
		webDriver.findElement(By.id("signUpNav")).click();
		webDriver.findElement(By.id("loginJspLink")).click();
		webDriver.findElement(By.name("lusername")).click();
		webDriver.findElement(By.name("lusername")).sendKeys("testuser2");
		webDriver.findElement(By.name("lpassword")).click();
		webDriver.findElement(By.name("lpassword")).sendKeys("testpassword2");
		webDriver.findElement(By.cssSelector(".formButton")).click();

		// Find clickable img.
		webDriver.findElement(By.id("GERMAN SHEPHERD")).click();

		// add a review
		webDriver.findElement(By.className("add-a-review-btn")).click();
		// fill in form
		webDriver.findElement(By.name("rreview")).click();
		webDriver.findElement(By.name("rreview")).sendKeys("great dog to play with");
		webDriver.findElement(By.name("rrating")).click();
		webDriver.findElement(By.name("rrating")).sendKeys("4");
		webDriver.findElement(By.className("formButton")).click();

		// Confirm that it works by comparing the Text inside the alert.
		AssertJUnit.assertEquals(webDriver.switchTo().alert().getText(), "review added");
		webDriver.switchTo().alert().accept();
		webDriver.findElement(By.className("top_title_logout")).click();
		webDriver.switchTo().alert().accept();

	}

	@Test(priority = 7)
	public void checkEditReview() {
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		// add the review
		// signs in 1st
		webDriver.findElement(By.id("signUpNav")).click();
		webDriver.findElement(By.id("loginJspLink")).click();
		webDriver.findElement(By.name("lusername")).click();
		webDriver.findElement(By.name("lusername")).sendKeys("testuser2");
		webDriver.findElement(By.name("lpassword")).click();
		webDriver.findElement(By.name("lpassword")).sendKeys("testpassword2");
		webDriver.findElement(By.className("formButton")).click();

		// Find clickable img.
		webDriver.findElement(By.id("GERMAN SHEPHERD")).click();

		// add a review
		webDriver.findElement(By.className("add-a-review-btn")).click();
		// fill in add review form
		webDriver.findElement(By.name("rreview")).click();
		webDriver.findElement(By.name("rreview")).sendKeys("great dog to play with");
		webDriver.findElement(By.name("rrating")).click();
		webDriver.findElement(By.name("rrating")).sendKeys("4");
		webDriver.findElement(By.className("formButton")).click();
		webDriver.switchTo().alert().accept();

		// Find clickable img.
		webDriver.findElement(By.id("GERMAN SHEPHERD")).click();

		// find editButton
		webDriver.findElement(By.id("editButton")).click();
		// fill in edit review form
		webDriver.findElement(By.name("ureview")).click();
		webDriver.findElement(By.name("ureview")).sendKeys("and for first time owners");
		webDriver.findElement(By.name("urating")).click();
		webDriver.findElement(By.name("urating")).clear();
		webDriver.findElement(By.name("urating")).sendKeys("5");
		webDriver.findElement(By.className("formButton")).click();

		// check alert and logout
		AssertJUnit.assertEquals(webDriver.switchTo().alert().getText(), "review edited");
		webDriver.switchTo().alert().accept();
		webDriver.findElement(By.className("top_title_logout")).click();
		webDriver.switchTo().alert().accept();
	}

	@Test(priority = 8)
	public void checkDeleteReview() { // need addreview 1st that why delete review priority lower than addreview
		webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");

		webDriver.manage().window().setSize(new Dimension(1388, 824));

		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-page-dog-img")));

		// signs in 1st
		webDriver.findElement(By.id("signUpNav")).click();
		webDriver.findElement(By.id("loginJspLink")).click();
		webDriver.findElement(By.name("lusername")).click();
		webDriver.findElement(By.name("lusername")).sendKeys("testuser2");
		webDriver.findElement(By.name("lpassword")).click();
		webDriver.findElement(By.name("lpassword")).sendKeys("testpassword2");
		webDriver.findElement(By.className("formButton")).click();

		// Find clickable img.
		webDriver.findElement(By.id("GERMAN SHEPHERD")).click();

		// add review
		webDriver.findElement(By.className("add-a-review-btn")).click();
		// fill in add review form
		webDriver.findElement(By.name("rreview")).click();
		webDriver.findElement(By.name("rreview")).sendKeys("great dog to play with");
		webDriver.findElement(By.name("rrating")).click();
		webDriver.findElement(By.name("rrating")).sendKeys("4");
		webDriver.findElement(By.className("formButton")).click();
		webDriver.switchTo().alert().accept();

		// Find clickable img.
		webDriver.findElement(By.id("GERMAN SHEPHERD")).click();

		// delete review
		webDriver.findElement(By.className("buttonTrash")).click();

		// Confirm that it works by comparing the Text inside the alert.
		AssertJUnit.assertEquals(webDriver.switchTo().alert().getText(), "review deleted");
		webDriver.switchTo().alert().accept();
		webDriver.findElement(By.className("top_title_logout")).click();
		webDriver.switchTo().alert().accept();
	}

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver.
		// to amend directory path base on your local file path.
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		// System.setProperty("webdriver.chrome.driver", System.getenv("chromedriver"));

		// initialize FirefoxDriver at the start of test.
//	  webDriver = new ChromeDriver();  
		ChromeOptions chrome_options = new ChromeOptions();
		chrome_options.addArguments("--headless");
		webDriver = new ChromeDriver(chrome_options);
		// put chrome_options = window wont open
		// without = see when the window stop

	}

//  @AfterMethod
//  public void logout(Method method) {
//	  if(method.getName().equals("checkLogin") || method.getName().equals("checkUpdateUser")) {
//		    webDriver.manage().window().setSize(new Dimension(1388, 824));
//
//	  }
//  }

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test.
		webDriver.quit();
	}

}