package moduleLevel_Scenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import moduleLevelTestScripts.LeaseNonAccrualAndAccrualScript;
import testDataProvider_Repository.LeaseDataProvider;

public class LeaseNonAccrualAndAccrualDataSetup_Test extends BaseTest {
	

	//Back end Lease creation Script
	@Test(dataProvider = "DataProvider_LeaseNonAccrualAndAccrual",dataProviderClass = LeaseDataProvider.class,enabled=true)
	public void LeaseNonAccrualAndAccrualDataSetup(Map<String, String> map) throws AWTException, InterruptedException, IOException, SQLException
	{
		test=reports.createTest("Lease Non Accrual and Accrual Data Setup"+map.get("SlNo"),"Lease Non Accrual and Accrual Data Setup");
		LeaseNonAccrualAndAccrualScript leasenonaccrualandaccrualscript = new LeaseNonAccrualAndAccrualScript();
		leasenonaccrualandaccrualscript.leasenonaccrualandaccrualscript(driver, test, map);
	}


}
