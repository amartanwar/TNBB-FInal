package moduleLevelTestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import generic.BaseTest;
import pom.InvoiceSearchPage;
import pom.PortFolioManagementMenu;
import pom.ReceiptBatchListPage;
import pom.ReceiptBatchSetupPage;
import pom.ReceiptPostingPage;
import pom.ReceivableSearchPage;
import pom.ReceivablesAndReceiptsMenuPage;
import pom.jobListPage;

public class ReceiptPostingDataSetupScript extends BaseTest {


	public void receiptPostingDataSetupScript(WebDriver driver, ExtentTest test, Map<String, String> map) throws java.text.ParseException 
	{
	
		PortFolioManagementMenu portfoliomanagement = new PortFolioManagementMenu(driver, test);
		portfoliomanagement.clickPortFolioManagement();
		
		ReceivablesAndReceiptsMenuPage receivablesandreceiptmenupage = new ReceivablesAndReceiptsMenuPage(driver, test);
		receivablesandreceiptmenupage.openRPostReceiptCash();
		
		if(Integer.parseInt(map.get("Post By Receivable ?"))==1)
		{
			
			InvoiceSearchPage invoicesearchpage = new InvoiceSearchPage(driver, test);
			invoicesearchpage.clickOnPostReceiptByReceivableHypeLink();
			
			ReceivableSearchPage receivablesearchpage = new ReceivableSearchPage(driver, test);
			//receivablesearchpage.clickAccountNumberCheckBox();
			//receivablesearchpage.clickLeaseSequenceNumberRadioButton();
			receivablesearchpage.enterLeaseSequenceNumber(map.get("Lease Sequence Number"));
			receivablesearchpage.clickOnPostReceiptsButton();
			
			ReceiptPostingPage receiptpostingpage = new ReceiptPostingPage(driver, test);
			receiptpostingpage.selectReceiptType(map.get("Receipt Type"));
			
			if((map.get("Receipt Type")).equalsIgnoreCase("Check"))
			{
				receiptpostingpage.enterCheckNumber(map.get("Check Number"));
			}
			
			receiptpostingpage.enterReceivedDate(map.get("Received Date"));
			receiptpostingpage.enterCheckAmount(map.get("Check Amount"));
			String receiptPostingWindow =  receiptpostingpage.clickOnBatchNameImportButton();
			
			ReceiptBatchListPage receiptbatchlist = new ReceiptBatchListPage(driver, test);
			//String ReceiptBatchListWindow = receiptbatchlist.clickOnAddButton(receiptPostingWindow);
			receiptbatchlist.clickOnAddButton();
			ReceiptBatchSetupPage receiptbatchsetuppage = new ReceiptBatchSetupPage(driver, test);
			receiptbatchsetuppage.enterBatchName(map.get("Batch Name"));
			receiptbatchsetuppage.enterBatchAmount(map.get("Batch Amount"));
			receiptbatchsetuppage.clcikOnSaveAndSelect(receiptPostingWindow);
			
			receiptpostingpage.enterUnallocatedCashComment(map.get("Unallocated Cash Comment"));
			receiptpostingpage.selectUnallocatedCashGLTemplate(map.get("Unallocated GL Template"));
			
			int j=0;
			DateFormat format= new SimpleDateFormat("mm/dd/yyyy");

			while(format.parse(driver.findElement(By.id("ctl00xFCxPHxgrdPaymentxgrdList_rc_"+j+"_7")).getText().toString()).compareTo(format.parse(map.get("Receipt Posting Date")))<=0)
			
				{
					driver.findElement(By.id("ctl00xFCxPHxgrdPaymentxgrdList_rc_"+j+"_0")).click();
					j++;
				
				};

			receiptpostingpage.clickOnDistributeButton();
			receiptpostingpage.clickOnPostButton();
			
			receivablesandreceiptmenupage.openReceiptBatchManagement();
			
			receiptbatchlist.enterBatchName(map.get("Batch Name"));
			receiptbatchlist.clickOnSearchButton();
			receiptbatchlist.clickOnPostButton();
			receiptbatchlist.clickOnJobID();
			
			jobListPage joblistpage =  new jobListPage(driver, test);
			String JobStatus = joblistpage.validateJobStatus();
			System.out.println(JobStatus);

		}
		
		else
		{
			InvoiceSearchPage invoicesearchpage = new InvoiceSearchPage(driver, test);
			
			
			
			if( (map.get("Search Criteria")).equalsIgnoreCase("Invoice Search"))
			{
				invoicesearchpage.enterFromInvoiceNumber(map.get("From Invoice Number"));
				invoicesearchpage.enterToInvoiceNumber(map.get("To Invoice Number"));
				invoicesearchpage.clickOnSelectAll();
				invoicesearchpage.clickOnPostReceipts();
			}
			
			if( (map.get("Search Criteria")).equalsIgnoreCase("Lease"))
			{
				invoicesearchpage.clickAccountNumberCheckBox();
				invoicesearchpage.clickLeaseSequenceNumberRadioButton();
				invoicesearchpage.enterLeaseSequenceNumber(map.get("Lease Sequence Number"));
				invoicesearchpage.clickOnSelectAll();
				invoicesearchpage.clickOnPostReceipts();
			}
			
			if( (map.get("Search Criteria")).equalsIgnoreCase("Job ID"))
			{
				invoicesearchpage.enterJobID(map.get("JobID"));
				invoicesearchpage.clickOnSelectAll();
				invoicesearchpage.clickOnPostReceipts();
			}

		
			ReceiptPostingPage receiptpostingpage = new ReceiptPostingPage(driver, test);
			receiptpostingpage.selectReceiptType(map.get("Receipt Type"));
			
			if((map.get("Receipt Type")).equalsIgnoreCase("Check"))
			{
				receiptpostingpage.enterCheckNumber(map.get("Check Number"));
			}
			
			receiptpostingpage.enterReceivedDate(map.get("Received Date"));
			receiptpostingpage.enterCheckAmount(map.get("Check Amount"));
			String receiptPostingWindow =  receiptpostingpage.clickOnBatchNameImportButton();
			
			ReceiptBatchListPage receiptbatchlist = new ReceiptBatchListPage(driver, test);
			receiptbatchlist.clickOnAddButton();
			//String ReceiptBatchListWindow = receiptbatchlist.clickOnAddButton(receiptPostingWindow);
			
			ReceiptBatchSetupPage receiptbatchsetuppage = new ReceiptBatchSetupPage(driver, test);
			receiptbatchsetuppage.enterBatchName(map.get("Batch Name"));
			receiptbatchsetuppage.enterBatchAmount(map.get("Batch Amount"));
			receiptbatchsetuppage.clcikOnSaveAndSelect(receiptPostingWindow);
			
			receiptpostingpage.clickOnSelectAll();
			receiptpostingpage.clickOnDistributeButton();
			receiptpostingpage.clickOnPostButton();
			
			receivablesandreceiptmenupage.openReceiptBatchManagement();
			
			receiptbatchlist.enterBatchName(map.get("Batch Name"));
			receiptbatchlist.clickOnSearchButton();
			receiptbatchlist.clickOnPostButton();
			receiptbatchlist.clickOnJobID();
			
			jobListPage joblistpage =  new jobListPage(driver, test);
			String JobStatus = joblistpage.validateJobStatus();
			System.out.println(JobStatus);


		}

		
	}

}
