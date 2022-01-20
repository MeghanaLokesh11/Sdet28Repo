package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;


@Listeners(com.crm.comcast.GenericUtility.ListenerImpClass.class)

public class DemoForTakingScreenShot extends BaseClass {
	@Test
	public void sample() {
		
		String expectedname="Apple";
		String actualName="Appleeeeeee";
		
		Assert.assertEquals(actualName, expectedname);
	}

}
