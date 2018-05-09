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

public class ContactPersonSetupPage extends BasePage {

	public ContactPersonSetupPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "ctl00_FC_PH_ContactPersonUC1_txtFirstName")
	private WebElement firstName;
	
	@FindBy(id = "ctl00_FC_PH_ContactPersonUC1_txtLastName")
	private WebElement lastName;
	
	@FindBy(id = "ctl00_FC_PH_ContactPersonUC1_txtEmailId")
	private WebElement email;	
	
	@FindBy(id = "ctl00_FC_PH_ContactPersonUC1_grdContactTypes_ctl00_Select")
	private WebElement contactType;
	
	@FindBy(id = "igtxtctl00_FC_PH_ContactPersonUC1_txtPhoneNumber1")
	private WebElement phoneNumber1;
	
	@FindBy(id = "ctl00_FC_PH_ContactPersonUC1_ContactAddressUC1_cmdAddressImport_cmdImportButton")
	private WebElement addressImportButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdSelectClient_cmdExportButton")
	private WebElement saveAndSelect;
	
	
	
	public void clickOnContactTypes()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(contactType));
		contactType.click();
	}
	
	public void enterFirstName(String firstname)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.clear();
		firstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.clear();
		lastName.sendKeys(lastname);
	}
	
	
	public void enterPhoneNumber1(String phonenumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(phoneNumber1));
		phoneNumber1.clear();
		phoneNumber1.sendKeys(phonenumber);
	}
	
	public void enteremailID(String emailID)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(email));
		email.clear();
		email.sendKeys(emailID);
	}
	
	public String clickOnAddressImportButton(String customerprofilewindow)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(addressImportButton));
		String contactpersonsetupWindow = driver.getWindowHandle();
		addressImportButton.click();
		SwitchControlToNextWindow sc= new SwitchControlToNextWindow();
		//Switch control to next window, and 3 windows are involved at that instance, Multiple windows method is used.
		sc.waitForWndows_MultipleWindows(driver, customerprofilewindow, contactpersonsetupWindow); 
		return contactpersonsetupWindow;
	}
	
	public void clickOnSaveAndSelect(String contactpersonlistwindow)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(saveAndSelect));
		saveAndSelect.click();
		driver.switchTo().window(contactpersonlistwindow);
	}


}
