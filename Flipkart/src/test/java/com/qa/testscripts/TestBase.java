package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.FlipkartPages;

public class TestBase {
	WebDriver driver;
	FlipkartPages Fp;
	JavascriptExecutor js;
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setup(String Browser, String Url) {
		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\91889\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\91889\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		Fp = new FlipkartPages(driver);
		js = (JavascriptExecutor) driver;
		
		driver.get(Url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(Source, target);
		System.out.println("Screenshot is captured");
	}

}
