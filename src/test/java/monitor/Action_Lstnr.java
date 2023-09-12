package monitor;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Action_Lstnr implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("test failed "+result.getName());
	}

	
	
}
