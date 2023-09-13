package monitor;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import utils.Scroll;

public class Retry extends Scroll implements IRetryAnalyzer{

	private int start = 0;
	private int end = 150;
	
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(start < end) {
			System.out.println("start > "+start);
			start++ ;
			
			try {
				Thread.sleep(1090);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return true;
		}else {
			return false;			
		}
		
	}

	
	
}
