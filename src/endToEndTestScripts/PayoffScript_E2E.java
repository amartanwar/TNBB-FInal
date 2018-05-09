package endToEndTestScripts;

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

public class PayoffScript_E2E {
	
	public void partialPayoffScript(WebDriver driver, ExtentTest test,Map<String, String> map,int j) throws InterruptedException, AWTException
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
		
		if(map.get("Is Full Payoff"+j).equals("1"))
		{
			payoffassetselectionandassignmentpage.clickOnSelectAll();
		}
		
		else
		{
			for(int i=1;i<=Integer.parseInt(map.get("Total number of Assets to be paid off"+j));i++)
			{
				payoffassetselectionandassignmentpage.selectCheckBoxAtAssetLevel(map.get("InventoryID"+i));
			}
		}
		payoffassetselectionandassignmentpage.selectAssignmentDropDown();
		payoffassetselectionandassignmentpage.selectStatusDropDown(map.get("Status"+j));
		payoffassetselectionandassignmentpage.clickOnAddButton();
		payoffassetselectionandassignmentpage.clickOnAssignButton();
		payoffassetselectionandassignmentpage.enterPayOffQuoteName(map.get("Payoff Quote Name"+j));
		payoffassetselectionandassignmentpage.selectTerminationType(map.get("Termination Type"+j));
		payoffassetselectionandassignmentpage.clickOnSaveButton();
		
		PayoffQuoteParametersPage payoffquoteparameterspage = new PayoffQuoteParametersPage(driver, test);
		
		int previousRestructureMonth = Integer.parseInt(map.get("Previous Restructure Month"+j));
		int paymentNumber = Integer.parseInt(map.get("Payment Number"+j));
		int effectivePaymentNumber = (paymentNumber-previousRestructureMonth)+1;
		String effectivePaymentNumber_String =String.valueOf(effectivePaymentNumber);
		
		payoffquoteparameterspage.selectPaymentNumber(effectivePaymentNumber_String);
		payoffquoteparameterspage.clickOnContinueButton();
		payoffquoteparameterspage.handleAlert();
		
		PayoffQuotePage payoffquotepage = new PayoffQuotePage(driver, test);
		payoffquotepage.enterDueDate(map.get("DueDate"+j));
		payoffquotepage.enterBasePayoff(map.get("Base Payoff Amount"+j));
		payoffquotepage.clickOnSaveButton();
		payoffquotepage.handleAlert();
		
		leasemenupage.openPayoffInvoice();
		
		CustomerListPage customerlistpage = new CustomerListPage(driver, test);
		customerlistpage.enterAccountNumber(map.get("Account Number"));
		customerlistpage.clickOnsearchButton();
		customerlistpage.clickOnSelectButton();
		
		payoffquotelistpage.enterPayoffQuoteName(map.get("Payoff Quote Name"+j));
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
		fullpayoffactivationpage.selectGLTemplate(map.get("GL Template"+j));
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
			leaseinventoryinleasepage.checkPrimaryAsset(map.get("New Primary Asset"+j));
			leaseinventoryinleasepage.clickOnPageSaveButton();
			
			leaseentryhomepage.clickOnSaveButton();
			test.log(Status.PASS, "Partial Payoff completed successfully");
		}
		
	}

}
