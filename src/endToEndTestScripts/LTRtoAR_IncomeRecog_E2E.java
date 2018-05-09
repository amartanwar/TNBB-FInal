package endToEndTestScripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import pom.IncomeRecognitionUpdatePage;
import pom.LTRtoARUpdatePage;
import pom.SalesTaxAssessmentUpdatePage;
import pom.UpdatesMenuPage;
import pom.jobListPage;

public class LTRtoAR_IncomeRecog_E2E {
	
	public void ltrToAR(WebDriver driver, ExtentTest test,Map<String, String> map,int i) throws InterruptedException, IOException
	{
		
		UpdatesMenuPage updatesmenupage = new UpdatesMenuPage(driver, test);
		updatesmenupage.runLTRtoARUpdate();
		
		LTRtoARUpdatePage ltrtoarupdatepage = new LTRtoARUpdatePage(driver, test);
		ltrtoarupdatepage.clickLeaseRadioButton();
		ltrtoarupdatepage.enterLeaseSequenceNumber(map.get("Lease Sequence number"));
		ltrtoarupdatepage.enterUpdateThroughDate(map.get("LTRtoAR-Update Through Date"+i));
		ltrtoarupdatepage.enterPostDate(map.get("LTRtoAR-Post Date"+i));
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
					incomerecognitionupdatepage.enterUpdateThroughDate(map.get("Income Recognition-Update Through Date"+i));
					incomerecognitionupdatepage.enterPostDate(map.get("Income Recognition-Post Date"+i));
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
			salestaxassessmentupdatepage.enterUpdateThroughDate(map.get("Sales Tax-Post Date"+i));
			salestaxassessmentupdatepage.enterPostDate(map.get("Sales Tax-Update Through Date"+i));
			salestaxassessmentupdatepage.clickRunImmediatelyRadioButton();
			salestaxassessmentupdatepage.clickRunUpdate();
			salestaxassessmentupdatepage.clickOnJobID();

			String SalesTaxJobStatus = 	joblistpage.validateJobStatus();
			System.out.println("IncomeRecognition Job Status-"+SalesTaxJobStatus);
		}

	
	}


}
