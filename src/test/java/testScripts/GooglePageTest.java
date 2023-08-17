package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GooglePageTest {
	WebDriver driver;
	
//@BeforeMethod
@BeforeTest
public void setup()
{ 
	driver = new ChromeDriver();
	driver.manage().window().maximize();	
}
	
  //@Test(priority = 1)
@Test
public void searchJavaTest() {
driver.get ("https://www.google.com");
SoftAssert softAssert = new SoftAssert();
softAssert.assertEquals(driver.getTitle(), "Google" );
WebElement srcBox = driver.findElement(By.name("q"));
srcBox.sendKeys("Java Tutorial");
srcBox.sendKeys(Keys.ENTER);
softAssert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
softAssert.assertAll();  
  }
 // @Test(priority = 2)
  @Test
	  public void searchSeleniumTest() {

	driver.get ("https://www.google.com");
	WebElement srcBox = driver.findElement(By.name("q"));
	srcBox.sendKeys("Selenium Tutorial");
	srcBox.sendKeys(Keys.ENTER);
	Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
 
	  }
  @Test(dependsOnMethods = "searchCucumberTest")
  public void searchAppiumTest() {

driver.get ("https://www.google.com");
WebElement srcBox = driver.findElement(By.name("q"));
srcBox.sendKeys("Appium Tutorial");
srcBox.sendKeys(Keys.ENTER);
Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");

  }
  @Test(enabled = true)
  public void searchCucumberTest() {

driver.get ("https://www.google.com");
WebElement srcBox = driver.findElement(By.name("q"));
srcBox.sendKeys("Cucumber Tutorial");
srcBox.sendKeys(Keys.ENTER);
Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search1");

  }
 	  
 	 // @AfterMethod
 	  @AfterTest
 	  
 	  public void threadsDown()
 	  {
 		  driver.close();
 	  }
 	  }
 	  
