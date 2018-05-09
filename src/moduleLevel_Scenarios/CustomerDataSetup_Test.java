package moduleLevel_Scenarios;

import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.CustomerCreation;
import testDataProvider_Repository.LeaseDataProvider;

public class CustomerDataSetup_Test extends BaseTest

{

	//Back end Lease creation Script
	@Test(dataProvider = "DataProvider_CustomerCreation",dataProviderClass = LeaseDataProvider.class,enabled=true)
	public void CustomerDataSetup(Map<String, String> map) throws Exception
	{
		test=reports.createTest("CustomerDataSetup"+map.get("SlNo"),"Customer Creation");
		CustomerCreation customercreation = new CustomerCreation();
		customercreation.customercreation(driver, test, map);
	}

}
