package moduleLevelTestScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pom.AssetListPage;
import pom.CustomerListPage;
import pom.LeaseAccrualPage;
import pom.LeaseBlendedIncome;
import pom.LeaseCasualityPage;
import pom.LeaseClassificationPage;
import pom.LeaseContractOptionPage;
import pom.LeaseCreatePage;
import pom.LeaseEntryHomePage;
import pom.LeaseIDCSetupPage;
import pom.LeaseInventoryInLeasePage;
import pom.LeaseInvestmentPage;
import pom.LeaseMenuPage;
import pom.LeaseMilageParameterPage;
import pom.LeasePaymentSchedulePage;
import pom.LeaseProfilePage;
import pom.LeaseServicingPage;
import pom.LeaseStructurePage;
import pom.LeaseTaxFlowsPage;

public class BackendLeaseDataSetupScript
{

	public void leaseDataSetupScript(WebDriver driver, ExtentTest test, Map<String,String> map)
					throws AWTException, InterruptedException, IOException 				
	{
		//Navigate to create new lease
		LeaseMenuPage leasemenupage= new LeaseMenuPage(driver, test);
		leasemenupage.clickOnLeaseMenu();
		leasemenupage.clickOnNewLease();
		
		//Searching for particular customer
		CustomerListPage customerlistpage = new CustomerListPage(driver, test);
		customerlistpage.enterAccountNumber(map.get("AccountNumber"));
		customerlistpage.clickOnsearchButton();
		customerlistpage.clickOnSelectButton();
		
		//Create new lease
		LeaseCreatePage leasecreatepage= new LeaseCreatePage(driver, test);
		leasecreatepage.enterLeaseSequenceNumber(map.get("Lease_sequenceNumber"));
		leasecreatepage.clcikOnSaveButton();
		
		//Enter all mandatory details in LeaseProfile page
		LeaseProfilePage leaseprofilepage= new LeaseProfilePage(driver, test);
		leaseprofilepage.setAlias((map.get("LeaseAlias")));
		leaseprofilepage.selectOriginationChannel();
		leaseprofilepage.selectTransactiontype();
		String OTP = map.get("OTPLease?");
		if(OTP.equalsIgnoreCase("Yes"))
		{
			leaseprofilepage.selectOTPLease();
			leaseprofilepage.selectOtpAccountingTreatmentID();
			leaseprofilepage.selectotpIncomeGLTemplate();
		}
			
		leaseprofilepage.enterInvoiceGroup((map.get("LeaseInvoiceGroup")));
		leaseprofilepage.selectreceiptCashGLTemplate();
		leaseprofilepage.selectRemarketingResponsibility();
		leaseprofilepage.selectGLCompany();
		leaseprofilepage.selectGLCash();
		leaseprofilepage.selectGLCenter();
		leaseprofilepage.clickOnSaveButton();
		
		//Import Primary inventory in to the lease
		LeaseInventoryInLeasePage leaseinevntoryinleasepage= new LeaseInventoryInLeasePage(driver, test);
		String beforeWindow1 = leaseinevntoryinleasepage.clickOnImportButton();
		AssetListPage assetlistpage= new AssetListPage(driver, test);
		assetlistpage.searchByAlias((map.get("LeasePrimaryInventoryAlias1")));
		assetlistpage.clickOnSearchButton();
		assetlistpage.clickOnCurrentAll();
		assetlistpage.clickOnSelectExportButton(beforeWindow1);
		leaseinevntoryinleasepage.selectPrimaryAsset();
		leaseinevntoryinleasepage.clickSaveAndContinue();	
		
		// Import other inventories
		for(int i=2;i<=Integer.parseInt(map.get("AssetCount"));i++)
		{
			String beforeWindow = leaseinevntoryinleasepage.clickOnImportButton();
			AssetListPage assetlistpageduplicate = new AssetListPage(driver, test);
			assetlistpageduplicate.searchByAlias((map.get("LeaseInventoryAlias"+i)));
			assetlistpageduplicate.clickOnSearchButton();
			assetlistpageduplicate.clickOnCurrentAll();
			assetlistpageduplicate.clickOnSelectExportButton(beforeWindow);
			leaseinevntoryinleasepage.clickSaveAndContinue();
		}	
		leaseinevntoryinleasepage.clickOnPageSaveButton();

		//Provide LeaseParameter details
		LeaseMilageParameterPage leasemilageparameterpage= new LeaseMilageParameterPage(driver, test);
		leasemilageparameterpage.clickOnSaveButton();
		
		//Provide Lease Investment details
		LeaseInvestmentPage leaseinvestmentpage= new LeaseInvestmentPage(driver, test);
		leaseinvestmentpage.enterResidualBooked((map.get("ResidualBookedAmount")));
		leaseinvestmentpage.enterResidualExpected((map.get("ResidualExpectedAmount")));
		leaseinvestmentpage.entercustomerResidualGuarantee((map.get("CustomerResidualGuaranteeAmount")));
		leaseinvestmentpage.clickOnSaveButton();
		leaseinvestmentpage.handlePopup1();
		
		//Provide Lease IDC details
		
			
		
		if(Integer.parseInt(map.get("Is IDC Required ?")) == 1)
		{


			if(Integer.parseInt(map.get("Number of IDCs"))==1)
			{
			LeaseIDCSetupPage leaseIDCsetuppage= new LeaseIDCSetupPage(driver, test);	
			leaseIDCsetuppage.selectIDCTemplate(map.get("IDCTemplate1;"));
			WebElement IDCAmount = driver.findElement(By.id("ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3"));
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(IDCAmount));
			IDCAmount.click();
			WebElement AcquisitionCostClick = driver.findElement(By.id("igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls2"));
			wait.until(ExpectedConditions.elementToBeClickable(AcquisitionCostClick));
			AcquisitionCostClick.clear();
			AcquisitionCostClick.sendKeys(map.get("IDCAmount1"));
			leaseIDCsetuppage.clickOnSaveButton();
			}
		
			else if(Integer.parseInt(map.get("Number of IDCs"))>1)
			{
				
				LeaseIDCSetupPage leaseIDCsetuppage= new LeaseIDCSetupPage(driver, test);
				leaseIDCsetuppage.selectIDCTemplate(map.get("IDCTemplate1"));
				WebElement IDCAmount = driver.findElement(By.id("ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3"));
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.elementToBeClickable(IDCAmount));
				IDCAmount.click();
				WebElement AcquisitionCostClick = driver.findElement(By.id("igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls2"));
				wait.until(ExpectedConditions.elementToBeClickable(AcquisitionCostClick));
				AcquisitionCostClick.clear();
				AcquisitionCostClick.sendKeys(map.get("IDCAmount1"));
				
				for(int j=1;j<Integer.parseInt(map.get("Number of IDCs"));j++)
				{
					
					leaseIDCsetuppage.clickOnAddButton();
					WebElement IDCAmount1 = driver.findElement(By.id("ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_"+j+"_3"));
					wait.until(ExpectedConditions.elementToBeClickable(IDCAmount1));
					IDCAmount1.click();
					WebElement AcquisitionCostClick1 = driver.findElement(By.id("igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls2"));
					wait.until(ExpectedConditions.elementToBeClickable(AcquisitionCostClick1));
					AcquisitionCostClick1.clear();
					AcquisitionCostClick1.sendKeys(map.get("IDCAmount"+(j+1)));
					
					WebElement IDCBucket = driver.findElement(By.id("ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_"+j+"_2"));
					wait.until(ExpectedConditions.elementToBeClickable(IDCBucket));
					IDCBucket.click();
					WebElement IDCBucketClick = driver.findElement(By.id("igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls0"));
					wait.until(ExpectedConditions.elementToBeClickable(IDCBucketClick));
					IDCBucketClick.clear();
					IDCBucketClick.sendKeys(map.get("IDCBucket"+(j+1)));
				}
			
				leaseIDCsetuppage.clickOnSaveButton();
			}
		}
		
		else
		{
			LeaseIDCSetupPage leaseIDCsetuppage= new LeaseIDCSetupPage(driver, test);	
			leaseIDCsetuppage.clickOnCloseButton();
		}
		
		
		// add structure details
		
		
		// Lease Structure details
		LeaseStructurePage leasestructurepage = new LeaseStructurePage(driver, test);
		if(map.get("Is Advance/Arrear").equalsIgnoreCase("Advance"))
		{
			leasestructurepage.enterNumberofPayments(map.get("LeaseNumberOfPayments"));
			leasestructurepage.selectLeaseFrequency(map.get("Payment Frequency"));
			leasestructurepage.clickOnMaturityDate();
			Thread.sleep(1000);
			leasestructurepage.enterNumberOfPaymentsDueOnCommencement(map.get("PaymentsDueOnInception"));
			leasestructurepage.enterCommencementDate(map.get("LeaseCommencementDate"));
			leasestructurepage.clickOnMaturityDate();
			Thread.sleep(1000);
			leasestructurepage.enterDueDate(map.get("DueDay"));
			leasestructurepage.clickOnMaturityDate();
			Thread.sleep(1000);
			leasestructurepage.enterRegularTotalPayment(map.get("LeaseRental"));
			leasestructurepage.enterCommencementTotalPayment(map.get("TotalPaymentOnCommencement"));
		}
		else
		{
			leasestructurepage.enterNumberofPayments((map.get("LeaseNumberOfPayments")));
			leasestructurepage.selectLeaseFrequency(map.get("Payment Frequency"));
			leasestructurepage.clickOnMaturityDate();
			Thread.sleep(1000);
			leasestructurepage.enterCommencementDate((map.get("LeaseCommencementDate")));
			leasestructurepage.clickOnMaturityDate();
			Thread.sleep(1000);
			leasestructurepage.enterDueDate((map.get("DueDay")));
			leasestructurepage.clickOnMaturityDate();
			Thread.sleep(1000);
			leasestructurepage.enterRegularTotalPayment((map.get("LeaseRental")));
		}
		leasestructurepage.clickOnSaveButton();
		
		//Lease Payment schedule details
		LeasePaymentSchedulePage leasepaymentschedulepage = new LeasePaymentSchedulePage(driver, test);
		leasepaymentschedulepage.clickOnCloseButton();
		
		//Perform classification test
		LeaseClassificationPage leaseclassificationpage= new LeaseClassificationPage(driver, test);
		leaseclassificationpage.enterTotalEconomicLife((map.get("LeaseEconomicLife")));
		leaseclassificationpage.enterTotalRemainingLife((map.get("RemainingLife")));
		leaseclassificationpage.clickOnPerform90PercentTestButton();
		leaseclassificationpage.selectLeaseAccountingTreatment((map.get("LeaseAccountingTreatment")));
		leaseclassificationpage.deselectTaxLease();
		leaseclassificationpage.deselectTracLease();
		leaseclassificationpage.selectLeaseBookingGLTemplate(map.get("LeaseBookingGLTemplate"));
		leaseclassificationpage.selectLtrToARGLTemplate(map.get("LtrToARGLTemplate"));
		leaseclassificationpage.selectOTPARGLTemplate(map.get("OTPARGLTemplate"));
		leaseclassificationpage.selectProduct(map.get("ProductType"));
		leaseclassificationpage.clickOnSaveButton();

		//Lease Blended income details
		LeaseBlendedIncome leaseblendedincome = new LeaseBlendedIncome(driver, test);
	
		if(Integer.parseInt(map.get("Is BI Required ?")) == 1)
		{
		
		
		for(int j=1;j<=Integer.parseInt(map.get("Number of BI Types"));j++)
		{
			String BlendType = map.get("BI Type"+j);
				if(BlendType.equalsIgnoreCase("AssetBased-FAS91") || BlendType.equalsIgnoreCase("AssetBased-NonFAS91") )
					{
		
						for(int k=1;k<=Integer.parseInt(map.get("Number of BI Type "+j));k++)
						{
			
							leaseblendedincome.addBlendedIncomeChargeBackWithAssetBackEnd((map.get("BIType-"+j+" BlendedName-"+k)),(map.get("BIType-"+j+" BlendedAmount-"+k)),(map.get("BIType-"+j+" alias-"+k)),(map.get("BIType-"+j+" DueDate-"+k)),(map.get("BIType-"+j+" Code-"+k)));
							leaseblendedincome.saveBlendedItem();
						}
					}
				else if(BlendType.equalsIgnoreCase("LeaseBased-FAS91") ||BlendType.equalsIgnoreCase("LeaseBased-NonFAS91"))
				{

					System.out.println("Test");						
					for(int k=1;k<=Integer.parseInt(map.get("Number of BI Type "+j));k++)
					{
						System.out.println("Test1");	
						leaseblendedincome.addBlendedIncomeChargeBack((map.get("BIType-"+j+" BlendedName-"+k)),(map.get("BIType-"+j+" BlendedAmount-"+k)),(map.get("BIType-"+j+" DueDate-"+k)),map.get("BIType-"+j+" Code-"+k));
						leaseblendedincome.saveBlendedItem();
					}
				}
				
				
		}
		
		leaseblendedincome.clickOnCloseButton();	
		
		}
		
		
		else
		{
			leaseblendedincome.clickOnCloseButton();
		}
		
		
		
		//Enter Accrual Screen
		LeaseEntryHomePage leaseentryhomepage = new LeaseEntryHomePage(driver, test);
		leaseentryhomepage.clickOnLeaseAccrualScreen();
		
		//Compute yield
		LeaseAccrualPage leaseaccrualpage= new LeaseAccrualPage(driver, test);
		leaseaccrualpage.clickOnComputeYieldButton();
		leaseaccrualpage.clickOnSaveButton();
		
		//Save Contract option page
		LeaseContractOptionPage leasecontractoptionpage = new LeaseContractOptionPage(driver, test);
		leasecontractoptionpage.clickOnSaveButton();
		
		//Save Causality page
		LeaseCasualityPage leasecasualitypage = new LeaseCasualityPage(driver, test);
		leasecasualitypage.clickOnSaveButton();
		
		//Save LeaseTaxFlows page
		LeaseTaxFlowsPage leasetaxflowpage = new LeaseTaxFlowsPage(driver, test);
		leasetaxflowpage.clickOnSaveButton();
		
		//Save LeaseServicing page
		LeaseServicingPage leaseservicingpage = new LeaseServicingPage(driver, test);
		leaseservicingpage.clickOnSaveButton();
		
		//Changing booking Status to Commenced
	//	LeaseEntryHomePage leasentryhomepage = new LeaseEntryHomePage(driver, test);
		leaseentryhomepage.selectLeaseBookingStatus();
		leaseentryhomepage.clickOnSaveButton();
		leaseentryhomepage.handlePopup1();
		
		//Verifying presence of Lease List title 
		leaseentryhomepage.verfyTittle("Lease List", "Title is matching");
		test.log(Status.PASS, "Lease commenced successfully");
		
	}
}

