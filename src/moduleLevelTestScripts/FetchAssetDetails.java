package moduleLevelTestScripts;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import generic.DataBaseVerification;

public class FetchAssetDetails 
{
	
	public void fetchAssetDetails(Map<String, String> map) throws IOException, SQLException
	{
		DataBaseVerification databaseverification = new DataBaseVerification();
		databaseverification.fetchinDataFromDBInToExcelActual(map.get("Query to Fetch Inventory Details"), map.get("Excel Name"), "Inventory Details");
	}
	
}
