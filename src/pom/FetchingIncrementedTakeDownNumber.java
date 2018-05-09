package pom;

import generic.DataBaseVerification;

public class FetchingIncrementedTakeDownNumber 
{
	public String fetchTakeDownNumber(String LOCNumber)
	{
	
		String query = "select  top 1 LessorDefinedUniqueId from LeaseTransaction_Profile where  LessorDefinedUniqueId like '%"+LOCNumber+"%' and Agreementtypeid = 3 order by LeaseTransactionID  desc";
		DataBaseVerification databaseverification = new DataBaseVerification();	
		String value =	databaseverification.fetchinSingleValueDataFromDB(query);
		return value;	
	}
}
