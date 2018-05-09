package endToEndScenarios;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import generic.BaseTest;
import moduleLevelTestScripts.AssetCreation;
import moduleLevelTestScripts.FrontEndLeaseDataSetupScript;
import moduleLevelTestScripts.VendorInvoiceCreation;
import testDataProvider_Repository.LeaseDataProvider;

public class JIRA447 extends BaseTest {

	@Test(dataProvider = "DataProvider_AssetCreation", dataProviderClass = LeaseDataProvider.class,priority=0)
	public void jira447Asset(WebDriver driver, ExtentTest test, Map<String, String> map) throws Exception 
	{
	
		AssetCreation assetcreation = new AssetCreation();
		assetcreation.assetCreation(driver, test, map);
	}
	
	@Test(dataProvider = "DataProvider_VICreation", dataProviderClass = LeaseDataProvider.class,priority=1)
	public void jira447VI(WebDriver driver, ExtentTest test, Map<String, String> map) throws Exception 
	{
		VendorInvoiceCreation vendorinvoicecreation = new VendorInvoiceCreation();
		vendorinvoicecreation.vendorInvoiceScript(driver, test, map);
	}
	
	@Test(dataProvider = "DataProvider_FrontendLeaseSetup", dataProviderClass = LeaseDataProvider.class,priority=2)
	public void jira447Lease(WebDriver driver, ExtentTest test, Map<String, String> map) throws Exception 
	{
		FrontEndLeaseDataSetupScript frontendleasedatasetupscript = new FrontEndLeaseDataSetupScript();
		frontendleasedatasetupscript.frontendScript(driver, test, map);
	}
		/*LTRtoAR_IR_STUpdatesDataSetup_Test ltrtoar_stupdatedatasetup_test = new LTRtoAR_IR_STUpdatesDataSetup_Test();
		ltrtoar_stupdatedatasetup_test.LTRtoARIncomeRecog(map);*/
			
	}
	
	

