package test_map_rnc;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Scroll;

public class Test_Runner extends Scroll {

	Test_Runner tn;
	Set<String> comanyName;
	
	@Test(priority = 1)
	public void search() {

		WebElement searchBox = dr.findElement(By.id("searchboxinput"));

		wait.until(ExpectedConditions.elementToBeClickable(searchBox)).click();

		searchBox.sendKeys("software company in ranchi", Keys.ENTER);

	}

	@Test(priority = 2)
	public void resultList() {

//		WebElement resList= dr.findElement(By.xpath("//div[@role='feed']"));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='feed']")));
		System.out.println("list is displayed");
		
		comanyName= new LinkedHashSet<String>();
	}

	@Test(priority = 3)
	public void end_of_Search() {

		System.out.println("in scroll");

		WebElement scrollable = dr.findElement(By.xpath("//div[@role='feed']"));

		wait.until(ExpectedConditions.elementToBeClickable((scrollable)));

		System.out.println("scroll elemenrt is found");

		Actions act = new Actions(dr);
		WheelInput.ScrollOrigin s_org = WheelInput.ScrollOrigin.fromElement(scrollable);
		act.scrollFromOrigin(s_org, 0, 190).perform();
		
		WebElement res_Parent_Card= dr.findElement(By.xpath("//div[@class='UaQhfb fontBodyMedium']"));
		
//		List<WebElement> list_company= dr.findElements(By.xpath("//div[@class='NrDZNb']//div[2]"));		

		List<WebElement> list_company= res_Parent_Card.findElements(By.xpath("//div[@class='NrDZNb']//div[2]"));		
				
		for (WebElement each_Comp: list_company) {
				comanyName.add(each_Comp.getText());
		}
		
		try {
			WebElement bottom= dr.findElement(By.xpath("//span[contains(text() , 'You')]"));
			act.moveToElement(bottom).build().perform();
			
			System.out.println("got text > "+bottom.getText());
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}

	}
	
	@Test(priority = 4)
	public void printList() {
		int i= 1;
		
		for(String name: comanyName) {
			System.out.println(i+" - "+name);
			i++;
		}
		
	}

}

















