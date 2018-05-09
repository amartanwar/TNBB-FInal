package moduleLevel_Scenarios;

import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.AssetCreation;
import testDataProvider_Repository.LeaseDataProvider;

public class AssetDataSetup_Test extends BaseTest {

	
	//Asset Script
	@Test(dataProvider = "DataProvider_AssetCreation", dataProviderClass = LeaseDataProvider.class)
	public void AssetDataSetup(Map<String, String> map) throws Exception
	{
		test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
		AssetCreation assetcreation = new AssetCreation();
		assetcreation.assetCreation(driver, test, map);
		
		
	}
	
}
