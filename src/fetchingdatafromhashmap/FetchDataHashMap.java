package fetchingdatafromhashmap;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FetchDataHashMap 
{
public WebDriver driver;
	
	@Test
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com");
		
		System.out.println(getcredentialsmap().get("seller"));
		String sellercredentials=getcredentialsmap().get("seller");
		
		driver.findElement(By.id("username")).sendKeys(sellercredentials.split(":")[0]);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(sellercredentials.split(":")[1]);
	}
	
	public static HashMap<String, String> getcredentialsmap()
	{
		HashMap<String, String> usermap=new HashMap<>();
		usermap.put("adminstrator", "admin:manager");
		usermap.put("customer", "pinaki:pinaki@123");
		usermap.put("distributor", "anupam:anupam@123");
		usermap.put("seller", "arup:arup@123");
		return usermap;
	}
}