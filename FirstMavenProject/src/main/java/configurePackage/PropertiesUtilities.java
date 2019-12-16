package configurePackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesUtilities {
	
	public static WebDriver driver = null;
	
	public  static void login() throws Exception {
		
		
		Properties prop = new Properties();
		File f = new File("C:\\Users\\KAJAL SAYANE\\Desktop\\Selenium WebDriver\\eclipse workspace\\FirstMavenProject\\datadriven.properties");
		FileInputStream fetchData = new FileInputStream(f);
		prop.load(fetchData);		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement enterEmail = driver.findElement(By.id(prop.getProperty("EmailById")));
		enterEmail.sendKeys(prop.getProperty("username"));
		
		driver.findElement(By.xpath(prop.getProperty("nextByxpath"))).click();
		
		WebElement enterPassword = driver.findElement(By.name(prop.getProperty("PasswordByname")));
		enterPassword.sendKeys(prop.getProperty("password"));
		
		driver.findElement(By.xpath(prop.getProperty("nextPByxpath"))).click();
	
		
	}
	

}
