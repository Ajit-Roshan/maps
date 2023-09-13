package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import test_map_rnc.Setups;

public class Scroll extends Setups {

	public void scrollActions() {		
		
		System.out.println("in scroll");
		
		WebElement scrollable= dr.findElement(By.xpath("//div[@role='feed']"));
		
		System.out.println("scroll elemenrt is ffound");
		
		Actions act= new Actions(dr);	
		WheelInput.ScrollOrigin s_org= WheelInput.ScrollOrigin.fromElement(scrollable);
		act.scrollFromOrigin(s_org, 0, 100);
				
	}
	
	
	
}
