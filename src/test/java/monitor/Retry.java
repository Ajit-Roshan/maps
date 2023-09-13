package monitor;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	private int start = 0;
	private int end = 10;
	
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(start < end) {
			System.out.println("start > "+start);
			start++ ;
			return true;
		}else {
			return false;			
		}
		
	}

	
	
}
