package com.qa.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPages {
	WebDriver driver;
	@FindBy(xpath="//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]")
	WebElement Login;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement Email;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	WebElement Password;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
	WebElement LoginBtn;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement SearchForProduct;
	
	@FindBy(xpath="//a[contains(text(),'Cadbury Madbury Bars')]")
	WebElement ClickOnProduct;
	
	
	
	@FindBy(xpath="//span[contains(text(),'Your username or password is incorrect')]")
	WebElement ErrorMsg;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	WebElement MyAccount;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement BuyNowBtn;
	
	public WebElement getBuyNowBtn() {
		return BuyNowBtn;
	}
	
	@FindBy(xpath="//div[contains(text(),'Logout')]")
	WebElement Logout;
	
	public WebElement getLogin() {
		return Login;
		
	}
	public WebElement getEmail() {
		return Email;                                                  
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	public WebElement getSearchForProduct() {
		return SearchForProduct;
	}
	public WebElement getMyAccount() {
		return MyAccount; 
	}
	public WebElement getClickOnProduct() {
		return  ClickOnProduct;
	}
	

	public WebElement getErrorMsg() {
		return ErrorMsg;
	}
	
	public WebElement Logout() {
		return Logout;
	}
	
	public FlipkartPages(WebDriver driver) {
		this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	

}

