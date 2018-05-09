package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class InvoiceSearchPage extends BasePage
{								
	@FindBy(id="ctl00_FC_PH_InvoiceSearchCriteriaUserControl_rdnLeaseSequenceNo")
	private WebElement leaseSequenceNumberRadioButton;
	
	@FindBy(id="ctl00_FC_PH_InvoiceSearchCriteriaUserControl_chkAccountNo")
	private WebElement accountNumberCheckBox;
	
	@FindBy(id="ctl00_FC_PH_InvoiceSearchCriteriaUserControl_txtLeaseSequenceNo")
	private WebElement leaseSequenceNumber;

	@FindBy(id="ctl00_FT_PH_cmdSearch_cmdButtonControl")
	private WebElement searchButton;
	
	@FindBy(id="ctl00_NB_PH_InvoiceListNavBarUserControl_cmdPostByCharge")
	private WebElement postReceiptByReceivableHyperLink;
	
	@FindBy(id="ctl00_FC_PH_InvoiceSearchCriteriaUserControl_txtInvoiceNoFrom")
	private WebElement fromInvoiceNumber;

	@FindBy(id="ctl00_FC_PH_InvoiceSearchCriteriaUserControl_txtInvoiceNoTo")
	private WebElement toInvoiceNumber;
	
	@FindBy(id="ctl00_FC_PH_InvoiceSearchCriteriaUserControl_chkJobID")
	private WebElement jobIdCheckBox;
	
	@FindBy(id="igtxtctl00_FC_PH_InvoiceSearchCriteriaUserControl_txtJobID")
	private WebElement jobId;
	
	@FindBy(id="ctl00_FC_PH_grdList_lnkAll")
	private WebElement selectAll;
	
	@FindBy(id="ctl00_FT_PH_cmdRedirectTo_cmdButtonControl")
	private WebElement postReceipts;
	
	public InvoiceSearchPage(WebDriver driver,ExtentTest test) 

	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void clickLeaseSequenceNumberRadioButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(leaseSequenceNumberRadioButton));
		leaseSequenceNumberRadioButton.click();
	}
	
	public void enterLeaseSequenceNumber(String leaseSeqNumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(leaseSequenceNumber));
		leaseSequenceNumber.sendKeys(leaseSeqNumber);
	}
	
	public void clickAccountNumberCheckBox()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(accountNumberCheckBox));
		accountNumberCheckBox.click();
	}
	
	public void clickOnSearchButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}
	
	public void clickOnPostReceiptByReceivableHypeLink()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(postReceiptByReceivableHyperLink));
		postReceiptByReceivableHyperLink.click();
	}
	
	public void enterFromInvoiceNumber(String from)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(fromInvoiceNumber));
		fromInvoiceNumber.sendKeys(from);
	}
	
	public void enterToInvoiceNumber(String to)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(toInvoiceNumber));
		toInvoiceNumber.sendKeys(to);
	}
	
	public void enterJobID(String JobID)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(jobIdCheckBox));
		jobIdCheckBox.click();
		wt.until(ExpectedConditions.elementToBeClickable(jobId));
		jobId.sendKeys(JobID);
	}
	
	public void clickOnSelectAll()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(selectAll));
		selectAll.click();
	}
	
	
	public void clickOnPostReceipts()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(postReceipts));
		postReceipts.click();
	}
	

	
}
