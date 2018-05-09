package test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pom.CreateTransactionPage;
import pom.CustomerListPage;
import pom.FetchingIncrementedTakeDownNumber;
import pom.JarkFlowPage;
import pom.LeaseBlendedIncome;
import pom.LeaseClassificationPage;
import pom.LeaseIDCSetupPage;
import pom.LeaseSecurityDepositPage;
import pom.OriginationMenu;
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
import pom.VendorInvoiceListPage;
import pom.WorkFlowClassesMenu;

public class FrontEndLeaseDataSetupScriptV1

{
	
	
	
	public void frontendScript(WebDriver driver, ExtentTest test, Map<String,String> map) throws InterruptedException
	{
		
		OriginationMenu originationmenu = new OriginationMenu(driver, test);
		originationmenu.clickoriginationinstallation();

		
		// Opportunity
		
	
		WorkFlowClassesMenu workflowclassesmenu = null;
		TransactionHomePage transactionhomepage =  new TransactionHomePage(driver, test);
		String OpportunitytransactionNumber = null;
		TransactionListPage transactionlistpage = null;
		TransactionAdminPage transactionadminpage = new TransactionAdminPage(driver, test);
		
		
if(Integer.parseInt(map.get("Is Opportunity required ?"))==1)
		
{
		
		workflowclassesmenu =  new WorkFlowClassesMenu(driver, test);
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
		transactionbriefpage.clickOnSaveButton();
		
		
		transactionhomepage.clickOnGenericTab();
		transactionhomepage.clickOnAdminLink();
		
	
		transactionadminpage.selectReceiptCashGLTemplate(map.get("Receipt Cash GL Template"));
		transactionadminpage.selectBankProductCode(map.get("Bank Product Code"));
		transactionadminpage.selectCollateralCode(map.get("Collateral Code"));
		transactionadminpage.selectLoanPurposeCode(map.get("Loan Purpose Code"));
		transactionadminpage.selectRemarketingResponsibility(map.get("Remarketing Responsibilty"));
		
		
/*		String Interiminterest = map.get("GenerateInterimInterest?");
		int Ii = Integer.parseInt(Interiminterest);
		
		if(Ii==1)
		{
			transactionadminpage.clickOnGenerateInterimInterest();
			transactionadminpage.selectInterimInterestGLTemplate(map.get("InterimInterestGLTemplate"));
			Thread.sleep(2000);
			transactionadminpage.selectInterimInterestBillingType(map.get("InterimInterestBillingType"));
			transactionadminpage.enterBaseRate(map.get("BaseRate"));
			transactionadminpage.enterSpread(map.get("Spread"));
			
		}
		
	
		
		if(Integer.parseInt(map.get("GenerateInterimRent?"))==1)
		{
			transactionadminpage.clickOnGenerateInterimRent();
			transactionadminpage.selectInterimRentGLTemplate(map.get("InterimRentGLTemplate"));
			transactionadminpage.selectInterimRentBillingType(map.get("InterimRentBillingType"));
		}*/
		
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
	
		
		
		for(int i=1;i<=5;i++)
		{
		transactionhomepage.clickOnOverrideException();
		String beforewindow1 = transactionhomepage.clickOnFlowManagementtLink();
		
		JarkFlowPage jarkflowpage = new JarkFlowPage(driver, test);
		jarkflowpage.clickOnFlowChange();
		jarkflowpage.clickOnDefaultNextPath();
		jarkflowpage.clickOnContinue(beforewindow1);
		}
		
		
		OpportunitytransactionNumber = transactionhomepage.fetchTransactionNumber();
		transactionhomepage.opportunityVerification();
		
		
		//LOC

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
		
	
else // When Opportunity required is False
	{	
		workflowclassesmenu =  new WorkFlowClassesMenu(driver, test);
		workflowclassesmenu.clickOnWokFlowClassesMenu();
		workflowclassesmenu.clickOnOpenTransaction();

		transactionlistpage = new TransactionListPage(driver, test);
		transactionlistpage.enterTransactionNumber(map.get("LOC Transaction Number"));
		transactionlistpage.clickSearchButton();
		transactionlistpage.clickSelectButton();
	}
	
		String beforewindow2 = transactionhomepage.clickOnAutoProceduretLink();
		TransactionAutoProcedurePage transactionautoprocedurepage = new TransactionAutoProcedurePage(driver, test);
		transactionautoprocedurepage.clickRunButton();
		transactionautoprocedurepage.handlePopup1();
		transactionautoprocedurepage.clickCloseButton(beforewindow2);
		
		String LOCtransactionNumber = transactionhomepage.fetchTransactionNumber();
		transactionhomepage.locVerification();

		
		
		
		
		
		
		//TakeDown
		
		String TakeDownNumber;

		
		if (Integer.parseInt(map.get("Is Opportunity required ?")) == 0)
		{
			
			FetchingIncrementedTakeDownNumber fetchingincrementedtakeDownnumber = new FetchingIncrementedTakeDownNumber();
			TakeDownNumber = fetchingincrementedtakeDownnumber.fetchTakeDownNumber(map.get("LOC Transaction Number"));
			transactionlistpage.enterTransactionNumber(TakeDownNumber);
			
		}
		

		else 
		{
		
		transactionlistpage.enterTransactionNumber(LOCtransactionNumber.trim()+"-01");
		
		}
		
		transactionlistpage.clickSearchButton();
		transactionlistpage.clickSelectButton();
		
		transactionhomepage.clickOnGenericTab();
		
		
		transactionhomepage.clickOnAdminLink();
		
		
		//transactionadminpage.selectReceiptCashGLTemplate(map.get("Receipt Cash GL Template"));
		//transactionadminpage.selectBankProductCode(map.get("Bank Product Code"));
		//transactionadminpage.selectCollateralCode(map.get("Collateral Code"));
		//transactionadminpage.selectLoanPurposeCode(map.get("Loan Purpose Code"));
		//transactionadminpage.selectRemarketingResponsibility(map.get("Remarketing Responsibilty"));
		
		
		String Interiminterest = map.get("GenerateInterimInterest?");
		int Ii = Integer.parseInt(Interiminterest);
		
		if(Ii==1)
		{
			transactionadminpage.clickOnGenerateInterimInterest();
			transactionadminpage.selectInterimInterestGLTemplate(map.get("InterimInterestGLTemplate"));
			Thread.sleep(2000);
			transactionadminpage.selectInterimInterestBillingType(map.get("InterimInterestBillingType"));
			transactionadminpage.enterBaseRate(map.get("BaseRate"));
			transactionadminpage.enterSpread(map.get("Spread"));
			
		}
		
	
		
		if(Integer.parseInt(map.get("GenerateInterimRent?"))==1)
		{
			transactionadminpage.clickOnGenerateInterimRent();
			transactionadminpage.selectInterimRentGLTemplate(map.get("InterimRentGLTemplate"));
			transactionadminpage.selectInterimRentBillingType(map.get("InterimRentBillingType"));
		}
		
		transactionadminpage.clickSaveButton();
		
		

		
		transactionhomepage.clickOnFundingDetailsLink();
		
		TransactionFundingDetailsPage transactionfundingdetailspage = new TransactionFundingDetailsPage(driver, test);
		String beforewindow3 = transactionfundingdetailspage.clickAddButton();
		
		VendorInvoiceListPage vendornvoicelistpage = new VendorInvoiceListPage(driver, test);
		vendornvoicelistpage.addVendorInvoiceNumber(map.get("VendorInvoice Number"));
		vendornvoicelistpage.clickOnSearchButton();
		vendornvoicelistpage.clickOnSelectALLButton();
		vendornvoicelistpage.clickOnSelectButton(beforewindow3);
		
		transactionfundingdetailspage.clickSaveButton();
		
		transactionhomepage.clickOnLeaseTab();
		transactionhomepage.clickOnLeasedAssetLink();
		
		TransactionLeaseAssetPage transactionleaseassetpage = new TransactionLeaseAssetPage(driver, test);
		
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
		
		
		
		
		
		
		
		
		//Classification Page
		
		
		transactionhomepage.clickOnClassificationTestLink();
		
		LeaseClassificationPage leaseclassificationpage= new LeaseClassificationPage(driver, test);
		leaseclassificationpage.enterTotalEconomicLife(map.get("Total Economic Life"));
		leaseclassificationpage.enterTotalRemainingLife(map.get("Total Remaining Life"));
		leaseclassificationpage.clickOnPerform90PercentTestButton();
		leaseclassificationpage.handleAlert();
		leaseclassificationpage.handleAlert();
		Thread.sleep(3000);
		leaseclassificationpage.selectLeaseAccountingTreatment(map.get("Lease Accounting Treatment Type"));
		leaseclassificationpage.deselectTaxLease();
	//	leaseclassificationpage.deselectTracLease();
		leaseclassificationpage.selectLeaseBookingGLTemplate(map.get("Lease Booking GL Template"));
		leaseclassificationpage.selectLtrToARGLTemplate(map.get("LTR-AR GL Template"));
	//	lcp.selectOTPARGLTemplate(map.get("OTPARGLTemplate"));
		leaseclassificationpage.selectProduct(map.get("Product Code"));
		leaseclassificationpage.clickOnSaveButton();
		
		
		
		
		
		
		transactionhomepage.clickOnGlobalSave();
		
		
		
		
		transactionhomepage.clickOnServicingTab();
		System.out.println("servicing tab clicked");
		
		
		LeaseBlendedIncome leaseblendedincome = new LeaseBlendedIncome(driver, test);
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
					
									leaseblendedincome.addBlendedIncomeChargeBackWithAssetFrontEnd((map.get("BIType-"+j+" BlendedName-"+k)),(map.get("BIType-"+j+" BlendedAmount-"+k)),(map.get("BIType-"+j+" Inventory-"+k)),(map.get("BIType-"+j+" Code-"+k)));
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
			
		
			

		if(Integer.parseInt(map.get("Is IDC Required ?")) == 1)
		{
/*			for(int i = 1;i<=Integer.parseInt(map.get("Number of IDCs"));i++)
			{
				
				lidc.clickIDCAmount();
				lidc.enterIDCAmount((map.get("IDCAmount"+i)));
				lidc.clickOnSaveButton();
			}*/
		
			for(int j=0;j<Integer.parseInt(map.get("Number of IDCs"));j++)
				{
					transactionhomepage.clickOnIDCLink();
					LeaseIDCSetupPage leaseIDCsetuppage= new LeaseIDCSetupPage(driver, test);
					leaseIDCsetuppage.selectIDCTemplate(map.get("IDCTemplate"+(j+1)));
					WebElement IDCAmount = driver.findElement(By.id("ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3"));
					IDCAmount.click();
					WebElement AcquisitionCostClick = driver.findElement(By.id("igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls2"));
					AcquisitionCostClick.clear();
					AcquisitionCostClick.sendKeys(map.get("IDCAmount"+(j+1)));
					leaseIDCsetuppage.clickOnSaveButton();
				}
			
		}
			
			
			
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
		
		
		transactionhomepage.clickOnGlobalSave();
		
		for(int k=1;k<=6;k++)
		{
			transactionhomepage.clickOnOverrideException();
			String beforewindow1 = transactionhomepage.clickOnFlowManagementtLink();
			JarkFlowPage jarkflowpage = new JarkFlowPage(driver, test);
			jarkflowpage.clickOnFlowChange();
			jarkflowpage.clickOnDefaultNextPath();
			jarkflowpage.clickOnContinue(beforewindow1);
		}
		Thread.sleep(4000);
		transactionhomepage.takedownVerification();
		test.log(Status.PASS, "FrontEnd Lease commenced successfully");
	}
	

   }
	

