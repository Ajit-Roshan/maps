package test_map_rnc;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

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
	
	public String searchData;
	
//	public Scanner sc;
	
	public int baseRating;
	public int baseVoter;
	
	@BeforeSuite
	public void start() throws Throwable {
		
//		sc= new Scanner(System.in);

		
//		System.out.print("what you want to search for in not specific general stuff : ");
//		searchData= sc.nextLine();
//		
//		System.out.print("eneter the base Rating : ");
//		baseRating= sc.nextInt();
//		
//		System.out.print("enter base voter : ");
//		baseVoter= sc.nextInt();
		
		
		pf= new Properties();
		pf.load(new FileInputStream("src/test/resources/utils/requrement.properties"));
		
		
		searchData= pf.getProperty("searchData_from_proFile");
		baseRating= Integer.parseInt(pf.getProperty("baseRating_from_proFile"));
		baseVoter= Integer.parseInt(pf.getProperty("baseVoter_from_proFile"));
		
		dr= new FirefoxDriver();
		dr.manage().window().maximize();
		
		dr.get(pf.getProperty("url"));
		
		wait= new WebDriverWait(dr, Duration.ofSeconds(20000));
	}
	
	@AfterSuite
	public void end() {
		dr.close();
//		System.out.println("cosing");
	}
	
	
}
