package moduleLevel_Scenarios;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import test.LTRtoAR_IncomeRecog;
import testDataProvider_Repository.LeaseDataProvider;

public class LTRtoAR_IR_STUpdatesDataSetup_Test extends BaseTest {
	
	
	@Test(dataProvider = "DataProvider_LTR-AR+IncomeRecognition",dataProviderClass = LeaseDataProvider.class,enabled = true)
	public void LTRtoARIncomeRecog(Map<String, String> map) throws InterruptedException, IOException
	{
		test=reports.createTest("Updates Successfull"+map.get("SlNo"),"Lease ResidualImpairment Restructure");
		LTRtoAR_IncomeRecog ltrtoarincomerecog = new LTRtoAR_IncomeRecog();
		ltrtoarincomerecog.ltrToAR(driver, test, map);
	}

}
