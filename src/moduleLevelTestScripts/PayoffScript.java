package moduleLevelTestScripts;

import java.awt.AWTException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pom.CustomerListPage;
import pom.FullPayOffActivationPage;
import pom.LeaseAccrualPage;
import pom.LeaseClassificationPage;
import pom.LeaseEntryHomePage;
import pom.LeaseInventoryInLeasePage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;
import pom.LeaseRestructurePage;
import pom.PayoffAssetSelectionAndAssignmentPage;
import pom.PayoffQuoteListPage;
import pom.PayoffQuotePage;
import pom.PayoffQuoteParametersPage;
import pom.jobListPage;

public class PayoffScript {
	
	public void partialPayoffScript(WebDriver driver, ExtentTest test,Map<String, String> map) throws InterruptedException, AWTException
	{
		
		LeaseMenuPage leasemenupage = new LeaseMenuPage(driver, test);
		leasemenupage.openPayOffQuote();
		
		LeaseListPage leaselistpage = new LeaseListPage(driver, test);
		leaselistpage.enterSequenceNumber(map.get("Lease Sequence Number"));
		leaselistpage.clickOnSearchButton();
		leaselistpage.clickONSelectButton();
		
		PayoffQuoteListPage payoffquotelistpage = new PayoffQuoteListPage(driver, test);
		payoffquotelistpage.clickOnAddButton();
		
		PayoffAssetSelectionAndAssignmentPage payoffassetselectionandassignmentpage = new PayoffAssetSelectionAndAssignmentPage(driver, test);
		
		if(map.get("Is Full Payoff").equals("1"))
		{
			payoffassetselectionandassignmentpage.clickOnSelectAll();
		}
		
		else
		{
			for(int i=1;i<=Integer.parseInt(map.get("Total number of Assets to be paid off"));i++)
			{
				payoffassetselectionandassignmentpage.selectCheckBoxAtAssetLevel(map.get("InventoryID"+i));
			}
		}
		payoffassetselectionandassignmentpage.selectAssignmentDropDown();
		payoffassetselectionandassignmentpage.selectStatusDropDown(map.get("Status"));
		payoffassetselectionandassignmentpage.clickOnAddButton();
		payoffassetselectionandassignmentpage.clickOnAssignButton();
		payoffassetselectionandassignmentpage.enterPayOffQuoteName(map.get("Payoff Quote Name"));
		payoffassetselectionandassignmentpage.selectTerminationType(map.get("Termination Type"));
		payoffassetselectionandassignmentpage.clickOnSaveButton();
		
		PayoffQuoteParametersPage payoffquoteparameterspage = new PayoffQuoteParametersPage(driver, test);
		payoffquoteparameterspage.selectPaymentNumber(map.get("Payment Number"));
		payoffquoteparameterspage.clickOnContinueButton();
		payoffquoteparameterspage.handleAlert();
		
		PayoffQuotePage payoffquotepage = new PayoffQuotePage(driver, test);
		payoffquotepage.enterDueDate(map.get("DueDate"));
		payoffquotepage.enterBasePayoff(map.get("Base Payoff Amount"));
		payoffquotepage.clickOnSaveButton();
		payoffquotepage.handleAlert();
		
		leasemenupage.openPayoffInvoice();
		
		CustomerListPage customerlistpage = new CustomerListPage(driver, test);
		customerlistpage.enterAccountNumber(map.get("Account Number"));
		customerlistpage.clickOnsearchButton();
		customerlistpage.clickOnSelectButton();
		
		payoffquotelistpage.enterPayoffQuoteName(map.get("Payoff Quote Name"));
		payoffquotelistpage.clickOnSearchButton();
		payoffquotelistpage.clickOnSelectAllButton();
		payoffquotelistpage.clickOnRunImmediatelyRadioButton();
		payoffquotelistpage.clickOnGenerateInvoiceButton();
		payoffquotelistpage.clickOnJobID();
		
		jobListPage joblistpage = new jobListPage(driver, test);
		String jobStatus = joblistpage.validateJobStatus();
		
		if(jobStatus.equalsIgnoreCase("Completed With Errors"))
		{
			String path = joblistpage.clickOnLogDetails();
			System.out.println(path);
		}
		
		leasemenupage.openPayoffActivate();
		
		leaselistpage.enterSequenceNumber(map.get("Lease Sequence Number"));
		leaselistpage.clickOnSearchButton();
		leaselistpage.clickONSelectButton();
		
		payoffquotelistpage.clickOnSelectButton();
		
		FullPayOffActivationPage fullpayoffactivationpage = new FullPayOffActivationPage(driver, test);
		fullpayoffactivationpage.selectGLTemplate(map.get("GL Template"));
		fullpayoffactivationpage.clickOnActivateButton();
		fullpayoffactivationpage.handleAlert();
		
		if(Integer.parseInt(map.get("Is Full Payoff"))==1)
		{
			String PayoffQuoteStatus = payoffquotelistpage.validateJobStatus();
			Assert.assertEquals(PayoffQuoteStatus, "Activated");
			test.log(Status.PASS, "Full Payoff completed successfully");
		}
		
		else
		{
			LeaseEntryHomePage leaseentryhomepage = new LeaseEntryHomePage(driver, test);
			leaseentryhomepage.clickOnRestructureScreen();
			
			LeaseRestructurePage leaserestructurepage = new LeaseRestructurePage(driver, test);
			leaserestructurepage.selectGLTemplate();
			leaserestructurepage.clickOnSaveButton();
			
			leaseentryhomepage.clickOnLeaseClassificationScreen();
			
			LeaseClassificationPage leaseclassificationpage = new LeaseClassificationPage(driver, test);
			leaseclassificationpage.clickOnPerform90PercentTestButton();
			leaseclassificationpage.clickOnSaveButton();
			
			leaseentryhomepage.clickOnLeaseAccrualScreen();
			
			LeaseAccrualPage leaseaccrualpage = new LeaseAccrualPage(driver, test);
			leaseaccrualpage.clickOnComputeYieldButton();
			leaseaccrualpage.clickOnSaveButton();
			
			leaseentryhomepage.clickOnInventoryInLeaseScreen();
			
			LeaseInventoryInLeasePage leaseinventoryinleasepage = new LeaseInventoryInLeasePage(driver, test);
			leaseinventoryinleasepage.checkPrimaryAsset(map.get("New Primary Asset"));
			leaseinventoryinleasepage.clickOnPageSaveButton();
			
			leaseentryhomepage.clickOnSaveButton();
			test.log(Status.PASS, "Partial Payoff completed successfully");
		}
		
	}

}
