package moduleLevelTestScripts;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pom.CreateTransactionPage;
import pom.CustomerListPage;
import pom.FetchingIncrementedTakeDownNumber;
import pom.InterimInterestUpdatePage;
import pom.InterimRentUpdatePage;
import pom.JarkFlowPage;
import pom.LeaseBlendedIncome;
import pom.LeaseClassificationPage;
import pom.LeaseIDCSetupPage;
import pom.LeaseSecurityDepositPage;
import pom.OriginationMenu;
import pom.PortFolioManagementMenu;
import pom.TransactionAdminPage;
import pom.TransactionAutoProcedurePage;
import pom.TransactionBriefPage;
import pom.TransactionCreditDecisionPage;
import pom.TransactionFundingDetailsPage;
import pom.TransactionHomePage;
import pom.TransactionLeaseAssetPage;
import pom.TransactionListPage;
import pom.TransactionPaymentCalculatorPage;
import pom.TransactionProposalPage;
import pom.UpdatesMenuPage;
import pom.VendorInvoiceListPage;
import pom.WorkFlowClassesMenu;
import pom.jobListPage;

public class FrontEndLeaseWithCapitalizationDataSetupScript

{
	
	public void frontendScript(WebDriver driver, ExtentTest test, Map<String,String> map) throws InterruptedException
	{

		OriginationMenu originationmenu = new OriginationMenu(driver, test);
		originationmenu.clickoriginationinstallation();

		WorkFlowClassesMenu workflowclassesmenu = new WorkFlowClassesMenu(driver, test);
		TransactionHomePage transactionhomepage =  new TransactionHomePage(driver, test);
		String OpportunitytransactionNumber = null;
		TransactionListPage transactionlistpage = new TransactionListPage(driver, test);
		TransactionAdminPage transactionadminpage = new TransactionAdminPage(driver, test);
		
	 	/*Checking whether Opportunity is required, 
		if Yes, creates an Opportunity and LOC 	*/
	if(Integer.parseInt(map.get("Is Opportunity required ?"))==1)		
		{	
			
			workflowclassesmenu.clickOnWokFlowClassesMenu();
			workflowclassesmenu.clickOnNewTransaction();
			
			CustomerListPage customerlistpage = new CustomerListPage(driver, test);
			customerlistpage.enterAccountNumber(map.get("Account Number"));
			customerlistpage.clickOnsearchButton();
			customerlistpage.clickOnSelectButton();
			
			CreateTransactionPage createtransactionpage = new CreateTransactionPage(driver, test);
			createtransactionpage.clickSelectButton();	
			TransactionBriefPage transactionbriefpage = new TransactionBriefPage(driver, test);
			transactionbriefpage.selectOriginationChannel(map.get("Origination Channel"));
			
			if(map.get("Origination Channel").equalsIgnoreCase("Indirect"))
			{
				transactionbriefpage.enterDealSource(map.get("Deal Source"));
			}
			
			transactionbriefpage.clickOnSaveButton();
			
			transactionhomepage.clickOnGenericTab();
			transactionhomepage.clickOnAdminLink();
			
			transactionadminpage.selectReceiptCashGLTemplate(map.get("Receipt Cash GL Template"));
			transactionadminpage.selectBankProductCode(map.get("Bank Product Code"));
			transactionadminpage.selectCollateralCode(map.get("Collateral Code"));
			transactionadminpage.selectLoanPurposeCode(map.get("Loan Purpose Code"));
			transactionadminpage.selectRemarketingResponsibility(map.get("Remarketing Responsibilty"));
			transactionadminpage.clickSaveButton();
			
			transactionhomepage.clickOnProposalLink();
			TransactionProposalPage transactionproposalpage = new TransactionProposalPage(driver, test);
			transactionproposalpage.enterOpportunityAmount(map.get("Opportunity Amount"));
			transactionproposalpage.selectSpecializedCategoryAsset(map.get("Specialized Asset Category"));
			transactionproposalpage.enterexhibitAmount(map.get("Exhibit Amount"));
			transactionproposalpage.selectTransactionType(map.get("Transaction Type"));
			transactionproposalpage.checkIndexBased();
			transactionproposalpage.enterNumberOfPayments(map.get("Number Of Payments"));
			//tpp.clickExhibitSaveButton();
			transactionproposalpage.clickSaveButton();
			
			transactionhomepage.clickOnGlobalSave();
		
			// Flow Management, i<5 because Opportunity has 5 steps
			for(int i=1;i<=5;i++)
			{
			transactionhomepage.clickOnOverrideException();
			String beforewindow1 = transactionhomepage.clickOnFlowManagementtLink();
			JarkFlowPage jarkflowpage = new JarkFlowPage(driver, test);
			jarkflowpage.clickOnFlowChange();
			jarkflowpage.clickOnDefaultNextPath();
			jarkflowpage.clickOnContinue(beforewindow1);
			}
			
			// Fetching Opportunity number to input that in LOC
			OpportunitytransactionNumber = transactionhomepage.fetchTransactionNumber();
			
			// Verifying whether Opportunity is in last step
			transactionhomepage.opportunityVerification();
			
			test.log(Status.PASS, "Opportunity created successfully");
			
			//Creating Line of Credit (LOC)
			workflowclassesmenu.clickOnWokFlowClassesMenu();
			workflowclassesmenu.clickOnOpenTransaction();
			
			transactionlistpage = new TransactionListPage(driver, test);
			transactionlistpage.enterTransactionNumber(OpportunitytransactionNumber.trim()+"-01");
			transactionlistpage.clickSearchButton();
			transactionlistpage.clickSelectButton();
			
			transactionhomepage.clickOnGenericTab();
			transactionhomepage.clickOnCreditDecisionLink();
		
			TransactionCreditDecisionPage transactioncreditdecisionpage = new TransactionCreditDecisionPage(driver, test);
			transactioncreditdecisionpage.clickOnAddButton();
			transactioncreditdecisionpage.enterRequestedAmount(map.get("Requested Amount"));
			transactioncreditdecisionpage.enterCreditDecisionName(map.get("Credit Decision Name"));
			transactioncreditdecisionpage.enterDecisionDate(map.get("Credit Decision Date"));
			transactioncreditdecisionpage.enterCommitmentExpiryDate(map.get("Commitment Expiry Date"));
			transactioncreditdecisionpage.enterChangeInApprovedAmout(map.get("Change in Approved Amount"));
			transactioncreditdecisionpage.clickOnSaveButton();
			transactioncreditdecisionpage.clickOnPageSaveButton();
		
			transactionhomepage.clickOnGlobalSave();
			
			//Flow Management, i<4 because LOC has 4 steps
			for(int j=1;j<=4;j++)
			{
			transactionhomepage.clickOnOverrideException();
			String beforewindow1 = transactionhomepage.clickOnFlowManagementtLink();
			
			JarkFlowPage jarkflowpage = new JarkFlowPage(driver, test);
			jarkflowpage.clickOnFlowChange();
			jarkflowpage.clickOnDefaultNextPath();
			jarkflowpage.clickOnContinue(beforewindow1);
			}
		}	
			
		/*When Opportunity required is False,
		Takes LOC number as input and creates a TakeDown*/
	else 
		{	
			workflowclassesmenu =  new WorkFlowClassesMenu(driver, test);
			workflowclassesmenu.clickOnWokFlowClassesMenu();
			workflowclassesmenu.clickOnOpenTransaction();
	
			
			transactionlistpage.enterTransactionNumber(map.get("LOC Transaction Number"));
			transactionlistpage.clickSearchButton();
			transactionlistpage.clickSelectButton();
		}
			
			// Runs AutoProcedure to create TakeDown
			String beforewindow2 = transactionhomepage.clickOnAutoProceduretLink();
			TransactionAutoProcedurePage transactionautoprocedurepage = new TransactionAutoProcedurePage(driver, test);
			transactionautoprocedurepage.clickRunButton();
			transactionautoprocedurepage.handlePopup1();
			transactionautoprocedurepage.clickCloseButton(beforewindow2);
			
			// Fetching Transaction number to input that in TakeDown
			String LOCtransactionNumber = transactionhomepage.fetchTransactionNumber();
			
			// Verifying whether LOC is in last step
			transactionhomepage.locVerification();
	
			test.log(Status.PASS, "LOC Autoprocedure ran successfully and created a TakeDown");
	
			//TakeDown
			String TakeDownNumber = null;
	
			/*If Opportunity is not required,
			then fetch the latest TakeDown number from DB created when Autoprocedure was run in LOC*/
			if (Integer.parseInt(map.get("Is Opportunity required ?")) == 0)
			{
				
				FetchingIncrementedTakeDownNumber fetchingincrementedtakeDownnumber = new FetchingIncrementedTakeDownNumber();
				TakeDownNumber = fetchingincrementedtakeDownnumber.fetchTakeDownNumber(map.get("LOC Transaction Number"));
				transactionlistpage.enterTransactionNumber(TakeDownNumber);	
			}
			

			
			/*If Opportuntiy is required,
			then append -01 to LOC number created*/
			else 
			{
				
				transactionlistpage.enterTransactionNumber(LOCtransactionNumber.trim()+"-01");
			
			}
			
			// Select the searched TakeDown
			transactionlistpage.clickSearchButton();
			transactionlistpage.clickSelectButton();
			
			//Enter TakeDown
			transactionhomepage.clickOnGenericTab();
			
			//Click on Admin link
			transactionhomepage.clickOnAdminLink();
			transactionadminpage.selectRemarketingResponsibility(map.get("Remarketing Responsibilty"));
	
			// If residaul at asset level is required and if it is marked False in UI, makes it True
			if(Integer.parseInt(map.get("Is Residual Entered At Asset Level ?"))==1)
			{
				if(transactionadminpage.verifyEnterResidualAtAssetLevelCheckBoxChecked()== false)
				{
					transactionadminpage.clickOnEnterResidualAtAssetLevel();
				}
			}
			
			// If residaul at asset level is not required and if it is marked True in UI, makes it False
			else if(transactionadminpage.verifyEnterResidualAtAssetLevelCheckBoxChecked()== true)
			{
					transactionadminpage.clickOnEnterResidualAtAssetLevel();
			}
			
			// Enters Interim Interest details if required
			if(Integer.parseInt(map.get("GenerateInterimInterest?"))==1)
			{
			
				if(transactionadminpage.verifyInterimInterestCheckBoxChecked()== false) 
				{
					transactionadminpage.clickOnGenerateInterimInterest();
					transactionadminpage.selectInterimInterestGLTemplate(map.get("InterimInterestGLTemplate"));
					Thread.sleep(2000);
					transactionadminpage.selectInterimInterestBillingType(map.get("InterimInterestBillingType"));
					transactionadminpage.enterBaseRate(map.get("BaseRate"));
					transactionadminpage.enterSpread(map.get("Spread"));
				}
			}
			
		
			// Enters Interim Rent details if required
			if(Integer.parseInt(map.get("GenerateInterimRent?"))==1)
			{
				
				if(transactionadminpage.verifyInterimRentCheckBoxChecked()== false)
				{
					transactionadminpage.clickOnGenerateInterimRent();
					transactionadminpage.selectInterimRentGLTemplate(map.get("InterimRentGLTemplate"));
					transactionadminpage.selectInterimRentBillingType(map.get("InterimRentBillingType"));
				}
			}
			
			transactionadminpage.clickSaveButton();
			
			// Click on Funding Details screen
			transactionhomepage.clickOnFundingDetailsLink();
			
			TransactionFundingDetailsPage transactionfundingdetailspage = new TransactionFundingDetailsPage(driver, test);
			String beforewindow3 = transactionfundingdetailspage.clickAddButton();
			
			VendorInvoiceListPage vendornvoicelistpage = new VendorInvoiceListPage(driver, test);
			vendornvoicelistpage.addVendorInvoiceNumber(map.get("VendorInvoice Number"));
			vendornvoicelistpage.clickOnSearchButton();
			vendornvoicelistpage.clickOnSelectALLButton();
			vendornvoicelistpage.clickOnSelectButton(beforewindow3);
			transactionfundingdetailspage.clickSaveButton();
			
	
			// Click on Lease Tab
			transactionhomepage.clickOnLeaseTab();
			
			//Leased Assets Screen
			transactionhomepage.clickOnLeasedAssetLink();
			TransactionLeaseAssetPage transactionleaseassetpage = new TransactionLeaseAssetPage(driver, test);
			
			for(int i=1; i<=Integer.parseInt(map.get("Total number of Assets"));i++)
			{
				if(Integer.parseInt(map.get("Lease Rent Amount differs at Asset Level ?"))==1)
				{	
					transactionleaseassetpage.enterFMVValue(map.get("FMV Value"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterLeaseRentFactor(map.get("Lease Rent Factor"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterLeaseRentAmount(map.get("Lease Rent Amount"+i), map.get("Inventory alias"+ i));
				}
	
				if(Integer.parseInt(map.get("Interim details differ at Asset level ?"))==1)
				{
				
					transactionleaseassetpage.enterInterimRentStartDate(map.get("Interim Rent Start Date"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterInterimRentFactor(map.get("Interim Rent Factor"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterInterimRentAmount(map.get("Interim Rent Amount"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterInterimInterestStartDate(map.get("Interim Interest Start Date"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterInterimInterestBasisPercentage(map.get("Interim Interest Basis Percentage"+i), map.get("Inventory alias"+ i));
				}
	
				if(Integer.parseInt(map.get("Is Residual Entered At Asset Level ?"))==1)
				{
					transactionleaseassetpage.enterResidualBookedAmount(map.get("Residual Booked Amount"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterResidualBookedpercentage(map.get("Residual Booked Percentage"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterResidualExpectedpercentage(map.get("Residual Expected Percentage"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterResidualBookedAmount(map.get("Residual Expected Amount"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterCustomerResidualGurantee(map.get("Customer Residual Gurantee"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterThirdPartyTotalResidualGurantee(map.get("Third Party Total Residual Gurantee"+i), map.get("Inventory alias"+ i));
					transactionleaseassetpage.enterResidualValueInsurance(map.get("Residual Value Insurance"+i), map.get("Inventory alias"+ i));
				}
			
				//transactionleaseassetpage.enterMarkUpAmount(map.get("MarkUp Amount"+i), map.get("Inventory alias"+ i));
			}	
				
			// If Interim details are to be enetered at Lease level then it selects all the inventories and en-mass updates
			if((map.get("Interim details differ at Asset level ?")).equals("0"))
			{
				if(Integer.parseInt(map.get("GenerateInterimInterest?"))==1)
				{
					transactionleaseassetpage.clickselectAllButton();
					transactionleaseassetpage.selectInterimInterestStartDate();
					transactionleaseassetpage.addInterimInterestStartDate(map.get("InterimInterestStartDate"));
					transactionleaseassetpage.clicksAddButton();
					transactionleaseassetpage.clicksAssignButton();
				}
	
				if(Integer.parseInt(map.get("GenerateInterimRent?"))==1)
				{
					transactionleaseassetpage.clickselectAllButton();
					transactionleaseassetpage.selectInterimRentStartDate();
					transactionleaseassetpage.addInterimRentStartDate(map.get("InterimRentStartDate"));
					transactionleaseassetpage.clicksAddButton();
					transactionleaseassetpage.selectInterimRentAmount();
					transactionleaseassetpage.addInterimRentAmount(map.get("InterimRentAmount"));
					transactionleaseassetpage.clicksAddButton();
					transactionleaseassetpage.clicksAssignButton();
				}
			}
			transactionleaseassetpage.clickSaveButton();
	
			//Payment Calculator
			transactionhomepage.clickOnPaymentCalculatorLink();
			TransactionPaymentCalculatorPage transactionpaymentcalculatorpage = new TransactionPaymentCalculatorPage(driver, test);
			transactionpaymentcalculatorpage.enterNumberCommencementPayments(map.get("Number Of Commencement Payments"));
	
			if(Integer.parseInt(map.get("Number Of Commencement Payments"))==1)
			{		
				transactionpaymentcalculatorpage.enterCommencementPayment(map.get("Commencement Payment"));
			}	
			transactionpaymentcalculatorpage.enterNumberOfPayments(map.get("Number Of Payments"));
			transactionpaymentcalculatorpage.enterCommencementDate(map.get("Commencement Date"));
			transactionpaymentcalculatorpage.selectPaymentFrequency(map.get("Payment Frequency"));
			transactionpaymentcalculatorpage.enterDueDay((map.get("Due Day")));
			transactionpaymentcalculatorpage.selectPaymentStructure(map.get("Payment Structure"));
			transactionpaymentcalculatorpage.enterRegularPayment(map.get("Regular Payment Amount"));
		
			if(Integer.parseInt(map.get("UpFront Payment"))>0)
			{
				transactionpaymentcalculatorpage.enterOtherUpfrontPayment(map.get("UpFront Payment"));
			}
		
			if(Integer.parseInt(map.get("Is Residual Entered At Asset Level ?"))==0)
			{		
				if(Integer.parseInt(map.get("Pricing Residual"))>0)
				{
					transactionpaymentcalculatorpage.enterPricingResidual(map.get("Pricing Residual"));
				}
				
				if(Integer.parseInt(map.get("Residual Booked"))>0)
				{
					transactionpaymentcalculatorpage.enterRsidualBooked(map.get("Residual Booked"));
				}
			
				if(Integer.parseInt(map.get("Lessor Risk"))>0)
				{
					transactionpaymentcalculatorpage.enterLessorRisk(map.get("Lessor Risk"));
				}
				
				if(Integer.parseInt(map.get("Customer Risk"))>0)
				{
					transactionpaymentcalculatorpage.enterCustomerRisk(map.get("Customer Risk"));
				}
				
				if(Integer.parseInt(map.get("Third Party Risk"))>0)
				{
					transactionpaymentcalculatorpage.enterThirdPartyRisk(map.get("Third Party Risk"));
				}
				
				if(Integer.parseInt(map.get("Residual Value Insurance"))>0)
				{
					transactionpaymentcalculatorpage.enterResidualValueInsurance("Residual Value Insurance");
				}
			
			}
	
			if(Integer.parseInt(map.get("Is Float Rate Deal ?"))==1)
			{
				transactionpaymentcalculatorpage.clickFloatRateLease();
				transactionpaymentcalculatorpage.enterFloatRateEffectiveDate(map.get("Float Rate Effective Date"));
				transactionpaymentcalculatorpage.selectFloatRateIndex(map.get("Float Rate Index"));
				transactionpaymentcalculatorpage.selectDayCountMethod(map.get("Float Rate Day Count Method"));
				transactionpaymentcalculatorpage.selectNonBusinessDayRule(map.get("Float Rate Non Bussiness Day Rule"));
				transactionpaymentcalculatorpage.enterEffectiveRateDayOfMonth(map.get("Effective Rate Day of Month"));
				transactionpaymentcalculatorpage.enterEffectiveRateLeadUnits(map.get("Effective Rate Lead units"));
			}
			
			transactionpaymentcalculatorpage.clickGeneratePaymentsButton();
			transactionpaymentcalculatorpage.clickSaveButton();
	
			// click on Servicing Tab
			transactionhomepage.clickOnServicingTab();
			LeaseBlendedIncome leaseblendedincome = new LeaseBlendedIncome(driver, test);
			
			// Blended Item details
			if(Integer.parseInt(map.get("Is BI Required ?")) == 1)
			{
				transactionhomepage.clickOnBlendedIncomeLink();
	
				for(int j=1;j<=Integer.parseInt(map.get("Number of BI Types"));j++)
					{
						String BlendType = map.get("BI Type"+j);
							if(BlendType.equalsIgnoreCase("AssetBased-FAS91") || BlendType.equalsIgnoreCase("AssetBased-NonFAS91") )
								{
					
									for(int k=1;k<=Integer.parseInt(map.get("Number of BI Type "+j));k++)
									{
						
										leaseblendedincome.addBlendedIncomeChargeBackWithAssetFrontEnd((map.get("BIType-"+j+" BlendedName-"+k)),(map.get("BIType-"+j+" BlendedAmount-"+k)),(map.get("BIType-"+j+" alias-"+k)),(map.get("BIType-"+j+" Code-"+k)));
										leaseblendedincome.saveBlendedItem();
									}
								}
							else if(BlendType.equalsIgnoreCase("LeaseBased-FAS91") ||BlendType.equalsIgnoreCase("LeaseBased-NonFAS91"))
							{
	
								System.out.println("Test");						
								for(int k=1;k<=Integer.parseInt(map.get("Number of BI Type "+j));k++)
								{
									System.out.println("Test1");	
									leaseblendedincome.addBlendedIncomeChargeBack((map.get("BIType-"+j+" BlendedName-"+k)),(map.get("BIType-"+j+" BlendedAmount-"+k)),map.get("BIType-"+j+" Code-"+k));
									leaseblendedincome.saveBlendedItem();
								}
							}
							
							
					}
				
				leaseblendedincome.clickOnFrontEndCloseButton();
			}
				
			// Lease IDC setup
			if(Integer.parseInt(map.get("Is IDC Required ?")) == 1)
			{
				// If IDC count is just 1
				if(Integer.parseInt(map.get("Number of IDCs"))==1)
				{
				transactionhomepage.clickOnIDCLink();
				LeaseIDCSetupPage leaseIDCsetuppage= new LeaseIDCSetupPage(driver, test);	
				leaseIDCsetuppage.selectIDCTemplate(map.get("IDCTemplate1"));
				
				if(Integer.parseInt(map.get("IDCAmount1"))>0)
				{
					WebElement IDCAmount = driver.findElement(By.id("ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3"));
					WebDriverWait wait = new WebDriverWait(driver, 5);
					wait.until(ExpectedConditions.elementToBeClickable(IDCAmount));
					IDCAmount.click();
					WebElement AcquisitionCostClick = driver.findElement(By.id("igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls2"));
					wait.until(ExpectedConditions.elementToBeClickable(AcquisitionCostClick));
					AcquisitionCostClick.clear();
					AcquisitionCostClick.sendKeys(map.get("IDCAmount1"));
				}
				
				if(Integer.parseInt(map.get("IDCFixedAmount1"))>0)
				{
					leaseIDCsetuppage.enterFixedPortionAmount(map.get("IDCFixedAmount1"));
				}
				
				if(Integer.parseInt(map.get("IDCVariablePercentage1"))>0)
				{
					leaseIDCsetuppage.enterFixedPortionAmount(map.get("IDCVariablePercentage1"));
				}
				leaseIDCsetuppage.clickOnSaveButton();
				}
				
				/*If IDC count is more than 1,
				First choose one IDC template and later add 'n' number of Buckets to it*/
				else if(Integer.parseInt(map.get("Number of IDCs"))>1)
				{
					
					LeaseIDCSetupPage leaseIDCsetuppage= new LeaseIDCSetupPage(driver, test);
					transactionhomepage.clickOnIDCLink();
					leaseIDCsetuppage.selectIDCTemplate(map.get("IDCTemplate1"));
					WebDriverWait wait = new WebDriverWait(driver, 5);
					
					if(Integer.parseInt(map.get("IDCAmount1"))>0)
					{
					WebElement IDCAmount = driver.findElement(By.id("ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3"));
					wait.until(ExpectedConditions.elementToBeClickable(IDCAmount));
					IDCAmount.click();
					WebElement AcquisitionCostClick = driver.findElement(By.id("igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls2"));
					wait.until(ExpectedConditions.elementToBeClickable(AcquisitionCostClick));
					AcquisitionCostClick.clear();
					AcquisitionCostClick.sendKeys(map.get("IDCAmount1"));
					}
					
					if(Integer.parseInt(map.get("IDCFixedAmount1"))>0)
					{
						leaseIDCsetuppage.enterFixedPortionAmount(map.get("IDCFixedAmount1"));
					}
					
					if(Integer.parseInt(map.get("IDCVariablePercentage1"))>0)
					{
						leaseIDCsetuppage.enterFixedPortionAmount(map.get("IDCVariablePercentage1"));
					}
					
					
					
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
				
						/*java.util.List<WebElement> bookExpenseMode = driver.findElements(By.xpath("//*[@id='ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_"+j+"_6']/select"));	
						bookExpenseMode.click();
						Select select = new Select(bookExpenseMode);
						select.selectByVisibleText(map.get("Book Expense mode"+(j+1)));
						*/	
					}
				
					leaseIDCsetuppage.clickOnSaveButton();
				}
			}
	
			// Lease Security Deposit setup	
			LeaseSecurityDepositPage leasesecuritydepositpage = new LeaseSecurityDepositPage(driver, test);
				
			if(Integer.parseInt(map.get("Is Security deposit Required ?")) == 1)
				{
					
					for(int i = 1;i<=Integer.parseInt(map.get("Number of Security Deposits"));i++)
					{
			
						transactionhomepage.clickOnSecurityDepositLink();
						leasesecuritydepositpage.clickOnAddButton();
						leasesecuritydepositpage.selectcodeName(map.get("Security deposit Code"+i));
						leasesecuritydepositpage.enterAmount(map.get("Security deposit Amount"+i));
						leasesecuritydepositpage.clickOnSaveButton();
						leasesecuritydepositpage.clickOnCloseButton();
					}
				}
			
			transactionhomepage.clickOnOverrideException();
			transactionhomepage.clickOnGlobalSave();
			transactionhomepage.clickOnCloseButton();
			
	
			// Navigates to Updates (Interim Rent and Interim Interest)
			PortFolioManagementMenu portfoliomanagementmenu = new PortFolioManagementMenu(driver, test);
			portfoliomanagementmenu.clickPortFolioManagement();
		
			UpdatesMenuPage updatesmenupage = new UpdatesMenuPage(driver, test);
			
			/*Initialize the Job status to NA incase if any of the 2 updates(Interim Interest/Interim Rent) is not Required
			Ex - Execution should proceed evn if only 1 update is required
			Interim Interest - yes & Interim Rent - No
			Interim Interest - No & Interim Rent - Yes*/
			String interiminterestjobstatus = "NA",interimrentjobstatus = "NA";
			
			
			if(Integer.parseInt(map.get("GenerateInterimInterest?"))==1 && map.get("InterimInterestBillingType").equalsIgnoreCase("Capitalization"))
			{
				updatesmenupage.runinterimInterestUpdate();
				
				InterimInterestUpdatePage interiminterestupdatepage = new InterimInterestUpdatePage(driver, test);
				interiminterestupdatepage.clickLeaseRadioButton();
				if(Integer.parseInt(map.get("Is Opportunity required ?"))==1)
				{
					interiminterestupdatepage.enterLeaseSequenceNumber(LOCtransactionNumber.trim()+"-01");
				}
				else
				{
					interiminterestupdatepage.enterLeaseSequenceNumber(TakeDownNumber);
				}
				interiminterestupdatepage.enterUpdateThroughDate(map.get("Interim Interest update through date"));
				interiminterestupdatepage.clickRunImmediatelyRadioButton();
				interiminterestupdatepage.clickRunUpdate();
				interiminterestupdatepage.clickOnJobID();
				jobListPage joblistpage = new jobListPage(driver, test);
				interiminterestjobstatus = 	joblistpage.validateJobStatus();
				System.out.println("Interim Interest Job Status-"+interiminterestjobstatus);
				test.log(Status.PASS, "Interim Interest Job ran successfully");
			}
			
			else
			{
				test.log(Status.FAIL, "Interim Interest billing type is not Capitalization");
			}
	
			
			if(Integer.parseInt(map.get("GenerateInterimRent?"))==1 && map.get("InterimRentBillingType").equalsIgnoreCase("Capitalization"))
			{
				updatesmenupage.runinterimRentUpdate();
				
				InterimRentUpdatePage interimrentupdatepage = new InterimRentUpdatePage(driver, test);
				interimrentupdatepage.clickLeaseRadioButton();
				if(Integer.parseInt(map.get("Is Opportunity required ?"))==1)
				{
					interimrentupdatepage.enterLeaseSequenceNumber(LOCtransactionNumber.trim()+"-01");
				}
				else
				{
					interimrentupdatepage.enterLeaseSequenceNumber(TakeDownNumber);
				}
				interimrentupdatepage.enterUpdateThroughDate(map.get("Interim Rent update through date"));
				interimrentupdatepage.clickRunImmediatelyRadioButton();
				interimrentupdatepage.clickRunUpdate();
				interimrentupdatepage.clickOnJobID();
				jobListPage joblistpage = new jobListPage(driver, test);
				interimrentjobstatus = 	joblistpage.validateJobStatus();
				System.out.println("Interim Rent Job Status-"+interimrentjobstatus);
				test.log(Status.PASS, "Interim Rent Job ran successfully");
			}
			
			else
			{
				test.log(Status.FAIL, "Interim Rent billing type is not Capitalization");
			}
			
			
			System.out.println("Both jobs ran");
			
			//Execution should proceed If an update ran successfully or if it was not required
			if((interiminterestjobstatus.equals("Completed Successfully") || interiminterestjobstatus.equalsIgnoreCase("NA"))  &&  
					(interimrentjobstatus.equals("Completed Successfully") || interimrentjobstatus.equalsIgnoreCase("NA")))
		
			{
					originationmenu.clickoriginationinstallation();
					workflowclassesmenu.clickOnWokFlowClassesMenu();
					workflowclassesmenu.clickOnOpenTransaction();
	
					if(Integer.parseInt(map.get("Is Opportunity required ?"))==1)
					{
						transactionlistpage.enterTransactionNumber(LOCtransactionNumber.trim()+"-01");
					}
					else
					{
						transactionlistpage.enterTransactionNumber(TakeDownNumber);
					}
					
					transactionlistpage.clickSearchButton();
					transactionlistpage.clickSelectButton();
					
					//Flow Management - Push TakeDown to S2
					for(int k=1;k<2;k++)
					{
						transactionhomepage.clickOnOverrideException();
						String beforewindow1 = transactionhomepage.clickOnFlowManagementtLink();
						JarkFlowPage jarkflowpage = new JarkFlowPage(driver, test);
						jarkflowpage.clickOnFlowChange();
						jarkflowpage.clickOnDefaultNextPath();
						jarkflowpage.clickOnContinue(beforewindow1);
					}
					
					//Global Save before Autoprocedure
					transactionhomepage.clickOnOverrideException();
					transactionhomepage.clickOnGlobalSave();
				
					// Run Autoprocedure
					String beforewindow4 = transactionhomepage.clickOnAutoProceduretLink();
					//TransactionAutoProcedurePage transactionautoprocedurepage = new TransactionAutoProcedurePage(driver, test);
					transactionautoprocedurepage.clickRunButton();
					transactionautoprocedurepage.handlePopup1();
					transactionautoprocedurepage.clickCloseButton(beforewindow4);
				
					// Click on Lease Tab
					transactionhomepage.clickOnLeaseTab();
					
					// Click on Classification Link
					transactionhomepage.clickOnClassificationTestLink();
					LeaseClassificationPage leaseclassificationpage= new LeaseClassificationPage(driver, test);
					leaseclassificationpage.enterTotalEconomicLife(map.get("Total Economic Life"));
					leaseclassificationpage.enterTotalRemainingLife(map.get("Total Remaining Life"));
					leaseclassificationpage.clickOnPerform90PercentTestButton();
					leaseclassificationpage.handleAlert();
					//wait for the next alert
					Thread.sleep(1000);
					leaseclassificationpage.handleAlert();
					Thread.sleep(1000);
			
					
					if((map.get("Lease Accounting Treatment Type")).equalsIgnoreCase("Sales Type") ||(map.get("Lease Accounting Treatment Type")).equalsIgnoreCase("Conditional Sales") || (map.get("Lease Accounting Treatment Type")).equalsIgnoreCase("Direct Finance") )
					{
						leaseclassificationpage.selectLeaseAccountingTreatment(map.get("Lease Accounting Treatment Type"));
					}
					leaseclassificationpage.deselectTaxLease();
				//	leaseclassificationpage.deselectTracLease();
					leaseclassificationpage.selectLeaseBookingGLTemplate(map.get("Lease Booking GL Template"));
					leaseclassificationpage.selectLtrToARGLTemplate(map.get("LTR-AR GL Template"));
				//	lcp.selectOTPARGLTemplate(map.get("OTPARGLTemplate"));
					leaseclassificationpage.selectProduct(map.get("Product Code"));
					leaseclassificationpage.clickOnSaveButton();
					
					transactionhomepage.clickOnOverrideException();
					transactionhomepage.clickOnGlobalSave();
			
					// Flow management to pust TakeDown to S18
					for(int k=1;k<=4;k++)
					{
						transactionhomepage.clickOnOverrideException();
						String beforewindow1 = transactionhomepage.clickOnFlowManagementtLink();
						JarkFlowPage jarkflowpage = new JarkFlowPage(driver, test);
						jarkflowpage.clickOnFlowChange();
						jarkflowpage.clickOnDefaultNextPath();
						jarkflowpage.clickOnContinue(beforewindow1);
					}
					
					transactionhomepage.clickOnOverrideException();
					transactionhomepage.clickOnGlobalSave();
					
					//Final round of Lease Classification - BBNT Requirement
					// Click on Lease Tab
					transactionhomepage.clickOnLeaseTab();
					
					// Click on Classification Link
					transactionhomepage.clickOnClassificationTestLink();
					leaseclassificationpage.enterTotalEconomicLife(map.get("Total Economic Life"));
					leaseclassificationpage.enterTotalRemainingLife(map.get("Total Remaining Life"));
					leaseclassificationpage.clickOnPerform90PercentTestButton();
					leaseclassificationpage.handleAlert();
					leaseclassificationpage.handleAlert();
					Thread.sleep(3000);
					
					if((map.get("Lease Accounting Treatment Type")).equalsIgnoreCase("Sales Type") ||(map.get("Lease Accounting Treatment Type")).equalsIgnoreCase("Conditional Sales") || (map.get("Lease Accounting Treatment Type")).equalsIgnoreCase("Direct Finance") )
					{
						leaseclassificationpage.selectLeaseAccountingTreatment(map.get("Lease Accounting Treatment Type"));
					}
					leaseclassificationpage.selectLeaseBookingGLTemplate(map.get("Lease Booking GL Template"));
					leaseclassificationpage.selectLtrToARGLTemplate(map.get("LTR-AR GL Template"));
				//	lcp.selectOTPARGLTemplate(map.get("OTPARGLTemplate"));
					leaseclassificationpage.selectProduct(map.get("Product Code"));
					leaseclassificationpage.clickOnSaveButton();
					
					transactionhomepage.clickOnOverrideException();
					transactionhomepage.clickOnGlobalSave();
					
					//Flow Management to push TakeDown to S19
					for(int k=1;k<2;k++)
					{
						//transactionhomepage.clickOnOverrideException();
						String beforewindow1 = transactionhomepage.clickOnFlowManagementtLink();
						JarkFlowPage jarkflowpage = new JarkFlowPage(driver, test);
						jarkflowpage.clickOnFlowChange();
						jarkflowpage.clickOnDefaultNextPath();
						jarkflowpage.clickOnContinue(beforewindow1);
					}
					transactionhomepage.takedownVerification();
					test.log(Status.PASS, "FrontEnd Lease commenced successfully");
					test.log(Status.PASS, "Lease Transaction number -"+TakeDownNumber);
			}
			
			else
			{
				System.out.println("Job failed");
				test.log(Status.FAIL, "FrontEnd Lease Failed - Either Interim Rent/Interim Interest Job has failed");
			}
	
		}
	
}
	

