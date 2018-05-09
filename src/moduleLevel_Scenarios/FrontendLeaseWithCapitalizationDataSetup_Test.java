package moduleLevel_Scenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.FrontEndLeaseWithCapitalizationDataSetupScript;
import testDataProvider_Repository.LeaseDataProvider;

public class FrontendLeaseWithCapitalizationDataSetup_Test extends BaseTest {
	
	//Front end Lease with Capitalization creation Script
		@Test(dataProvider = "DataProvider_FrontendLeaseWithCapitalizationSetup",dataProviderClass = LeaseDataProvider.class,enabled = true)
		public void FrontendLeaseWithCapitalizationDataSetup(Map<String, String> map) throws AWTException, InterruptedException, IOException
		{
			test=reports.createTest("Frontend Leas With Capitalizatione Data Setup"+map.get("SlNo"),"Lease Booking");
			FrontEndLeaseWithCapitalizationDataSetupScript frontendleasewithcapitalizationdatasetupscript = new FrontEndLeaseWithCapitalizationDataSetupScript();
					frontendleasewithcapitalizationdatasetupscript.frontendScript(driver, test, map);
		}

}
