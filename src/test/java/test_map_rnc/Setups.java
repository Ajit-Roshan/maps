package test_map_rnc;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Setups {

	public Properties pf;
	public WebDriver dr;
	
	
	@BeforeSuite
	public void start() throws Throwable {

		pf= new Properties();
		pf.load(new FileInputStream("src/test/resources/utils/requrement.properties"));
		
		dr= new ChromeDriver();
		dr.manage().window().maximize();
		
		dr.get(pf.getProperty("url"));

	}
	
	@AfterSuite
	public void end() {
		dr.close();
	}
	
}
