package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;

public class RetryClass extends BaseClass {
	@Test (retryAnalyzer=com.crm.comcast.GenericUtility.RetryimplimentationClass.class)
	public void retry() {
		Assert.assertEquals(true, false);
	}

}
