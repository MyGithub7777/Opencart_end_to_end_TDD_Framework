package baselayer;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pagelayer.Homepage;
import pagelayer.Registerpage;

public class BaseClass {

	public static WebDriver driver;
	public Homepage homepage_obj;
	public Registerpage registerpage_obj;
	public static Logger logger;
	
	
	@BeforeTest
	public void start() {
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String logFile = "./log/testlog_" + timestamp + ".log";

		System.setProperty("logFile", logFile);
		
		logger = Logger.getLogger("*** Test Data Driven Opencart Project ***");
		PropertyConfigurator.configure("log4jfile.properties");
		
		logger.info("-------- Open cart framework execution started --------");
	}
	
	@AfterTest
	public void finish() {
		logger.info("-------- Open cart framework execution finish --------");
	}
	
	@BeforeMethod
	public void setUp() {
		
		String browser_name = "chrome";
		
		if(browser_name.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Provide valid browser name");
		}
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Object creation
		homepage_obj = new Homepage(driver);
		registerpage_obj = new Registerpage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
