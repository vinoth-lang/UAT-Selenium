package common_things;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Before_After_Login {
	
	public static WebDriver driver = null;
	public static Properties properties = null;
	
	 

	/**
	 * This Method is used to load the property file and Return
	 * 
	 * @return
	 * @throws IOException
	 */

	public Properties load_PropertyFile() throws IOException {
		FileInputStream file = new FileInputStream("Config.properties");
		properties = new Properties();
		properties.load(file);
		return properties;
	}

	@BeforeSuite
	public void launch_browser() throws IOException, InterruptedException {
		load_PropertyFile();
		String browser = properties.getProperty("Browser");
		String url = properties.getProperty("url");
		String driverlocation = properties.getProperty("DriverLocation");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverlocation);
			//driver = new ChromeDriver();
			ChromeOptions ChromeOptions = new ChromeOptions();				
			ChromeOptions.addArguments("--window-size=1920,1080");
			ChromeOptions.addArguments("--disable-extensions");
			ChromeOptions.addArguments("--proxy-server='direct://'");
			ChromeOptions.addArguments("--proxy-bypass-list=*");
			ChromeOptions.addArguments("--start-maximized");
			ChromeOptions.addArguments("--headless");
			ChromeOptions.addArguments("--disable-gpu");
			ChromeOptions.addArguments("--disable-dev-shm-usage");
			ChromeOptions.addArguments("--no-sandbox");
			ChromeOptions.addArguments("--ignore-certificate-errors");
			
			driver = new ChromeDriver(ChromeOptions);
		
			
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gekco.driver", driverlocation);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	}

	@AfterSuite
	public void tear_down() {

		driver.quit();
	}

}
