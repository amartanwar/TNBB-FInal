package moduleLevelTestScripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pom.LeaseAccrualPage;
import pom.LeaseEntryHomePage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;
import pom.LeaseRestructurePage;
import pom.RestructureDetailsPage;

public class NBVImpairmentRestructureScript {

	public void nbvImpairmentRestructureScript(WebDriver driver, ExtentTest test,Map<String, String> map) throws InterruptedException, IOException
	{
		LeaseMenuPage leasemenu = new LeaseMenuPage(driver, test);
		leasemenu.openNBVImpairmentPage();
		
		LeaseListPage leaselistpage = new LeaseListPage(driver, test);
		leaselistpage.enterSequenceNumber(map.get("Lease Sequence"));
		leaselistpage.clickOnSearchButton();
		leaselistpage.clickONSelectButton();
		
		RestructureDetailsPage restructuredetailspage = new RestructureDetailsPage(driver, test);
		restructuredetailspage.selectPaymentNumber(map.get("Restructure Payment number"));
		restructuredetailspage.clickOnSelectButton();
		restructuredetailspage.handleAlert();
		
		LeaseRestructurePage leaserestructurepage = new LeaseRestructurePage(driver, test);
		leaserestructurepage.selectGLTemplate();
		leaserestructurepage.enterNBVImpairmentValue(map.get("NBV Impairment Amount"));
		leaserestructurepage.clickOnSaveButton();
		
		LeaseEntryHomePage leaseentryhomepage = new LeaseEntryHomePage(driver, test);
		
		leaseentryhomepage.clickOnLeaseAccrualScreen();
		
		LeaseAccrualPage leaseaccrualpage = new LeaseAccrualPage(driver, test);
		leaseaccrualpage.clickOnComputeYieldButton();
		leaseaccrualpage.clickOnSaveButton();
		
		leaseentryhomepage.clickOnSaveButton();
		leaseentryhomepage.handlePopup1();
		
		leaseentryhomepage.verfyTittle("Lease List", "Title is matching");
		test.log(Status.PASS, "Lease NBV Impairment Restructure is successfull");

	}

}
