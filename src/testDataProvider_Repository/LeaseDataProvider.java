package testDataProvider_Repository;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LeaseDataProvider extends DataProviderGenerator 

{
		
	// Back end Lease Data Provider
	@DataProvider(name ="DataProvider_BackendLeaseSetup")
	public static Object[][] BackendLease()
	{
		
		String excelName = "BackendLease_ExcelModel";
		Object[][] leaseData=objectGeneratorWithMultiSheet(excelName);
		return leaseData; 
	
	}
	

	// Front end Lease Data Provider
	@DataProvider(name ="DataProvider_FrontendLeaseSetup")
	public static Object[][] FrontendLease()
	{
		
		String excelName = "FrontendLease_ExcelModel";
		//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
		Object[][] leaseData=objectGeneratorWithMultiSheet(excelName);
		return leaseData; 
	
	}
	
	// Front end Lease with Capitalization Data Provider
	@DataProvider(name ="DataProvider_FrontendLeaseWithCapitalizationSetup")
	public static Object[][] FrontendLeaseWithCapitalization()
	{
		
		String excelName = "FrontendLeaseWithCapitalization_ExcelModel";
		//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
		Object[][] leaseDatawithCapitalization=objectGeneratorWithMultiSheet(excelName);
		return leaseDatawithCapitalization; 
	
	}
	
	// Asset Data Provider
	@DataProvider(name ="DataProvider_AssetCreation")
	public static Object[][] AssetCreation()
	{
		
		String excelName = "AssetCreation_ExcelModel";
		//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
		Object[][] assetData=objectGeneratorWithSingleSheet(excelName, "Data For Inventory Creation");
		return assetData; 
	
	}
	
	// VI Data Provider
	@DataProvider(name ="DataProvider_VICreation")
	public static Object[][] VICreation()
	{
		
		String excelName = "VendorInvoice_ExcelModel";
		//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
		Object[][] VIData=objectGeneratorWithSingleSheet(excelName, "Vendor Invoice Details");
		return VIData; 
	
	}
	
	
	
	// Customer Data Provider
	@DataProvider(name ="DataProvider_CustomerCreation")
	public static Object[][] CustomerCreation()
	{
		
		String excelName = "CustomerCreation_ExcelModel";
		Object[][] customerdata=objectGeneratorWithMultiSheet(excelName);
		return customerdata; 
	
	}

	
	// Restructure Data Provider
	@DataProvider(name ="DataProvider_LeaseRestructure")
	public static Object[][] LeaseRestructure()
	{
		
		String excelName = "LeaseRestructure_ExcelModel";
		Object[][] restructuredata=objectGeneratorWithMultiSheet(excelName);
		return restructuredata; 
	
	}
		
	
	// ResidualImpairmentRestructure Data Provider
	@DataProvider(name ="DataProvider_ResidualImpairmentRestructure")
	public static Object[][] LeaseResidualImpairmentRestructure()
	{
		
		String excelName = "ResidualImpairmentRestructure_ExcelModel";
		Object[][] ResidualImpairmentRestructuredata=objectGeneratorWithMultiSheet(excelName);
		return ResidualImpairmentRestructuredata; 
	
	}
	
	
	// NBVImpairmentRestructure Data Provider
	@DataProvider(name ="DataProvider_NBVImpairmentRestructure")
	public static Object[][] LeaseNBVImpairmentRestructure()
	{
		
		String excelName = "NBVImpairmentRestructure_ExcelModel";
		Object[][] NBVImpairmentRestructuredata=objectGeneratorWithMultiSheet(excelName);
		return NBVImpairmentRestructuredata; 
	
	}
	
	
	// SalvageValueRestructure Data Provider
	@DataProvider(name ="DataProvider_SalvageValueRestructure")
	public static Object[][] LeaseSalvageValueRestructure()
	{
		
		String excelName = "SalvageValueRestructure_ExcelModel";
		Object[][] SalvageValueRestructuredata=objectGeneratorWithMultiSheet(excelName);
		return SalvageValueRestructuredata; 
	
	}
	
	// FullPayoff Data Provider
	@DataProvider(name ="DataProvider_FullPayoff")
	public static Object[][] FullPayoff()
	{
		
		String excelName = "FullPayoff_ExcelModel";
		Object[][] FullPayoffData=objectGeneratorWithMultiSheet(excelName);
		return FullPayoffData; 
	
	}
	
	
	// Payoff Data Provider
	@DataProvider(name ="DataProvider_Payoff")
	public static Object[][] Payoff()
	{
		
		String excelName = "Payoff_ExcelModel";
		Object[][] PayoffData=objectGeneratorWithMultiSheet(excelName);
		return PayoffData; 
	
	}
	
	// Assumption Data Provider
	@DataProvider(name ="DataProvider_Assumption")
	public static Object[][] Assumption()
	{
		
		String excelName = "LeaseAssumption_ExcelModel";
		Object[][] Assumption=objectGeneratorWithMultiSheet(excelName);
		return Assumption; 
	
	}
	
	// Lease Non-Accrual and Accrual Data Provider
	@DataProvider(name ="DataProvider_LeaseNonAccrualAndAccrual")
	public static Object[][] LeaseNonAccrualAndAccrual()
	{
		
		String excelName = "LeaseNonAccrualAndAccrual_ExcelModel";
		Object[][] LeaseNAAndA=objectGeneratorWithMultiSheet(excelName);
		return LeaseNAAndA; 
	
	}
	
	// Receipt Posting Data Provider
	@DataProvider(name ="DataProvider_ReceiptPosting")
	public static Object[][] ReceiptPosting()
	{
		
		String excelName = "ReceiptPosting_ExcelModel";
		Object[][] RP=objectGeneratorWithSingleSheet(excelName, "Receipt Posting");
		return RP; 
	
	}
	

	// LTR-AR+IncomeRecognition Data Provider
	@DataProvider(name ="DataProvider_LTR-AR+IncomeRecognition")
	public static Object[][] LTRtoAR_IncomeRecognition()
	{
		
		String excelName = "LTRtoAR_ExcelModel";
		Object[][] LTRtoAR_IncomeRecognition=objectGeneratorWithMultiSheet(excelName);
		return LTRtoAR_IncomeRecognition; 
	
	}
	
}
