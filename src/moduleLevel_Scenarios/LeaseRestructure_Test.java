package moduleLevel_Scenarios;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.LeaseRestructureScript;
import moduleLevelTestScripts.NBVImpairmentRestructureScript;
import moduleLevelTestScripts.ResidualImpairmentRestructureScript;
import moduleLevelTestScripts.SalvageValueRestructureScript;
import testDataProvider_Repository.LeaseDataProvider;

public class LeaseRestructure_Test extends BaseTest {
	
	@Test(dataProvider = "DataProvider_LeaseRestructure",dataProviderClass = LeaseDataProvider.class,enabled = false)
	public void leaseRestructureDataSetup(Map<String, String> map) throws InterruptedException, IOException
	{
		test=reports.createTest("Lease restructure"+map.get("SlNo"),"Lease Restructure");
		LeaseRestructureScript leaserestructurescript = new LeaseRestructureScript();
		leaserestructurescript.leaseRestructureScript(driver, test, map);
	}

	
	@Test(dataProvider = "DataProvider_ResidualImpairmentRestructure",dataProviderClass = LeaseDataProvider.class,enabled = false)
	public void ResidualImpairmentRestructureDataSetup(Map<String, String> map) throws InterruptedException, IOException
	{
		test=reports.createTest("ResidualImpairment Restructure"+map.get("SlNo"),"Lease ResidualImpairment Restructure");
		ResidualImpairmentRestructureScript residualimpairmentrestructurescript = new ResidualImpairmentRestructureScript();
		residualimpairmentrestructurescript.residualImpairmentRestructureScript(driver, test, map);
	}

	@Test(dataProvider = "DataProvider_NBVImpairmentRestructure",dataProviderClass = LeaseDataProvider.class,enabled = false)
	public void NBVImpairmentRestructureDataSetup(Map<String, String> map) throws InterruptedException, IOException
	{
		test=reports.createTest("NBVImpairment Restructure"+map.get("SlNo"),"Lease NBVImpairment Restructure");
		NBVImpairmentRestructureScript nbvimpairmentrestructurescript = new NBVImpairmentRestructureScript();
		nbvimpairmentrestructurescript.nbvImpairmentRestructureScript(driver, test, map);
	}

	
	@Test(dataProvider = "DataProvider_SalvageValueRestructure",dataProviderClass = LeaseDataProvider.class,enabled = true)
	public void SalvageValueRestructureDataSetup(Map<String, String> map) throws InterruptedException, IOException
	{
		test=reports.createTest("NBVImpairment Restructure"+map.get("SlNo"),"Lease NBVImpairment Restructure");
		SalvageValueRestructureScript salvagevaluerestructurescript = new SalvageValueRestructureScript();
		salvagevaluerestructurescript.salvageValueRestructureScript(driver, test, map);
	}
	
	
}
