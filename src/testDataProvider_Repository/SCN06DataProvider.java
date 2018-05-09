package testDataProvider_Repository;

import org.testng.annotations.DataProvider;

import generic.DataProviderGeneratorE2E;

public class SCN06DataProvider extends DataProviderGeneratorE2E
{

	
	// Customer Data Provider
		@DataProvider(name ="DataProvider_CustomerCreation")
		public static Object[][] CustomerCreation()
		{
			
			String excelName = "CustomerCreation_ExcelModel";
			Object[][] customerdata=objectGeneratorWithMultiSheet_SCN06(excelName);
			return customerdata; 
		
		}

		// Asset Data Provider
		@DataProvider(name ="DataProvider_AssetCreation")
		public static Object[][] AssetCreation()
		{
			
			String excelName = "AssetCreation_ExcelModel";
			//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
			Object[][] assetData=objectGeneratorWithSingleSheet_SCN06(excelName, "Data For Inventory Creation");
			return assetData; 
		
		}
		
		// VI Data Provider
		@DataProvider(name ="DataProvider_VICreation")
		public static Object[][] VICreation()
		{
			
			String excelName = "VendorInvoice_ExcelModel";
			//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
			Object[][] VIData=objectGeneratorWithSingleSheet_SCN06(excelName, "Vendor Invoice Details");
			return VIData; 
		
		}
		
		// Front end Lease Data Provider
		@DataProvider(name ="DataProvider_FrontendLeaseSetup")
		public static Object[][] FrontendLease()
		{
			
			String excelName = "FrontendLease_ExcelModel";
			//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
			Object[][] leaseData=objectGeneratorWithMultiSheet_SCN06(excelName);
			return leaseData; 
		
		}
		
		// LTR-AR+IncomeRecognition Data Provider
		@DataProvider(name ="DataProvider_LTR-AR+IncomeRecognitionE2E")
		public static Object[][] LTRtoAR_IncomeRecognition()
		{
			
			String excelName = "LTRtoAR_E2E_ExcelModel";
			Object[][] LTRtoAR_IncomeRecognition=objectGeneratorWithMultiSheet_SCN06(excelName);
			return LTRtoAR_IncomeRecognition; 
		
		}
		
		// Receipt Posting Data Provider
		@DataProvider(name ="DataProvider_ReceiptPostingE2E")
		public static Object[][] ReceiptPosting()
		{
			
			String excelName = "ReceiptPosting_E2E_ExcelModel";
			Object[][] RP=objectGeneratorWithMultiSheet_SCN06(excelName);
			return RP; 
		
		}
		
		// Lease Non-Accrual and Accrual Data Provider
		@DataProvider(name ="DataProvider_LeaseNonAccrualAndAccrual")
		public static Object[][] LeaseNonAccrualAndAccrual()
		{
			
			String excelName = "LeaseNonAccrualAndAccrual_E2E_ExcelModel";
			Object[][] LeaseNAAndA=objectGeneratorWithMultiSheet_SCN06(excelName);
			return LeaseNAAndA; 
		
		}
		
		// Restructure Data Provider
		@DataProvider(name ="DataProvider_LeaseRestructure")
		public static Object[][] LeaseRestructure()
		{
			
			String excelName = "LeaseRestructure_ExcelModel";
			Object[][] restructuredata=objectGeneratorWithMultiSheet_SCN06(excelName);
			return restructuredata; 
		
		}
		
		// Payoff Data Provider
		@DataProvider(name ="DataProvider_Payoff")
		public static Object[][] Payoff()
		{
			
			String excelName = "Payoff_E2E_ExcelModel";
			Object[][] PayoffData=objectGeneratorWithMultiSheet_SCN06(excelName);
			return PayoffData; 
		
		}


}
