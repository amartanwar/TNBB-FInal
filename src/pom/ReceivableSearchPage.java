package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class ReceivableSearchPage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_ReceivableSearchCriteriaUserControl_rdnLeaseSequenceNo")
	private WebElement leaseSequenceNumberRadioButton;
	
	@FindBy(id="ctl00_FC_PH_ReceivableSearchCriteriaUserControl_chkAccountNo")
	private WebElement accountNumberCheckBox;
	
	@FindBy(id="ctl00_FC_PH_ReceivableSearchCriteriaUserControl_txtLeaseSequenceNo")
	private WebElement leaseSequenceNumber;
	
	@FindBy(id="ctl00_FT_PH_cmdPostReceipts_cmdButtonControl")
	private WebElement postReceiptsButton;
	
	public ReceivableSearchPage(WebDriver driver,ExtentTest test) 

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
	
	public void clickOnPostReceiptsButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(postReceiptsButton));
		postReceiptsButton.click();
	}
	

}
