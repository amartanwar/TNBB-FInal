package moduleLevelTestScripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import generic.BaseTest;
import pom.CustomerListPage;
import pom.FlagIncomeForAccrualPage;
import pom.FlagIncomeForNonAccrualPage;
import pom.LeaseMenuPage;
import pom.jobListPage;

public class LeaseNonAccrualAndAccrualScript extends BaseTest {
	
	
	public void leasenonaccrualandaccrualscript(WebDriver driver, ExtentTest test, Map<String, String> map) throws InterruptedException
	{
		
		LeaseMenuPage leasemenupage = new LeaseMenuPage(driver, test);
		
		
		if(Integer.parseInt(map.get("Is Non-Accrual ?"))==0)
		{
			leasemenupage.openAccrualScreen();
			
			CustomerListPage customerlistpage = new CustomerListPage(driver, test);
			customerlistpage.enterAccountNumber(map.get("Account Number"));
			customerlistpage.clickOnsearchButton();
			customerlistpage.clickOnSelectButton();
			
			FlagIncomeForAccrualPage flagincomeforaccrualpage = new FlagIncomeForAccrualPage(driver, test);
			flagincomeforaccrualpage.enterSequenceNumber(map.get("Lease Sequence Number"));
			flagincomeforaccrualpage.clickOnSearchButton();
			flagincomeforaccrualpage.clickOnSelectAllButton();
			flagincomeforaccrualpage.selectIncomeAcctualAllowed();
			flagincomeforaccrualpage.clickOnAddButton();
			flagincomeforaccrualpage.clickOnAssignButton();
			flagincomeforaccrualpage.clickOnRunImmediately();
			flagincomeforaccrualpage.clickOnRunupdateButton();
			flagincomeforaccrualpage.clickOnJobID();
			
			jobListPage joblistpage = new jobListPage(driver, test);
			String jobStatus = joblistpage.validateJobStatus();
			
			System.out.println(jobStatus);
			
		}
		
		else
		{
			
			leasemenupage.openNonAccrualScreen();
			
			CustomerListPage customerlistpage = new CustomerListPage(driver, test);
			customerlistpage.enterAccountNumber(map.get("Account Number"));
			customerlistpage.clickOnsearchButton();
			customerlistpage.clickOnSelectButton();
			
			FlagIncomeForNonAccrualPage flagincomeforNonaccrualpage = new FlagIncomeForNonAccrualPage(driver, test);
			flagincomeforNonaccrualpage.enterSequenceNumber(map.get("Lease Sequence Number"));
			flagincomeforNonaccrualpage.clickOnSearchButton();
			flagincomeforNonaccrualpage.clickOnSelectAllButton();
			flagincomeforNonaccrualpage.selectIncomeAcctualAllowed();
			flagincomeforNonaccrualpage.clickOnAddButton();
			flagincomeforNonaccrualpage.clickOnAssignButton();
			flagincomeforNonaccrualpage.clickOnRunImmediately();
			flagincomeforNonaccrualpage.clickOnRunupdateButton();
			flagincomeforNonaccrualpage.clickOnJobID();
			
			jobListPage joblistpage = new jobListPage(driver, test);
			String jobStatus = joblistpage.validateJobStatus();
			
			System.out.println(jobStatus);
			
		}

		
	}

}
