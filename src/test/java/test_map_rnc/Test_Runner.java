package test_map_rnc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Runner extends Setups {

	Test_Runner tn;
	Set<String> c_n_r_v; //company_name_rating_votes

	@Test(priority = 1)
	public void search() {

		WebElement searchBox = dr.findElement(By.id("searchboxinput"));

		wait.until(ExpectedConditions.elementToBeClickable(searchBox)).click();

		searchBox.sendKeys(searchData);
		dr.findElement(By.xpath(".//button[@id='searchbox-searchbutton']")).click();


	}

	@Test(priority = 2)
	public void resultList() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='feed']")));
		System.out.println("list is displayed");

		c_n_r_v= 	new HashSet<String>();
	}


	@Test(priority = 3 , enabled = true)
	public void trila_modem_2() {

		WebElement scrollable = dr.findElement(By.xpath("//div[@role='feed']"));

		wait.until(ExpectedConditions.elementToBeClickable((scrollable)));

		Actions act = new Actions(dr);

		List<WebElement> res_all_Parent_Card = dr.findElements(By.xpath("//div[@class='UaQhfb fontBodyMedium']"));

		for (WebElement each : res_all_Parent_Card) {			
			String newText="";			
			try {
				String c_name = each.findElement(By.xpath(".//div[@class='qBF1Pd fontHeadlineSmall ']")).getText();
				String c_rating_str = each.findElement(By.xpath(".//span[@class='MW4etd']")).getText();				
				String c_voters_str = each.findElement(By.xpath(".//span[@class='UY7F9']")).getText();
				
				newText = c_name+"@"+c_rating_str+"@"+c_voters_str;
				c_n_r_v.add(newText);				
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		//	//	//	//	//
		WheelInput.ScrollOrigin s_org = WheelInput.ScrollOrigin.fromElement(scrollable);
		act.scrollFromOrigin(s_org, 0, 190).perform();


		try {

			WebElement bottom= dr.findElement(By.xpath(".//span[contains(text(),  'end of the list' )]"));
			act.moveToElement(bottom).build().perform();

			System.out.println("got text > "+bottom.getText());
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}
	}
	
	@Test(priority = 5)
	public void folter_Result() {
		
		for (String dataSet : c_n_r_v ) {
//			System.out.println("a > "+dataSet);
			
			String[] hld= dataSet.split("@");
			
			String cName=  hld[0];
			String cRating=  hld[1];
			String cVotes=  hld[2];
			
//			System.out.println("name > "+cName);
//			System.out.println("rating > "+cRating);
//			System.out.println("votes > "+cVotes);
		
			
			
			Float t_Rating= Float.parseFloat(cRating);    			//
//			System.out.println("127");
			
			String temp ="";
			if(cVotes.length() < 6) {
//				System.out.println("131 "+ cVotes.length());
				
				for(int q=1; q< (cVotes.length()-1); q++) {
					temp= temp+cVotes.charAt(q);
				}
//				System.out.println("temp is "+temp);
			}
			
			if(cVotes.length() == 7) {
				temp = temp+cVotes.charAt(1)+"000";
//				System.out.println("140");
			}
			
			if(cVotes.length() == 8) {
				temp = temp+cVotes.charAt(1)+"0000";
//				System.out.println("145");
			}
			
			
			int t_Votes= Integer.parseInt(temp); 				//
//			System.out.println("149");
			
			if((t_Votes >= baseVoter) && (t_Rating >= baseRating)) {
//				System.out.println("152");
				System.out.println("result name : "+cName);
				System.out.println("");
			}

		
		}
		
	}
	

	
	


}	














































