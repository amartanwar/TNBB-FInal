package endToEndScenarios;

import java.util.Map;

import org.testng.annotations.Test;

import endToEndTestScripts.LTRtoAR_IncomeRecog_E2E;
import endToEndTestScripts.LeaseNonAccrualAndAccrualScript_E2E;
import endToEndTestScripts.PayoffScript_E2E;
import endToEndTestScripts.ReceiptPostingDataSetupScript_E2E;
import generic.BaseTest;
import moduleLevelTestScripts.AssetCreation;
import moduleLevelTestScripts.CustomerCreation;
import moduleLevelTestScripts.FrontEndLeaseDataSetupScript;
import moduleLevelTestScripts.LeaseRestructureScript;
import moduleLevelTestScripts.VendorInvoiceCreation;
import testDataProvider_Repository.SCN06DataProvider;

public class SCN06 extends BaseTest
{

		//Customer Creation
		@Test(dataProvider = "DataProvider_CustomerCreation", dataProviderClass = SCN06DataProvider.class, priority = 0)
		public void customerSetup(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			CustomerCreation customercreation = new CustomerCreation();
			customercreation.customercreation(driver, test, map);
		
		}
		
		//Asset Creation
		@Test(dataProvider = "DataProvider_AssetCreation", dataProviderClass = SCN06DataProvider.class,priority = 1)
		public void assetSetup(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			AssetCreation assetcreation = new AssetCreation();
			assetcreation.assetCreation(driver, test, map);
		}
		
		//VI Creation
		@Test(dataProvider = "DataProvider_VICreation", dataProviderClass = SCN06DataProvider.class,priority = 2)
		public void vendorInvoiceSetup(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			VendorInvoiceCreation vendorinvoicecreation = new VendorInvoiceCreation();
			vendorinvoicecreation.vendorInvoiceScript(driver, test, map);
		}
	
		//Front End Lease Booking
		@Test(dataProvider = "DataProvider_FrontendLeaseSetup", dataProviderClass = SCN06DataProvider.class,priority = 3)
		public void frontendLeaseSetup(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			FrontEndLeaseDataSetupScript frontendleasedatasetupscript = new FrontEndLeaseDataSetupScript();
			frontendleasedatasetupscript.frontendScript(driver, test, map);
		}
	
		//Run LTR-AR, Income Recognition and Sales Tax together -1
		@Test(dataProvider = "DataProvider_LTR-AR+IncomeRecognitionE2E", dataProviderClass = SCN06DataProvider.class,priority = 4)
		public void updates_1(Map<String, String> map) throws Exception
		{
			
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			LTRtoAR_IncomeRecog_E2E ltrtoar_incomerecog_e2e = new LTRtoAR_IncomeRecog_E2E();
			ltrtoar_incomerecog_e2e.ltrToAR(driver, test, map, 1);
	
		}
	
		// Receipt Posting -1
		@Test(dataProvider = "DataProvider_ReceiptPostingE2E", dataProviderClass = SCN06DataProvider.class,priority = 5)
		public void receiptPostingSetup_1(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			 ReceiptPostingDataSetupScript_E2E receiptpostingdatasetupscript_e2e = new ReceiptPostingDataSetupScript_E2E();
			 receiptpostingdatasetupscript_e2e.receiptPostingDataSetupScript(driver, test, map, 1);

		}
		
		//Non Accrual -1
		@Test(dataProvider = "DataProvider_LeaseNonAccrualAndAccrual", dataProviderClass = SCN06DataProvider.class,priority = 6)
		public void accrual_NonAccrualSetup_1(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			LeaseNonAccrualAndAccrualScript_E2E leasenonaccrualandaccrualscript = new LeaseNonAccrualAndAccrualScript_E2E();
			leasenonaccrualandaccrualscript.leasenonaccrualandaccrualscript(driver, test, map,1);
		}
		
		//Run LTR-AR, Income Recognition and Sales Tax together -2
		@Test(dataProvider = "DataProvider_LTR-AR+IncomeRecognitionE2E", dataProviderClass = SCN06DataProvider.class,priority = 7)
		public void updates_2(Map<String, String> map) throws Exception
		{
			
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			LTRtoAR_IncomeRecog_E2E ltrtoar_incomerecog_e2e = new LTRtoAR_IncomeRecog_E2E();
			ltrtoar_incomerecog_e2e.ltrToAR(driver, test, map, 2);
	
		}
		
	// Receipt Posting -2
		@Test(dataProvider = "DataProvider_ReceiptPostingE2E", dataProviderClass = SCN06DataProvider.class,priority = 8)
		public void receiptPostingSetup_2(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			 ReceiptPostingDataSetupScript_E2E receiptpostingdatasetupscript_e2e = new ReceiptPostingDataSetupScript_E2E();
			 receiptpostingdatasetupscript_e2e.receiptPostingDataSetupScript(driver, test, map, 2);

		}
		
		// Lease Restructure
		@Test(dataProvider = "DataProvider_LeaseRestructure", dataProviderClass = SCN06DataProvider.class,priority = 9)
		public void StructuralRestructure(Map<String, String> map) throws Exception
		{
			
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			LeaseRestructureScript leaserestructurescript = new LeaseRestructureScript();
			leaserestructurescript.leaseRestructureScript(driver, test, map);
	
		}
		
		//Run LTR-AR, Income Recognition and Sales Tax together -3
		@Test(dataProvider = "DataProvider_LTR-AR+IncomeRecognitionE2E", dataProviderClass = SCN06DataProvider.class,priority = 10)
		public void updates_3(Map<String, String> map) throws Exception
		{
			
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			LTRtoAR_IncomeRecog_E2E ltrtoar_incomerecog_e2e = new LTRtoAR_IncomeRecog_E2E();
			ltrtoar_incomerecog_e2e.ltrToAR(driver, test, map, 3);
	
		}
		
		// Partial Payoff
		@Test(dataProvider = "DataProvider_Payoff", dataProviderClass = SCN06DataProvider.class,priority = 11)
		public void partialPayoff(Map<String, String> map) throws Exception
		{
			
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			PayoffScript_E2E payoffscript_e2e = new PayoffScript_E2E();
			payoffscript_e2e.partialPayoffScript(driver, test, map, 1);
	
		}
		
		//Accrual -2
		@Test(dataProvider = "DataProvider_LeaseNonAccrualAndAccrual", dataProviderClass = SCN06DataProvider.class,priority = 12)
		public void accrual_NonAccrualSetup_2(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			LeaseNonAccrualAndAccrualScript_E2E leasenonaccrualandaccrualscript = new LeaseNonAccrualAndAccrualScript_E2E();
			leasenonaccrualandaccrualscript.leasenonaccrualandaccrualscript(driver, test, map,2);
		}
		
		//Run LTR-AR, Income Recognition and Sales Tax together -4
		@Test(dataProvider = "DataProvider_LTR-AR+IncomeRecognitionE2E", dataProviderClass = SCN06DataProvider.class,priority = 13)
		public void updates_4(Map<String, String> map) throws Exception
		{
					
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			LTRtoAR_IncomeRecog_E2E ltrtoar_incomerecog_e2e = new LTRtoAR_IncomeRecog_E2E();
			ltrtoar_incomerecog_e2e.ltrToAR(driver, test, map, 4);
			
		}
		
		// Receipt Posting -3
		@Test(dataProvider = "DataProvider_ReceiptPostingE2E", dataProviderClass = SCN06DataProvider.class,priority = 14)
		public void receiptPostingSetup_3(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			 ReceiptPostingDataSetupScript_E2E receiptpostingdatasetupscript_e2e = new ReceiptPostingDataSetupScript_E2E();
			 receiptpostingdatasetupscript_e2e.receiptPostingDataSetupScript(driver, test, map, 3);

		}
		
		//No Accrual -3
		@Test(dataProvider = "DataProvider_LeaseNonAccrualAndAccrual", dataProviderClass = SCN06DataProvider.class,priority = 15)
		public void accrual_NonAccrualSetup_3(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			LeaseNonAccrualAndAccrualScript_E2E leasenonaccrualandaccrualscript = new LeaseNonAccrualAndAccrualScript_E2E();
			leasenonaccrualandaccrualscript.leasenonaccrualandaccrualscript(driver, test, map,3);
		}
		
		//Run LTR-AR, Income Recognition and Sales Tax together -5
		@Test(dataProvider = "DataProvider_LTR-AR+IncomeRecognitionE2E", dataProviderClass = SCN06DataProvider.class,priority = 16)
		public void updates_5(Map<String, String> map) throws Exception
		{
							
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			LTRtoAR_IncomeRecog_E2E ltrtoar_incomerecog_e2e = new LTRtoAR_IncomeRecog_E2E();
			ltrtoar_incomerecog_e2e.ltrToAR(driver, test, map, 5);
					
		}
				
		// Receipt Posting -4
		@Test(dataProvider = "DataProvider_ReceiptPostingE2E", dataProviderClass = SCN06DataProvider.class,priority = 17)
		public void receiptPostingSetup_4(Map<String, String> map) throws Exception
		{
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			 ReceiptPostingDataSetupScript_E2E receiptpostingdatasetupscript_e2e = new ReceiptPostingDataSetupScript_E2E();
			 receiptpostingdatasetupscript_e2e.receiptPostingDataSetupScript(driver, test, map, 4);

		}
				
		// Full Payoff
		@Test(dataProvider = "DataProvider_Payoff", dataProviderClass = SCN06DataProvider.class,priority = 18)
		public void fullPayoff(Map<String, String> map) throws Exception
		{
					
			test=reports.createTest("AssetCreation"+map.get("Sl No"),"Asset creation");
			PayoffScript_E2E payoffscript_e2e = new PayoffScript_E2E();
			payoffscript_e2e.partialPayoffScript(driver, test, map, 2);
	
		}	
		
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	

