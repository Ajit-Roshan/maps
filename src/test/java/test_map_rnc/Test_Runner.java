package test_map_rnc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Scroll;

public class Test_Runner extends Scroll {
	
	WebDriverWait wait;
	Test_Runner tn;
	
	@Test(priority = 1)
	public void search() {
		
		wait= new WebDriverWait(dr, Duration.ofSeconds(10));
		
		WebElement searchBox= dr.findElement(By.id("searchboxinput"));
		
		wait.until(ExpectedConditions.elementToBeClickable(searchBox)).click();
		
		searchBox.sendKeys("company in ranchi" , Keys.RETURN);
		
	}
	
	
	@Test(priority = 2)
	public void resultList() {
		
//		WebElement resList= dr.findElement(By.xpath("//div[@role='feed']"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='feed']")));
		System.out.println("list is displayed");
	}
	
	
	@Test(priority = 3)
	public void end_of_Search() {
		
		tn= new Test_Runner();
		tn.scrollActions();
		
		WebElement end_Line_Search= dr.findElement(By.xpath("//span[@class='HlvSq']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(end_Line_Search));
		
		boolean end_line_status= end_Line_Search.isDisplayed();
		
		if(end_line_status == false) {
			
			Assert.fail();
		}
		
	}
	
}






































