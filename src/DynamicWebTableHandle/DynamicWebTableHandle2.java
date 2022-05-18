package DynamicWebTableHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Work\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com/"); // enter URL
		
		driver.findElement(By.name("username")).sendKeys("minalt");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);
		
	driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		//form[@id='vContactsForm']//tr[4]//td[2]
		//form[@id='vContactsForm']//tr[5]//td[2]
		//form[@id='vContactsForm']//tr[6]//td[2]
		String before_xpath = "//form[@id='vContactsForm']//tr[";
		String after_xpath = "]//td[2]";

		//METHOD-1
		for (int i=4 ; i<=6 ; i++)
		{
		String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
		System.out.println(name);
		if(name.contains("m5 m5")){
		driver.findElement(By.xpath("//tr["+i+"]//td[1]//input[1]")).click();
			}
		}
		
		//METHOD-2
		//We will use customized xpath
		

	}
	}
