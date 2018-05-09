package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class FlagIncomeForNonAccrualPage extends BasePage {

	public FlagIncomeForNonAccrualPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ctl00_FC_PH_schSearchControl_bshBasicSearch_OneStringctl00_FC_PH_schSearchControlrRrrRrrRr0rRr0")
	WebElement sequenceNumber;
	
	@FindBy(id = "ctl00_FC_PH_schSearchControl_cmdSearch_cmdButtonControl")
	WebElement searchButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdRunUpdate_cmdButtonControl")
	WebElement runUpdateButton;
	
	
	@FindBy(id = "ctl00_FC_PH_grdList_AssignmentListControl_fields")
	WebElement assignmentSelectDropDown;
	
	@FindBy(id = "ctl00_FC_PH_grdList_AssignmentListControl_entryButtons")
	WebElement addButton;
	

	@FindBy(id = "ctl00_FC_PH_JobScheduler_rdoImmediately")
	WebElement runImmediatelyRadioButton;
	
	@FindBy(id = "ctl00_FC_PH_grdList_cmdAssign_cmdButtonControl")
	WebElement assignButton;
	
	@FindBy(id = "ctl00_FC_PH_grdList_lnkAllCP")
	WebElement selectAllButton;
	
	@FindBy(xpath ="//*[@id=\"ctl00_GlobalInstructionBox_DisplayArea\"]/font/a" )
	private WebElement jobID;
	
	
	public void enterSequenceNumber(String sequencenumber)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(sequenceNumber));
		sequenceNumber.clear();
		sequenceNumber.sendKeys(sequencenumber);
	}
	
	public void clickOnSearchButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}
	
	
	public void clickOnRunImmediately()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(runImmediatelyRadioButton));
		runImmediatelyRadioButton.click();
	}
	
	public void clickOnAddButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	public void clickOnAssignButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(assignButton));
		assignButton.click();
	}
	
	
	public void clickOnSelectAllButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(selectAllButton));
		selectAllButton.click();
	}
	
	
	public void selectIncomeAcctualAllowed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(assignmentSelectDropDown));
		Select se = new Select(assignmentSelectDropDown);
		se.selectByIndex(1);
	}
	
	public void clickOnRunupdateButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(runUpdateButton));
		runUpdateButton.click();
	}
	
	
	public void clickOnJobID()
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(jobID));
		jobID.click();	
	}
	
}
