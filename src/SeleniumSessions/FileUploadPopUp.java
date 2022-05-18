package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://html.com/input-type-file/");
		// type = "file" should be present for browser/attach file/UploadFile button
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:/Users/etlwmnl/Pictures/Saved Pictures/key-lime");
		
		
		
	}

}
