package SeleniumPlus;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test4 {
	
	@Test
	public void testProducts(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://hdfcbank.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.className("popupCloseButton")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement loans= driver.findElement(By.xpath("//*[@id='main']/div/div[13]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[2]/div/ul/li[5]"));
		js.executeScript("arguments[0].click()", new Object[]{loans});
		
		WebElement d=driver.findElement(By.className("drp2"));
		List<WebElement> li=d.findElements(By.tagName("li"));
		Assert.assertEquals(18,li.size()-1);
		System.out.println(li.size());
		
	}
}
