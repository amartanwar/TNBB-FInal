package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.SwitchControlToNextWindow;

public class CollectionGroupSetupPage extends BasePage {

	public CollectionGroupSetupPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "ctl00_FC_PH_txtCollectionGroupName")
	private WebElement collectionGroupName;
	
	@FindBy(id = "ctl00_FC_PH_chkCollectionGroupDefault")
	private WebElement isDefault;
	
	@FindBy(id = "ctl00_FC_PH_ContactPersonAssignmentUC1_cmdAddEditDelete_cmdAdd_cmdButtonControl")
	private WebElement contactPersonAddButton;
	
	@FindBy(id = "ctl00_FC_PH_ContactPersonAssignmentUC1_cmdAddEditDelete_cmdSave_cmdButtonControl")
	private WebElement contactPersonSaveButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public void enterCollectionGroupName(String invoicegroupname)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(collectionGroupName));
		collectionGroupName.clear();
		collectionGroupName.sendKeys(invoicegroupname);
	}
	
	public void clickDefault()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(isDefault));
		isDefault.click();
	}
	
	public String clickOnContactPersonAddButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(contactPersonAddButton));
		String CollectionGroupSetupWindow = driver.getWindowHandle();
		contactPersonAddButton.click();
		SwitchControlToNextWindow sc= new SwitchControlToNextWindow();
		sc.waitForWndows(driver, CollectionGroupSetupWindow); //Control is being changed to new window
		return CollectionGroupSetupWindow;
	}
	
	public void clickOnContactPersonSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(contactPersonSaveButton));
		contactPersonSaveButton.click();
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
}
