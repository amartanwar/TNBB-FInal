package moduleLevel_Scenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.BackendLeaseDataSetupScript;
import testDataProvider_Repository.LeaseDataProvider;

public class LeaseDataSetup_Test  extends BaseTest

{

	//Back end Lease creation Script
	@Test(dataProvider = "DataProvider_BackendLeaseSetup",dataProviderClass = LeaseDataProvider.class,enabled=false)
	public void BackendLeaseDataSetup(Map<String, String> map) throws AWTException, InterruptedException, IOException, SQLException
	{
		test=reports.createTest("Backend Lease Data Setup"+map.get("SlNo"),"Lease Booking");
		BackendLeaseDataSetupScript backendleasedatasetupscript = new BackendLeaseDataSetupScript();
		backendleasedatasetupscript.leaseDataSetupScript(driver, test, map);
	}

		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
