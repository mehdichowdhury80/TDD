package base;

import static constant.IBConstant.BROWSER;
import static constant.IBConstant.CHROME;
import static constant.IBConstant.EDGE;
import static constant.IBConstant.FIREFOX;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constant.KeyConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utils.ReadConfig;

public class TestBase {

	
	public static WebDriver driver;
	
	ReadConfig config;
	public HomePage hp;
	@BeforeSuite
	public void beforeSuitSetup() throws IOException {
		config = new ReadConfig();
	}

	@Parameters(BROWSER)
	@BeforeMethod
	public void setUp(@Optional (CHROME)String browsername)  {//optional will run if no browser found
		driver = intializingBrowser(browsername);
		driver.manage().window().maximize();
		int pageLoadTime = Integer.parseInt(config.getValue(KeyConfig.pageLoadTime));
		int implicitWaitTime = Integer.parseInt(config.getValue(KeyConfig.impliciteWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.get("https://www.bestbuy.com/");
		//driver.get(config.getValue(KeyConfig.url));
		initObject();
		
		
		
	}
	public WebDriver intializingBrowser(String browsername) {
		switch (browsername) {
		case CHROME: 
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		case FIREFOX:
		WebDriverManager.firefoxdriver().setup();
		case EDGE:
			WebDriverManager.edgedriver().setup();
			default:WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}
		
		
	}	
	/*WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		hp = new HomePage(driver);
		driver.get("https://www.bestbuy.com/");
		System.out.print("We r here");
		Thread.sleep(5000);*/

	public void initObject() {
		hp= new HomePage(driver);
	}

	@AfterMethod

	public void quit() {
		driver.quit();
	}
}