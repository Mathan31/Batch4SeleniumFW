package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;
import utilities.PropertiesReader;

public class BaseClass {
	
	public static WebDriver driver;
	public int iBrowserType = 1; // 1-Chrome,2-FF,3-Edge,4-IE
	public String fileName = "Environment_Details";
	public String sURL = PropertiesReader.getPropertyValue(fileName, "production");
	public String sSheetName = "";
	@BeforeClass
	public void browserInvoke() {

		switch (iBrowserType) {
		case 1:
			System.out.println("User selection is : " + iBrowserType + ",So invoking Chrome Browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User selection is : " + iBrowserType + ",So invoking FF Browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case 3:
			System.out.println("User selection is : " + iBrowserType + ",So invoking Edge Browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("User selection is wrong: " + iBrowserType + ",So invoking the default Chrome Browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider(name="ExcelData")
	public Object[][] getExcelValue(){
		Object[][] data = ExcelReader.getSheet(sSheetName);
		return data;
	}

}
