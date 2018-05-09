package moduleLevel_Scenarios;

import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.ReceiptPostingDataSetupScript;
import testDataProvider_Repository.LeaseDataProvider;

public class ReceiptPosting_Test extends BaseTest {

	
	//Receipt Posting
	@Test(dataProvider = "DataProvider_ReceiptPosting", dataProviderClass = LeaseDataProvider.class)
	public void ReceiptPosting(Map<String, String> map) throws Exception
	{
		test=reports.createTest("Receipt Posting"+map.get("Sl No"),"Lease Receipt Posting");
		ReceiptPostingDataSetupScript receiptpostingdatasetupscript = new ReceiptPostingDataSetupScript();
		receiptpostingdatasetupscript.receiptPostingDataSetupScript(driver, test, map);
		
		
	}
}



