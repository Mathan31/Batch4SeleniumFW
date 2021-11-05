package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import libraries.HTMLReport;
import utilities.ExcelReader;
import utilities.PropertiesReader;

public class BaseClass extends HTMLReport{
	
	public WebDriver driver;
	public int iBrowserType = 1; // 1-Chrome,2-FF,3-Edge,4-IE
	public String fileName = "Environment_Details";
	public String sURL = PropertiesReader.getPropertyValue(fileName, "production");
	public String sSheetName = "";
	public String testCaseName,testDescription,module;
	
	@BeforeSuite
	public void initReport() {
		startReport();
	}
	
	@AfterSuite
	public void flushReport() {
		endReport();
	}
	
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
		startTestCase(testCaseName, testDescription);
		startTestcase(module);
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

	public String takeScreenshot() {
		String sPath = System.getProperty("user.dir")+"/snap/img"+System.currentTimeMillis()+".png";
		TakesScreenshot oShot = (TakesScreenshot)driver;
		File osrc = oShot.getScreenshotAs(OutputType.FILE);
		File dis = new File(sPath);
		try {
			FileUtils.copyFile(osrc, dis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sPath;
	}

}
