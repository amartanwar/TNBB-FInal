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
import generic.SwitchControlToNextWindow;

public class InvoiceGroupSetupPage extends BasePage {

	public InvoiceGroupSetupPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "ctl00_FC_PH_txtInvoiceGroupName")
	private WebElement invoiceGroupName;
	
	@FindBy(id = "ctl00_FC_PH_chkIsPrimaryGroup")
	private WebElement isPrimaryGroup;
	
	@FindBy(id = "igtxtctl00_FC_PH_txtInvoiceAgingDays")
	private WebElement invoiceAgingDays;
	
	@FindBy(id = "ctl00_FC_PH_txtRemittanceName")
	private WebElement remittanceTemplate;
	
	@FindBy(id = "ctl00_FC_PH_cboDueDay")
	private WebElement dueDay;
	
	@FindBy(id = "ctl00_FC_PH_txtCollectionGroupName")
	private WebElement collectionGroupName;
	
	@FindBy(id = "ctl00_FC_PH_ContactPersonAssignmentUC1_cmdImportContact_cmdImportButton")
	private WebElement firstNameImportButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void enterInvoiceGroupName(String invoicegroupname)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(invoiceGroupName));
		invoiceGroupName.clear();
		invoiceGroupName.sendKeys(invoicegroupname);
	}

	public void enterRemittanceTemplate(String remittancetemplate)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(remittanceTemplate));
		remittanceTemplate.clear();
		remittanceTemplate.sendKeys(remittancetemplate);
	}
	
	public void clickPrimaryGroup()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(isPrimaryGroup));
		isPrimaryGroup.click();
	}
	
	public void enterInvoiceAgingDays(String invoiceagingdays)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(invoiceAgingDays));
		invoiceAgingDays.clear();
		invoiceAgingDays.sendKeys(invoiceagingdays);
	}
	
	public void selectDueDay(String dueday)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(dueDay));
		Select se = new Select(dueDay);
		se.selectByVisibleText(dueday);
	}
	
	public void enterCollectionGroupName(String collectiongroup)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(collectionGroupName));
		collectionGroupName.clear();
		collectionGroupName.sendKeys(collectiongroup);
	}
	
	
	public String clickOnFirstNameImportButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(firstNameImportButton));
		String invoicegroupsetupwindow = driver.getWindowHandle();
		firstNameImportButton.click();
		SwitchControlToNextWindow sc= new SwitchControlToNextWindow();
		sc.waitForWndows(driver, invoicegroupsetupwindow); //Control is being changed to new window
		return invoicegroupsetupwindow;
	}
	
	
	
	
	
	
}
