package moduleLevel_Scenarios;

import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.LeaseAssumptionScript;
import testDataProvider_Repository.LeaseDataProvider;

public class LeaseAssumptionDataSetup_Test extends BaseTest {

	
	//Asset Script
	@Test(dataProvider = "DataProvider_Assumption", dataProviderClass = LeaseDataProvider.class)
	public void AssumptionDataSetup(Map<String, String> map) throws Exception
	{
		test=reports.createTest("Lease Assumption"+map.get("Sl No"),"Assumption");
		LeaseAssumptionScript leaseassumptionscript = new LeaseAssumptionScript();
		leaseassumptionscript.leaseAssumptionScript(driver, test, map);
	
	}

}
