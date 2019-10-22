package SeleniumPlus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1{
	
	@Test
	public void testCreditCards(){
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement E =driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement W= driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
		Actions action= new Actions(driver);
		action.dragAndDrop(E, W).perform();
		//action.moveToElement(driver.findElement(By.xpath(""))).perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
		String S= driver.findElement(By.xpath("ctl00_ContentPlaceholder1_Label1")).getText();
		
		Assert.assertTrue(S.endsWith("99"));
		
	}

}
