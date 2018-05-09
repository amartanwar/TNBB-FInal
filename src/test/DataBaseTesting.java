package test;

import org.testng.annotations.Test;

import generic.DataBaseVerification;

@SuppressWarnings("unused")
public class DataBaseTesting 
{

	public String test(String LOCNumber)
	{
		//String query = 	"select  top 1 LessorDefinedUniqueId from LeaseTransaction_Profile where CustomerID = 50016 and LessorDefinedUniqueId like '%"+LOCNumber+"%' and Agreementtypeid = 3 order by LeaseTransactionID  desc";
		
		String query = "select count (*)+10 from LeaseTransaction_Profile where CustomerID = 50016 and LessorDefinedUniqueId like '%"+LOCNumber+"%' and Agreementtypeid = 3";
		
		DataBaseVerification databaseverification = new DataBaseVerification();
	
		String value =	databaseverification.fetchinSingleValueDataFromDB(query);
			
		System.out.println(value);
		
		int i = Integer.parseInt(value);

	//	String [] array = value.split("-", 4);
	//	
	//	for (String a : array)
	//	{
	//		System.out.println(a);
	//	}
	
	//	int i = Integer.parseInt(array[3]);
	//	int incrementedValue = i+1; 
	//	String newincrementedValue;
			String x;
	//	
	
		if(i<=9)
			{
		//		 newincrementedValue = "0"+incrementedValue;
				 x = LOCNumber+"-0"+value;
		//		 array[3] = newincrementedValue;
		//		 s = String.join("-", array);	// Joining the array
				System.out.println(x);
			}
		else
			{
		
				x = LOCNumber+"-"+value;
		
		//		newincrementedValue =String.valueOf(incrementedValue);  //converting int to String
		//		array[3] = newincrementedValue;
		//		s = String.join("-", array);  // Joining the array
				System.out.println(x);
			}
	
		return x;
	}
	

	public void test2()
	{
		DataBaseTesting databasetesting = new DataBaseTesting();
		String result = databasetesting.test("1001201-01-01");		
		System.out.println(result);
	}
	
}
