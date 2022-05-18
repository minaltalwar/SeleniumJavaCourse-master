package SeleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Work\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//	driver.get("https://makemysushi.com/404"); // enter URL
		driver.get("https://classic.crmpro.com/"); // enter URL
				
		driver.findElement(By.name("username")).sendKeys("minalt");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);
		
	driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
	
		//links --- starts with //a
		//images ---starts with //img
		//1. get the list of all the links and images
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Total links and Images (Active + Inactive)---->"+linklist.size());
		
		List<WebElement> activeList = new ArrayList<WebElement>();
		
		//2. iterate linklist: exclude all the links/images that dosen't have any href attribute
		for (int i = 0; i < linklist.size(); i++) {
			System.out.println(linklist.get(i).getAttribute("href"));
			// now we need href that are not null and that donot start with javascript
			if (linklist.get(i).getAttribute("href") != null && (! linklist.get(i).getAttribute("href").contains("javascript"))) {
				activeList.add(linklist.get(i)); // if linklist.i contains href='some link' means ataribute of href is not null,e,g href = "" - this is null , href = 'http://a.www.com' - this is not null, then add it in activeList array
							
			}
		}
		
		//get the size of active links and images and print
		System.out.println("Active Links and Images ----> "+activeList.size());
		
		//3. check the href url, with  httpconnection api:
		// response = 200 (ok) , 404 (not found) , 
		for (int j = 0; j < activeList.size(); j++) {
			
			HttpURLConnection connection = (HttpURLConnection)new URL(activeList.get(j).getAttribute("href")).openConnection();
			connection.connect(); // connect 
			String response = connection.getResponseMessage(); // return ok as response msg if conn is successfull
			connection.disconnect(); // disconnect once response is ok
			System.out.println(activeList.get(j).getAttribute("href")+"------>>>"+response);
			
		}System.out.println("All Checks Completed!");
	}

}
