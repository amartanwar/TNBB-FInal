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

public class LeaseSecurityDepositPage extends BasePage {

	public LeaseSecurityDepositPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy( id="ctl00_FT_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;
	
	@FindBy(id="ctl00_FC_PH_UCSundryReceivable_cboSundryCodeName_cboComboBoxControl")
	private WebElement codeName;
	
	@FindBy(id="igtxtctl00_FC_PH_UCSundryReceivable_txtAmount_txtWebCurrencyEdit")
	private WebElement amount;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	
	
	
	public void selectcodeName(String code) throws InterruptedException
	{
		WebDriverWait wt= new WebDriverWait(driver, 30);
		wt.until(ExpectedConditions.elementToBeClickable(codeName));
		Select se= new Select(codeName);
		se.selectByVisibleText(code); 
	}
	
	
	
	public void enterAmount(String Amount)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(amount));
		amount.clear();
		amount.sendKeys(Amount);
	}
	
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
	}
	
	
	
	public void clickOnCloseButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(closeButton));
		closeButton.click();
	}
	
	
	
	public void clickOnAddButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
