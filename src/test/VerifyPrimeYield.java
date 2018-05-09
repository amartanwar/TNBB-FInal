package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import generic.DataBaseVerification;
import generic.ExcelComparator;

public class VerifyPrimeYield 
{


	public void fetchExpectedPrimeYield(Map<String,String> map) throws IOException, SQLException 
	{
		//test=reports.createTest("BackendLeaseDataSetup","Lease Booking");	
		DataBaseVerification dbv = new DataBaseVerification();	
		dbv.fetchinDataFromDBInToExcelExpected(map.get("ExpectedYieldQuery"), map.get("ExpectedResultExcelName"), "YieldValues");
//		String unitno = dbv.fetchinSingleValueDataFromDB("Select CustomerYield, PrimeYield, IDCYield from Lease_Yield where LeaseID in (Select LeaseID from Lease_Profile where  SequenceNumber = 'AT-1-204192')");
//		System.out.println(unitno);
//		dbv.validateSingleValueDataFromDB("select 'Scr2_' + ltrim(rtrim(str(count(InventoryID)+1))) FROM Inventory_Profile", "998ty", "pass", test);	
	}
	
	
	public void fetchandCompareActualPrimeYield(Map<String,String> map, ExtentTest test) throws IOException, SQLException 
	{
		//test=reports.createTest("BackendLeaseDataSetup","Lease Booking");
		DataBaseVerification dbv = new DataBaseVerification();
		dbv.fetchinDataFromDBInToExcelActual("Select CustomerYield, PrimeYield, IDCYield from Lease_Yield where LeaseID in (Select LeaseID from Lease_Profile where  SequenceNumber =" + "'" + map.get("Lease_sequenceNumber") + "'" + ")", map.get("ActualResultExcelName"), "YieldValues");
		ExcelComparator ec =  new ExcelComparator();
		ec.compareTwoExcel(map.get("ExpectedResultExcelName") , map.get("ActualResultExcelName"), "pass", test);
		
	}
	
}
