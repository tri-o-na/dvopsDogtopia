package com.dvops.maven.eclipse;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DVOPSTest {
	  //Note: In the future, when using cssSelector, we can find the values inside a div/img/a/etc using the following format:
	  //{div/img/a/etc} [ {attribute(Like src, href, etc)} = "{value of said attribute}" ]
	
	  //declare Selenium WebDriver
	  private WebDriver webDriver;	
  @Test
  public void checkDogDesc() {
	  	//Note: Must have server running to access the following test
	    webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");
	    
	    //For some reason selenium doesnt want to cooperate, so I decided to do a more "horrible" fix and make it work
	    //Just making the window be clickable, idk why selenium really likes to click outside of the area. 
	    webDriver.manage().window().setSize(new Dimension(1388, 824));
	    
	    //Find clickable img. 
	    webDriver.findElement(By.id("GERMAN SHEPHERD")).click();
	    
	    //Confirm that it works by comparing the Title of the addReview.jsp.
	    Assert.assertEquals(webDriver.findElement(By.className("dog-title")).getText(), "GERMAN SHEPHERD");
	  }
  
  
  @Test
  public void checkSignUp() {
	  	//Note: Must have server running to access the following test.
	    webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/");
	    
	    //For some reason selenium doesnt want to cooperate, so I decided to do a more "horrible" fix and make it work.
	    //Just making the window be clickable, idk why selenium really likes to click outside of the area. 
	    webDriver.manage().window().setSize(new Dimension(1388, 824));
	    
	    //Find and click signUp page link.
	    webDriver.findElement(By.cssSelector("a[href='signUp.jsp']")).click();
	    
	    //Find and click login page link.
	    webDriver.findElement(By.cssSelector("a[href='login.jsp']")).click();
	    
	    //Confirm that it works by comparing the Text inside accountTitle.
	    Assert.assertEquals(webDriver.findElement(By.className("accountTitle")).getText(), "Please sign in.");
	  }
  
  @Test
  public void checkAboutUs() {
	  	//Note: Must have server running to access the following test.
	    webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/");
	    
	    //For some reason selenium doesnt want to cooperate, so I decided to do a more "horrible" fix and make it work.
	    //Just making the window be clickable, idk why selenium really likes to click outside of the area. 
	    webDriver.manage().window().setSize(new Dimension(1388, 824));
	    
	    //Find and click about-us link.
	    webDriver.findElement(By.cssSelector("a[href='about-us.jsp']")).click();
	    
	    //Confirm that it works by comparing the Text inside aboutUsTitle.
	    Assert.assertEquals(webDriver.findElement(By.className("aboutUsTitle")).getText(), "About us");
	  }
  
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver.
	  //to amend directory path base on your local file path.
	  String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test.
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test.
	  webDriver.quit();	
  }

}