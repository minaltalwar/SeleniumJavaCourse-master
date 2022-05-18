package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropBoxHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Work\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.jquery-az.com/jquery/demo.php?ex=152.0_1"); // enter URL
        driver.findElement(By.xpath("//button[@id='btndropdown']")).click();
        // Method 1:
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Bootstrap']")).click();
        Thread.sleep(2000);
        //Method 2:
        // 1stly i am unchecking what we have selected then method 2 implementation:
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Bootstrap']")).click();
        Thread.sleep(2000);
        List<WebElement> list =  driver.findElements(By.xpath("//ul[contains(@class , 'dropdown-menu')]//li//label"));
        System.out.println(list.size());
        
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i).getText());
        	if (list.get(i).getText().contains("Bootstrap")) {
        		list.get(i).click();
        		break;
			}
			
		}
        
	}

}
