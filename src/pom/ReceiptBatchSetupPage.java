package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class ReceiptBatchSetupPage extends BasePage{

	public ReceiptBatchSetupPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="ctl00_FC_PH_txtBatchName")
	private WebElement batchName;

	@FindBy(id="igtxtctl00_FC_PH_txtDeposTotal_txtWebCurrencyEdit")
	private WebElement depositTotal;
		
	@FindBy(id="ctl00_FT_PH_cmdSelectClient_cmdExportButton")
	private WebElement saveAndSelectButton;
	

	public void enterBatchName(String BatchName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(batchName));
		batchName.sendKeys(BatchName);
	}
	
	public void enterBatchAmount(String BatchAmount)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(depositTotal));
		depositTotal.clear();
		depositTotal.sendKeys(BatchAmount);
	}
	
	public void clcikOnSaveAndSelect(String receiptPostingWindow)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(saveAndSelectButton));
		saveAndSelectButton.click();
		driver.switchTo().window(receiptPostingWindow);
	}
	

}
