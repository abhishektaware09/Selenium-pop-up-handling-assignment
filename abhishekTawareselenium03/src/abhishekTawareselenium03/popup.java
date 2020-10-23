package abhishekTawareselenium03;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class popup {
	
	WebDriver driver;
	String url="http://popuptest.com/goodpopups.html";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		
		driver.findElement(By.linkText("Good PopUp #1")).click();

		Set<String>window=driver.getWindowHandles();						

		Iterator<String>a=window.iterator();								

		String parent=a.next();											
		String child=a.next();											

		driver.switchTo().window(child);									

		System.out.println("Child Window : "+driver.getTitle());
		driver.close();														

		driver.switchTo().window(parent);								
		System.out.println("Parent Window : "+driver.getTitle());			
		
	}

}