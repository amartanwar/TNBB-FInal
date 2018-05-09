package moduleLevelTestScripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pom.LeaseAccrualPage;
import pom.LeaseEntryHomePage;
import pom.LeaseInventoryInLeasePage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;
import pom.LeaseRestructurePage;
import pom.RestructureDetailsPage;

public class SalvageValueRestructureScript {
	
	public void salvageValueRestructureScript(WebDriver driver, ExtentTest test,Map<String, String> map) throws InterruptedException, IOException
	{
		LeaseMenuPage leasemenu = new LeaseMenuPage(driver, test);
		leasemenu.openSalvageValueImpairment();
		
		LeaseListPage leaselistpage = new LeaseListPage(driver, test);
		leaselistpage.enterSequenceNumber(map.get("Lease Sequence number"));
		leaselistpage.clickOnSearchButton();
		leaselistpage.clickONSelectButton();
		
		RestructureDetailsPage restructuredetailspage = new RestructureDetailsPage(driver, test);
		restructuredetailspage.selectPaymentNumber(map.get("Restructure Payment number"));
		restructuredetailspage.clickOnSelectButton();
		restructuredetailspage.handleAlert();
		
		
		
		LeaseInventoryInLeasePage leaseinventoryinlease = new LeaseInventoryInLeasePage(driver, test);
		
		if(Integer.parseInt(map.get("Is Residual Entered At Asset Level ?"))==1)
		{
			for(int i=1;i<=Integer.parseInt(map.get("Total number of Assets"));i++)
			{
			leaseinventoryinlease.enterResidualBookedAmountForSalvage(map.get("Residual Booked Amount"+i), map.get("Inventory alias"+ i));
			}
		}
		
		else
		{
			leaseinventoryinlease.clickOnSelectAllButton();
			leaseinventoryinlease.selectResidualBookedAmount();
			leaseinventoryinlease.enterValue(map.get("Residual Booked Amount"));
			leaseinventoryinlease.clickOnAddButton();
			leaseinventoryinlease.clickOnAssignButton();
		}
		
		leaseinventoryinlease.clickOnPageSaveButton();
		
		
		
		
		LeaseRestructurePage leaserestructurepage = new LeaseRestructurePage(driver, test);
		//leaserestructurepage.selectGLTemplate();
		leaserestructurepage.clickOnSaveButton();
		
		
		LeaseEntryHomePage leaseentryhomepage = new LeaseEntryHomePage(driver, test);
		
		leaseentryhomepage.clickOnLeaseAccrualScreen();
		
		LeaseAccrualPage leaseaccrualpage = new LeaseAccrualPage(driver, test);
		leaseaccrualpage.clickOnComputeYieldButton();
		leaseaccrualpage.clickOnSaveButton();
		
		leaseentryhomepage.clickOnSaveButton();
		leaseentryhomepage.handlePopup1();
		
		leaseentryhomepage.verfyTittle("Lease List", "Title is matching");
		test.log(Status.PASS, "Salvage Value  Restructure successfully");
		
		

	}

}
