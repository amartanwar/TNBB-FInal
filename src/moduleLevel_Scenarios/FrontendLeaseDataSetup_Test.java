package moduleLevel_Scenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.FrontEndLeaseDataSetupScript;
import testDataProvider_Repository.LeaseDataProvider;

public class FrontendLeaseDataSetup_Test extends BaseTest{
	
	//Front end Lease creation Script
	@Test(dataProvider = "DataProvider_FrontendLeaseSetup",dataProviderClass = LeaseDataProvider.class,enabled = true)
	public void FrontendLeaseDataSetup(Map<String, String> map) throws AWTException, InterruptedException, IOException
	{
		test=reports.createTest("Frontend Lease Data Setup"+map.get("SlNo"),"Lease Booking");
		FrontEndLeaseDataSetupScript frontendleasedatasetupscript = new FrontEndLeaseDataSetupScript();
		frontendleasedatasetupscript.frontendScript(driver, test, map);
	}

}
