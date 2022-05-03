package fetchingdatafromarray;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class fdfoarray
{
public WebDriver driver;
@BeforeMethod
public void setup()
{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    driver=new ChromeDriver();
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://demo.actitime.com");
}
@DataProvider(name="logindata")
public Object[][] passdata()
{
Object[][] data=new Object[5][2];
data[0][0]="anupam";
data[0][1]="sahoo";
data[1][0]="pintu";
data[1][1]="mohanty";
data[2][0]="chintu";
data[2][1]="mohantyy";
data[3][0]="monalisa";
data[3][1]="sutar";
data[4][0]="admin";
data[4][1]="manager";
return data;

}
@Test(dataProvider = "logindata")
public void login(String username,String password) throws InterruptedException
{
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
	driver.findElement(By.id("loginButton")).click();
	Thread.sleep(2000);
	String actualtitle=driver.getTitle();
	System.out.println(actualtitle);
	if(actualtitle.contains("Enter"))
	{
		System.out.println("redirect to homepage");
	}
	else
	{
		System.out.println("invalid username and password");
	}
}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
