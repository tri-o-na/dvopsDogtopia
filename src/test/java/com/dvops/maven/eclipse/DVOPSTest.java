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
	  UserCollection userCollection = new UserCollection();
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
  
  @Test(priority = 1)
  public void checkSignUp() {
	  	//Note: Must have server running to access the following test.
	  	webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");
	    
	    //For some reason selenium doesnt want to cooperate, so I decided to do a more "horrible" fix and make it work.
	    //Just making the window be clickable, idk why selenium really likes to click outside of the area. 
	    webDriver.manage().window().setSize(new Dimension(1388, 824));
	    
	    webDriver.findElement(By.linkText("Sign Up")).click();
	    webDriver.findElement(By.name("rusername")).click();
	    webDriver.findElement(By.name("rusername")).sendKeys("testuser1");
	    webDriver.findElement(By.name("remail")).click();
	    webDriver.findElement(By.name("remail")).sendKeys("testuser1@gmail.com");
	    webDriver.findElement(By.name("rpassword")).click();
	    webDriver.findElement(By.name("rpassword")).sendKeys("testpassword1");
	    webDriver.findElement(By.cssSelector(".formButton")).click();
	    
	    //Confirm that it works by comparing the Text inside accountTitle.
	    Assert.assertEquals(webDriver.findElement(By.className("accountTitle")).getText(), "Please sign in.");
	  } 
  
  @Test(priority = 2)
  public void checkLogin() {
	  	//Note: Must have server running to access the following test.
	  	webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");
	    
	    //For some reason selenium doesnt want to cooperate, so I decided to do a more "horrible" fix and make it work.
	    //Just making the window be clickable, idk why selenium really likes to click outside of the area. 
	    webDriver.manage().window().setSize(new Dimension(1388, 824));
	    
	    webDriver.findElement(By.linkText("Sign Up")).click();
	    webDriver.findElement(By.linkText("Have An Account? Sign In Here")).click();
	    webDriver.findElement(By.name("lusername")).click();
	    webDriver.findElement(By.name("lusername")).sendKeys("testuser1");
	    webDriver.findElement(By.name("lpassword")).click();
	    webDriver.findElement(By.name("lpassword")).sendKeys("testpassword1");
	    webDriver.findElement(By.cssSelector(".formButton")).click();

	    
	    //Confirm that it works by comparing the Text inside accountTitle.
	    Assert.assertEquals(webDriver.findElement(By.id("navAccount")).getText(), "ACCOUNT");
	  } 
  
  @Test(priority = 3)
  public void checkLogOut() {
	  
	  	//Note: Must have server running to access the following test.
	  	webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");
	    
	    //For some reason selenium doesnt want to cooperate, so I decided to do a more "horrible" fix and make it work.
	    //Just making the window be clickable, idk why selenium really likes to click outside of the area. 
	    webDriver.manage().window().setSize(new Dimension(1388, 824));
	    webDriver.findElement(By.className("top_title_logout")).click();
	    webDriver.switchTo().alert().accept();
	    
	    //Confirm that it works by comparing the Text inside accountTitle.
	    Assert.assertEquals(webDriver.findElement(By.className("top_title_main")).getText(), "HOME");
	  } 
  
  @Test(priority = 3)
  public void checkUpdateUser() {
	  	//Note: Must have server running to access the following test.
	  	webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");
	    
	    //For some reason selenium doesnt want to cooperate, so I decided to do a more "horrible" fix and make it work.
	    //Just making the window be clickable, idk why selenium really likes to click outside of the area. 
	    webDriver.manage().window().setSize(new Dimension(1388, 824));
	    
	    webDriver.findElement(By.linkText("Sign Up")).click();
	    webDriver.findElement(By.linkText("Have An Account? Sign In Here")).click();
	    webDriver.findElement(By.name("lusername")).click();
	    webDriver.findElement(By.name("lusername")).sendKeys("testuser2");
	    webDriver.findElement(By.name("lpassword")).click();
	    webDriver.findElement(By.name("lpassword")).sendKeys("testpassword2");
	    webDriver.findElement(By.cssSelector(".formButton")).click();
	    
	    webDriver.findElement(By.linkText("ACCOUNT")).click();
	    webDriver.findElement(By.name("epassword")).sendKeys("3");
	    webDriver.findElement(By.name("updateUser")).click();
	    webDriver.findElement(By.className("top_title_logout")).click();
	    webDriver.switchTo().alert().accept();
	    
	    webDriver.findElement(By.linkText("Sign Up")).click();
	    webDriver.findElement(By.linkText("Have An Account? Sign In Here")).click();
	    webDriver.findElement(By.name("lusername")).click();
	    webDriver.findElement(By.name("lusername")).sendKeys("testuser2");
	    webDriver.findElement(By.name("lpassword")).click();
	    webDriver.findElement(By.name("lpassword")).sendKeys("testpassword23");
	    webDriver.findElement(By.cssSelector(".formButton")).click();	    

	    
	    //Confirm that it works by comparing the Text inside accountTitle.
	    Assert.assertEquals(webDriver.findElement(By.id("navAccount")).getText(), "ACCOUNT");
	  } 
  
  @Test(priority = 4)
  public void checkDeleteUser() {
	  	//Note: Must have server running to access the following test.
	  	webDriver.navigate().to("http://localhost:8080/dvopsDogtopia/DogServlet/home");
	    
	    //For some reason selenium doesnt want to cooperate, so I decided to do a more "horrible" fix and make it work.
	    //Just making the window be clickable, idk why selenium really likes to click outside of the area. 
	    webDriver.manage().window().setSize(new Dimension(1388, 824));
	    
	    webDriver.findElement(By.linkText("Sign Up")).click();
	    webDriver.findElement(By.linkText("Have An Account? Sign In Here")).click();
	    webDriver.findElement(By.name("lusername")).click();
	    webDriver.findElement(By.name("lusername")).sendKeys("testuser2");
	    webDriver.findElement(By.name("lpassword")).click();
	    webDriver.findElement(By.name("lpassword")).sendKeys("testpassword23");
	    webDriver.findElement(By.cssSelector(".formButton")).click();
	    
	    webDriver.findElement(By.linkText("ACCOUNT")).click();
	    webDriver.findElement(By.name("deleteUser")).click();
	    
	    webDriver.findElement(By.linkText("Sign Up")).click();
	    webDriver.findElement(By.linkText("Have An Account? Sign In Here")).click();
	    webDriver.findElement(By.name("lusername")).click();
	    webDriver.findElement(By.name("lusername")).sendKeys("testuser2");
	    webDriver.findElement(By.name("lpassword")).click();
	    webDriver.findElement(By.name("lpassword")).sendKeys("testpassword23");
	    webDriver.findElement(By.cssSelector(".formButton")).click();	    

	    
	    //Confirm that it works by comparing the Text inside accountTitle.
	    Assert.assertEquals(webDriver.switchTo().alert().getText(), "User does not exist, or inputted User/Password incorrect");
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