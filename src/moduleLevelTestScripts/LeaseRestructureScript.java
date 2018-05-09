package moduleLevelTestScripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pom.LeaseAccrualPage;
import pom.LeaseClassificationPage;
import pom.LeaseEntryHomePage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;
import pom.LeasePaymentSchedulePage;
import pom.LeaseRestructurePage;
import pom.LeaseStructurePage;
import pom.RestructureDetailsPage;

public class LeaseRestructureScript {
	
	public void leaseRestructureScript(WebDriver driver, ExtentTest test,Map<String, String> map) throws InterruptedException, IOException
	{
		LeaseMenuPage leasemenu = new LeaseMenuPage(driver, test);
		leasemenu.openLeaseRestructurePage();
		
		LeaseListPage leaselistpage = new LeaseListPage(driver, test);
		leaselistpage.enterSequenceNumber(map.get("Lease Sequence"));
		leaselistpage.clickOnSearchButton();
		leaselistpage.clickONSelectButton();
		
		RestructureDetailsPage restructuredetailspage = new RestructureDetailsPage(driver, test);
		
		//Restructure cant be done before Non-Accrual Date
		// We have to find the effective month in the UI from which Restructure has to be done
		if(map.get("IS Non Accrual Deal").equalsIgnoreCase("1"))
		{
			int restructurePaymentNumber = Integer.parseInt(map.get("Restructure Payment number"));
			
			//Month from when lease went to Non-Accrual state
			int nonAccrualMonth = Integer.parseInt(map.get("Non Accrual Month"));

			// Plus 2 is done because, UI show one month before non-Accrual period. So we have to include
			// that one month + first month of Non-Accrual period as it is shown in UI.
			
			int effectivePaymentNumber = (restructurePaymentNumber-nonAccrualMonth)+2;
	
			String effectivePaymentNumber_String =String.valueOf(effectivePaymentNumber);
			restructuredetailspage.selectPaymentNumber(effectivePaymentNumber_String);
			
		}
		
		
		restructuredetailspage.clickOnSelectButton();
		restructuredetailspage.handleAlert();
		
		LeaseRestructurePage leaserestructurepage = new LeaseRestructurePage(driver, test);
		leaserestructurepage.selectGLTemplate();
		leaserestructurepage.clickOnSaveButton();
		
		
		LeaseEntryHomePage leaseentryhomepage = new LeaseEntryHomePage(driver, test);
		leaseentryhomepage.clickOnStructureScreen();
		
		LeaseStructurePage leasestructure = new LeaseStructurePage(driver, test);
		leasestructure.enterNumberofPayments(map.get("Number of Payments"));
		leasestructure.clickOnSaveButton();
		
		leaseentryhomepage.clickOnPaymentScheduleScreen();
		
		LeasePaymentSchedulePage leasepaymentschedulepage = new LeasePaymentSchedulePage(driver, test);
		
	
		int no = Integer.parseInt(map.get("Restructure Payment number"));
		
		//int eno = no-1;
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='ctl00xFCxPHxgrdListxgrdList_r_"+no+"']/td/nobr"));
		
		element.click();
		leasepaymentschedulepage.clickOnClearButton();
		
		
		for(int i=1;i<=Integer.parseInt(map.get("Number of Set"));i++)
		{
			leasepaymentschedulepage.clickOnAddButton();
			leasepaymentschedulepage.enterNumberOfPayments(map.get("Restructured number of Payments-"+i));
			leasepaymentschedulepage.enterPaymentAmount(map.get("Payment Amount-"+i));
			leasepaymentschedulepage.clickOnSaveButton();
		}
		
		leasepaymentschedulepage.clickOnCloseButton();
		
		leaseentryhomepage.clickOnLeaseClassificationScreen();
		
		LeaseClassificationPage leaseclassificationpage = new LeaseClassificationPage(driver, test);
		leaseclassificationpage.clickOnPerform90PercentTestButton();
		leaseclassificationpage.clickOnSaveButton();
		
		leaseentryhomepage.clickOnLeaseAccrualScreen();
		
		LeaseAccrualPage leaseaccrualpage = new LeaseAccrualPage(driver, test);
		leaseaccrualpage.clickOnComputeYieldButton();
		leaseaccrualpage.clickOnSaveButton();
		
		leaseentryhomepage.clickOnSaveButton();
		leaseentryhomepage.handlePopup1();
		leaseentryhomepage.handlePopup1();
		leaseentryhomepage.handlePopup1();
		
		leaseentryhomepage.verfyTittle("Lease List", "Title is matching");
		test.log(Status.PASS, "Lease Restructure successfully");
		
		
		
	}
	

}
