package moduleLevelTestScripts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import generic.DataBaseVerification;
import generic.ExcelComparator;

public class VerifyIncomeSchedule
{


	public void fetchExpectedIncomeSchedule(Map<String,String> map) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelExpected(map.get("ExpectedIncomeScheduleQuery"), map.get("ExpectedIncomeScheduleResultExcelName"), "IncomeScheduleValues");
	}
	
	
	public void fetchandCompareActualIncomeSchedule(Map<String,String> map, ExtentTest test) throws IOException, SQLException 
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelActual("Select CustomerYield, PrimeYield, IDCYield from Lease_Yield where LeaseID in (Select LeaseID from Lease_Profile where  SequenceNumber =" + "'" + map.get("Lease_sequenceNumber") + "'" + ")", map.get("ActualIncomeScheduleResultExcelName"), "IncomeScheduleValues");

		ExcelComparator excelcomparator =  new ExcelComparator();
		excelcomparator.compareTwoExcel(map.get("ExpectedIncomeScheduleResultExcelName") , map.get("ActualIncomeScheduleResultExcelName"), "pass", test);	
	}
	
}
