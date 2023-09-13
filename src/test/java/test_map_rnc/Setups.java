package test_map_rnc;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Setups {

	public Properties pf;
	public WebDriver dr;
	public WebDriverWait wait;
	
	
	@BeforeSuite
	public void start() throws Throwable {

		pf= new Properties();
		pf.load(new FileInputStream("src/test/resources/utils/requrement.properties"));
		
		dr= new FirefoxDriver();
		dr.manage().window().maximize();
		
		dr.get(pf.getProperty("url"));
		
		wait= new WebDriverWait(dr, Duration.ofSeconds(20000));
	}
	
	@AfterSuite
	public void end() {
//		dr.close();
		System.out.println("cosing");
	}
	
	
}
