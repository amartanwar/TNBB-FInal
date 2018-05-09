package moduleLevel_Scenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.PayoffScript;
import testDataProvider_Repository.LeaseDataProvider;

public class Payoff_Test extends BaseTest {
	

	
	@Test(dataProvider = "DataProvider_Payoff",dataProviderClass = LeaseDataProvider.class,enabled = true)
	public void PayoffDataSetup(Map<String, String> map) throws InterruptedException, IOException, AWTException
	{
		test=reports.createTest("Payoff"+map.get("SlNo"),"Payoff");
		PayoffScript payoffscript = new PayoffScript();
		payoffscript.partialPayoffScript(driver, test, map);
	}

}
