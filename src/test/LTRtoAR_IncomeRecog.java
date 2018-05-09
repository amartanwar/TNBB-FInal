package test;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import pom.IncomeRecognitionUpdatePage;
import pom.LTRtoARUpdatePage;
import pom.SalesTaxAssessmentUpdatePage;
import pom.UpdatesMenuPage;
import pom.jobListPage;

public class LTRtoAR_IncomeRecog {
	
	public void ltrToAR(WebDriver driver, ExtentTest test,Map<String, String> map) throws InterruptedException, IOException
	{
		
		UpdatesMenuPage updatesmenupage = new UpdatesMenuPage(driver, test);
		updatesmenupage.runLTRtoARUpdate();
		
		LTRtoARUpdatePage ltrtoarupdatepage = new LTRtoARUpdatePage(driver, test);
		ltrtoarupdatepage.clickLeaseRadioButton();
		ltrtoarupdatepage.enterLeaseSequenceNumber(map.get("Lease Sequence number"));
		ltrtoarupdatepage.enterUpdateThroughDate(map.get("LTRtoAR-Update Through Date"));
		ltrtoarupdatepage.enterPostDate(map.get("LTRtoAR-Post Date"));
		ltrtoarupdatepage.clickRunImmediatelyRadioButton();
		ltrtoarupdatepage.clickRunUpdate();
		ltrtoarupdatepage.clickOnJobID();
		
		jobListPage joblistpage = new jobListPage(driver, test);
		String LTRtoARjobstatus = 	joblistpage.validateJobStatus();
		System.out.println("LTR-AR Job Status-"+LTRtoARjobstatus);
		
		String IncomeRecogjobstatus = null;
		
		if(LTRtoARjobstatus.equals("Completed Successfully"))
				{
					updatesmenupage.runIncomeRecognitionUpdate();
					IncomeRecognitionUpdatePage incomerecognitionupdatepage = new IncomeRecognitionUpdatePage(driver, test);
					incomerecognitionupdatepage.clickLeaseRadioButton();
					incomerecognitionupdatepage.enterLeaseSequenceNumber(map.get("Lease Sequence number"));
					incomerecognitionupdatepage.enterUpdateThroughDate(map.get("IncomeRecog-Update Through Date"));
					incomerecognitionupdatepage.enterPostDate(map.get("IncomeRecog-Post Date"));
					incomerecognitionupdatepage.clickRunImmediatelyRadioButton();
					incomerecognitionupdatepage.clickRunUpdate();
					incomerecognitionupdatepage.clickOnJobID();

					IncomeRecogjobstatus = 	joblistpage.validateJobStatus();
					System.out.println("IncomeRecognition Job Status-"+IncomeRecogjobstatus);
				}
		
		if(IncomeRecogjobstatus.equals("Completed Successfully"))
		{
			updatesmenupage.openSalesTaxUpdatePage();
			SalesTaxAssessmentUpdatePage salestaxassessmentupdatepage = new SalesTaxAssessmentUpdatePage(driver, test);
			salestaxassessmentupdatepage.clickLeaseRadioButton();
			salestaxassessmentupdatepage.enterLeaseSequenceNumber(map.get("Lease Sequence number"));
			salestaxassessmentupdatepage.enterUpdateThroughDate(map.get("SalesTax-Update Through Date"));
			salestaxassessmentupdatepage.enterPostDate(map.get("SalesTax-Post Date"));
			salestaxassessmentupdatepage.clickRunImmediatelyRadioButton();
			salestaxassessmentupdatepage.clickRunUpdate();
			salestaxassessmentupdatepage.clickOnJobID();

			String SalesTaxJobStatus = 	joblistpage.validateJobStatus();
			System.out.println("IncomeRecognition Job Status-"+SalesTaxJobStatus);
		}

	
	}


}
