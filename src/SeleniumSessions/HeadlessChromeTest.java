package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Work\\chromedriver.exe");
		
		//// ---------- Code for headless browser--------------- ////
		ChromeOptions options= new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options); // launch chrome
		//// ---------- Code for headless browser ends here --------------- ////
		
		
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com/"); // enter URL
		
	    System.out.println(driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.getTitle());
	}

}
