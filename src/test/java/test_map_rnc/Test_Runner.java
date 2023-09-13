package test_map_rnc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.annotations.Test;

public class Test_Runner extends Setups {
	
	Actions act;
	
	Test_Runner tes;
	
	@Test(priority = 1)
	public void search() {
		
		tes= new Test_Runner();
		tes.sleep(5);
		
		String searchBox= pf.getProperty("search_box_id");
		String searchKeyword= pf.getProperty("search_for");
		
		dr.findElement(By.id(searchBox)).sendKeys(searchKeyword); ;
		
	}
	
	@Test(priority = 2)
	public void scrollResult() {

		tes.sleep(3);
		
		act= new Actions(dr);
		
		String responseList= pf.getProperty("result_list");
		
		WebElement resultList= dr.findElement(By.xpath(responseList));
		
		WheelInput.ScrollOrigin so= WheelInput.ScrollOrigin.fromElement(resultList);
				
		act.scrollFromOrigin(so, 0, 200);
		
	}
	
	@Test(priority = 3)
	public void gtCompany_Name() {		
		
		tes.sleep(2);
		
		String res_comp_name= pf.getProperty("res_comp_name");
		
		WebElement comp_name=dr.findElement(By.xpath(res_comp_name));
		
		String C_Name= comp_name.getText();
		
		System.out.println("name of company is "+C_Name);
		
	}
	
	@Test(priority = 4)
	public void gtCompany_Rating() {		
		
		tes.sleep(2);
		
		String res_comp_rating= pf.getProperty("res_com_rating");
		
		WebElement comp_rating=dr.findElement(By.xpath(res_comp_rating));
		
		String C_Rating= comp_rating.getText();
		
		System.out.println("rating of company is "+C_Rating);
		
	}
	
	@Test(priority = 5)
	public void Rated_by_people() {		
		
		tes.sleep(2);
		
		String res_by_people= pf.getProperty("res_no_people");
		
		WebElement res_by_num=dr.findElement(By.xpath(res_by_people));
		
		String res_NO= res_by_num.getText();
		
		System.out.println("no of feedback "+res_NO);
		
	}
	
}






