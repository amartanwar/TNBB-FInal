package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LTRtoARUpdatePage extends BasePage 
{

	public  LTRtoARUpdatePage(WebDriver driver,ExtentTest test)
	{
		super(driver,test);

		PageFactory.initElements(driver, this);
	}
				
	@FindBy(id="ctl00_FC_PH_LeaseBasedControlUC1_rdoCustomer")
	private WebElement customerRadioButton;
	
	@FindBy(id="ctl00_FC_PH_LeaseBasedControlUC1_rdoLease")
	private WebElement leaseRadioButton;
	
	@FindBy(id="ctl00_FC_PH_LeaseBasedControlUC1_rdoFromLease")
	private WebElement fromLeaseNumberRadioButton;
	
	@FindBy(id="ctl00_FC_PH_LeaseBasedControlUC1_txtUpdateThroughDate_input")
	private WebElement updateThroughDate;
	
	@FindBy(id="ctl00_FC_PH_SchedulerUC1_rdoImmediately")
	private WebElement runImmediatelyRadioButton;
	
	@FindBy(id="ctl00_FT_PH_cmdRunUpdate_cmdButtonControl")
	private WebElement runupdateButton;
	
	
	@FindBy(xpath ="//*[@id=\"ctl00_GlobalInstructionBox_DisplayArea\"]/font/a" )
	private WebElement jobID;
	
	@FindBy(id="ctl00_FC_PH_LeaseBasedControlUC1_txtFromSequenceNumber")
	private WebElement leaseSequenceNumber;
	
	@FindBy(id="ctl00_FC_PH_LeaseBasedControlUC1_txtcustomer")
	private WebElement customerNumber;
	
	@FindBy(id="ctl00_FC_PH_LeaseBasedControlUC1_txtPostDate_input")
	private WebElement postDate;
	
	
	
	public void clickCutomerRadioButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(customerRadioButton));
		customerRadioButton.click();	
	}
	
	public void clickLeaseRadioButton()
	{
		WebDriverWait wt1=new WebDriverWait(driver, 15);
		wt1.until(ExpectedConditions.elementToBeClickable(leaseRadioButton));
		leaseRadioButton.click();
	}
	
	
	public void enterUpdateThroughDate(String date)
	{
		WebDriverWait wt1=new WebDriverWait(driver, 15);
		wt1.until(ExpectedConditions.elementToBeClickable(updateThroughDate));
		updateThroughDate.clear();
		updateThroughDate.sendKeys(date);
	}
	
	public void clickRunImmediatelyRadioButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(runImmediatelyRadioButton));
		runImmediatelyRadioButton.click();
	}
	
	public void clickRunUpdate()
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(runupdateButton));
		runupdateButton.click();	
	}

	public void clickOnJobID()
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(jobID));
		jobID.click();	
	}
	
	public void enterLeaseSequenceNumber(String sequencenumber)
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(leaseSequenceNumber));
		leaseSequenceNumber.sendKeys(sequencenumber);	
	}
	
	public void enterCustomerNumber(String accountnumber)
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(customerNumber));
		customerNumber.sendKeys(accountnumber);	
	}
	
	
	public void enterPostDate(String PostDate)
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(postDate));
		postDate.clear();
		postDate.sendKeys(PostDate);	
	}
	
	
}
