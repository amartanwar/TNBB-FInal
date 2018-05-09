package moduleLevelTestScripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pom.AssetLocationAndInvoiceGroupMappingPage;
import pom.AssetLocationSetupListPage;
import pom.InvoiceGroupListPage;
import pom.LeaseAssumptionDetailPage;
import pom.LeaseAssumptionParamentPage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;

public class LeaseAssumptionScript extends BaseTest {
	
	public void leaseAssumptionScript(WebDriver driver, ExtentTest test, Map<String,String> map) throws InterruptedException
	{
		
		LeaseMenuPage leasemenupage = new LeaseMenuPage(driver, test);
		leasemenupage.opennewAsseumption();
		
		LeaseListPage leaselistpage = new LeaseListPage(driver, test);
		leaselistpage.enterSequenceNumber(map.get("Lease Sequence Number"));
		leaselistpage.clickOnSearchButton();
		leaselistpage.clickONSelectButton();
		
		LeaseAssumptionParamentPage leaseassumptionparameterpage = new LeaseAssumptionParamentPage(driver, test);
		leaseassumptionparameterpage.selectAssumptionReason(map.get("Assumption Reason"));
		leaseassumptionparameterpage.enterNewAccountNumber(map.get("New Account Number"));
		leaseassumptionparameterpage.enterNewInvoiceGroup(map.get("New Invoice Group"));
		leaseassumptionparameterpage.selectPayment(map.get("Payment Number"));
		leaseassumptionparameterpage.clickOnContinueButton();
		leaseassumptionparameterpage.handlePopup1();
		leaseassumptionparameterpage.handlePopup1();
		leaseassumptionparameterpage.handlePopup1();
		
		LeaseAssumptionDetailPage leaseassumptiondetailpage = new LeaseAssumptionDetailPage(driver, test);
		leaseassumptiondetailpage.clickOnSaveButton();
		
		AssetLocationAndInvoiceGroupMappingPage assetlocationandinvoicegroupmappingpage = new AssetLocationAndInvoiceGroupMappingPage(driver, test);
		assetlocationandinvoicegroupmappingpage.clickOnCloneLocation();
		assetlocationandinvoicegroupmappingpage.clickOnSelectAllButton();
		assetlocationandinvoicegroupmappingpage.selectNewInvoiceGroup();
		String IcurrentWindow = assetlocationandinvoicegroupmappingpage.importNewInvoiceGroup();
		
		InvoiceGroupListPage invoicegrouplistpage = new InvoiceGroupListPage(driver, test);
		invoicegrouplistpage.clickOnSelectButton(IcurrentWindow);
		
		assetlocationandinvoicegroupmappingpage.clickOnAddButton();
		assetlocationandinvoicegroupmappingpage.selectNewLocation();
		String lcurrentWindow = assetlocationandinvoicegroupmappingpage.importNewLocation();
		
		AssetLocationSetupListPage assetlocationsetuplistpage = new AssetLocationSetupListPage(driver, test);
		assetlocationsetuplistpage.clickOnSelectButton(lcurrentWindow);
		
		assetlocationandinvoicegroupmappingpage.clickOnAddButton();
		assetlocationandinvoicegroupmappingpage.clickOnAssignButton();
		assetlocationandinvoicegroupmappingpage.clickOnSaveButton();
		
		leaseassumptiondetailpage.selectAssumptionStatus();
		leaseassumptiondetailpage.clickOnGlobalSaveButton();
		leaseassumptiondetailpage.handlePopup1();
		leaseassumptiondetailpage.handlePopup1();
		leaseassumptiondetailpage.handlePopup1();
		
		test.log(Status.PASS, "Lease Assumption is successfully completed");

		
		
	}

}
