package moduleLevel_Scenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.VendorInvoiceCreation;
import testDataProvider_Repository.LeaseDataProvider;

public class VendorInvoiceDataSetup_Test extends BaseTest 
{
	//Vendor Invoice Script
	@Test(dataProvider = "DataProvider_VICreation",dataProviderClass = LeaseDataProvider.class)
	public void VendorInvoiceDataSetup(Map<String, String> map) throws AWTException, InterruptedException, IOException, SQLException
	{
		test=reports.createTest("VIDatasetup"+map.get("SlNo"),"Vendor Invoice creation");
		VendorInvoiceCreation vendorinvoicecreation = new VendorInvoiceCreation();
		vendorinvoicecreation.vendorInvoiceScript(driver, test, map);
	}	
}
