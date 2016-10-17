package webSite1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class WebSite1Auto {
	String browser;
	WebDriver driver;
	

	@BeforeTest
	@Parameters ("browser")
	public void openBrowser(String browser){
		if(browser.equalsIgnoreCase("Chrome")){
			driver = new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("FireFox")){
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Safari")){
			driver = new SafariDriver();
		}
	driver.get("http://prograwebjuevesn4.esy.es/index.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void verifyTitle(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expectedTitle = "Equipo #3";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void clickPages(){
		driver.findElement(By.xpath("/html/body/nav/div/i")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/nav/ul/li[3]/a")));
		driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expectedTitle = driver.getTitle();
		String actualTitle = "Practica #1";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@AfterMethod
	public void returnPage(){
		driver.navigate().back();
	}
	@Test
	public void clickPages2(){
		driver.findElement(By.xpath("/html/body/nav/div/i")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/nav/ul/li[4]/a")));
		driver.findElement(By.xpath("/html/body/nav/ul/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expectedTitle = driver.getTitle();
		String actualTitle = "Practica #2";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void clickPages3(){
		
		driver.findElement(By.xpath("/html/body/nav/div/i")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/nav/ul/li[5]/a")));
		driver.findElement(By.xpath("/html/body/nav/ul/li[5]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expectedTitle = driver.getTitle();
		String actualTitle = "Practica #3";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@AfterTest
	public void driverQuite(){
		driver.quit();
	}
}
