package com.qa.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Flipkart_001 extends TestBase{
	
	@Test
	public void Login() throws InterruptedException {
		
			
		Fp.getEmail().sendKeys("9741438530");
		Fp.getEmail().submit();
		Fp.getPassword().sendKeys("Vidya123");
		Fp.getPassword().submit();
		//Fp.getLoginBtn().click();
		Thread.sleep(1000);
		
		
		Fp.getSearchForProduct().sendKeys("choclates");
	    Fp.getSearchForProduct().submit();
	    Thread.sleep(5000);
	    boolean title=driver.getTitle().contains("Choclates");
	    Assert.assertTrue(title);
	   Reporter.log("user is searching for choclates",true);
	    Thread.sleep(1000);
		
	    
	    Fp.getClickOnProduct().click();
	    Thread.sleep(3000);
	    
	    
	    String parent=driver.getWindowHandle();
	    Set<String>s=driver.getWindowHandles();
	    Iterator<String> I1= s.iterator();
	    while(I1.hasNext())
	    {

	    String child_window=I1.next();


	    if(!parent.equals(child_window))
	    {
	    driver.switchTo().window(child_window);
		Fp.getBuyNowBtn().click();
	    }
	    }
	    Thread.sleep(3000);
	    String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order");
		Reporter.log("order placed successfully",true);
	    driver.navigate().back();
	    String xp="//div[contains(text(),'Archana')]";
	    WebElement MyAccount=driver.findElement(By.xpath(xp));
	    Actions action=new Actions(driver);
	    action.moveToElement(MyAccount).perform();
	   // String xp1="//div[contains(text(),'Logout')]";
	   // WebElement Logout=driver.findElement(By.xpath(xp1));
	    
	   // Actions action1=new Actions(driver);
	 //   action1.moveToElement( Logout).build().perform();
	 //   action1.click();
	    Fp.Logout().click();
	    Thread.sleep(3000);
	    
	   
	    
		 boolean title2=driver.getTitle().contains("Online Shopping Site for Mobiles");
		  Assert.assertTrue(title2);
		   Reporter.log("logged out",true);
	 
	  
	   
	   
	   
	   
	   
	   
	   
	}
}


