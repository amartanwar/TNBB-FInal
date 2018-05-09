package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.SwitchControlToNextWindow;

public class ReceiptPostingPage extends BasePage{

	public ReceiptPostingPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="ctl00_FC_PH_cboPaymentType_cboComboBoxControl")
	private WebElement receiptType;

	@FindBy(id="igtxtctl00_FC_PH_txtCheckAmount_txtWebCurrencyEdit")
	private WebElement checkAmount;
		
	@FindBy(id="ctl00_FC_PH_txtCheckNo")
	private WebElement checkNumber;
	
	@FindBy(name="ctl00$FC_PH$cboUnallocatedCashGLTemplate$cboGLTransaction")
	private WebElement UnallocatedCashGLTemplate;
	
	@FindBy(id="igtxtctl00_FC_PH_txtUnAllocatedCash_txtWebCurrencyEdit")
	private WebElement UnallocatedCash ;
	
	@FindBy(id="ctl00_FC_PH_txtComments")
	private WebElement UnallocatedCashComment;
	
	@FindBy(id="ctl00_FC_PH_cmdDistribute_cmdButtonControl")
	private WebElement distributeButton;
	
	@FindBy(id="ctl00_FC_PH_cmdApplyChanges_cmdButtonControl")
	private WebElement applyChangesButton;
	
	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;

	@FindBy(id="ctl00_FT_PH_cmdPost_cmdButtonControl")
	private WebElement postButton;
	
	@FindBy(id="ctl00_FC_PH_grdPayment_lnkAllCP")
	private WebElement selectAll;
	
	@FindBy(id="ctl00_FC_PH_txtReceived_input")
	private WebElement receivedDate;
	
	@FindBy(id="ctl00_FC_PH_cmdImportBatchId_cmdImportButton")
	private WebElement batchNameImportButton;
	
	
	
	public void selectReceiptType(String receipttype)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(receiptType));
		Select se = new Select(receiptType);
		se.selectByVisibleText(receipttype);
	}
	
	public void enterCheckNumber(String CheckNumber)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(checkNumber));
		checkNumber.sendKeys(CheckNumber);
	}
	
	public void enterReceivedDate(String date)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(receivedDate));
		receivedDate.clear();
		receivedDate.sendKeys(date);
	}
	
	public void enterCheckAmount(String CheckAmount)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(checkAmount));
		checkAmount.clear();
		checkAmount.sendKeys(CheckAmount);
	}
	
	public void clickOnApplyChangesButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(applyChangesButton));
		applyChangesButton.click();
	}
	
	public void clickOnDistributeButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(distributeButton));
		distributeButton.click();
	}
	
	public void clickOnPostButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(postButton));
		postButton.click();
	}
	
	public String clickOnBatchNameImportButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(batchNameImportButton));
		
		String receiptPostingWindow = driver.getWindowHandle();
		
		batchNameImportButton.click();
		
		SwitchControlToNextWindow switchcontroltonextwindow = new SwitchControlToNextWindow();
		switchcontroltonextwindow.waitForWndows(driver, receiptPostingWindow);
		return receiptPostingWindow;
	}
	
	public void clickOnSelectAll()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(selectAll));
		selectAll.click();
	}
	
	public void selectUnallocatedCashGLTemplate(String template)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(UnallocatedCashGLTemplate));
		Select se = new Select(UnallocatedCashGLTemplate);
		se.selectByVisibleText(template);
	}
	
	public void enterUnallocatedCashComment(String comment)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(UnallocatedCashComment));
		UnallocatedCashComment.sendKeys(comment);
	}
	

	public void handleAlert()
	{
		
			try
			{
				
				WebDriverWait wt=new WebDriverWait(driver, 1);
				wt.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
			}
			catch (Exception e)
			{
				
			}
		
	}
	
	
	

}
